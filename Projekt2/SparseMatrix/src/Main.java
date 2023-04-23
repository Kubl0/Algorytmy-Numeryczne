
public class Main
{
    public static void main (String[] args)
    {
        int[] values = new int[3];
        values[0] = 100;
        values[1] = 10;
        values[2] = 10;

        double[] results = Test.test(values);
        System.out.println("A1: ");
        System.out.println("Dense: " + results[0]);
        System.out.println("Band: " + results[1]);
        System.out.println("Sparse: " + results[2]);
        System.out.println("A2: ");
        System.out.println("Dense: " + results[3]);
        System.out.println("Band: " + results[4]);
        //3 decimal places
        System.out.println("Sparse: " + results[5]);
    }
}
