package project;

public class Main {
    public static void main(String[] args) {
        Board easy;

        int[] easyR1 = new int[] {0,7,0,1,3,0,6,8,0};
        int[] easyR2 = new int[] {0,0,2,0,0,0,0,3,0};
        int[] easyR3 = new int[] {5,3,0,7,0,4,0,0,9};
        int[] easyR4 = new int[] {0,0,3,0,2,0,0,6,0};
        int[] easyR5 = new int[] {0,0,0,9,1,5,0,0,2};
        int[] easyR6 = new int[] {0,0,4,0,8,3,1,9,0};
        int[] easyR7 = new int[] {0,0,5,0,0,0,9,0,6};
        int[] easyR8 = new int[] {7,0,0,3,4,0,8,5,0};
        int[] easyR9 = new int[] {8,9,0,0,5,6,0,7,3};

        easy = new Board(easyR1, easyR2, easyR3, easyR4, easyR5, easyR6, easyR7, easyR8,easyR9);

        Board output = easy.solve(easy);

        for(int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                System.out.println(output.matrix[y][x]);
            }

            System.out.println("\n");

        }


    }
}
