import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class SudokuTest {
    @Test
    public void testConstruction() throws FileNotFoundException {
        Sudoku sudoku = new Sudoku("sudoku1.txt");

        assertEquals(9,sudoku.getSize());

        assertEquals(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"},sudoku.getValid_symbols());

        assertEquals(true,sudoku.isValidSudoku(sudoku.getSudoku_board()));

        String sudokuboard = sudoku.getSudokustring();
    }

    @Test
    public void testIsValid () throws FileNotFoundException {

        Sudoku sudoku = new Sudoku("bad1.txt");
        assertEquals(false,sudoku.isValidSudoku(sudoku.getSudoku_board()));

        sudoku = new Sudoku("bad2.txt");
        assertEquals(false,sudoku.isValidSudoku(sudoku.getSudoku_board()));

        sudoku = new Sudoku("bad3.txt");
        assertEquals(false,sudoku.isValidSudoku(sudoku.getSudoku_board()));

        sudoku = new Sudoku("bad4.txt");
        assertEquals(false,sudoku.isValidSudoku(sudoku.getSudoku_board()));

    }
}
