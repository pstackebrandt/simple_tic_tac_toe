class Main {
    public static void main(String[] args) {
        final int start = 9;
        final int end = 0;
        for (int i = start; i >= end; i--) {
            System.out.print(i);
            if  (i > end){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
