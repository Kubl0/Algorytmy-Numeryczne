package Projekt3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.IntStream;

import Projekt3.Methods.*;

import static Projekt3.Test.*;

public class Test3 {
    public static void main(String[] args) {
        double[][] x = new double[10][];

        for (int i = 1; i <= 10; i++) {
            x[i - 1] = new double[i * 100];
            for (int j = 1; j <= i * 100; j++) {
                x[i - 1][j - 1] = j * 0.1 / i;
            }

            double[] y = new double[i * 100];

            for (int j = 1; j <= i * 100; j++) {
                y[j - 1] = calculateSin3x(x[i - 1][j - 1]);
            }

            System.out.println(i * 100 + " " + Math.abs(CSI.integrateCSI(x[i - 1], y) - calculateLibraryIntegral(x[i - 1], y)));
        }
    }
}
