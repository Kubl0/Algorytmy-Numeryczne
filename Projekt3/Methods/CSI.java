package Projekt3.Methods;

import java.util.Arrays;

public class CSI {
    public static double integrateCSI(double[] x, double[] y) {
        double a = x[0];
        double b = x[x.length - 1];

        // Obliczanie macierzy A
        double[][] A = new double[x.length][x.length];
        double[] B = new double[x.length];

        for (int i = 0; i < x.length; i++) {
            Arrays.fill(A[i], 0.0);

            if (i == 0 || i == x.length - 1) {
                A[i][i] = 1.0;
                B[i] = 0.0;
            } else {
                double h1 = x[i] - x[i - 1];
                double h2 = x[i + 1] - x[i];
                A[i][i - 1] = h1;
                A[i][i] = 2.0 * (h1 + h2);
                A[i][i + 1] = h2;
                B[i] = (3.0 / h2) * (y[i + 1] - y[i]) - (3.0 / h1) * (y[i] - y[i - 1]);
            }
        }

        // Rozwiązanie macierzy A
        double[] C = solveMatrix(A, B);

        double integral = 0;

        for (int i = 0; i < x.length - 1; i++) {
            double xa = Math.max(x[i], a);
            double xb = Math.min(x[i + 1], b);

            double segmentIntegral = integrateSegment(xa, xb, x[i], y[i], C[i], (y[i + 1] - y[i]) / (x[i + 1] - x[i]), x[i + 1], y[i + 1]);
            integral += segmentIntegral;
        }

        return integral;
    }

    private static double[] solveMatrix(double[][] A, double[] BOriginal) {
        int N = BOriginal.length;
        double[][] AMatrix = new double[N][N];
        for (int i = 0; i < N; i++) {
            int rowLength = A[i].length;
            System.arraycopy(A[i], 0, AMatrix[i], 0, rowLength);
        }

        double[] B = new double[N];
        System.arraycopy(BOriginal, 0, B, 0, N);

        for (int k = 0; k < N; k++) {
            int max = k;
            for (int i = k + 1; i < N; i++) {
                if (Math.abs(AMatrix[i][k]) > Math.abs(AMatrix[max][k])) {
                    max = i;
                }
            }
            if (AMatrix[max][k] != 0) {
                double[] temp = AMatrix[k];
                AMatrix[k] = AMatrix[max];
                AMatrix[max] = temp;
                double t = B[k];
                B[k] = B[max];
                B[max] = t;

                double div = AMatrix[k][k];
                AMatrix[k][k] = 1;
                for (int j = k + 1; j < N; j++) {
                    AMatrix[k][j] /= div;
                }
                B[k] /= div;

                for (int i = k + 1; i < N; i++) {
                    double factor = AMatrix[i][k];
                    AMatrix[i][k] = 0;
                    for (int j = k + 1; j < N; j++) {
                        AMatrix[i][j] -= factor * AMatrix[k][j];
                    }
                    B[i] -= factor * B[k];
                }
            }
        }
        return calculateResult(N, AMatrix, B);
    }

    private static double[] calculateResult(int n, double[][] a, double[] b) {
        double[] X = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = b[i];
            for (int j = i + 1; j < n; j++) {
                sum -= a[i][j] * X[j];
            }
            X[i] = sum / a[i][i];
        }
        return X;
    }

    private static double integrateSegment(double a, double b, double x0, double y0, double c, double d, double x1, double y1) {
        double h = x1 - x0;
        double integral = (h / 6) * (y0 + 4 * ((c * a) + (d * a * a)) + y1);

        return integral;
    }
}
