public class Test {
    
    public static double[] test(int[] args) {
        int size = args[0];
        int band = args[1];
        int density = args[2];

        double[][] denseMatrixA = Generator.DS2generateDenseMatrixA(size);
        double[][] bandMatrixA = Generator.DS2generateBandMatrixA(size, band);
        double[][] sparseMatrixA = Generator.DS2generateSparseMatrixA(size, density);

        double[] matrixB = Generator.generateMatrixB(size);

        MySparseMatrix_DS2 denseMatrixSolver = new MySparseMatrix_DS2(denseMatrixA);
        MySparseMatrix_DS2 bandMatrixSolver = new MySparseMatrix_DS2(bandMatrixA);
        MySparseMatrix_DS2 sparseMatrixSolver = new MySparseMatrix_DS2(sparseMatrixA);

        double[] denseMatrixX = denseMatrixSolver.solveA1(matrixB);
        double[] bandMatrixX = bandMatrixSolver.solveA1(matrixB);
        double[] sparseMatrixX = sparseMatrixSolver.solveA1(matrixB);

        double[] denseMatrixX1 = denseMatrixSolver.solveA2(matrixB);
        double[] bandMatrixX1 = bandMatrixSolver.solveA2(matrixB);
        double[] sparseMatrixX1 = sparseMatrixSolver.solveA2(matrixB);

        double[] denseMatrixAX = Generator.multiplyMatrix(denseMatrixA, denseMatrixX);
        double[] bandMatrixAX = Generator.multiplyMatrix(bandMatrixA, bandMatrixX);
        double[] sparseMatrixAX = Generator.multiplyMatrix(sparseMatrixA, sparseMatrixX);

        double[] denseMatrixAX1 = Generator.multiplyMatrix(denseMatrixA, denseMatrixX1);
        double[] bandMatrixAX1 = Generator.multiplyMatrix(bandMatrixA, bandMatrixX1);
        double[] sparseMatrixAX1 = Generator.multiplyMatrix(sparseMatrixA, sparseMatrixX1);
//        System.out.println("A1:");
//        System.out.println("Średni błąd macierzy gęstych: " + Generator.getAccuracy(denseMatrixAX, matrixB));
//        System.out.println("Średni błąd macierzy wstęgoe: " + Generator.getAccuracy(bandMatrixAX, matrixB));
//        System.out.println("Średni błąd macierzy rzadkic: " + Generator.getAccuracy(sparseMatrixAX, matrixB));
//        System.out.println("A2:");
//        System.out.println("Średni błąd macierzy gęstych: " + Generator.getAccuracy(denseMatrixAX1, matrixB));
//        System.out.println("Średni błąd macierzy wstęgoe: " + Generator.getAccuracy(bandMatrixAX1, matrixB));
//        System.out.println("Średni błąd macierzy rzadkic: " + Generator.getAccuracy(sparseMatrixAX1, matrixB));
        double[] result = new double[6];
        result[0] = Generator.getAccuracy(denseMatrixAX, matrixB);
        result[1] = Generator.getAccuracy(bandMatrixAX, matrixB);
        result[2] = Generator.getAccuracy(sparseMatrixAX, matrixB);
        result[3] = Generator.getAccuracy(denseMatrixAX1, matrixB);
        result[4] = Generator.getAccuracy(bandMatrixAX1, matrixB);
        result[5] = Generator.getAccuracy(sparseMatrixAX1, matrixB);
        return result;
    }
}