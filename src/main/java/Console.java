import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) throws IOException {

        System.out.println("enter the file name");
        Scanner sc = new Scanner(System.in);
        //String filename = sc.next();
        String filename="sudoku1.txt";
        Sudoku sudoku1 = new Sudoku(filename);

        if (sudoku1.isValidSudoku(sudoku1.getSudoku_board())) {
            Sudoku_Solver solvedsudoku = new Sudoku_Solver(sudoku1);
            System.out.println("enter the file name in which you want to save the solution");
            sc = new Scanner(System.in);
            //filename = sc.next();
            filename = "1.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(solvedsudoku.toString());
            writer.close();
            System.out.println(solvedsudoku.toString());
        }
        else{
            System.out.println(sudoku1.getSudokustring());
            System.out.println("Invalid sudoku board");
        }
    }
}
