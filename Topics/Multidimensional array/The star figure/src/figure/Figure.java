package figure;

import java.util.Arrays;

public class Figure {
    final private int size;

    private String[][] matrix;

    public Figure(int size) {
        this.size = size;
        // create matrix
        createMatrix();
        // fill background
        paintBackground();
    }

    private void createMatrix() {
        matrix = new String[size][size];
    }

    private void paintBackground() {
       matrix = writeBackground(size, matrix, ".");
    }

    /** Fill total figure with @backgroundElement.*/
    protected static String[][] writeBackground(int size, String[][] matrix, String backgroundElement) {
        for (String[] column : matrix) {
            Arrays.fill(column, backgroundElement);
        }
        return matrix;
    }

    /** Print current figure to console as picture. */
    public void show() {
        System.out.println(Figure.show(size, matrix));
    }

    /** Print current figure to console as array. */
    public void showMatrix(){
        System.out.println(Arrays.deepToString(matrix));
    }

    /** Returns formatted figure. Lines are delimited by \n. */
    public static String show(int size, String[][] matrix) {
        return Arrays.deepToString(matrix);
    }
}
