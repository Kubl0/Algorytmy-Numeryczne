public class MySparseMatrix_DS2 {
    private double[][] A;

    public MySparseMatrix_DS2(double[][] A) {
        this.A = A;
    }
    public void solveWithPivot(double[] B)
    {
        int N = B.length;
        for (int k = 0; k < N; k++)
        {
            int max = k;
            for (int i = k + 1; i < N; i++)
                if (Math.abs(A[i][k]) > Math.abs(A[max][k]))
                    max = i;
            if(A[max][k] != 0) {
                double[] temp = A[k];
                A[k] = A[max];
                A[max] = temp;
                double t = B[k];
                B[k] = B[max];
                B[max] = t;

                for (int i = k + 1; i < N; i++) {
                    double factor = A[i][k] / A[k][k];
                    A[i][k] = 0;
                    B[i] -= factor * B[k];
                    for (int j = k+1; j < N; j++)
                        A[i][j] -= factor * A[k][j];
                }
            }
        }
        printRowEchelonForm(A, B);

        double[] X = new double[N];
        for (int i = N - 1; i >= 0; i--)
        {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++)
                sum += A[i][j] * X[j];
            X[i] = (B[i] - sum) / A[i][i];
        }

        printSolution(X);

    }
    public void printRowEchelonForm(double[][] A, double[] B)
    {
        int N = B.length;
        System.out.println("\nRow Echelon form : ");
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.printf("%.3f ", A[i][j]);
            System.out.printf("| %.3f\n", B[i]);
        }
        System.out.println();
    }

    public void printSolution(double[] X) {
        int N = X.length;
        System.out.println("Solution : ");
        for (int i = 0; i < N; i++)
            System.out.printf("x%d = %.3f ", i, X[i]);
        System.out.println();
    }

    public void solveWithoutPivot(double[] B) {
        int N = B.length;
        for (int k = 0; k < N-1; k++) {
            for (int i = k + 1; i < N; i++) {
                double factor = A[i][k] / A[k][k];
                B[i] -= factor * B[k];
                for (int j = k; j < N; j++) {
                    A[i][j] -= factor * A[k][j];
                }
            }
        }
        printRowEchelonForm(A, B);
    
        double[] X = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += A[i][j] * X[j];
            }
            X[i] = (B[i] - sum) / A[i][i];
        }
        printSolution(X);
    }
}
