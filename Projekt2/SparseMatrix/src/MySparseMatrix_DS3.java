import java.util.*;

public class MySparseMatrix_DS3 {
    private List<List<Double>> columns;

    public MySparseMatrix_DS3(List<List<Double>> columns) {
        this.columns = columns;
    }

    public void solveWithPivot(double[] B) {
        int N = B.length;
        for (int k = 0; k < N; k++) {
            int max = k;
            for (int i = k + 1; i < N; i++) {
                if (Math.abs(columns.get(i).get(k)) > Math.abs(columns.get(max).get(k))) {
                    max = i;
                }
            }
            if (columns.get(max).get(k) != 0) {
                Collections.swap(columns, k, max);
                double t = B[k];
                B[k] = B[max];
                B[max] = t;

                for (int i = k + 1; i < N; i++) {
                    double factor = columns.get(i).get(k) / columns.get(k).get(k);
                    columns.get(i).set(k, 0.0);
                    B[i] -= factor * B[k];
                    for (int j = k+1; j < N; j++) {
                        columns.get(i).set(j, columns.get(i).get(j) - factor * columns.get(k).get(j));
                    }
                }
            }
        }
        printRowEchelonForm(columns, B);

        double[] X = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += columns.get(j).get(i) * X[j];
            }
            X[i] = (B[i] - sum) / columns.get(i).get(i);
        }

        printSolution(X);
    }

    public void printRowEchelonForm(List<List<Double>> columns, double[] B) {
        int N = B.length;
        System.out.println("\nRow Echelon form : ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%.3f ", columns.get(j).get(i));
            }
            System.out.printf("| %.3f\n", B[i]);
        }
        System.out.println();
    }

    public void printSolution(double[] X) {
        int N = X.length;
        System.out.println("Solution : ");
        for (int i = 0; i < N; i++) {
            System.out.printf("x%d = %.3f ", i, X[i]);
        }
        System.out.println();
    }

    public void solveWithoutPivot(double[] B) {
        int N = B.length;
        for (int k = 0; k < N-1; k++) {
            for (int i = k + 1; i < N; i++) {
                double factor = columns.get(i).get(k) / columns.get(k).get(k);
                B[i] -= factor * B[k];
                for (int j = k; j < N; j++) {
                    columns.get(i).set(j, columns.get(i).get(j ) - factor * columns.get(k).get(j));
                }
            }
        }
        printRowEchelonForm(columns, B);

        double[] X = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += columns.get(j).get(i) * X[j];
            }
            X[i] = (B[i] - sum) / columns.get(i).get(i);
        }

        printSolution(X);
    }
}
