package Maman14;

/**
 * Write a description of class MatrixList here.
 *
 * @author (Pierre Janineh)
 * @version (June 14, 2025)
 */
public class MatrixList
{
    IntNodeMat _m00;

    public MatrixList()
    {
        _m00 = null;
    }

    /**
     * Constructs a linked matrix from a given 2D array of integers.
     * Each element is represented by an IntNodeMat object, connected in all four directions (up, down, left, right) to form a 2D linked structure.
     * @param mat a 2D integer array representing the matrix to build. If null or empty, the matrix will be initialized as empty.
     */
    public MatrixList(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            _m00 = null;
            return;
        }

        int rows = mat.length;
        int cols = mat[0].length;
        IntNodeMat[][] nodes = new IntNodeMat[rows][cols];

        // Create nodes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nodes[i][j] = new IntNodeMat(mat[i][j]);
            }
        }

        // Link nodes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j < cols - 1) {
                    nodes[i][j].setNextCol(nodes[i][j + 1]);
                    nodes[i][j + 1].setPrevCol(nodes[i][j]);
                }
                if (i < rows - 1) {
                    nodes[i][j].setNextRow(nodes[i + 1][j]);
                    nodes[i + 1][j].setPrevRow(nodes[i][j]);
                }
            }
        }

        _m00 = nodes[0][0];
    }

    /**
     * Returns the value at the (i, j) position in the matrix.
     * If the indices are out of bounds, returns Integer.MIN_VALUE.
     * @param i the row index (0-based)
     * @param j the column index (0-based)
     * @return the value at position (i, j) or Integer.MIN_VALUE if invalid
     */
    public int getDataIJ(int i, int j) {
        IntNodeMat ptr = getNodeAt(i, j);

        return (ptr != null) ? ptr.getData() : Integer.MIN_VALUE;
    }

    /**
     * Sets the value at the (i, j) position in the matrix to the given number.
     * If the indices are out of bounds, the method does nothing.
     * @param num the value to set
     * @param i the row index (0-based)
     * @param j the column index (0-based)
     */
    public void setDataIJ(int num, int i, int j) {
        IntNodeMat ptr = getNodeAt(i, j);

        if (ptr != null)
            ptr.setData(num);
    }

    // Returns the node at the specified (i, j) position in the matrix, or null if the position is out of bounds.
    private IntNodeMat getNodeAt(int i, int j) {
        IntNodeMat ptr = _m00;

        for (int row = 0; row < i && ptr != null; row++)
            ptr = ptr.getNextRow();

        for (int col = 0; col < j && ptr != null; col++)
            ptr = ptr.getNextCol();

        return ptr;
    }

    /**
     * Returns a string representation of the matrix, where each element is separated by a tab character,
     * and each row ends with a newline character. If the matrix is empty, returns an empty string.
     * @return string representation of the matrix.
     */
    public String toString() {
        if (_m00 == null) return "";

        String result = "";
        IntNodeMat rowPtr = _m00;

        while (rowPtr != null) {
            IntNodeMat colPtr = rowPtr;
            while (colPtr != null) {
                result += colPtr.getData();
                if (colPtr.getNextCol() != null)
                    result += "\t";
                colPtr = colPtr.getNextCol();
            }
            result += "\n";
            rowPtr = rowPtr.getNextRow();
        }

        return result;
    }

    /**
     * Recursively checks if all rows and all columns in the matrix are strictly descending.
     * That is, each value is greater than the next in both row and column directions.
     * @return true if the entire matrix is strictly descending by row and column, false otherwise
     */
    public boolean isDescending() {
        return isDescendingHelper(_m00);
    }

    // Recursively checks the matrix from the given node to ensure all rows and columns starting from this node are strictly descending.
    private boolean isDescendingHelper(IntNodeMat node) {
        if (node == null)
            return true;

        return isRowDescending(node) &&
                isColDescending(node) &&
                isDescendingHelper(node.getNextRow()) &&
                isDescendingHelper(node.getNextCol());
    }

    // Recursively checks if the current row, starting from the given node, is strictly descending (each value greater than the one to its right).
    private boolean isRowDescending(IntNodeMat node) {
        if (node == null || node.getNextCol() == null)
            return true;

        if (node.getData() <= node.getNextCol().getData())
            return false;

        return isRowDescending(node.getNextCol());
    }

    // Recursively checks if the current column, starting from the given node, is strictly descending (each value greater than the one below it).
    private boolean isColDescending(IntNodeMat node) {
        if (node == null || node.getNextRow() == null)
            return true;

        if (node.getData() <= node.getNextRow().getData())
            return false;

        return isColDescending(node.getNextRow());
    }

    /**
     * Returns the number of negative integers in the matrix.
     * Assumes that the matrix is strictly descending by rows and columns.
     * Optimized to run in O(n + m) time, where n is the number of rows and m is the number of columns.
     * And to run in O(1) space, due to the constant number of variables.
     * @return the count of negative numbers in the matrix
     */
    public int howManyNegative() {
        int count = 0;
        IntNodeMat row = _m00;

        // Move to bottom left corner
        while (row != null && row.getNextRow() != null) {
            row = row.getNextRow();
        }

        if (row == null) return 0;

        IntNodeMat current = row;
        int negativesInRow = 0;

        while (current != null) {
            IntNodeMat col = current;
            // Move right while data is negative
            while (col != null && col.getData() < 0) {
                negativesInRow++;
                col = col.getNextCol();
            }
            count += negativesInRow;
            negativesInRow = 0;
            current = current.getPrevRow();
        }

        return count;
    }
}
