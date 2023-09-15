public class RotateImage48 {

    public static void main(String[] args) {

        int[][]matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        System.out.println("Input matrix: ");
        printMatrix(matrix);
        rotate(matrix);

        System.out.println("Output matrix: ");
        printMatrix(matrix);
    }

    private static void rotate(int[][] matrix) {

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        //Transpose.
        for (int i=0; i<rowLen; i++) {
            for (int j=i+1; j<colLen; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reverse elements in each row.
        for (int l=0; l<rowLen; l++) {
            for (int m=0; m<colLen/2; m++) {
                int temp = matrix[l][m];
                matrix[l][m] = matrix[l][colLen-1-m];
                matrix[l][colLen-1-m] = temp;
            }
        }

    }

    private static void printMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Determine the maximum width of any element in the matrix
        int maxElementWidth = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int element = matrix[i][j];
                int elementWidth = String.valueOf(element).length();
                maxElementWidth = Math.max(maxElementWidth, elementWidth);
            }
        }

        // Print the matrix with equal spacing
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int element = matrix[i][j];
                System.out.printf("%" + (maxElementWidth + 1) + "d", element);
            }
            System.out.println(); // Move to the next row
        }

    }
    

}
