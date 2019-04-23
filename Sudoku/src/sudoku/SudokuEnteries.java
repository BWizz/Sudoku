package sudoku;

import java.util.Arrays;

public class SudokuEnteries {
    public SudokuEnteries() {
    }
    
    public void AddUserEntery(int EnteredValue, int row, int col){
        Sudoku_Array[row][col] = EnteredValue;
        System.out.println(Arrays.deepToString(Sudoku_Array).replace("], ", "]\n"));
        System.out.println("");
    }
    
    public void ResetUserEntery(){
        for (int[] row: Sudoku_Array){
            Arrays.fill(row, 0);
        }
        System.out.println(Arrays.deepToString(Sudoku_Array).replace("], ", "]\n"));
        System.out.println("");
    }
    
    public int[] GetColumn(int index){
        int[] col = new int[9];
        for(int i = 0; i<9; i++){
            col[i] = Sudoku_Array[i][index];
        }
        return col;
    }
    
    public int[] GetRow(int index){
        int[] row = new int[9];
        for(int i = 0; i<9; i++){
            row[i] = Sudoku_Array[index][i];
        }
        return row;
    }
    public int[] GetPanel(int row, int col){
        int[] panel = new int[9];
        int k = 0;
        int[] istart = new int[]{0,3,6};
        int[] jstart = new int[]{0,3,6};
        int rows = row/3;
        int cols = col/3;
        for(int i = istart[rows]; i<istart[rows]+3; i++){
            for(int j = jstart[cols]; j<jstart[cols]+3; j++){
                panel[k] = Sudoku_Array[i][j];
                k = k+1;
            }
        }
        return panel;
    }
    
    
    public int GetEntry(int row, int col){
        return Sudoku_Array[row][col];
    }
    
    public int Increment(int row, int col){
        int NewValue = Sudoku_Array[row][col];
        if (NewValue < 9){
            NewValue = NewValue + 1;
        }
        else{
            NewValue = 1;
        }
        Sudoku_Array[row][col]= NewValue;
        return NewValue;
    }
    
    public void PrintTable(){
        System.out.println(Arrays.deepToString(Sudoku_Array).replace("], ", "]\n"));
        System.out.println("");
    }
    
    private static int[][]Sudoku_Array = new int[9][9];
}
