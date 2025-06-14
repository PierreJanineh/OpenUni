package Maman14;

public class StudentsTester
{
    public static void main(String[] args)
    {
        MatrixList ml;
        ml = new MatrixList(new int[1][1]);
        int i = ml.getDataIJ (0, 0);
        ml.setDataIJ (0, 0, 0);
        System.out.println(ml);
        System.out.println("If there is a @ sign in the line above\n" +
            "(and not just a single 0)\n" +    
            "it means you didn't implement the toString method.");
        boolean b1 = ml.isDescending();
        int j = ml.howManyNegative();

        System.out.println("\n============================\n" +
            "If you see this message,\n" +
            "it means your software worked fine with this tester,\n" +
            "which only means you wrote all the expected methods\n" +
            "with the right interface.\n" +
            "It DOES NOT MEAN your software does exactly what it is\n" +
            "expected to do.\n" +
            "To check that, you will have to write your own tester\n" +
            "which must include all sorts of scenarios.\n" +
            "The bugs your tester doesn't find - will be found\n" +
            "by your instructor's tester, and will cost you\n" +
            "points in your grade.");

        System.out.println("\n============================\n");

        testConstructorAndToString();
        testGetDataIJ();
        testSetDataIJ();
        testIsDescending();
        testHowManyNegative();
        System.out.println("✅ All tests completed.");
    }

    private static void testConstructorAndToString() {
        int[][] mat = {
                {4, 3},
                {2, 1}
        };
        MatrixList ml = new MatrixList(mat);
        String expected = "4\t3\n2\t1\n";
        assert ml.toString().equals(expected) : "❌ Constructor or toString failed.";
    }

    private static void testGetDataIJ() {
        int[][] mat = {
                {5, 2},
                {3, 1}
        };
        MatrixList ml = new MatrixList(mat);
        assert ml.getDataIJ(1, 1) == 1 : "❌ getDataIJ(1,1) failed.";
        assert ml.getDataIJ(5, 5) == Integer.MIN_VALUE : "❌ getDataIJ out-of-bounds failed.";
    }

    private static void testSetDataIJ() {
        int[][] mat = {
                {5, 2},
                {3, 1}
        };
        MatrixList ml = new MatrixList(mat);
        ml.setDataIJ(9, 1, 1);
        assert ml.getDataIJ(1, 1) == 9 : "❌ setDataIJ failed.";
    }

    private static void testIsDescending() {
        int[][] descending = {
                {9, 6, 3},
                {8, 5, 2},
                {7, 4, 1}
        };
        MatrixList ml1 = new MatrixList(descending);
        assert ml1.isDescending() : "❌ isDescending failed on valid matrix.";

        int[][] notDescending = {
                {9, 9, 3},
                {8, 5, 2},
                {7, 4, 1}
        };
        MatrixList ml2 = new MatrixList(notDescending);
        assert !ml2.isDescending() : "❌ isDescending failed to catch invalid row.";
    }

    private static void testHowManyNegative() {
        int[][] mat = {
                {4, 3, -1},
                {2, -2, -3},
                {-1, -3, -4}
        };
        MatrixList ml = new MatrixList(mat);
        assert ml.howManyNegative() == 6 : "❌ howManyNegative failed.";

        int[][] noNegatives = {
                {5, 4},
                {3, 2}
        };
        MatrixList ml2 = new MatrixList(noNegatives);
        assert ml2.howManyNegative() == 0 : "❌ howManyNegative failed on no-negatives.";
    }
}
