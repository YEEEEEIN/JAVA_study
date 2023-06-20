package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1 {
	public static WebDriver dirver;
	public static String base_url = "http://www.naver.com";
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\Users\\예인\\Downloads\\chromedriver_win32\\chromedriver.exe";

	public static void main(String[] args) {
		System.setProperty(WEB_DRIVER_PATH, WEB_DRIVER_ID);
		dirver = new ChromeDriver();
		crawl();
	}

	public static void crawl() {
		try {
			dirver.get(base_url);
			// String temp = dirver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]/a[1]/div[1]/div[2]")).getText();
			// dirver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[5]/ul/li[5]/a/span[1]")).click();
			
		
			dirver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/div/form/fieldset/div/input")).click();
			Thread.sleep(500);

			dirver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/div/form/fieldset/div/input")).sendKeys("김규석");
			Thread.sleep(1000);

			dirver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/div/form/fieldset/div/input")).sendKeys(Keys.RETURN);
			Thread.sleep(1000);
			
			// System.out.println(temp);
			// System.out.println(dirver.getPageSource());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
