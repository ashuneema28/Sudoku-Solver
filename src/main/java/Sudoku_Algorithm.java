public abstract class Sudoku_Algorithm {
    static long  totaltime = 0;
    long  starttime;
    long  endtime;
    public final void solve(){
        start_time();
        solve_Sudoku();
        displayresult();
        end_time();
        total_time();
    }
    private void start_time(){
        starttime = System.nanoTime();
        System.out.println("The start time is "+starttime);
    }

    private void end_time(){
        endtime = System.nanoTime();
        System.out.println("The end time is "+endtime);
    }

    private void total_time(){
        totaltime = totaltime +(endtime -starttime);
        System.out.println("The total time is "+ totaltime);
    }

    public abstract boolean solve_Sudoku();
    public abstract boolean isAllowed(String[][] sudoku_board, int row, int col, String value);
    public abstract void displayresult();

    public long gettotaltime(){
        return totaltime;
    }
    public long getStrategyTime(){
        return endtime-starttime;
    }
}
