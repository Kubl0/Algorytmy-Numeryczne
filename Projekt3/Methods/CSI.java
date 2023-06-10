package Projekt3.Methods;

import java.util.Arrays;

public class CSI {
    public static double integrateCSI(double[] x, double[] y) {
        int n = x.length - 1;
        double[] h = new double[n];
        double[] alpha = new double[n];
        double[] l = new double[n + 1];
        double[] mu = new double[n + 1];
        double[] z = new double[n + 1];
        double[] c = new double[n + 1];
        double[] d = new double[n];

        for (int i = 0; i < n; i++) {
            h[i] = x[i + 1] - x[i];
            alpha[i] = (3 / h[i]) * (y[i + 1] - y[i]);
        }

        l[0] = 1;
        mu[0] = 0;
        z[0] = 0;

        for (int i = 1; i < n; i++) {
            l[i] = 2 * (x[i + 1] - x[i - 1]) - h[i - 1] * mu[i - 1];
            mu[i] = h[i] / l[i];
            z[i] = (alpha[i - 1] - h[i - 1] * z[i - 1]) / l[i];
        }

        l[n] = 1;
        z[n] = 0;
        c[n] = 0;

        for (int j = n - 1; j >= 0; j--) {
            c[j] = z[j] - mu[j] * c[j + 1];
            d[j] = (c[j + 1] - c[j]) / (3 * h[j]);
        }

        double integral = 0;

        for (int i = 0; i < n; i++) {
            integral += y[i] * h[i] + c[i] * Math.pow(h[i], 2) + d[i] * Math.pow(h[i], 3);
        }

        return integral;
    }
}
