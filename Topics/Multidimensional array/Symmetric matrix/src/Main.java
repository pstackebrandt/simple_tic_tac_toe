import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // get input
        final var scanner = new Scanner(System.in);
        final int length = scanner.nextInt();
        final var matrix = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        final boolean isSymmetrical = isMatrixSymmetricalToMainDiagonal(length, matrix);
        System.out.println(getAnswer(isSymmetrical));
    }

    private static String getAnswer(boolean isSymmetrical) {
        if (isSymmetrical) {
            return "YES";
        }
        return "NO";
    }

    private static boolean isMatrixSymmetricalToMainDiagonal(int length, int[][] matrix) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
