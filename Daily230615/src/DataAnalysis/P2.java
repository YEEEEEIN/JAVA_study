package DataAnalysis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class P2 {

	public static void main(String[] args) {
		try {
            String inputFile = "C:\\Users\\예인\\Desktop\\전력소비계수.xlsx";
            String outputFile = "C:\\Users\\예인\\Desktop\\결과.xlsx";
            FileInputStream fis = new FileInputStream(inputFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowCount = sheet.getPhysicalNumberOfRows();
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

            // 첫 번째 행에 목차 추가
            XSSFRow headerRow = sheet.getRow(0);
            XSSFCell rowSumHeader = headerRow.createCell(columnCount);
            rowSumHeader.setCellValue("RowSum");
            XSSFCell rowAvgHeader = headerRow.createCell(columnCount + 1);
            rowAvgHeader.setCellValue("RowAvg");

            // 행의 합과 평균 계산
            for (int row = 1; row < rowCount; row++) {
                XSSFRow rows = sheet.getRow(row);
                if (rows != null) {
                    double rowSum = 0;
                    int validCellCount = 0; // 유효한 셀의 개수를 세기 위한 변수
                    for (int column = 1; column < columnCount; column++) {
                        XSSFCell cell = rows.getCell(column);
                        if (cell != null && cell.getCellTypeEnum() == CellType.NUMERIC) {
                            rowSum += cell.getNumericCellValue();
                            validCellCount++;
                        }
                    }
                    XSSFCell sumCell = rows.createCell(columnCount);
                    sumCell.setCellValue(rowSum);
                    XSSFCell averageCell = rows.createCell(columnCount + 1);
                    if (validCellCount > 0) {
                        averageCell.setCellValue(rowSum / validCellCount);
                    } else {
                        averageCell.setCellValue(0);
                    }
                }
            }

            // 첫 번째 열의 마지막 행에 목차 추가
            XSSFRow colSumRow = sheet.createRow(rowCount);
            XSSFCell colSumHeader = colSumRow.createCell(0);
            colSumHeader.setCellValue("ColSum");
            XSSFRow colAvgRow = sheet.createRow(rowCount + 1);
            XSSFCell colAvgHeader = colAvgRow.createCell(0);
            colAvgHeader.setCellValue("ColAvg");

            // 열의 합과 평균 계산
            for (int column = 1; column < columnCount; column++) {
                double columnSum = 0;
                int validCellCount = 0; // 유효한 셀의 개수를 세기 위한 변수
                for (int row = 1; row < rowCount; row++) {
                    XSSFRow rows = sheet.getRow(row);
                    if (rows != null) {
                        XSSFCell cell = rows.getCell(column);
                        if (cell != null && cell.getCellTypeEnum() == CellType.NUMERIC) {
                            columnSum += cell.getNumericCellValue();
                            validCellCount++;
                        }
                    }
                }
                XSSFCell sumCell = colSumRow.createCell(column);
                sumCell.setCellValue(columnSum);
                XSSFCell averageCell = colAvgRow.createCell(column);
                if (validCellCount > 0) {
                    averageCell.setCellValue(columnSum / validCellCount);
                } else {
                    averageCell.setCellValue(0);
                }
            }

            // 마지막 열의 합과 평균 계산
            double lastColumnSum = 0;
            int validCellCount = 0; // 유효한 셀의 개수를 세기 위한 변수
            for (int row = 1; row < rowCount; row++) {
                XSSFRow rows = sheet.getRow(row);
                if (rows != null) {
                    XSSFCell cell = rows.getCell(columnCount - 1);
                    if (cell != null && cell.getCellTypeEnum() == CellType.NUMERIC) {
                        lastColumnSum += cell.getNumericCellValue();
                        validCellCount++;
                    }
                }
            }
            XSSFCell sumCell = colSumRow.createCell(columnCount - 1);
            sumCell.setCellValue(lastColumnSum);
            XSSFCell averageCell = colAvgRow.createCell(columnCount - 1);
            if (validCellCount > 0) {
                averageCell.setCellValue(lastColumnSum / validCellCount);
            } else {
                averageCell.setCellValue(0);
            }

            FileOutputStream fos = new FileOutputStream(outputFile);
            workbook.write(fos);
            workbook.close();
            fos.close();

            System.out.println("Data analysis completed. Results saved to: " + outputFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}