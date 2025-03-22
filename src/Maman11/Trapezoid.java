package Maman11;

import java.util.Scanner;

public class Trapezoid {
    public static void main (String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the left point coordinates of the base followed by its length:");
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int length1 = scan.nextInt();
        System.out.println ("Please enter the left point coordinates of the other base followed by its length:");
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        int length2 = scan.nextInt();

        int x3 = x1 + length1;
        int y3 = y1;
        int x4 = x2 + length2;
        int y4 = y2;
        double distanceBetweenP1AndP2 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double distanceBetweenP3AndP4 = Math.sqrt(Math.pow(x3 - x4, 2) + Math.pow(y3 - y4, 2));
        double area = Math.abs(y1 - y2) * (length1 + length2) / 2.0;
        double perimeter = length1 + length2 + distanceBetweenP1AndP2 + distanceBetweenP3AndP4;

        System.out.println("The area of the trapezoid is " + area);
        System.out.println("The perimeter of the trapezoid is " + perimeter);
    }
}
