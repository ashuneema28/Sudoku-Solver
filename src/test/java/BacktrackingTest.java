import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class BacktrackingTest {

    @Test
    public void TestSolve() throws FileNotFoundException {
        Sudoku sudoku1 = new Sudoku("sudoku1.txt");

        Backtracking backtracking = new Backtracking(sudoku1.getSize(), sudoku1.getSudoku_board(), sudoku1.getValid_symbols());
        backtracking.solve();

        String string = backtracking.getSudoku();
        assertEquals(string,backtracking.getSudoku());

        assertEquals(49558,backtracking.getUsage_count());

        System.out.println(backtracking.gettotaltime());
        System.out.println(backtracking.getStrategyTime());
    }
}
