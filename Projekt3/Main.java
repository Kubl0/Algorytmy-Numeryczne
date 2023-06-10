package Projekt3;

import Projekt3.Methods.*;

public class Main {

    public static void main(String[] args) {
        double[] x = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        double[] y = {0, 1, 4, 9, 16, 25, 36, 49, 64};

        System.out.println("Całka metodą trapezów: " + Trapezoidal.integrateTrapezoidal(x, y));

        System.out.println("Całka metodą Simpsona: " + Simpson.integrateSimpson(x, y));

        System.out.println("Całka metodą CSI: " + CSI.integrateCSI(x, y));
    }
}