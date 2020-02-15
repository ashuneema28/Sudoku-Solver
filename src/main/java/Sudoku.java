import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku {
    private String sudoku;
    private int size;
    private String [][] sudoku_board;
    private String[] valid_symbols;

    public Sudoku(String filename) throws FileNotFoundException {

        this.sudoku = getsudoku(filename);

    }

    public boolean isValidSudoku(String[][] sudoku_board) {
        if (sudoku_board == null || sudoku_board.length != size || sudoku_board[0].length != size)
       {
           //System.out.println("Invalid formatting");
           return false;
       }

       if(!(isPerfectSquare(size))){
           //System.out.println("not a perfect square");
           return false;
       }
       int flag=0;
       for (int i = 0; i<size; i++){
           for(int j =0; j<size; ++j){
                if(!(sudoku_board[i][j].equals("0"))){
                    for(int k=0;k<size;++k){
                        if(sudoku_board[i][j].equals(valid_symbols[k])){
                            flag=1;
                        }
                        if((k==size-1)&&(flag==0)){
                            System.out.println("Invalid symbol in sudoku");
                            return false;
                        }
                    }
                    flag=0;
                }
           }
       }
        //Check Each Column
        for(int i = 0; i<size; i++){
            String [] column = new String[size];
            for(int j = 0; j<size; j++){
                column[j] = sudoku_board[j][i];
                //System.out.println("values in colBoard are : "+colBoard[j].getVal());
            }
            int m = 0;
            while(m<column.length){
                int n = 0;
                while(n<column.length){
                    //  System.out.println("value of m and n are : "+colBoard[m].getVal()+","+colBoard[n].getVal());
                    if(column[m].equals(column[n])){
                        if(m==n) {
                            //System.out.println("value of m and n are equal");
                        }
                        else{
                            if(Integer.parseInt(column[m]) == 0 && Integer.parseInt(column[m]) == 0){
                                //          System.out.println("value of m and n are zero");
                            }else{
                                System.out.println("Invalid values in column");
                                return false;
                            }
                        }
                    }
                    n++;
                }
                m++;
            }
        }
        //Check Each Row
        for(int i = 0; i<size; i++){
            String [] row = new String[size];
            for(int j = 0; j<size; j++){
                row[j] = sudoku_board[i][j];
                //  System.out.println("values in rowBoard are : "+rowBoard[j].getVal());
            }
            int m = 0;
            while(m<row.length){
                int n = 0;
                while(n<row.length){
                    //    System.out.println("value of m and n are : "+rowBoard[m].getVal()+","+rowBoard[n].getVal());
                    if(row[m].equals(row[n])){
                        if(m==n) {
                            //System.out.println("value of m and n are equal");
                        }
                        else{
                            if(Integer.parseInt(row[m]) == 0 && Integer.parseInt(row[m]) == 0){
                                //              System.out.println("value of m and n are zero");
                            }else{
                                System.out.println("Invalid values in row");
                                return false;
                            }
                        }
                    }
                    n++;
                }
                m++;
            }
        }
        // check that num is not repeated in subgrid
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                String [] subGrid = getSubGrid(i, j, String.valueOf(sudoku_board[i][j]));
                for(int p = 0; p<subGrid.length; p++){
                    //System.out.println("subGrid values are : "+subGrid[p].getVal());
                }
                int m = 0;
                while(m<subGrid.length){
                    int n = 0;
                    while(n<subGrid.length){
                        //  System.out.println("value of m and n are : "+subGrid[m].getVal()+","+subGrid[n].getVal());
                        if(subGrid[m].equals(subGrid[n])){
                            if(m==n) {
                                //System.out.println("value of m and n are equal");
                            }
                            else{
                                if(Integer.parseInt(subGrid[m]) == 0 && Integer.parseInt(subGrid[m]) == 0){
                                    //            System.out.println("value of m and n are zero");
                                }else{
                                    System.out.println("Invalid values in grid");
                                    return false;
                                }
                            }
                        }
                        n++;
                    }
                    m++;
                }
            }
        }
        return true;
    }

    public String[] getSubGrid(int row, int column, String value){
        String [] subGridVals = new String[size];
        Double sqrt = Math.sqrt(size);
        int squareRoot = sqrt.intValue();
        int r = row - row%squareRoot;
        int c = column - column%squareRoot;
        int k = 0;
        for(int i = r; i<r+squareRoot; i++){

            for(int j = c; j<c+squareRoot; j++){
                subGridVals[k] = sudoku_board[i][j];
                k++;
            }
        }
        return subGridVals;
    }

  //  public boolean solve_Sudoku(int n, String [][] sudoku_board){
  //      //System.out.println("value of n is : "+n);
  //      int row = -1;
  //      int col = -1;
  //      boolean isEmpty = true;
  //      for (int i = 0; i < n; i++)
  //      {
  //          for (int j = 0; j < n; j++)
  //          {
  //              if (sudoku_board[i][j].equals("0"))
  //              {
  //                  row = i;
  //                  col = j;
  //
  //                  isEmpty = false;
  //                  break;
  //              }
  //          }
  //          if (!isEmpty)
  //          {
  //              break;
  //          }
  //      }
  //      // no empty space left
  //      if (isEmpty)
  //      {
  //          return true;
  //      }
  //
  //      // else for each-row backtrack
  //      for (String i : valid_symbols)
  //      {
  //          //System.out.println("valid number is : "+i);
  //          if (isAllowed(sudoku_board, row, col, i ))
  //          {
  //              sudoku_board[row][col] = i;
  //              //sudoku_board[row][col].replace(sudoku_board[row][col],i);
  //              if (solve_Sudoku(n,sudoku_board))
  //              {
  //                  // print(board, n);
  //                  return true;
  //              }
  //              else
  //              {
  //                  sudoku_board[row][col] ="0" ; // replace it
  //              }
  //          }
  //      }
  //
  //      return false;
  //  }

   // public boolean isAllowed(String[][] sudoku_board, int row, int col, String value) {
   //     //number is not repeated in row
   //     for (int i = 0; i < sudoku_board.length; i++) {
   //         if (sudoku_board[row][i].equals(value)) {
   //             return false;
   //         }
   //     }
   //     //number is not repeated in column
   //     for (int i = 0; i < sudoku_board.length; i++) {
   //         if (sudoku_board[i][col].equals(value)) {
   //             return false;
   //         }
   //     }
   //     //number is not repeated in subgrid block
   //     Double sqrt = Math.sqrt(size);
   //     int squareRoot = sqrt.intValue();
   //     int r = row - row % squareRoot;
   //     int c = col - col % squareRoot;
   //     for (int i = r; i < r + squareRoot; i++) {
   //
   //         for (int j = c; j < c + squareRoot; j++) {
   //             if(sudoku_board[i][j].equals(value))
   //                 return false;
   //         }
   //     }
   //     return true;
   // }

    public int getSize() {
        return size;
    }

    public String[][] getSudoku_board() {
        return sudoku_board;
    }

    public String[] getValid_symbols() {
        return valid_symbols;
    }

    public String getsudoku(String filename) throws FileNotFoundException {
        String sudoku ="";
        File file = new File(filename);
        Scanner sc = new Scanner (file);
        size = Integer.parseInt(String.valueOf(sc.nextLine()));
        String valids = "";
        sudoku_board = new String[size][size];
        valid_symbols = new String[size];

        System.out.println(size);
        sudoku = sudoku.concat(String.valueOf(size));
        sudoku = sudoku.concat("\n");

        valids = valids.concat(sc.nextLine());
        valid_symbols = valids.split(" ");

        for (int i =0 ; i< valid_symbols.length ; ++i){
            System.out.print(valid_symbols[i]+" ");
            sudoku = sudoku.concat(valid_symbols[i]);
            sudoku = sudoku.concat(" ");
        }
        System.out.print("\n");
        sudoku = sudoku.concat("\n");

        String [] sudoku_string = new String[size];

        for (int i =0 ; sc.hasNextLine() ; ++i){
            sudoku_string[i]=sc.nextLine();
            System.out.print(sudoku_string[i]+"\n");
            sudoku = sudoku.concat(sudoku_string[i]);
            sudoku = sudoku.concat("\n");
        }

        //System.out.println("actual sudoku is as follows:");

        for(int i =0 ; i<size ; ++i){
            String [] row = sudoku_string[i].split(" ");
            for(int j=0 ; j<size ; ++j){
                if(row[j].equals("-"))
                {
                    sudoku_board[i][j]="0";
                }
                else {
                    sudoku_board[i][j] = row[j];
                }
            }
        }
        return sudoku;
    }

    public String getSudokustring() {
        return sudoku;
    }

    static boolean isPerfectSquare(int x)
    {

        // Find floating point value of
        // square root of x.
        double sr = Math.sqrt(x);

        // If square root is an integer
        return ((sr - Math.floor(sr)) == 0);
    }
}
