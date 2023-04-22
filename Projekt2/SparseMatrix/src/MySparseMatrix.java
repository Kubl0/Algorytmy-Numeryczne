public class MySparseMatrix {
    private int[][] matrix;
    private int rows;
    private int columns;

    public MySparseMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new int[rows][columns];
    }

    public void set(int row, int column, int value) {
        matrix[row][column] = value;
    }

    public int get(int row, int column) {
        return matrix[row][column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    
}
