import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final int size = scanner.nextInt();
        scanner.close();

        final var star = new Figure(size);
        star.show();
    }
}

/**
 * Figure writes a figure (for now only a star) to the console. The base of the
 * painted figure is a square with a side length given by the user. The
 * Background is painted with "." and SPACE. The star is painted with "*" char.
 * The rays of the star are diagonals and lines through the horizontal and
 * vertical middle. Lines through the middle are painted only when there is an
 * exact middle (that means: only for odd side length).
 */
class Figure {
    final private int size;

    private String[][] matrix;

    /**
     * Paint figure of side length {@code size} that displays a star.
     *
     * @param size - Side length of figure.
     */
    public Figure(int size) {
        this.size = size;
        createMatrix();
        paintBackground();
        writeStar();
    }

    private void createMatrix() {
        matrix = new String[size][size];
    }

    private void paintBackground() {
        matrix = writeBackground(matrix);
    }

    /**
     * Fill total figure with @backgroundElement.
     *
     * @param matrix - Will be used to fill the figures points into.
     */
    protected static String[][] writeBackground(String[][] _matrix) {
        for (String[] column : _matrix) {
            Arrays.fill(column, ".");
        }
        return _matrix;
    }

    private void writeStar() {
        matrix = Figure.writeStar(size, matrix);
    }

    /**
     * Get a matrix which contains a star made of {@code element} strings and
     * background elements.
     *
     * @param size   - Size of the matrix counts of rows and of columns must each
     *               be equal to size.
     * @param matrix - This will be used to draw the star into.
     * @return matrix with star
     */
    protected static String[][] writeStar(int size, String[][] _matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (isFallingDiagonal(row, col) || isRisingDiagonal(size, row, col) || isHorizontalMiddle(size, col)
                        || isVerticalMiddle(size, row)) {
                    _matrix[row][col] = "*";
                }
            }
        }
        return _matrix;
    }

    /**
     * Returns whether row at {@code rowIndex} is middle row of a container with
     * {@code rowCount} rows.
     *
     * @param rowCount Range is 1..n.
     * @param rowIndex Range 0..rowCount-1.
     */
    protected static boolean isVerticalMiddle(final int rowCount, final int rowIndex) {
        return Math.isMiddleInRange(rowCount, rowIndex + 1);
    }

    /**
     * Returns whether column at {@code colIndex} is middle column of a container
     * with {@code colCount} columns.
     *
     * @param colCount Range is 1..n.
     * @param colIndex Range 0..colCount-1.
     */
    protected static boolean isHorizontalMiddle(final int colCount, final int colIndex) {
        return Math.isMiddleInRange(colCount, colIndex + 1);
    }

    protected static boolean isRisingDiagonal(int size, int row, int column) {
        return row == size - 1 - column || column == size - 1 - row;
    }

    protected static boolean isFallingDiagonal(int i, int k) {
        return i == k;
    }

    /**
     * Print current figure to console as picture.
     */
    public void show() {
        System.out.println(Figure.show(matrix));
    }

    /**
     * Print current figure to console as array.
     */
    @SuppressWarnings("unused")
    public void showMatrix() {
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * Returns formatted figure. Lines are delimited by \n.
     */
    public static String show(String[][] matrix) {
        final var builder = new StringBuilder();

        for (var row : matrix) {
            StringBuilder line = new StringBuilder();
            for (var col : row) {
                line.append(col).append(" ");
            }
            line = new StringBuilder(line.toString().trim());
            builder.append(line).append("\n");
        }

        return builder.toString();
    }
}

class Math {

    /**
     * Returns whether {@code size} is an even number.
     */
    public static boolean isEven(int size) {
        return size % 2 == 0;
    }

    /**
     * Returns whether {@code size} is an odd number.
     */
    @SuppressWarnings("unused")
    public static boolean isOdd(int size) {
        return !isEven(size);
    }

    /**
     * Returns whether a value is in the middle of a range of numbers. Borders of
     * the range are included. Only one number can be in the middle of a range.
     * That's why only a range of odd length can have a middle. Returns false if
     * checked value is lower than lower border and greater than upper border.
     *
     * @param range - Must not be smaller than 1.
     * @param value - Should be within {@code range}. Must be based on 1 but not on 0.
     * @return true: {@code value} is the middle in {@code range}.
     * @throws IllegalArgumentException Will be thrown when range or value are invalid.
     */
    public static boolean isMiddleInRange(final int range, final int value) {
        if (range <= 0) {
            throw new IndexOutOfBoundsException(
                    String.format("Parameter range %d must not be smaller than 1.", range));
        }

        if (value < 1 || value > range) {
            throw new IndexOutOfBoundsException(
                    String.format("Parameter value %d must not be smaller or greater than range %d.", value, range));
        }

        return isMiddleBetween0AndPositiveValue(range - 1, value - 1);
    }

    /**
     * Returns whether value is in the middle of 0 and maxValue. Borders are
     * included. Only one number can be in the middle. Otherwise, there is no integer
     * middle possible. That's why only a range of odd length can have a middle.
     * Returns false if numberToCheck is lower than minRange and greater than
     * maxRange.
     *
     * @param maxValue - Must not be smaller than minValue (0).
     * @return true: numberToCheck is the middle number between 0 and @number.
     */
    public static boolean isMiddleBetween0AndPositiveValue(final int maxValue, final int numberToCheck) {
        final int minValue = 0;

        if (maxValue < minValue) {

            throw new IllegalArgumentException(
                    "maxValue = " + maxValue + " must not be lower than minValue = " + minValue + " .");
        }

        if (maxValue == minValue && numberToCheck == minValue) {
            return true; // special case for range of length 1
        }

        if (numberToCheck < minValue || numberToCheck > maxValue) {
            return false; // Value is out of range.
        }

        final int range = maxValue + 1;

        if (range % 2 == 0) {

            return false; // Even range can't have a single middle value.
        }

        final int middlePosition = range / 2;

        return middlePosition == numberToCheck;
    }
}

