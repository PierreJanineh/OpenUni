package Maman11;

import java.util.Scanner;

public class Train {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter 4 integers ");
        System.out.println("Please enter the speed of train 1:");
        int train1Speed = scan.nextInt();
        System.out.println("Please enter the time of train 1 (in minutes):");
        int train1Duration = scan.nextInt();
        System.out.println("Please enter the speed of train 2:");
        int train2Speed = scan.nextInt();
        System.out.println("Please enter the time of train 2 (in minutes):");
        int train2Duration = scan.nextInt();

        double distanceA = train1Speed * (train1Duration / 60.0);
        double distanceB = train2Speed * (train2Duration / 60.0);
        double distanceBetweenTrains = distanceA - distanceB;
        System.out.println("The distance between the trains is " + Math.abs(distanceBetweenTrains) + " km.");
    }
}