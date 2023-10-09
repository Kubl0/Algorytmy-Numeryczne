package Projekt3.Methods;

public class Simpson {
    public static double integrateSimpson(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Tablice x i y muszą być tej samej długości");
        }
        int N = x.length;
        double h = x[1] - x[0];
        // 1/3
        double sum = 1.0 / 3.0 * (y[0] + y[N - 1]);
        // 4/3
        for (int i = 1; i < N - 1; i += 2) {
            sum += 4.0 / 3.0 * y[i];
        }
        // 2/3
        for (int i = 2; i < N - 1; i += 2) {
            sum += 2.0 / 3.0 * y[i];
        }
        return sum * h;
    }
}
