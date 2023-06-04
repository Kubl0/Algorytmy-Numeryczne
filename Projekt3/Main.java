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
        if (x.length != y.length) {
            throw new IllegalArgumentException("x i y musza byc tej samej dlugosci");
        }
        double integral = 0;
        for (int i = 1; i < x.length; i++) {
            double h = x[i] - x[i - 1];
            double sum = (y[i] + y[i - 1]) / 2;
            integral += h * sum;
        }
        return integral;
    }

    public static double integrateSimpson(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Tablice x i y muszą być tej samej długości.");
        }
        
        int N = x.length;
        double h = x[1] - x[0];
        
        // 1/3
        double sum = 1.0 / 3.0 * (y[0] + y[N - 1]);
        
        // 4/3
        for (int i = 1; i < N - 1; i += 2) {
            // double xi = x[i];
            sum += 4.0 / 3.0 * y[i];
        }
        
        // 2/3
        for (int i = 2; i < N - 1; i += 2) {
            // double xi = x[i];
            sum += 2.0 / 3.0 * y[i];
        }
        
        return sum * h;
    }

}
