public class MySparseMatrix_A2 {
    private double[][] A;

    public MySparseMatrix_A2(double[][] A) {
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

                for (int i = k + 1; i < N; i++) {
                    double factor = A[i][k] / A[k][k];
                    A[i][k] = 0;
                    for (int j = k; j < N; j++)
                        A[i][j] -= factor * A[k][j];
                }
            }
        }
        printRowEchelonForm(A);
    }
    public void printRowEchelonForm(double[][] A) {
        int N = A[0].length;
        System.out.println("\nRow Echelon form : ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf("%.3f ", A[i][j]);
            System.out.println();
        }
    }
}
