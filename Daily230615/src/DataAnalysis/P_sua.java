package DataAnalysis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class P_sua {
	public static void main(String[] args) {
	      File file = new File("C:\\Users\\a\\Desktop\\서울시 지하철7호선 역별 승하차 인원 정보.xlsx"); // 새 파일 인스턴스 생성
	      FileInputStream fis = null;
	      try {
	         fis = new FileInputStream(file);
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	         return; // 파일을 찾을 수 없는 경우 중단
	      }
	      XSSFWorkbook workbook = null;
	      try {
	         List<String[]> kkk = new ArrayList<>();
	         workbook = new XSSFWorkbook(fis);
	         XSSFSheet sheet = workbook.getSheet("Sheet1");
	         DecimalFormat decimalFormat = new DecimalFormat("#.###");

	         for (int row = 1; row < sheet.getPhysicalNumberOfRows(); row++) {
	            List<String> list = new ArrayList<>();
	            XSSFRow rows = sheet.getRow(row);
	            if (rows != null) {
	               int cells = rows.getPhysicalNumberOfCells();
	               double sum = 0.0;
	               double avg = 0.0;
	               String sumValue = "";
	               String avgValue = "";

	               for (int column = 0; column < cells; column++) {
	                  XSSFCell cell = rows.getCell(column);
	                  if (cell != null) {
	                     String value = "";
	                     switch (cell.getCellType()) {
	                     case NUMERIC:
	                        double numericValue = cell.getNumericCellValue();
	                        value = decimalFormat.format(numericValue);
	                        if (column == 3 || column == 4) {
	                           sum += numericValue;
	                        }
	                        avg = sum / 2;
	                        break;
	                     case STRING:
	                        value = cell.getStringCellValue();
	                        break;
	                     case BLANK:
	                        value = "";
	                        break;
	                     case ERROR:
	                        value = "Error in cell";
	                        break;
	                     default:
	                        break;
	                     }
	                     System.out.print(value + " ");
	                     list.add(value);
	                  }
	               }
	               sumValue = decimalFormat.format(sum);
	               avgValue = decimalFormat.format(avg);
	               System.out.print(sumValue);
	               System.out.println(avgValue);
	               list.add(sumValue);
	               list.add(avgValue);
	            }
	            System.out.println(list.toString());

	            String[] array = new String[list.size()];
	            array = list.toArray(new String[list.size()]);
	            kkk.add(array);
	         }

	         String[][] arr = new String[1643][7];

	         for (int i = 0; i < 1643; i++) {
	            for (int j = 0; j < 7; j++) {
	               arr[i] = kkk.get(i);
	            }
	         }

	         XSSFWorkbook workbook1 = new XSSFWorkbook();
	         XSSFSheet sheet1 = workbook1.createSheet("sheet1"); // sheet 생성

	         // 첫 번째 행에 데이터 추가
	         Row firstRow = sheet1.createRow(0);
	         String[] header = { "사용일자", "호선명", "역명", "승차총승객", "하차총승객", "하루총승객수", "하루평균승객수" };
	         for (int j = 0; j < header.length; j++) {
	            Cell cell = firstRow.createCell(j);
	            cell.setCellValue(header[j]);
	         }

	         // 나머지 행에 데이터 추가
	         for (int i = 0; i < arr.length; i++) {
	            Row row = sheet1.createRow(i + 1); // 행 생성
	            String[] rowData = arr[i];

	            for (int j = 0; j < rowData.length; j++) {
	               Cell cell = row.createCell(j); // 셀 생성
	               cell.setCellValue(rowData[j]); // 값 설정
	            }
	         }

	         String writeFileName = "C:\\Users\\a\\Desktop\\output.xlsx";
	         FileOutputStream fos = new FileOutputStream(writeFileName);
	         workbook1.write(fos);
	         fos.close();

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	}