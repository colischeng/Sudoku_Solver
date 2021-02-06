package project;

import java.util.HashMap;

public class Board {
    public int[][] matrix;

    public Board(int[] row1, int[] row2, int[] row3, int[] row4, int[] row5,
                 int[] row6, int[] row7, int[] row8, int[] row9) {

        matrix = new int[][]{row1, row2, row3, row4, row5, row6, row7, row8, row9};

    }

    public void editBoard(int x, int y, int value) {
        matrix[y][x] = value;
    }

    // Test row X's satisfies the Sudoku condition
    public boolean horizontal(int y) {
        // Hashmap for O(n) time and space
        HashMap<Integer, Integer> testMap = new HashMap<>();

        for(int i = 0; i < 9; i++) {

            // Ignore zeros
            if(matrix[y][i] == 0) {
                continue;
            }

            //If it contains an already seen value then stop and return false
            if(testMap.containsKey(matrix[y][i])) {
               return false;
            } else {
               testMap.put(matrix[y][i],1);
            }
        }

        return true;
    }

    public boolean vertical(int x) {
        // Hashmap for O(n) time and space
        HashMap<Integer, Integer> testMap = new HashMap<>();

        for(int i = 0; i < 9; i++) {

            // Ignore zeros
            if(matrix[i][x] == 0) {
                continue;
            }

            //If it contains an already seen value then stop and return false
            if(testMap.containsKey(matrix[i][x])) {
                return false;
            } else {
                testMap.put(matrix[i][x],1);
            }
        }

        return true;
    }



    public boolean diagonal(int x, int y) {
        return false;
    }


}
