import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        try {
            File file = new File("cyferki.csv");
            Scanner scanner = new Scanner(file);

            double[] array = new double[9];
            int i = 0;

            while (scanner.hasNextDouble() && i < 9) {
                array[i] = scanner.nextDouble();
                i++;
            }

            scanner.close();

            double[][] A = {
                { array[0], array[1], array[2] },
                { array[3], array[4], array[5] },
                { array[6], array[7], array[8] }
            };

            MySparseMatrix_DS2 matrix = new MySparseMatrix_DS2(A);
            matrix.solveA2(new double[]{0.1, 0.2, 0.3});

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
