package Projekt3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.IntStream;

import Projekt3.Methods.*;

public class Test2 {

    public static void main(String[] args) {
        double[] x = new double[1000];
        for (int i = 1; i <= 1000; i++) {
            x[i-1] = i * 0.01;
        }

        int numPoints = 2;

        for (int i = 0; i < 1000; i++) {
            double a = x[i];

            double tabx[] = new double[numPoints];
            for (int j = 0; j < numPoints; j++) {
                tabx[j] = a + j * 0.001;
            }

            double tabySin3x[] = new double[numPoints];
            double tabyCosDiv5[] = new double[numPoints];
            double tabyEx[] = new double[numPoints];
            for (int j = 0; j < numPoints; j++) {
                tabySin3x[j] = calculateSin3x(tabx[j]);
                tabyCosDiv5[j] = calculateCosxDiv5(tabx[j]);
                tabyEx[j] = calculateEx(tabx[j]);
            }

            double errorCSI = Math.abs(CSI.integrateCSI(tabx, tabySin3x) - calculateLibraryIntegral(tabx, tabySin3x));
            double errorSimpson = Math.abs(Simpson.integrateSimpson(tabx, tabySin3x) - calculateLibraryIntegral(tabx, tabySin3x));
            double errorTrapezoidal = Math.abs(Trapezoidal.integrateTrapezoidal(tabx, tabySin3x) - calculateLibraryIntegral(tabx, tabySin3x));
            saveToFile("Sin3x.txt", x[i], numPoints, errorCSI, errorSimpson, errorTrapezoidal);

            errorCSI = Math.abs(CSI.integrateCSI(tabx, tabyCosDiv5) - calculateLibraryIntegral(tabx, tabyCosDiv5));
            errorSimpson = Math.abs(Simpson.integrateSimpson(tabx, tabyCosDiv5) - calculateLibraryIntegral(tabx, tabyCosDiv5));
            errorTrapezoidal = Math.abs(Trapezoidal.integrateTrapezoidal(tabx, tabyCosDiv5) - calculateLibraryIntegral(tabx, tabyCosDiv5));
            saveToFile("CosDiv5.txt", x[i], numPoints, errorCSI, errorSimpson, errorTrapezoidal);

            errorCSI = Math.abs(CSI.integrateCSI(tabx, tabyEx) - calculateLibraryIntegral(tabx, tabyEx));
            errorSimpson = Math.abs(Simpson.integrateSimpson(tabx, tabyEx) - calculateLibraryIntegral(tabx, tabyEx));
            errorTrapezoidal = Math.abs(Trapezoidal.integrateTrapezoidal(tabx, tabyEx) - calculateLibraryIntegral(tabx, tabyEx));
            saveToFile("Ex.txt", x[i], numPoints, errorCSI, errorSimpson, errorTrapezoidal);

            numPoints++;
        }
    }

    public static void saveToFile(String filename, double x, int numPoints, double errorCSI, double errorSimpson, double errorTrapezoidal) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(x + " " + numPoints + " " + errorCSI + " " + errorSimpson + " " + errorTrapezoidal + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double calculateSin3x(double x) {
        return Math.sin(3 * x);
    }

    public static double calculateCosxDiv5(double x) {
        return Math.cos(x) / 5;
    }

    public static double calculateEx(double x) {
        return Math.exp(x);
    }

    public static double calculateLibraryIntegral(double[] x, double[] y) {
        double width = 0.01;

        double integral = IntStream.range(0, x.length - 1)
                .mapToDouble(i -> (y[i] + y[i + 1]) * 0.5 * width)
                .sum();

        return integral;
    }
}
