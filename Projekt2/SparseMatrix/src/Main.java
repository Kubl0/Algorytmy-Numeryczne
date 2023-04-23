
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
        MySparseMatrix_DS2 m1 = new MySparseMatrix_DS2(A);
        m1.solveA2(B);
        m1.solveA1(B);

        double[][] A2 = {
                {2,-3,-2},
                {1,-1,1},
                {-1,2,2}
        };
        double[] B2 = {8,-11,-3};
        MySparseMatrix_DS3 m2 = new MySparseMatrix_DS3(A2);
        m2.solveA1(B2);
    }
}