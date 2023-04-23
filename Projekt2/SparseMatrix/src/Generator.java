import java.util.Random;

public class Generator {

    public static double[][] DS2generateDenseMatrixA (int size) {
        double[][] matrixA = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixA[i][j] = getRandomDouble();
            }
        }
        return matrixA;
    }


    public static double[][] DS2generateBandMatrixA (int size, int band) {
        double[][] matrixA = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (Math.abs(i - j) <= band) {
                    matrixA[i][j] = getRandomDouble();
                }
            }
        }
        return matrixA;
    }

    public static double[][] DS2generateSparseMatrixA (int size, int density) {
        double[][] matrixA = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (getRandomInt() <= density) {
                    matrixA[i][j] = getRandomDouble();
                }
            }
        }
        return matrixA;
    }

    private static int getRandomInt() {
        Random random = new Random();
        return random.nextInt(100);
    }


    public static double[] generateMatrixB (int size) {
        double[] matrixB = new double[size];
        for (int i = 0; i < size; i++) {
            matrixB[i] = getRandomDouble();
        }
        return matrixB;
    }

    private static double getRandomDouble() {
        Random random = new Random();
        double randomNumber = random.nextDouble();
        double randomDouble = random.nextDouble() * 2e16;
        if (randomNumber < 0.5) {
            randomDouble = -randomDouble;
        } else {
            randomDouble = randomDouble - 1;
        }
        return randomDouble;
    }

    public static double[] multiplyMatrix(double[][] matrixA, double[] matrixX) {
        double[] matrixAX = new double[matrixA.length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA.length; j++) {
                matrixAX[i] += matrixA[i][j] * matrixX[j];
            }
        }
        return matrixAX;
    }

    public static String getAccuracy(double[] matrixAX, double[] matrixB) {
        double accuracy = 0;
        for (int i = 0; i < matrixAX.length; i++) {
            accuracy += Math.abs(matrixAX[i] - matrixB[i]);
        }
        return String.format("%.2f", accuracy/matrixAX.length);
    }
}