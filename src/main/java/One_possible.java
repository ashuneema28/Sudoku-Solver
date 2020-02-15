import java.util.ArrayList;

public class One_possible extends Sudoku_Algorithm {
    private int size;
    private String [][] sudoku_board;
    private String[] valid_symbols;
    private String setvalue;
    private int usage_count=0;

    public One_possible(int size, String [][] sudoku_board, String [] valid_symbols){
        this.size=size;
        this.sudoku_board=sudoku_board;
        this.valid_symbols=valid_symbols;
    }

    public boolean solve_Sudoku() {
        int initial_zero_count = 0;
        int final_zero_count = 0;
        for (int i = 0; i < size; i++) {
            for (int j=0; j < size; ++j) {
                if (sudoku_board[i][j].equals("0")) {
                    initial_zero_count++;
                }
            }
        }

        for(int i =0; i<size; ++i){
            for (int j = 0 ; j<size ; ++j){
                if(sudoku_board[i][j].equals("0")){
                    if(isAllowed(sudoku_board,i,j,sudoku_board[i][j])){
                        sudoku_board[i][j]=getSetvalue();
                        usage_count++;
                    }
                }
            }
        }
        for(int i = 0; i<size; ++i){
            for(int j = 0; j<size; ++j){
                if (sudoku_board[i][j].equals("0")){
                    final_zero_count++;
                }
            }
        }
        if(initial_zero_count != final_zero_count){
            solve_Sudoku();
        }
        return true;
    }


    public int getUsage_count() {
        return usage_count;
    }

    public boolean isAllowed(String[][] sudoku_board, int row, int col, String value){
        ArrayList<String> invalid_valiues = new ArrayList<String>();
        for(int i =0; i<size; ++i){
            if(!(sudoku_board[row][i].equals("0"))){
                if(!(invalid_valiues.contains(sudoku_board[row][i]))){
                    invalid_valiues.add(sudoku_board[row][i]);
                }
            }
        }

        for(int i =0; i<size; ++i){
            if(!(sudoku_board[i][col].equals("0"))){
                if(!(invalid_valiues.contains(sudoku_board[i][col]))){
                    invalid_valiues.add(sudoku_board[i][col]);
                }
            }
        }

        String [] grid = getgrid(row,col);
        for(int i =0; i<size; ++i){
            if(!(grid[i].equals("0"))){
                if(!(invalid_valiues.contains(grid[i]))){
                    invalid_valiues.add(grid[i]);
                }
            }
        }

        if (invalid_valiues.size() == size-1){
            for(int i=0; i<size; ++i){
                if(!(invalid_valiues.contains(valid_symbols[i]))){
                    setSetvalue(valid_symbols[i]);
                }
            }
            return true;
        }
        return false;
    }

    public String[] getgrid(int row, int col){
        String [] grid = new String[size];
        int l = 0;
        Double sqrt = Math.sqrt(size);
        int squareRoot = sqrt.intValue();
        int r = row - row % squareRoot;
        int c = col - col % squareRoot;
        for (int i = r; i < r + squareRoot; i++) {

            for (int j = c; j < c + squareRoot; j++) {
                grid[l] =sudoku_board[i][j];
                l++;
            }
        }
        return grid;
    }

    public int getSize() {
        return size;
    }

    public String[][] getSudoku_board() {
        return sudoku_board;
    }

    public String[] getValid_symbols() {
        return valid_symbols;
    }

    public String getSetvalue() {
        return setvalue;
    }

    public void setSetvalue(String setvalue) {
        this.setvalue = setvalue;
    }

    public void displayresult(){
        System.out.println("The solved sudoku is as follows:");
        for(int i =0 ; i<size ; ++i)
        {
            for(int j=0 ; j<size ; ++j){
                System.out.print(sudoku_board[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}

