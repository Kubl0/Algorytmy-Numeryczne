package Projekt3;

public class Main {
    public static void main(String[] args) {
        double[] x = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        double[] y = {0, 1, 4, 9, 16, 25, 36, 49, 64};

        double trapezoidalResult = integrateTrapezoidal(x, y);
        System.out.println("Całka metodą trapezów: " + trapezoidalResult);

        double simpsonResult = integrateSimpson(x, y);
        System.out.println("Całka metodą Simpsona: " + simpsonResult);
    }

    public static double integrateTrapezoidal(double[] x, double[] y) {
        double integral = 0;
        for (int i = 1; i < x.length; i++) {
            double h = x[i] - x[i - 1];
            double sum = (y[i] + y[i - 1]) / 2;
            integral += h * sum;
        }
        return integral;
    }

    public static double integrateSimpson(double[] x, double[] y) {
        double integral = 0;
        for (int i = 1; i < x.length - 1; i += 2) {
            double h = x[i + 1] - x[i - 1];
            double sum = y[i - 1] + 4 * y[i] + y[i + 1];
            integral += (h / 3) * sum;
        }
        return integral;
    }
}
