package DataAnalysis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVRead3 {

	public static void main(String[] args) {
		String readFileName = "C:\\Users\\예인\\Desktop\\국민 해외관광객 주요 목적지별 통계(202303).csv";
		String writeFileName = "C:\\Users\\예인\\Desktop\\result3.csv";
		try {
			CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "CP949"));
			CSVWriter cw = new CSVWriter(new FileWriter(writeFileName));
			String[] data = {"sum", "avg"}; 
			cw.writeNext(data);
			
			String[] nextLine;
			// 파일의 첫줄을 읽어옴
			if((nextLine = csvReader.readNext()) == null) {
				System.out.println("빈파일입니다");
				return;
			}
			
			int[] columnSum = new int[nextLine.length - 1];
            int[] columnCount = new int[nextLine.length - 1];

			
			while ((nextLine = csvReader.readNext()) != null) {
				int sum = 0;
				int cnt = 0;
				for (int i = 1; i < nextLine.length; i++) {
					int data1 = Integer.parseInt(nextLine[i]);
					sum += data1;
					cnt++;
					
					int data3 = Integer.parseInt(nextLine[i]);
                    columnSum[i - 1] += data3;
                    columnCount[i - 1]++;
				}
				double avg = (double)sum / cnt;
				
				String summ = String.valueOf(sum);
				String avgg = String.valueOf(avg);
				String[] data2 = {summ, avgg};
				cw.writeNext(data2);
				
				
				// System.out.println(nextLine.length + ":" + String.join("|", nextLine));
			}
			
			String[] columnSumString = new String[columnSum.length + 1];
            String[] columnAvgString = new String[columnSum.length + 1];
            columnSumString[0] = "sum";
            columnAvgString[0] = "avg";
            for (int i = 0; i < columnSum.length; i++) {
                columnSumString[i+1] = String.valueOf(columnSum[i]);
                double avg = (double) columnSum[i] / columnCount[i];
                columnAvgString[i+1] = String.valueOf(avg);
            }
            
            cw.writeNext(columnSumString);
            cw.writeNext(columnAvgString);

			cw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		}
}