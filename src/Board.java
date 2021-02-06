public class Board {
    public int[][] board;

    public Board() {
        int[] row1 = new int[9];
        int[] row2 = new int[9];
        int[] row3 = new int[9];
        int[] row4 = new int[9];
        int[] row5 = new int[9];
        int[] row6 = new int[9];
        int[] row7 = new int[9];
        int[] row8 = new int[9];
        int[] row9 = new int[9];

        board = new int[][]{row1, row2, row3, row4, row5, row6, row7, row8, row9};

    }

    public boolean horizontalTest(int x, int y) {
        return false;
    }

    public boolean verticalTest(int x, int y) {
        return false;
    }



    public boolean diagonalTest(int x, int y) {
        return false;
    }

}
