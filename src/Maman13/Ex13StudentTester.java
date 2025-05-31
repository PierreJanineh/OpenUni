package Maman13;
/**
 * 20441
 * 2025B
 * StudentTester Ex13 
 *
 */


public class Ex13StudentTester
{
    public static void main(String[] args)
    {
        System.out.println ("********** Question 1A **********\n");
        int[] a1 = {4, -1, 5, 7, 2};
        int[] b1 = {4, 3, 8, 15, 17};
        int k = 3;
        System.out.println("Checking method 'get(int[] b, int k)' on array "+toString(b1)+" and k = " + k);      
        int studentResult1A = Ex13.get(b1,k);
        System.out.println("Result is: "+ studentResult1A+" must be: "+a1[k]);
        System.out.println();
        
        System.out.println ("********** Question 1B **********\n");
        int[] a2 = {4, 5, 5, 6, 7, 7, 15};
        int[] b2 = {4, 9, 14, 20, 27, 34, 49};
        
        int x = 5;
        System.out.println("Checking method 'find(int[] b, int x)' on array "+toString(b2)+" and x = " + x);      
        int studentResult1B = Ex13.find(b2, x);
        System.out.println("Result is: "+ studentResult1B+" must be: 1 or 2");
        System.out.println();

        System.out.println ("********** Question 2 **********\n");
        int[] arr = {2, 3, 8, 27};
        k = 30;
        System.out.println("Checking method 'superInc' on array " + toString(arr)+" and k ="+k);
        boolean studentResult2 = Ex13.superInc(arr, k);
        System.out.println("Result is: "+studentResult2+" must be TRUE");
        System.out.println();
        k = 7;
        System.out.println("Checking method 'superInc' on array " + toString(arr)+" and k ="+k);
        studentResult2 = Ex13.superInc(arr, k);
        System.out.println("Result is: "+studentResult2+" must be FALSE");
        System.out.println();
 
     System.out.println ("********** Question 3 **********\n");
        int[] a= {1,2,0,3,-1};
        int diff = 3;
        System.out.println("Checking method 'countEqualDiff(int[] arr, int diff)' on array "+toString(a)+" and diff = " + diff);      
        int studentResult3A = Ex13.countEqualDiff(a,diff);
        System.out.println("Result is: "+ studentResult3A+" must be: 2");
        System.out.println();

        diff = 5;
        System.out.println("Checking method 'countEqualDiff(int[] arr, int diff)' on array "+toString(a)+" and diff = " + diff);      
        studentResult3A = Ex13.countEqualDiff(a,diff);
        System.out.println("Result is: "+ studentResult3A+" must be: 2");
        System.out.println();

        diff = 1;
        System.out.println("Checking method 'countEqualDiff(int[] arr, int diff)' on array "+toString(a)+" and diff = " + diff);      
        studentResult3A = Ex13.countEqualDiff(a,diff);
        System.out.println("Result is: "+ studentResult3A+" must be: 8");
        System.out.println();

        int[] b= {1,2,0,4,-1};
        diff = 3;
        System.out.println("Checking method 'countEqualDiff(int[] arr, int diff)' on array "+toString(b)+" and diff = " + diff);      
        int studentResult3B = Ex13.countEqualDiff(b,diff);
        System.out.println("Result is: "+ studentResult3B+" must be: 0");
        System.out.println();

        diff = 5;
        System.out.println("Checking method 'countEqualDiff(int[] arr, int diff)' on array "+toString(b)+" and diff = " + diff);      
        studentResult3B = Ex13.countEqualDiff(b,diff);
        System.out.println("Result is: "+ studentResult3B+" must be: 0");
        System.out.println();

        diff = 1;
        System.out.println("Checking method 'countEqualDiff(int[] arr, int diff)' on array "+toString(b)+" and diff = " + diff);      
        studentResult3B = Ex13.countEqualDiff(b,diff);
        System.out.println("Result is: "+ studentResult3B+" must be: 0");
        System.out.println();

        System.out.println ("********** Question 4 **********\n");
        int[][] mat ={
                {-2, -3, 3},
                {-5,-10,1},
                {10,30,-5}                
            };
        System.out.println("Checking method 'minPoints(int[][] m)' on array\n"+toString(mat));      
        int studentResult4 = Ex13.minPoints(mat);
        System.out.println("Result is: "+ studentResult4+" must be: 6");
        System.out.println();
        System.out.println("Array after the operation is performed:\n" + toString(mat));

    }

    private static String toString(int[] arr)
    {
        String s = "{";
        for(int i=0; i<arr.length-1; i++)
            s+=arr[i]+", ";
        return s+arr[arr.length-1]+"}";
    }

    private static String toString(int[][] arr)
    {
        String s="";
        for(int i=0; i<arr.length; i++)
        {
            s+="\t";
            for(int j=0; j<arr[i].length; j++)
                s+=arr[i][j]+"\t";
            s+="\n";
        }
        return s;
    }
}
