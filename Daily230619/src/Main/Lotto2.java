package Main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class Lotto2 {

	public static void main(String[] args) throws CsvValidationException {
		String csvFilePath = "C:\\Users\\예인\\Desktop\\rowdata.csv";
        String resultFilePath = "C:\\Users\\예인\\Desktop\\LottoResult3.csv";

        try (CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(csvFilePath), "CP949"));
             CSVWriter csvWriter = new CSVWriter(new OutputStreamWriter(new FileOutputStream(resultFilePath), "CP949"))) {

            String[] headers = csvReader.readNext(); // 헤더 읽기
            int[] numbers = new int[headers.length - 1]; // 번호 배열 초기화

            csvWriter.writeNext(new String[]{"회차", "최댓값", "최솟값"}); // 결과 쓰기 헤더

            String[] line;
            while ((line = csvReader.readNext()) != null) {
                for (int i = 1; i < line.length; i++) {
                    int number = Integer.parseInt(line[i]);
                    numbers[i - 1] = number;
                }

                // 번호 간 거리 계산
                int maxDistance = 0;
                int minDistance = Integer.MAX_VALUE;
                for (int i = 0; i < numbers.length; i++) {
                    for (int j = i + 1; j < numbers.length; j++) {
                        int distance = Math.abs(numbers[i] - numbers[j]);
                        if (distance > maxDistance) {
                            maxDistance = distance;
                        }
                        if (distance < minDistance) {
                            minDistance = distance;
                        }
                    }
                }

                // 결과 쓰기
                String[] result = {line[0], String.valueOf(maxDistance), String.valueOf(minDistance)};
                csvWriter.writeNext(result);
            }

            System.out.println("결과가 파일에 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}