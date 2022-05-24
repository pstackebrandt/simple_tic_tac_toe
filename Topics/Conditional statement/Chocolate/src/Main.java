import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = 0;
        int height = 0;
        int expectedPieces = 0;
        boolean expectedResult = false;

//        var test = true;
        var test = false;
//        var testNum = 1;
//        var testNum = 2;
        var testNum = 3;

        if (test) {
            if (testNum == 1) {
                height = 2;
                expectedPieces = 6;
                expectedResult = true;
            }

            // test 2
            if (testNum == 2) {
                width = 4;
                width = 2;
                height = 10;
                expectedPieces = 7;
                expectedResult = false;
            }

            if (testNum == 3) {
                width = 7;
                height = 14;
                expectedPieces = 21;
                expectedResult = true;
            }
        } else {
            width = scanner.nextInt();
            height = scanner.nextInt();
            expectedPieces = scanner.nextInt();
        }

        boolean dividable = Main.ChocolateBar.dividableIntoBlock(width, height, expectedPieces);

        System.out.println(dividable ? "YES" : "NO");
    }

    public static class ChocolateBar {

        /**
         * Returns whether chocolate is dividable into a block of
         * {@code blockSize} pieces. Width or height of the block must be equal
         * to width or height of the block.
         *
         * @param blockSize Count of pieces of the block.
         */
        public static boolean dividableIntoBlock(int width, int height, int blockSize) {
            boolean dividable = dividableIntoBlock(blockSize, width);
            if (!dividable) {
                //noinspection SuspiciousNameCombination
                dividable = dividableIntoBlock(blockSize, height);
            }
            return dividable;
        }

        /**
         * Returns whether chocolate is dividable into a block of
         * {@code blockSize} pieces with 1 side of length {@code blockWidth}.
         */
        private static boolean dividableIntoBlock(int expectedBlockSize, int blockWidth) {
            boolean dividable = false;

            int rows = 1;
            int pieces = getPiecesCount(blockWidth, rows);
            while (pieces <= expectedBlockSize) {
                if (pieces == expectedBlockSize) {
                    dividable = true;
                    break;
                }
                rows++;
                pieces = getPiecesCount(blockWidth, rows);
            }
            return dividable;
        }

        /**
         * Get pieces count of a block.
         */
        private static int getPiecesCount(int blockWidth, int blockRows) {
            return blockWidth * blockRows;
        }
    }
}

