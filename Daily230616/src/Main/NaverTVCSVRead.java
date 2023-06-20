package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class NaverTVCSVRead {

	public static void main(String[] args) throws CsvValidationException {
		 String readFileName = "C:\\Users\\예인\\Desktop\\naver_tv_data1.csv";
	        String writeFileName = "C:\\Users\\예인\\Desktop\\NaverResult.csv";

	        try {
	            CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "CP949"));
	            CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(new FileOutputStream(writeFileName), "CP949"));

	            DecimalFormat decimalFormat1 = new DecimalFormat("###0");
	            DecimalFormat decimalFormat2 = new DecimalFormat("###0.00");

	            List<String[]> dataLines = new ArrayList<>();

	            String[] nextLine;
	            // 파일의 첫 줄을 읽어옴 (타이틀)
	            if ((nextLine = csvReader.readNext()) == null) {
	                System.out.println("빈 파일입니다");
	                csvReader.close();
	                csvWriter.close();
	                return;
	            }

	            dataLines.add(nextLine); // 타이틀 추가

	            double sumViews = 0;
	            double sumLikes = 0;
	            int count = 0; // 행의 개수를 세는 변수
	            while ((nextLine = csvReader.readNext()) != null) { // 데이터 행 반복
	                count++;

	                int views = Integer.parseInt(nextLine[3]);
	                int likes = Integer.parseInt(nextLine[4]);

	                sumViews += views;
	                sumLikes += likes;

	                if (count % 50 == 0) { // 매 50행마다 합계와 평균 계산하여 출력
	                    String[] row = Arrays.copyOf(nextLine, nextLine.length);
	                    row[0] = "합계";
	                    row[1] = "";
	                    row[2] = "";
	                    row[3] = decimalFormat1.format(sumViews);
	                    row[4] = decimalFormat1.format(sumLikes);
	                    dataLines.add(row);

	                    double averageViews = sumViews / 50;
	                    double averageLikes = sumLikes / 50;

	                    String[] avgRow = new String[nextLine.length];
	                    avgRow[0] = "평균";
	                    avgRow[1] = "";
	                    avgRow[2] = "";
	                    avgRow[3] = decimalFormat2.format(averageViews);
	                    avgRow[4] = decimalFormat2.format(averageLikes);
	                    dataLines.add(avgRow);

	                    sumViews = 0;
	                    sumLikes = 0;
	                } else {
	                    dataLines.add(nextLine);
	                }

	                if (count == csvReader.getLinesRead()) { // 마지막 데이터 처리
	                    double averageViews = sumViews / (count % 50);
	                    double averageLikes = sumLikes / (count % 50);

	                    String[] row = Arrays.copyOf(nextLine, nextLine.length);
	                    row[0] = "합계";
	                    row[1] = "";
	                    row[2] = "";
	                    row[3] = decimalFormat1.format(sumViews);
	                    row[4] = decimalFormat1.format(sumLikes);
	                    dataLines.add(row);

	                    String[] avgRow = new String[nextLine.length];
	                    avgRow[0] = "평균";
	                    avgRow[1] = "";
	                    avgRow[2] = "";
	                    avgRow[3] = decimalFormat2.format(averageViews);
	                    avgRow[4] = decimalFormat2.format(averageLikes);
	                    dataLines.add(avgRow);
	                }
	            }

	            csvWriter.writeAll(dataLines); // 리스트 내용 쓰기
	            csvWriter.close();
	            csvReader.close();

	            System.out.println("파일 쓰기 완료");
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}