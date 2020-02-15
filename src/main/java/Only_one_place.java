public class Only_one_place extends Sudoku_Algorithm {
    private int size;
    private String [][] sudoku_board;
    private String[] valid_symbols;
    private int usage_count=0;

    public int getSize() {
        return size;
    }


    public String[][] getSudoku_board() {
        return sudoku_board;
    }


    public String[] getValid_symbols() {
        return valid_symbols;
    }


    public Only_one_place(int size, String [][] sudoku_board, String [] valid_symbols){
        this.size=size;
        this.sudoku_board=sudoku_board;
        this.valid_symbols=valid_symbols;
    }

    public int getUsage_count() {
        return usage_count;
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
                    if(valid_in_row(i)){
                        String [] check_row = getrow(i);
                        for(int k =0; k<size; ++k){
                            for(int l = 0; l<size; ++l){
                                if (valid_symbols[k].equals(check_row[l])){
                                    break;
                                }
                                if(l == size-1){
                                    sudoku_board[i][j]=valid_symbols[k];
                                    usage_count++;

                                }
                            }
                        }
                    }
                    if(valid_in_column(j)){
                        String [] check_column = getcolumn(j);
                        for(int k =0; k<size; ++k){
                            for(int l = 0; l<size; ++l){
                                if (valid_symbols[k].equals(check_column[l])){
                                    break;
                                }
                                if(l == size-1){
                                    sudoku_board[i][j]=valid_symbols[k];
                                    usage_count++;
                                }
                            }
                        }
                    }
                    if(valid_in_grid(i,j)){
                        String [] check_grid = getgrid(i,j);
                        for(int k =0; k<size; ++k){
                            for(int l = 0; l<size; ++l){
                                if (valid_symbols[k].equals(check_grid[l])){
                                    break;
                                }
                                if(l == size-1){
                                    sudoku_board[i][j]=valid_symbols[k];
                                    usage_count++;
                                }
                            }
                        }
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

    @Override
    public boolean isAllowed(String[][] sudoku_board, int row, int col, String value) {
        return true;
    }

    public boolean valid_in_row(int row) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (sudoku_board[row][i].equals("0")) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean valid_in_column(int col) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (sudoku_board[i][col].equals("0")) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean valid_in_grid(int row, int col) {
        int count = 0;
        String [] grid = getgrid(row,col);
        for(int i =0; i<size ; ++i){
            if(grid[i].equals("0")){
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public String[] getrow(int row){
        String [] row_to_return = new String[size];
        for(int i = 0; i<size; ++i){
            row_to_return[i]= sudoku_board[row][i];
        }
        return row_to_return;
    }

    public String[] getcolumn(int col){
        String [] column_to_return = new String[size];
        for(int i = 0; i<size; ++i){
            column_to_return[i]= sudoku_board[i][col];
        }
        return column_to_return;
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

