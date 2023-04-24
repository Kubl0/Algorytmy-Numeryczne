import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class sin_function {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("sin_function.csv");

		for (double x = -2 * Math.PI; x <= 2 * Math.PI; x += 0.0000125) {
			// built in sin function
			double builtInSin = Math.sin(x);

			// Taylor series front to back
			double taylorSin1 = taylor_sin_start(x, 20);

			// Taylor series back to front
			double taylorSin2 = taylor_sin_end(x, 20);

			// Taylor series front to back with earlier value
			double taylorSin3 = taylor_sin_start_earlier_value(x, 6);

			// Taylor series back to front with earlier value
			double taylorSin4 = taylor_sin_end_earlier_value(x, 20);

			fw.write(String.format(Locale.US, "%.6f;%.25f;%.25f;%.25f;%.25f;%.25f%n", x,
					builtInSin, taylorSin1,
					taylorSin2, taylorSin3, taylorSin4));

		}

		fw.close();

		double error = Math.sin(Math.PI / 2) - taylor_sin_start(Math.PI / 2, 5);
		System.out.println(error);

		double error2 = Math.abs(Math.sin(Math.PI / 2) - taylor_sin_start(Math.PI / 2, 20));
		System.out.println(error2);
		double error3 = Math.abs(Math.sin(Math.PI * 2) - taylor_sin_start(Math.PI * 2, 20));
		System.out.println(error3);

	}

	public static double helper(double x, int i) {
		double numerator = power(-1, i);
		double denominator = factorial(2 * i + 1);
		double multiplier = power(x, 2 * i + 1);

		double result = (numerator / denominator) * multiplier;
		return result;
	}

	public static double taylor_sin_start(double x, int n) {
		double result = 0;
		for (int i = 0; i <= n; i++) {
			result += helper(x, i);
		}

		return result;
	}

	public static double taylor_sin_end(double x, int n) {
		List<Double> list = new ArrayList<Double>();
		for (int i = n; i >= 0; i--) {
			list.add(helper(x, i));
		}

		return list.stream().reduce(0.0, (a, b) -> a + b);
	}

	private static List<Double> calculate_terms(double x, int n) {
		double polar = 1;
		double denominator = 1;
		double meter = x;
		List<Double> terms = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			double term = polar * meter / denominator;
			terms.add(term);
			polar *= -1;
			denominator *= (2 * i) * (2 * i + 1);
			meter *= x * x;
		}

		return terms;
	}

	public static double taylor_sin_start_earlier_value(double x, int n) {
		List<Double> terms = calculate_terms(x, n);
		return terms.stream().reduce(0.0, (a,b) -> a+b);
	}

	public static double taylor_sin_end_earlier_value(double x, int n) {
		List<Double> terms = calculate_terms(x, n);
		Collections.reverse(terms);
		return terms.stream().reduce(0.0, (a,b) -> a+b);
	}

	//
	//
	// FUNKCJE POMOCNICZE
	//
	//

	public static double factorial(int n) {
		double result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	public static double power(double x, int n) {
		double result = 1;
		for (int i = 0; i < n; i++) {
			result *= x;
		}
		return result;
	}
}
