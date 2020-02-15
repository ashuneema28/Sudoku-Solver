import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class OnlyoneplaceTest {
    @Test
    public void testsolve() throws FileNotFoundException {
        Sudoku sudoku1 = new Sudoku("sudoku6.txt");

        Only_one_place onlyOnePlace = new Only_one_place(sudoku1.getSize(), sudoku1.getSudoku_board(), sudoku1.getValid_symbols());
        onlyOnePlace.solve();

        assertEquals(9,onlyOnePlace.getSize());

        assertEquals(2,onlyOnePlace.getUsage_count());

        System.out.println(onlyOnePlace.gettotaltime());
        System.out.println(onlyOnePlace.getStrategyTime());

        onlyOnePlace.isAllowed(sudoku1.getSudoku_board(), 5,6,"9");

        System.out.println(onlyOnePlace.getSudoku_board());

        System.out.println(onlyOnePlace.getValid_symbols());
    }
}
