import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class SudokuSolverTest {

    @Test
    public void testconstruction() throws FileNotFoundException {
        Sudoku sudoku1 = new Sudoku("sudoku1.txt");

        Sudoku_Solver solvedsudoku = new Sudoku_Solver(sudoku1);

        String string = solvedsudoku.toString();
        assertEquals(string,solvedsudoku.toString());

        sudoku1 = new Sudoku("sudoku6.txt");

        solvedsudoku = new Sudoku_Solver(sudoku1);

        string = solvedsudoku.toString();
        assertEquals(string,solvedsudoku.toString());
    }
}
