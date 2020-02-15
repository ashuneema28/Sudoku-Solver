public class Sudoku_Solver {
    private Sudoku sudoku;
    private String tofile;
    public Sudoku_Solver(Sudoku sudoku1) {
        String onepossibletime,onlyoneplacetime,backtrackingtime;

        this.sudoku=sudoku1;
        tofile = sudoku.getSudokustring();
        One_possible one_possible = new One_possible(sudoku1.getSize(), sudoku1.getSudoku_board(), sudoku1.getValid_symbols());
        one_possible.solve();
        if (one_possible.getUsage_count()==0){
            onepossibletime="0";
        }
        else
        {
            onepossibletime=String.valueOf(one_possible.getStrategyTime());
        }

        System.out.println("Only_one_place starts");
       Only_one_place only_one_place = new Only_one_place(one_possible.getSize(), one_possible.getSudoku_board(), one_possible.getValid_symbols());
        only_one_place.solve();
        if (only_one_place.getUsage_count()==0){
            onlyoneplacetime="0";
        }
        else
        {
            onlyoneplacetime=String.valueOf(only_one_place.getStrategyTime());
        }

        System.out.println("Bactracking starts");

        Backtracking backtracking = new Backtracking(only_one_place.getSize(), only_one_place.getSudoku_board(), only_one_place.getValid_symbols());
        backtracking.solve();
        if (backtracking.getUsage_count()==0){
            backtrackingtime="0";
        }
        else
        {
            backtrackingtime=String.valueOf(backtracking.getStrategyTime());
        }
        tofile = tofile.concat(backtracking.getSudoku()+"\nTotal time: "+ String.valueOf(backtracking.gettotaltime())+" nanoseconds\n");
        tofile = tofile.concat("\nStrategy\t\t\t\t\tUses\t\t\t\t\tTime(nanoseconds)");
        tofile = tofile.concat("\nOne Possible\t\t\t\t"+String.valueOf(one_possible.getUsage_count())+"\t\t\t\t\t\t"+onepossibletime);
        tofile = tofile.concat("\nOnly one place\t\t\t\t"+String.valueOf(only_one_place.getUsage_count())+"\t\t\t\t\t\t"+onlyoneplacetime);
        tofile = tofile.concat("\nBacktracking\t\t\t\t"+String.valueOf(backtracking.getUsage_count())+"\t\t\t\t\t\t"+backtrackingtime);

    }

    public String toString(){
        return tofile;
    }
}
