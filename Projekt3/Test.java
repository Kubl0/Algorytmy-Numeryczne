package Projekt3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.IntStream;

import Projekt3.Methods.*;

public class Test {

    public static void main(String[] args) {
        double[] x = new double[1000];
        for (int i = 1; i <= 1000; i++) {
            x[i-1] = i * 0.01;
        }

        double[] CSI1 = new double[1000];
        double[] Simpson1 = new double[1000];
        double[] Trapezoidal1 = new double[1000];
        double[] Library1 = new double[1000];

        for (int i = 0; i < 1000; i++) {
            double a = x[i];

            double tabx[] = new double[10];
            for (int j = 0; j < 10; j++) {
                tabx[j] = a + j * 0.001;
            }

            double taby[] = new double[10];
            for (int j = 0; j < 10; j++) {
                taby[j] = calculateSin3x(tabx[j]);
            }

            CSI1[i] = CSI.integrateCSI(tabx, taby);
            Simpson1[i] = Simpson.integrateSimpson(tabx, taby);
            Trapezoidal1[i] = Trapezoidal.integrateTrapezoidal(tabx, taby);

            Library1[i] = calculateLibraryIntegral(tabx, taby);
        }

        double[] CSI2 = new double[1000];
        double[] Simpson2 = new double[1000];
        double[] Trapezoidal2 = new double[1000];
        double[] Library2 = new double[1000];

        for (int i = 0; i < 1000; i++) {
            double a = x[i];

            double tabx[] = new double[10];
            for (int j = 0; j < 10; j++) {
                tabx[j] = a + j * 0.001;
            }

            double taby[] = new double[10];
            for (int j = 0; j < 10; j++) {
                taby[j] = calculateCosxDiv5(tabx[j]);
            }

            CSI2[i] = CSI.integrateCSI(tabx, taby);
            Simpson2[i] = Simpson.integrateSimpson(tabx, taby);
            Trapezoidal2[i] = Trapezoidal.integrateTrapezoidal(tabx, taby);

            Library2[i] = calculateLibraryIntegral(tabx, taby);
        }

        double[] CSI3 = new double[1000];
        double[] Simpson3 = new double[1000];
        double[] Trapezoidal3 = new double[1000];
        double[] Library3 = new double[1000]; 

        for (int i = 0; i < 1000; i++) {
            double a = x[i];

            double tabx[] = new double[10];
            for (int j = 0; j < 10; j++) {
                tabx[j] = a + j * 0.001;
            }

            double taby[] = new double[10];
            for (int j = 0; j < 10; j++) {
                taby[j] = calculateEx(tabx[j]);
            }

            CSI3[i] = CSI.integrateCSI(tabx, taby);
            Simpson3[i] = Simpson.integrateSimpson(tabx, taby);
            Trapezoidal3[i] = Trapezoidal.integrateTrapezoidal(tabx, taby);

            Library3[i] = calculateLibraryIntegral(tabx, taby);
        }

        saveToFile("CSI1.txt", x, CSI1);
        saveToFile("Simpson1.txt", x, Simpson1);
        saveToFile("Trapezoidal1.txt", x, Trapezoidal1);
        saveToFile("Library1.txt", x, Library1);

        saveToFile("CSI2.txt", x, CSI2);
        saveToFile("Simpson2.txt", x, Simpson2);
        saveToFile("Trapezoidal2.txt", x, Trapezoidal2);
        saveToFile("Library2.txt", x, Library2);

        saveToFile("CSI3.txt", x, CSI3);
        saveToFile("Simpson3.txt", x, Simpson3);
        saveToFile("Trapezoidal3.txt", x, Trapezoidal3);
        saveToFile("Library3.txt", x, Library3);
    }

    public static void saveToFile(String filename, double[] x, double[] y) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < x.length; i++) {
                writer.write(x[i] + " " + y[i] + "\n");
            }
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
