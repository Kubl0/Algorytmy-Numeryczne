import java.util.ArrayList;

public class MySparseMatrix {
    private int rows;
    private int columns;
    private ArrayList<ArrayList<Double>> matrix;

    public MySparseMatrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            this.matrix.add(new ArrayList<Double>());
        }
    }

    public void initialSet(ArrayList<ArrayList<Double>> data){
        if(data.size() != rows || data.get(0).size() != columns){
            throw new IllegalArgumentException("Wrong size of matrix");
        }
        this.matrix = data;
    }

    public void print(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public int size(){
        return rows;
    }

    public double get(int row, int col) {
        return matrix.get(row).get(col);
    }

    public void set(int row, int col, double value) {
        matrix.get(row).add(col, value);
    }

}
