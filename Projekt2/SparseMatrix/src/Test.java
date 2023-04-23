public class Test {
    
    public static void main(String[] args) {
        int size = 100;
        int band = 10;
        int density = 10;

        double[][] denseMatrixA = Generator.DS2generateDenseMatrixA(size);
        double[][] bandMatrixA = Generator.DS2generateBandMatrixA(size, band);
        double[][] sparseMatrixA = Generator.DS2generateSparseMatrixA(size, density);

        double[] denseMatrixB = Generator.generateMatrixB(size);
        double[] bandMatrixB = Generator.generateMatrixB(size);
        double[] sparseMatrixB = Generator.generateMatrixB(size);

        MySparseMatrix_DS2 denseMatrixSolver = new MySparseMatrix_DS2(denseMatrixA);
        MySparseMatrix_DS2 bandMatrixSolver = new MySparseMatrix_DS2(bandMatrixA);
        MySparseMatrix_DS2 sparseMatrixSolver = new MySparseMatrix_DS2(sparseMatrixA);

        double[] denseMatrixX = denseMatrixSolver.solveA1(denseMatrixB);
        double[] bandMatrixX = bandMatrixSolver.solveA1(bandMatrixB);
        double[] sparseMatrixX = sparseMatrixSolver.solveA1(sparseMatrixB);

        double[] denseMatrixAX = Generator.multiplyMatrix(denseMatrixA, denseMatrixX);
        double[] bandMatrixAX = Generator.multiplyMatrix(bandMatrixA, bandMatrixX);
        double[] sparseMatrixAX = Generator.multiplyMatrix(sparseMatrixA, sparseMatrixX);

        System.out.println("Dokładność macierzy gęstych: " + Generator.getAccuracy(denseMatrixAX, denseMatrixB));
        System.out.println("Dokładność macierzy wstęgowych: " + Generator.getAccuracy(bandMatrixAX, bandMatrixB));
        System.out.println("Dokładność macierzy rzadkich: " + Generator.getAccuracy(sparseMatrixAX, sparseMatrixB));
    }
}