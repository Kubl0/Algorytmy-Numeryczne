import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main
{
    public static void main (String[] args) throws IOException {
        FileWriter fileWriterDS2 = new FileWriter("resultsDS2.csv");
        PrintWriter printWriterDS2 = new PrintWriter(fileWriterDS2);

        int[] values = new int[3];
        values[0] = 100;
        values[1] = 1;
        values[2] = 10;

        printWriterDS2.println("DenseMatrixA1;BandMatrixA1;SparseMatrixA1;DenseMatrixA2;BandMatrixA2;SparseMatrixA2");
        int testSize = 100;
        double[] errors = new double[6];
        for (int i = 0; i < testSize; i++) {
            //Choose DS2 or DS3
            double[] results = Test.testDS3(values);
            for (int j = 0; j < 6; j++) {
                errors[j] += results[j];
            }
            printWriterDS2.println(results[0] + ";" + results[1] + ";" + results[2] + ";" + results[3] + ";" + results[4] + ";" + results[5]);
        }
        for (int i = 0; i < 6; i++) {
            errors[i] /= testSize;
        }
        System.out.println("DenseMatrixA1: " + errors[0]);
        System.out.println("BandMatrixA1: " + errors[1]);
        System.out.println("SparseMatrixA1: " + errors[2]);
        System.out.println("DenseMatrixA2: " + errors[3]);
        System.out.println("BandMatrixA2: " + errors[4]);
        System.out.println("SparseMatrixA2: " + errors[5]);

        printWriterDS2.close();

    }
}
