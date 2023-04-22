
public class Main
{
    public static void main (String[] args)
    {
        double[][] A = {
                {2,1,-1},
                {-3,-1,2},
                {-2,1,2}
        };
        double[] B = {8,-11,-3};
        MySparseMatrix_A2 m = new MySparseMatrix_A2(A);
        m.solveWithPivot(B);

    }
}