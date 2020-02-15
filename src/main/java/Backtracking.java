public class Backtracking extends Sudoku_Algorithm {
    private String sudoku;
    private int size;
    private String [][] sudoku_board;
    private String[] valid_symbols;
    private int usage_count=0;

    public Backtracking(int size, String [][] sudoku_board, String [] valid_symbols){
        this.size=size;
        this.sudoku_board=sudoku_board;
        this.valid_symbols=valid_symbols;
    }


    public boolean solve_Sudoku(){
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (sudoku_board[i][j].equals("0"))
                {
                    row = i;
                    col = j;

                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty)
            {
                break;
            }
        }
        // no empty space left
        if (isEmpty)
        {
            return true;
        }

        // else for each-row backtrack
        for (String i : valid_symbols)
        {
            if (isAllowed(sudoku_board, row, col, i ))
            {
                sudoku_board[row][col] = i;
                usage_count++;
                if (solve_Sudoku())
                {
                    return true;
                }
                else
                {
                    sudoku_board[row][col] ="0" ; // replace it
                }
            }
        }

        return false;
    }

    public boolean isAllowed(String[][] sudoku_board, int row, int col, String value) {
        //number is not repeated in row
        for (int i = 0; i < sudoku_board.length; i++) {
            if (sudoku_board[row][i].equals(value)) {
                return false;
            }
        }
        //number is not repeated in column
        for (int i = 0; i < sudoku_board.length; i++) {
            if (sudoku_board[i][col].equals(value)) {
                return false;
            }
        }
        //number is not repeated in subgrid block
        Double sqrt = Math.sqrt(size);
        int squareRoot = sqrt.intValue();
        int r = row - row % squareRoot;
        int c = col - col % squareRoot;
        for (int i = r; i < r + squareRoot; i++) {

            for (int j = c; j < c + squareRoot; j++) {
                if(sudoku_board[i][j].equals(value))
                    return false;
            }
        }
        return true;
    }

    public void displayresult(){
        String sudoku = "Solution:\n";
        System.out.println("The solved sudoku is as follows:");
        for(int i =0 ; i<size ; ++i)
        {
            for(int j=0 ; j<size ; ++j){
                System.out.print(sudoku_board[i][j]+" ");
                sudoku=sudoku.concat(sudoku_board[i][j]);
                sudoku=sudoku.concat(" ");
            }
            System.out.print("\n");
            sudoku=sudoku.concat("\n");
        }
        this.sudoku=sudoku;
    }

    public String getSudoku() {
        return sudoku;
    }

    public int getUsage_count() {
        return usage_count;
    }
}
