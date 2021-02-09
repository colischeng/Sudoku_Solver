package project;

public class Main {
    public static void main(String[] args) {
        Board easy;

//        int[] easyR1 = new int[] {0,0,0,0,0,0,0,0,0};
//        int[] easyR2 = new int[] {0,0,0,0,0,0,0,0,0};
//        int[] easyR3 = new int[] {0,0,0,0,0,0,0,0,0};
//        int[] easyR4 = new int[] {0,0,0,0,0,0,0,0,0};
//        int[] easyR5 = new int[] {0,0,0,0,0,0,0,0,0};
//        int[] easyR6 = new int[] {0,0,0,0,0,0,0,0,0};
//        int[] easyR7 = new int[] {0,0,0,0,0,0,0,0,0};
//        int[] easyR8 = new int[] {0,0,0,0,0,0,0,0,0};
//        int[] easyR9 = new int[] {0,0,0,0,0,0,0,0,0};

        int[] easyR1 = new int[] {8,0,0,0,7,0,0,0,0};
        int[] easyR2 = new int[] {0,0,0,0,6,3,0,0,0};
        int[] easyR3 = new int[] {1,9,0,8,0,0,0,0,0};
        int[] easyR4 = new int[] {2,0,7,0,0,0,6,0,0};
        int[] easyR5 = new int[] {0,0,4,0,0,0,5,3,0};
        int[] easyR6 = new int[] {0,0,0,0,0,5,8,0,0};
        int[] easyR7 = new int[] {5,6,0,0,0,9,0,0,0};
        int[] easyR8 = new int[] {0,0,8,0,5,0,0,0,2};
        int[] easyR9 = new int[] {0,0,0,0,3,7,0,0,0};

        easy = new Board(easyR1, easyR2, easyR3, easyR4, easyR5, easyR6, easyR7, easyR8,easyR9);

        Board output = easy.solve(easy);

        for(int y = 0; y < 9; y++) {
            System.out.println(output.matrix[y][0] + " " + output.matrix[y][1] + " " + output.matrix[y][2] + " " +
                    output.matrix[y][3] + " " + output.matrix[y][4] + " " + output.matrix[y][5] + " " +
                    output.matrix[y][6] + " " + output.matrix[y][7] + " " + output.matrix[y][8] + " ");


        }


    }
}
