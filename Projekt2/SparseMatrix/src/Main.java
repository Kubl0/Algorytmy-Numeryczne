public class Main {
    public static void main(String[] args) {
        int n = 3;
        MySparseMatrix matrix = new MySparseMatrix(n, n);
        double[] b = new double[n];

        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(0, 2, 3);
        matrix.set(1, 0, 4);
        matrix.set(1, 1, 5);
        matrix.set(1, 2, 6);
        matrix.set(2, 0, 7);
        matrix.set(2, 1, 8);
        matrix.set(2, 2, 9);

        b[0] = 1;
        b[1] = 2;
        b[2] = 3;

        System.out.println("Macierz A:");
        matrix.print();

        System.out.println("Wektor b:");
        for (int i = 0; i < n; i++) {
            System.out.println(b[i]);
        }

        Gauss.gaussElimination(matrix, b);

        System.out.println("Rozwiązanie:");
        for (int i = 0; i < n; i++) {
            System.out.println(b[i]);
        }
    }
}
