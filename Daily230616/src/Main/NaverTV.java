package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaverTV {
	 public static WebDriver driver;
	    public static String base_url = "https://tv.naver.com/";
	    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	    public static final String WEB_DRIVER_PATH = "C:\\Users\\예인\\Downloads\\chromedriver_win32\\chromedriver.exe";
	    public static List<String> dataSet = new ArrayList<>();

	    public static void main(String[] args) {
	        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
	        driver = new ChromeDriver();
	        // Run the code indefinitely
	        crawl();
	        saveToCSV("C:\\Users\\예인\\Desktop\\naver_tv_data1.csv", dataSet); // 경로 지정하였음
	        System.out.println("CSV 파일 생성 완료.");
	    }

	    public static void crawl() {
	        int count = 0;
	        LocalTime time = LocalTime.of(0, 0); // 시작 시간 00:00
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	        while (count < 4) { // while문 
	            try {
	                driver.get(base_url);
	                int cnt = 0;
	                int rank = 1;
	                while (cnt < 15) {
	                    for (int i = 4 * cnt + 1; i <= 4 * cnt + 4; i++) {
	                        // Check if the element exists
	                        List<WebElement> titleElements = driver.findElements(
	                                By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/ul/li[" + i + "]/dl/dt/a/tooltip"));
	                        
	                        if (titleElements.size() == 0) {
	                            // No more elements found, exit the loop
	                            break;
	                        }

	                        String now = titleElements.get(0).getText();
	                        String view = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/ul/li[" + i + "]/span/span[1]")).getText();
	                        String like = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/ul/li[" + i + "]/span/span[2]")).getText();
	                        
	                        // Replace "," with ","
	                        now = now.replaceAll(",", " ");
	                        
	                        view = view.replace("재생 수", "");
	                        view = view.replaceAll(",", "");
	                        
	                        like = like.replace("좋아요 수", "");
	                        like = like.replaceAll(",", "");
	                        
	                        String rowData = time.format(formatter) + "," + rank + "," + now + "," + view + "," + like; // Combine data into one row
	                
	                        System.out.println(rowData);
	                        dataSet.add(rowData);
	                        
	                        rank++;
	                    }

	                    WebElement nextButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/a[2]"));
	                    if (!nextButton.isEnabled()) {
	                        // Next button is disabled, no more pages, exit the loop
	                        break;
	                    }

	                    nextButton.click();
	                    
	                    Thread.sleep(1000);
	                    cnt++;
	                }
	                
	                // Increase time by 15 minutes
	                time = time.plusMinutes(15);
	                
	                // Wait for 15 minutes
	                Thread.sleep(1 * 60 * 1000);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            count++;
	        }
	    }

	    // List 객체를 통해 받은 내용을 CSV 파일로 저장(기본적으로 Java 프로그램의 작업 디렉토리에 저장됨)
	    public static void saveToCSV(String filename, List<String> data) {
	        try {
	            FileWriter writer = new FileWriter(filename);
	            
	            // Add column headers
	            writer.append("시간,순위,제목,조회수,좋아요 수");
	            writer.append("\n");
	            
	            // dataSet의 내용을 파일로 저장하기
	            for (String row : data) {
	                writer.append(row);
	                writer.append("\n");
	            }

	            writer.flush();
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
