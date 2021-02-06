package project;

import java.sql.SQLOutput;
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



    public boolean square(int x, int y) {
        // Hashmap for O(n) time and space
        HashMap<Integer, Integer> testMap = new HashMap<>();

        for(int j = start(y); j <= end(y); j++) {
            for(int i = start(x); i <= end(x); i++) {

                // Ignore zeros
                if(matrix[j][i] == 0) {
                    continue;
                }

                //If it contains an already seen value then stop and return false
                if(testMap.containsKey(matrix[j][i])) {
                    return false;
                } else {
                    testMap.put(matrix[j][i],1);
                }
            }
        }

        return true;
    }

    // Helper to figure out the start index for checking the square
    public int start(int i) {
        int start = 0;

        // 0,1,2 will start at index 0
        if(i >= 0 && i <= 2) {
            start = 0;
        }

        // 3,4,5 will start at index 3
        if(i >= 3 && i <= 5) {
            start = 3;
        }

        // 6,7,8 will start at index 5
        if(i >= 6 && i <= 8) {
            start = 6;
        }

        return start;
    }

    // Helper to figure out the end index for checking the square
    public int end(int i) {
        int end = 0;

        // 0,1,2 will end at index 2
        if(i >= 0 && i <= 2) {
            end = 2;
        }

        // 3,4,5 will end at index 5
        if(i >= 3 && i <= 5) {
            end = 5;
        }

        // 6,7,8 will end at index 8
        if(i >= 6 && i <= 8) {
            end = 8;
        }

        return end;
    }

    public boolean diagonal(int x, int y) {

        // Diagonals only occur when the x,y coordinate is the same or if their sum is 8. If it's not a diagonal
        // position, we don't need to evaluate further
        if(x + y == 8 || x == y) {
            return true;
        }

        return false;
    }

}
