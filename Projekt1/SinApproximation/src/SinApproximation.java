import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class SinApproximation {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("results.csv");
            for (double x = 0.000006; x <= 2 * Math.PI; x += 0.000006) {
                // Obliczenie sin(x) przy użyciu bibliotecznej funkcji Math.sin(x)
                double sinMath = Math.sin(x);

                int n = 20; // liczba sumowanych składników
                // Obliczenie sin(x) przy użyciu szeregu Taylora, sumowanie od początku
                double sinTaylor1 = 0;
                for (int i = 0; i <= n; i++) {
                    sinTaylor1 += power(-1, i) * power(x, 2 * i + 1) / factorial(2 * i + 1);
                }

                // Obliczenie sin(x) przy użyciu szeregu Taylora, sumowanie od końca
                double sinTaylor2 = 0;
                for (int i = n; i >= 0; i--) {
                    sinTaylor2 += power(-1, i) * power(x, 2 * i + 1) / factorial(2 * i + 1);
                }

                // Obliczenie sin(x) przy użyciu szeregu Taylora, obliczanie kolejnego wyrazu na podstawie poprzedniego
                List<Double> terms1 = help_calculate(x, n);
                double sinTaylor3 = 0;
                for (double term : terms1) {
                    sinTaylor3 += term;
                }

                // Obliczenie sin(x) przy użyciu szeregu Taylora, obliczanie kolejnego wyrazu na podstawie poprzedniego, sumowanie od końca
                List<Double> terms2 = help_calculate(x, n);
                double sinTaylor4 = 0;
                Collections.reverse(terms2);
                for (double term : terms2) {
                    sinTaylor4 += term;
                }

                fileWriter.write(String.format(Locale.US, "%.6f,%.18f,%.18f,%.18f,%.18f,%.18f%n", x, sinMath, sinTaylor1, sinTaylor2, sinTaylor3, sinTaylor4));
            }

            fileWriter.close();
            System.out.println("Obliczenia zakończone. Wyniki zapisane do pliku results.csv");
        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku");
            e.printStackTrace();
        }
    }

    public static double power(double x, int n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }

    public static double factorial(int n) {
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static List<Double> help_calculate(double x, int n) {
        double polar = 1;
        double denominator = 1;
        double meter = x;
        List<Double>

        terms = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            terms.add(polar * meter / denominator);
            polar *= -1;
            denominator *= (2 * i + 2) * (2 * i + 3);
            meter *= x * x;
        }
        return terms;
    }
}