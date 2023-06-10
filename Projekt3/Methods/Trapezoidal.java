package Projekt3.Methods;

public class Trapezoidal {
    public static double integrateTrapezoidal(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("x i y muszą być tej samej długości");
        }
        double integral = 0;
        for (int i = 1; i < x.length; i++) {
            double h = x[i] - x[i - 1];
            double sum = (y[i] + y[i - 1]) / 2;
            integral += h * sum;
        }
        return integral;
    }
}
