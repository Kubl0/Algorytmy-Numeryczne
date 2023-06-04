package Projekt3;

public class Test {

    public static void main(String[] args) {
        double[] x = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        double[] y1 = calculateSin3x(x);
        double[] y2 = calculateCosxDiv5(x);
        double[] y3 = calculateEx(x);

        double trapezoidalResult1 = Main.integrateTrapezoidal(x, y1);
        double simpsonResult1 = Main.integrateSimpson(x, y1);
        double trapezoidalResult2 = Main.integrateTrapezoidal(x, y2);
        double simpsonResult2 = Main.integrateSimpson(x, y2);
        double trapezoidalResult3 = Main.integrateTrapezoidal(x, y3);
        double simpsonResult3 = Main.integrateSimpson(x, y3);

        System.out.println("Całka sin(3x) metodą trapezów: " + trapezoidalResult1);
        System.out.println("Całka sin(3x) metodą Simpsona: " + simpsonResult1);
        System.out.println("Całka cos(x)/5 metodą trapezów: " + trapezoidalResult2);
        System.out.println("Całka cos(x)/5 metodą Simpsona: " + simpsonResult2);
        System.out.println("Całka e^x metodą trapezów: " + trapezoidalResult3);
        System.out.println("Całka e^x metodą Simpsona: " + simpsonResult3);

        double exactIntegral1 = calculateExactIntegralSin3x(0, 8);
        double exactIntegral2 = calculateExactIntegralCosxDiv5(0, 8);
        double exactIntegral3 = calculateExactIntegralEx(0, 8);

        System.out.println("Dokładna całka sin(3x): " + exactIntegral1);
        System.out.println("Dokładna całka cos(x)/5: " + exactIntegral2);
        System.out.println("Dokładna całka e^x: " + exactIntegral3);
    }

    public static double[] calculateSin3x(double[] x) {
        int n = x.length;
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            y[i] = Math.sin(3 * x[i]);
        }
        return y;
    }

    public static double[] calculateCosxDiv5(double[] x) {
        int n = x.length;
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            y[i] = Math.cos(x[i]) / 5;
        }
        return y;
    }

    public static double[] calculateEx(double[] x) {
        int n = x.length;
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            y[i] = Math.exp(x[i]);
        }
        return y;
    }

    public static double calculateExactIntegralSin3x(double a, double b) {
        return (-Math.cos(Math.cos(b)) * Math.sin(b) + Math.cos(Math.cos(a)) * Math.sin(a));
    }

    public static double calculateExactIntegralCosxDiv5(double a, double b) {
        return (5 * (Math.sin(b) - Math.sin(a)));
    }

    public static double calculateExactIntegralEx(double a, double b) {
        return (Math.exp(b) - Math.exp(a));
    }
}
