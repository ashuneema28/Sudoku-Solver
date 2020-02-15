import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class OnePossibleTest {

    @Test
    public void testsolve() throws FileNotFoundException {
        Sudoku sudoku1 = new Sudoku("sudoku3.txt");

        One_possible onePossible = new One_possible(sudoku1.getSize(), sudoku1.getSudoku_board(), sudoku1.getValid_symbols());
        onePossible.solve();

        assertEquals(16,onePossible.getSize());

        assertEquals(146,onePossible.getUsage_count());

        System.out.println(onePossible.gettotaltime());
        System.out.println(onePossible.getStrategyTime());

        System.out.println(onePossible.getSudoku_board());

        System.out.println(onePossible.getValid_symbols());
    }
}
