package Projekt3;

public class Main {

    public static void main(String[] args) {
        double[] x = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        double[] y = {0, 1, 4, 9, 16, 25, 36, 49, 64};

        double trapezoidalResult = integrateTrapezoidal(x, y);
        System.out.println("Całka metodą trapezów: " + trapezoidalResult);

        double simpsonResult = integrateSimpson(x, y);
        System.out.println("Całka metodą Simpsona: " + simpsonResult);

        double[][] coefficients = interpolateCSI(x, y);
        double[] integrals = calculateIntegrals(coefficients, x);
        double[] B = integrals;
        double[] solution = solveA2(coefficients, B);
        double totalIntegral = 0;
        for (double integral : solution) {
            totalIntegral += integral;
        }
        System.out.println("Całka całkowita: " + totalIntegral);

    }

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

    public static double[][] interpolateCSI(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Tablice x i y muszą być tej samej długości");
        }

        final int n = x.length - 1;

        final double h[] = new double[n];
        for (int i = 0; i < n; i++) {
            h[i] = x[i + 1] - x[i];
        }

        final double mu[] = new double[n];
        final double z[] = new double[n + 1];
        mu[0] = 0d;
        z[0] = 0d;
        double g = 0;
        for (int i = 1; i < n; i++) {
            g = 2d * (x[i + 1] - x[i - 1]) - h[i - 1] * mu[i - 1];
            mu[i] = h[i] / g;
            z[i] = (3d * (y[i + 1] * h[i - 1] - y[i] * (x[i + 1] - x[i - 1]) + y[i - 1] * h[i]) /
                    (h[i - 1] * h[i]) - h[i - 1] * z[i - 1]) / g;
        }

        final double b[] = new double[n];
        final double c[] = new double[n + 1];
        final double d[] = new double[n];

        z[n] = 0d;
        c[n] = 0d;

        for (int j = n - 1; j >= 0; j--) {
            c[j] = z[j] - mu[j] * c[j + 1];
            b[j] = (y[j + 1] - y[j]) / h[j] - h[j] * (c[j + 1] + 2d * c[j]) / 3d;
            d[j] = (c[j + 1] - c[j]) / (3d * h[j]);
        }

        final double coefficients[][] = new double[n][4];
        for (int i = 0; i < n; i++) {
            coefficients[i][0] = y[i];
            coefficients[i][1] = b[i];
            coefficients[i][2] = c[i];
            coefficients[i][3] = d[i];
        }

        return coefficients;
    }

    public static double[] calculateIntegrals(double[][] coefficients, double[] x) {
        int n = coefficients.length;
        double[] integrals = new double[n];
        for (int i = 0; i < n; i++) {
            double[] c = coefficients[i];
            double integral = c[0] * x[i] + c[1] / 2 * Math.pow(x[i], 2) + c[2] / 3 * Math.pow(x[i], 3) + c[3] / 4 * Math.pow(x[i], 4);
            integrals[i] = integral;
        }
        return integrals;
    }
    public static double[] solveA2(double[][] A, double[] BOriginal) {
        int N = BOriginal.length;
        double[][] AMatrix = new double[N][N];
        for (int i = 0; i < N; i++) {
            int rowLength = A[i].length;
            System.arraycopy(A[i], 0, AMatrix[i], 0, rowLength);
            // System.arraycopy(A[i], 0, AMatrix[i], 0, N);
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
    
}
