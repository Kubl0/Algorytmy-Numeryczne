import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 3;
        MySparseMatrix matrix = new MySparseMatrix(rows, columns);
        ArrayList<ArrayList<Double>> data = new ArrayList<>();
        data.addAll(Arrays.asList(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0)),
                new ArrayList<>(Arrays.asList(4.0, 5.0, 6.0)), new ArrayList<>(Arrays.asList(7.0, 8.0, 9.0))));

        matrix.initialSet(data);
        matrix.print();
    }
}
