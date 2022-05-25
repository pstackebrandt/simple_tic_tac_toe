import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        int width = 0;
        int height = 0;
        int expectedPieces = 0;
        boolean expectedResult = false;
        var testDescription = "";

//        var test = true;
        var test = false;
//        var testNum = 1;
//        var testNum = 2;
//        var testNum = 3;
//        var testNum = 4;
        var testNum = 5;

        if (test) {
            switch (testNum) {
                case 1:
                    testDescription = "should return true because block on height";
                    width = 4;
                    height = 2;
                    expectedPieces = 6;
                    expectedResult = true;
                    break;
                case 2:
                    testDescription = "should return false because pieces between rows";
                    width = 2;
                    height = 10;
                    expectedPieces = 7;
                    expectedResult = false;
                    break;
                case 3:
                    testDescription = "should return true because block on width";
                    width = 7;
                    height = 14;
                    expectedPieces = 21;
                    expectedResult = true;
                    break;
                case 4:
                    testDescription = "Should return false because more expected pieces than pieces in bar";
                    width = 2;
                    height = 3;
                    expectedPieces = 8;
                    expectedResult = false;
                    break;
                case 5:
                    testDescription = "Should return false because as much expected pieces as pieces in bar";
                    width = 2;
                    height = 3;
                    expectedPieces = 6;
                    expectedResult = false;
                    break;
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            width = scanner.nextInt();
            height = scanner.nextInt();
            expectedPieces = scanner.nextInt();
        }

        boolean dividable = Main.ChocolateBar.dividableIntoBlock(width, height, expectedPieces);

        if (test) {
            System.out.println(testDescription);
            System.out.println("width = " + width);
            System.out.println("height = " + height);
            System.out.println("expectedPieces = " + expectedPieces);
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("result = " + dividable);
        }
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
            if (blockSize > getPiecesCount(width, height)) {
                return false;
            }

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

