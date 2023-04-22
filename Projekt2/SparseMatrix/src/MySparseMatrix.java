import java.util.ArrayList;
import java.util.List;

public class MySparseMatrix {
    private int rows;
    private int columns;
    private List<List<Double>> data;

    public MySparseMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            data.add(new ArrayList<>(columns));
        }
    }

    public double get(int row, int col) {
        if (row >= rows || col >= columns) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        List<Double> rowData = data.get(row);
        return col < rowData.size() ? rowData.get(col) : 0.0;
    }

    public void set(int row, int col, double value) {
        if (row >= rows || col >= columns) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        List<Double> rowData = data.get(row);
        if (col < rowData.size()) {
            if (value == 0.0) {
                rowData.remove(col);
            } else {
                rowData.set(col, value);
            }
        } else if (value != 0.0) {
            for (int i = rowData.size(); i < col; i++) {
                rowData.add(0.0);
            }
            rowData.add(value);
        }
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(get(i, j) + " ");
            }
            System.out.println();
        }
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (get(i, j) != 0) {
                    size++;
                }
            }
        }
        return size;
    }
    
}
