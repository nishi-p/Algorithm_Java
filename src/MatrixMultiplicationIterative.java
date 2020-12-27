/**
 * MatrixMultiplicationIterative
 * For matrix multiplication A*B, size of matrix A*B is n*n where size of matrix A is n*m and size of matrix B is m*n.
 * O(n^3)
 *
 * @author Nishi Parameshwara
 */

public class MatrixMultiplicationIterative {

    public static void main(String[] args) {
        //number of columns of matrix1 must be equal to number of rows of matrix2 for matrix multiplication.
        int[][] matrix1 = new int[2][2];
        int[][] matrix2 = new int[2][2];
        int count = 1;
        int count1 = 10;

        //rows = matrix.length
        //columns = matrix[i].length; i = row number
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = count;
                count++;
            }
        }

        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix1[i][j] = count1;
                count1++;
            }
        }

        matrixMult(matrix1, matrix2);
    }

    public static void matrixMult(int[][] matrix1, int[][] matrix2){
        int[][] matrix3 = new int[2][2];

        //2 for loops to access any element of a matrix
        //1 for loop for finding the resultant value in the output matrix
        for (int i = 0; i < matrix1.length; i++) { //rows of matrix1
            for (int j = 0; j < matrix2[i].length; j++) { //columns of matrix2
                for (int k = 0; k <matrix1[i].length; k++) { //matrix1[i].length i.e. columns of matrix1 or
                    // matrix2.length i.e. rows of matrix 2
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        //print result matrix
        for(int i=0; i< matrix3.length; i++){
            for(int j=0; j< matrix3[i].length; j++){
                System.out.println(matrix3[i][j]);
            }
        }
    }
}
