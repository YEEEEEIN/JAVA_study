package DataAnalysis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVRead_Final {
	public static void main(String[] args) {
		String readFileName = "C:\\Users\\예인\\Desktop\\국민 해외관광객 주요 목적지별 통계(202303).csv";
        String writeFileName = "C:\\Users\\예인\\Desktop\\result5.csv";
        
        try {
            CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "CP949"));
            CSVWriter cw = new CSVWriter(new OutputStreamWriter(new FileOutputStream(writeFileName), "CP949"));
            
            DecimalFormat decimalFormat1 = new DecimalFormat("###0");
            DecimalFormat decimalFormat2 = new DecimalFormat("###0.00");
            
            List<String[]> dataLines = new ArrayList<>();

            String[] nextLine;
            // 파일의 첫줄을 읽어옴
            if ((nextLine = csvReader.readNext()) == null) {
                System.out.println("빈파일입니다");
                return;
            }
            
            String[] title = Arrays.copyOf(nextLine, nextLine.length + 2); // nextLine.length = 14, 열은 0부터 시작
            title[nextLine.length] = "sum";
            title[nextLine.length + 1] = "avg";
            
            dataLines.add(title); // 리스트에 한 줄 넣기
            
            double[] columnSum = new double[dataLines.get(0).length]; // 열의 합을 구하는 변수, 배열의 크기를 위에서 넣은 리스트의 첫번째 요소만큼 크기를 지정 => 16개
            
            int count = 0; // 행의 개수를 세는 변수
            while ((nextLine = csvReader.readNext()) != null) { // 파일의 두번째 줄부터 데이터가 없을때까지 읽기 => 새로운 행의 시작
            	count++;
                int sum = 0; // 행의 합을 구하는 변수 sum 초기화
                double avg = 0; // 행의 평균을 구하는 avg 초기화
                
                for (int i = 1; i < nextLine.length; i++) { // nextLine[0]은 연월
                    sum += Integer.parseInt(nextLine[i]); // 각 행의 누적합
                    
                    
                    columnSum[i] += Integer.parseInt(nextLine[i]); // 각 열의 누적 합 columnSum[1]~columnSum[13]
                }
                avg = (double) sum / (nextLine.length - 1); // 각 행의 평균
                
                columnSum[nextLine.length] += sum; // sum 열의 누적 합
                columnSum[nextLine.length + 1] += avg; // avg 열의 누적 합
                
                // String summ = String.valueOf(sum);
                // String avgg = String.valueOf(avg);
            
                String rowSum = decimalFormat1.format(sum);
                String rowAvg = decimalFormat2.format(avg);
              
                // 원본 데이터에 합과 평균 값을 추가
                String[] lineWithRowSumAndRowAvg = Arrays.copyOf(nextLine, nextLine.length + 2);
                lineWithRowSumAndRowAvg[nextLine.length] = rowSum;
                lineWithRowSumAndRowAvg[nextLine.length + 1] = rowAvg;

                dataLines.add(lineWithRowSumAndRowAvg);
            }
            
            String[] columnSumString = new String[dataLines.get(0).length];
            String[] columnAvgString = new String[dataLines.get(0).length];
            
            columnSumString[0] = "sum";
            columnAvgString[0] = "avg";
            
            for (int i = 1; i < columnSum.length; i++) { // columnSum.length = 16
            	columnSumString[i] = decimalFormat1.format(columnSum[i]);
            	
            	double avg = (double) columnSum[i] / count;
                columnAvgString[i] = decimalFormat2.format(avg);
            }

            dataLines.add(columnSumString); 
            dataLines.add(columnAvgString);

            cw.writeAll(dataLines); // 리스트 내용 쓰기

            cw.close();
            csvReader.close();
            System.out.println("파일 쓰기 완료");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}