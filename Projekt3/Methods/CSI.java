package Projekt3.Methods;

import java.util.Arrays;

public class CSI {
    public static double integrateCSI(double[] x, double[] y) {
        int n = x.length - 1;
        double[][] A = new double[n][n];
        double[] B = new double[n];

        for (int i = 0; i < n; i++) {
            if(i>0) {
                A[i][i] = 2 * (x[i + 1] - x[i - 1]);
                B[i] = 6 * ((y[i + 1] - y[i]) / (x[i + 1] - x[i]) - (y[i] - y[i - 1]) / (x[i] - x[i - 1]));
            }
            if (i > 0) {
                A[i][i - 1] = x[i] - x[i - 1];
            }
            if (i < n - 1) {
                A[i][i + 1] = x[i + 1] - x[i];
            }
        }

        int N = A.length;

        for (int k = 0; k < N; k++) {
            int max = k;
            for (int i = k + 1; i < N; i++) {
                if (Math.abs(A[i][k]) > Math.abs(A[max][k])) {
                    max = i;
                }
            }
            if (A[max][k] != 0) {
                double[] temp = A[k];
                A[k] = A[max];
                A[max] = temp;
                double t = B[k];
                B[k] = B[max];
                B[max] = t;

                double div = A[k][k];
                A[k][k] = 1;
                for (int j = k + 1; j < N; j++) {
                    A[k][j] /= div;
                }
                B[k] /= div;

                for (int i = k + 1; i < N; i++) {
                    double factor = A[i][k];
                    A[i][k] = 0;
                    for (int j = k + 1; j < N; j++) {
                        A[i][j] -= factor * A[k][j];
                    }
                    B[i] -= factor * B[k];
                }
            }
        }

        double integral = 0;

        for (int i = 0; i < n; i++) {
            double h = x[i + 1] - x[i];
            integral += y[i] * h + B[i] * Math.pow(h, 2) / 2;
        }

        return integral;
    }
}
