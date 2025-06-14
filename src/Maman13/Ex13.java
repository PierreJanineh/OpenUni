package Maman13;

import java.util.ArrayList;

public class Ex13 {
    public static void main(String[] args) {
        // First Question: //
        // A: //
        int[] b = new int[] {4, 3, 8, 15, 17};
        System.out.println("First Question (a) -> `get(int[] b, int k)`");
        System.out.println(get(b, 4));
        System.out.println();

        // First Question: //
        // B: //
        int[] b1 = new int[] {1, 4, 10, 17, 26};
        System.out.println("First Question (b) -> `find(int[] b, int x)`");
        System.out.println(find(b1, 7));
        System.out.println();

        // Second Question: //
        int[] arr = new int[] {2, 3, 8, 27};
        System.out.println("Second Question -> `superInc(int[] arr, int k)`");
        System.out.println(superInc(arr, 30));
        System.out.println();

        // Third Question: //
        int[] a = new int[] {1, 2, 0, 3, -1};
//        int[] a = new int[] {1, 2, 0, 4, -1};
        System.out.println("Third Question -> `countEqualDiff(int[] arr, int diff)`");
        System.out.println(countEqualDiff(a, 1));
        System.out.println();

        // Fourth Question: //
        int[][] m = new int[][] {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
        System.out.println("Fourth Question -> `minPoints(int[][] m)`");
        System.out.println(minPoints(m));
        System.out.println();
    }

    // First Question: //
    // A: //
    /**
     * Get the k-th element of the array a. Calculate the value of b[k] - b[k - 1] to get the vale of a[k].
     * Time complexity: O(1), due to the constant number of times (1) this method will run.
     * Space complexity: O(1), due to the constant number of times (1) this method will run and use memory.
     * @param b The sums array to use to get the value in array a.
     * @param k The index of the element to get.
     * @return The k-th element of the array a.
     */
    public static int get(int[] b, int k) {
        if (k == 0) return b[0];

        return b[k] - b[k - 1];
    }

    // First Question: //
    // B: //
    /**
     * Find the index of the element x in the array a.
     * Time complexity: O(log n), due to the iterations that depend on the size of the array a (n), and the number of times log₂(n) this method will run. Each iteration performs O(1) work.
     * Space complexity: O(1), due to the memory used by the variables (mid, left, right), which their sizes are constant.
     * @param b The sums array to use for finding values in array a.
     * @param x The value to look for in array a.
     * @return The index of the element z in the array a, or -1 if x is not in a.
     */
    public static int find(int[] b, int x) {
        int left = 0;
        int right = b.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentValue = get(b, mid);

            if (currentValue == x) return mid;

            if (currentValue < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // Second Question: //
    /**
     * Check if there exists any subsequence of elements in the array that sum to k.
     * A subsequence can include any non-contiguous elements from the original array.
     * Time complexity: O(n), The array is traversed once, processing each element a single time.
     * Space complexity: O(1), The algorithm uses only a constant amount of additional memory, irrespective of the input size.
     * @param arr The input array.
     * @param k The target sum to find.
     * @return true if there exists a subsequence that sums to k, false otherwise.
     */
    public static boolean superInc(int[] arr, int k) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (k >= arr[i]) {
                k -= arr[i];
            }
            if (k == 0) return true;
        }
        return false;
    }

    // Third Question: //
    /**
     * Count the number of subsequences of elements in the array that their sums and counts are equal to a given value. And print the subsequences.
     * @param arr The array to count subsequences in.
     * @param diff The diff value that counts and sums should be equal to.
     * @return The number of subsequences of elements in the array that their sums and counts are equal to a given value.
     */
    public static int countEqualDiff(int[] arr, int diff) {
        ArrayList<Integer> group1 = new ArrayList<>();
        ArrayList<Integer> group2 = new ArrayList<>();
        return countEqualDiffHelper(arr, 0, group1, group2, diff);
    }

    /**
     * Recursive helper method for countEqualDiff.
     * @param arr The array to count subsequences in.
     * @param index The current index in the recursion.
     * @param group1 The first grouping of elements in the array. This grouping will be modified during the recursion.
     * @param group2 The second grouping of elements in the array. This grouping will be modified during the recursion.
     * @param diff The diff value that counts and sums should be equal to.
     * @return The number of subsequences of elements in the array that their sums and counts are equal to a given value.
     */
    private static int countEqualDiffHelper(int[] arr, int index,
                                        ArrayList<Integer> group1,
                                        ArrayList<Integer> group2,
                                        int diff) {
        if (index == arr.length) {
            if (isValidGrouping(group1, group2, diff)) {
                printGroups(group1, group2);
                return 1;
            }
            return 0;
        }

        group1.add(arr[index]);
        int count1 = countEqualDiffHelper(arr, index + 1, group1, group2, diff);
        group1.remove(group1.size() - 1);

        group2.add(arr[index]);
        int count2 = countEqualDiffHelper(arr, index + 1, group1, group2, diff);
        group2.remove(group2.size() - 1);

        return count1 + count2;
    }

    /**
     * Helper method for countEqualDiff. Prints the current grouping of elements in the array.
     * @param group1 The current grouping of elements in the array.
     * @param group2 The current grouping of elements in the array.
     */
    private static void printGroups(ArrayList<Integer> group1,
                                    ArrayList<Integer> group2) {
        System.out.println("Group 1: " + group1);
        System.out.println("Group 2: " + group2);
        System.out.println("-------------------");
    }

    /**
     * Helper method for countEqualDiff. Checks if the current grouping of elements in the array meets the requirements.
     * @param group1 The current grouping of elements in the array. This grouping will be modified during the recursion.
     * @param group2 The current grouping of elements in the array. This grouping will be modified during the recursion.
     * @param diff The diff value that counts and sums should be equal to.
     * @return true if the current grouping of elements in the array meets the requirements, false otherwise.
     */
    private static boolean isValidGrouping(ArrayList<Integer> group1,
                                           ArrayList<Integer> group2,
                                           int diff) {
        if (Math.abs(group1.size() - group2.size()) != diff) {
            return false;
        }

        int sum1 = group1.stream().mapToInt(Integer::intValue).sum();
        int sum2 = group2.stream().mapToInt(Integer::intValue).sum();

        return Math.abs(sum1 - sum2) == diff;
    }


    // Fourth Question: //
    /**
     * Find the minimum points in a 2D array m.
     * @param m The 2D array to find the minimum points in.
     * @return The minimum points in the 2D array m.
     */
    public static int minPoints(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        return minPointsFrom(m, rows - 1, cols - 1);
    }

    /**
     * Recursive helper method for minPoints.
     * @param m The 2D array to find the minimum points in.
     * @param i The current row index in the recursion.
     * @param j The current column index in the recursion.
     * @return The minimum points in the 2D array m.
     */
    private static int minPointsFrom(int[][] m, int i, int j) {
        if (i == 0 && j == 0) {
            return Math.max(1, 1 - m[0][0]);
        }

        int minPoints = Integer.MAX_VALUE;

        if (i > 0) {
            int up = minPointsFrom(m, i - 1, j);
            minPoints = Math.min(minPoints, up);
        }

        if (j > 0) {
            int left = minPointsFrom(m, i, j - 1);
            minPoints = Math.min(minPoints, left);
        }

        return Math.max(1, minPoints - m[i][j]);
    }
}
