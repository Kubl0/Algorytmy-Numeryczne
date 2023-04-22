public class Gauss {
    public static void gaussElimination(MySparseMatrix matrix, double[] b) {
        int n = matrix.size();
        
        for (int k = 0; k < n; k++) {
            for (int i = k + 1; i < n; i++) {
                double factor = matrix.get(i, k) / matrix.get(k, k);
                for (int j = k + 1; j < n; j++) {
                    double newElem = matrix.get(i, j) - factor * matrix.get(k, j);
                    matrix.set(i, j, newElem);
                }
                b[i] -= factor * b[k];
            }
        }
    
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix.get(i, j) * b[j];
            }
            b[i] = (b[i] - sum) / matrix.get(i, i);
        }
    }

    public static void gaussEliminationPartialPivot(MySparseMatrix matrix, double[] b) {
        int n = matrix.size();
        for (int k = 0; k < n; k++) {
            int maxRow = k;
            double maxVal = Math.abs(matrix.get(k, k));
            for (int i = k + 1; i < n; i++) {
                double val = Math.abs(matrix.get(i, k));
                if (val > maxVal) {
                    maxRow = i;
                    maxVal = val;
                }
            }
            if (maxRow != k) {
                for (int j = k; j < n; j++) {
                    double temp = matrix.get(k, j);
                    matrix.set(k, j, matrix.get(maxRow, j));
                    matrix.set(maxRow, j, temp);
                }
                double temp = b[k];
                b[k] = b[maxRow];
                b[maxRow] = temp;
            }
            for (int i = k + 1; i < n; i++) {
                double factor = matrix.get(i, k) / matrix.get(k, k);
                for (int j = k + 1; j < n; j++) {
                    double newElem = matrix.get(i, j) - factor * matrix.get(k, j);
                    matrix.set(i, j, newElem);
                }
                b[i] -= factor * b[k];
            }
        }
    
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix.get(i, j) * b[j];
            }
            b[i] = (b[i] - sum) / matrix.get(i, i);
        }
    }
    
    
}
