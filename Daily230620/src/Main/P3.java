package Main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class P3 {

	public static void main(String[] args) throws CsvValidationException, NumberFormatException {

		String csvFile = "C:\\Users\\예인\\Desktop\\역대영화순위.CSV";

		try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvFile)).withSkipLines(1).build()) {
			List<Double> yList = new ArrayList<>();
			List<Double> x1List = new ArrayList<>();
			List<Double> x2List = new ArrayList<>();

			String[] line;
			int cntLine = 0;
			while ((line = reader.readNext()) != null) {
				yList.add(Double.parseDouble(line[0]));
				x1List.add(Double.parseDouble(line[1]));
				x2List.add(Double.parseDouble(line[2]));
			}

			int dataSize = cntLine;
			double[][] x = new double[dataSize][6];
			double[] y = new double[dataSize];

			for (int i = 0; i < dataSize; i++) {
				y[i] = yList.get(i);
				x[i][0] = x1List.get(i);
				x[i][1] = x2List.get(i);
			}

			OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
			regression.newSampleData(y, x);

			// 계수 추정
			double[] coefficients = regression.estimateRegressionParameters();
			System.out.println("Coefficients:");
			for (int i = 0; i < coefficients.length; i++) {
				System.out.println("Beta" + i + ": " + coefficients[i]);
			}

			// 결정계수 계산
			double rSquare = regression.calculateRSquared();
			System.out.println("\nR-Square: " + rSquare);

			// 조정된 결정계수 계산
			int numPredictors = 6; // 독립 변수의 개수
			double adjustedRSquare = 1 - (1 - rSquare) * (dataSize - 1) / (dataSize - numPredictors - 1);
			System.out.println("Adjusted R-Square: " + adjustedRSquare);

			// 표준 오차 계산
			double[] standardErrors = regression.estimateRegressionParametersStandardErrors();
			System.out.println("\nStandard Errors:");
			for (int i = 0; i < standardErrors.length; i++) {
				System.out.println("SE" + i + ": " + standardErrors[i]);
			}

			// 관측 수
			int numObservations = dataSize;
			System.out.println("\nNumber of Observations: " + numObservations);

			double[] pValues = calculatePValues(regression);
			System.out.println("\nP-Values:");

			for (int i = 0; i < pValues.length; i++) {
				System.out.println("P-Value" + i + ": " + pValues[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static double[] calculatePValues(OLSMultipleLinearRegression regression) {

		double[] standardErrors = regression.estimateRegressionParametersStandardErrors();
		int n = regression.estimateRegressionParameters().length;
		double[] pValues = new double[n];

		TDistribution tDistribution = new TDistribution(regression.estimateResiduals().length - n);

		for (int i = 0; i < n; i++) {
			double t = regression.estimateRegressionParameters()[i] / standardErrors[i];
			pValues[i] = 2 * (1 - tDistribution.cumulativeProbability(Math.abs(t)));
		}

		return pValues;
	}
}