package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.Board;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    Board easy;
    Board hard;

    Board solved;

    Board unSolvableInitially;
    Board unSolvableAfterSearch;


    @BeforeEach
    void runBefore(){
        // Easy board taken from https://sudoku.com/easy/
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


        // Solved board taken from https://www.andrew.cmu.edu/user/kkuan/finalWriteup.html
        int [] solvedR1 = new int[] {8,2,7,1,5,4,3,9,6};
        int [] solvedR2 = new int[] {9,6,5,3,2,7,1,4,8};
        int [] solvedR3 = new int[] {3,4,1,6,8,9,7,5,2};
        int [] solvedR4 = new int[] {5,9,3,4,6,8,2,7,1};
        int [] solvedR5 = new int[] {4,7,2,5,1,3,6,8,9};
        int [] solvedR6 = new int[] {6,1,8,9,7,2,4,3,5};
        int [] solvedR7 = new int[] {7,8,6,2,3,5,9,1,4};
        int [] solvedR8 = new int[] {1,5,4,7,9,6,8,2,3};
        int [] solvedR9 = new int[] {2,3,9,8,4,1,5,6,7};

        solved = new Board(solvedR1, solvedR2, solvedR3, solvedR4, solvedR5, solvedR6, solvedR7, solvedR8, solvedR9);

    }

    @Test
    void horizontalTest() {
        // Make sure that the board ignores zeros
        assertTrue(easy.horizontal(0));

        // Make row 1 of board easy valid
        easy.editBoard(0,0,2);
        easy.editBoard(2,0,4);
        easy.editBoard(5,0,5);
        easy.editBoard(8,0,9);
        assertTrue(easy.horizontal(0));

        // Make the matrix[0][0] to be equal to 9, the same as matrix[0][8]
        easy.editBoard(0,0,9);
        assertFalse(easy.horizontal(0));

    }

    @Test
    void verticalTest() {
        // Make sure that the board ignores zeros
        assertTrue(easy.vertical(0));

        // Make column 1 of board easy valid
        easy.editBoard(0,0,2);
        easy.editBoard(0,3,3);
        easy.editBoard(0,4,4);
        easy.editBoard(0,6,9);
        assertTrue(easy.vertical(0));

        // Make the matrix[0][0] to be equal to 8, the same as matrix[8][0]
        easy.editBoard(0,0,8);
        assertFalse(easy.vertical(0));
    }

    @Test
    void squareTest() {
        // Make sure that the board ignores zeros
        assertTrue(easy.square(0,0));

        // Make square with point (3,3) return true
        easy.editBoard(3,3,4);
        easy.editBoard(5,3,6);
        easy.editBoard(5,4,5);
        easy.editBoard(3,5,7);
        assertTrue(easy.square(3,3));

        // Make square at with point (3,3) return false after creating error
        easy.editBoard(3,3,6);
        assertFalse(easy.square(3,3));

        // Make square with point (7,7) return true
        easy.editBoard(6,6,9);
        easy.editBoard(7,6,2);
        easy.editBoard(8,7,1);
        easy.editBoard(6,8,4);
        assertTrue(easy.square(7,7));

        // Make square at with point (8,6) return false after creating error
        easy.editBoard(6,6,8);
        assertFalse(easy.square(8,6));

    }

    @Test
    void solvedTest() {
        // Is the solved board correctly marked as solved
        assertTrue(solved.solved());

        // Is an incorrectly solved board marked as solved
        // Change the number in Board[0][0] equal to 6, a number that appears in the same row
        solved.editBoard(0,0,6);
        assertFalse(solved.solved());

        // Is the incomplete board correctly marked as unsolved because it has 0s
        assertFalse(easy.solved());

    }

    @Test
    void validInsertTest() {

        assertFalse(easy.validInsert(0,0,3));

        assertFalse(easy.validInsert(0,0,5));

        assertFalse(easy.validInsert(0,0,2));

        assertTrue(easy.validInsert(0,0,9));

    }

    @Test
    void firstFreeTest() {
        int[] testArray = new int[2];
        testArray[0] = 0;
        testArray[1] = 0;
        assertArrayEquals(easy.firstFree(easy),testArray);

        testArray[0] = 4;
        testArray[1] = 8;
        solved.editBoard(4,8,0);
        assertArrayEquals(solved.firstFree(solved),testArray);

    }

    @Test
    void startHelperTest() {
        assertEquals(easy.start(0),0);
        assertEquals(easy.start(1),0);
        assertEquals(easy.start(2),0);
        assertEquals(easy.start(3),3);
        assertEquals(easy.start(4),3);
        assertEquals(easy.start(5),3);
        assertEquals(easy.start(6),6);
        assertEquals(easy.start(7),6);
        assertEquals(easy.start(8),6);
    }

    @Test
    void endHelperTest() {
        assertEquals(easy.end(0),2);
        assertEquals(easy.end(1),2);
        assertEquals(easy.end(2),2);
        assertEquals(easy.end(3),5);
        assertEquals(easy.end(4),5);
        assertEquals(easy.end(5),5);
        assertEquals(easy.end(6),8);
        assertEquals(easy.end(7),8);
        assertEquals(easy.end(8),8);
    }


}
