
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
        MySparseMatrix_DS2 m = new MySparseMatrix_DS2(A);
        m.solveWithPivot(B);
        m.solveWithoutPivot(B);

        System.out.println("--------------------------------------------------");
        double[][] A2 = {
                {2,-3,-2},
                {1,-1,2},
                {-1,2,2}
        };
        // double[][] A2 = {
        //         {2,1,-1},
        //         {-3,-1,2},
        //         {-2,1,2}
        // };
        double[] B2 = {8,-11,-3};
        MySparseMatrix_DS3 m2 = new MySparseMatrix_DS3(A2);
        m2.solveWithPivot(B2);
        m2.solveWithoutPivot(B2);
    }
}