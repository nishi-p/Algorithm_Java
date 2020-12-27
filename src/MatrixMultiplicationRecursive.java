/**
 * MatrixMultiplicationRecursive (Divide and Conquer)
 * Assumption is that the matrices are square matrices of size nxn and size equal to exact powers of 2
 * Strategy: Decide what is the smallest sub-problem i.e. base case for recursion --> 2x2 matrix can be multiplied
 * directly without further division.
 *
 * O(n^3)
 *
 * @author Nishi Parameshwara //INCOMP
 */

public class MatrixMultiplicationRecursive {

    public static void main(String[] args) {
        //number of columns of matrix1 must be equal to number of rows of matrix2 for matrix multiplication
        int[][] matrix1 = new int[4][4];
        int[][] matrix2 = new int[][]{{17,18,19,20},{21,22,23,24},{25,26,27,28},{29,30,31,32}};
        int count = 1;

        //rows = matrix.length
        //columns = matrix[i].length; i = row number
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = count;
                count++;
            }
        }

        int size = matrix1.length;
        int[][] C = new int[size][size];
        multiply(matrix1, matrix2, size, 0, 0, 0, 0, C);
    }

    public static void multiply(int[][] matrix1, int[][] matrix2, int size, int rowA, int colA, int rowB, int colB, int[][] C) {
        //both matrices have same length --> same number of rows and columns
        if (size == 2) {
            C[rowA][0] = matrix1[rowA][colA] * matrix2[rowB][colB];
        } else {
            size = matrix1.length / 2;
            //C[][] = add(multiply(matrix1, matrix2, size, ), multiply(matrix1, matrix2, size), int[][] C);
        }
    }

    public static void add(int[][] matrix1, int[][] matrix2, int[][] C){

    }
}
