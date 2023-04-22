import java.util.ArrayList;
import java.util.List;

public class MySparseMatrix {
    private List<List<Double>> matrix;
    private int size;

    public MySparseMatrix(int size) {
        this.size = size;
        matrix = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            matrix.add(new ArrayList<>(size));
        }
    }

    public void set(int row, int col, double value) {
        matrix.get(row).add(col, value);
    }

    public double get(int row, int col) {
        return matrix.get(row).get(col);
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(get(i, j) + " ");
            }
            System.out.println();
        }
    }
}
