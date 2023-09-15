public class SetMatrixZeroes73 {

    public static void main(String[] args) {

        int[][]matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        //int[][]matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        System.out.println("Before-");
        printMatrix(matrix);

        setZeroes(matrix);

        System.out.println("After-");
        printMatrix(matrix);

    }

    private static void setZeroes(int[][] matrix) {

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        boolean[] rowMarker = new boolean[rowLength];
        boolean[] colMarker = new boolean[colLength];

        for (int i=0; i<rowLength; i++) {
            for (int j=0; j<colLength; j++) {

                if (matrix[i][j] == 0) {
                    rowMarker[i] = true;
                    colMarker[j] = true;
                }
            }
        }


        for (int k=0; k<rowLength; k++) {
            for (int l=0; l<colLength; l++) {
                if (rowMarker[k] || colMarker[l]) {
                    matrix[k][l] = 0;
                }
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
