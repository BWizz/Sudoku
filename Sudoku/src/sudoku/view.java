
package sudoku;
import java.awt.Color;

import java.awt.Font;

import java.awt.Graphics;

import java.awt.TextField;
import java.awt.event.ActionEvent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.SwingWorker;

import jdk.internal.util.xml.impl.Pair;


/**
 *
 * @author brian.wisniewski
 */
public class view extends javax.swing.JFrame {

    /** Creates new form view */
    public view() {
        initComponents();
        /*
        this.MyTextFields = new JTextField[]
        {
        jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8,
        jTextField9, jTextField10, jTextField11, jTextField12, jTextField13, jTextField14, jTextField15,
        jTextField16, jTextField17, jTextField18, jTextField19, jTextField20, jTextField21, jTextField22,
        jTextField23, jTextField24, jTextField25, jTextField26, jTextField27, jTextField28, jTextField29,
        jTextField30, jTextField31, jTextField32, jTextField33, jTextField34, jTextField35, jTextField36,
        jTextField37, jTextField38, jTextField39, jTextField40, jTextField41, jTextField42, jTextField43,
        jTextField44, jTextField45, jTextField46, jTextField47, jTextField48, jTextField49, jTextField50,
        jTextField51, jTextField52, jTextField53, jTextField54, jTextField55, jTextField56, jTextField57,
        jTextField58, jTextField59, jTextField60, jTextField61, jTextField62, jTextField63, jTextField64,
        jTextField65, jTextField66, jTextField67, jTextField68, jTextField69, jTextField70, jTextField71,
        jTextField72, jTextField73, jTextField74, jTextField75, jTextField76, jTextField77, jTextField78,
        jTextField79, jTextField80, jTextField81};*/
        
        this.MyTextFields = new JTextField[][]
            {{       jTextField1,    jTextField2,    jTextField3,    jTextField10,   jTextField11,   jTextField12,   jTextField19,   jTextField20,   jTextField21   },
             {       jTextField4,    jTextField5,    jTextField6,    jTextField13,   jTextField14,   jTextField15,   jTextField22,   jTextField23,   jTextField24   },
             {       jTextField7,    jTextField8,    jTextField9,    jTextField16,   jTextField17,   jTextField18,   jTextField25,   jTextField26,   jTextField27   },
             {       jTextField46,   jTextField47,   jTextField48,   jTextField37,   jTextField38,   jTextField39,   jTextField28,   jTextField29,   jTextField30   },
             {       jTextField49,   jTextField50,   jTextField51,   jTextField40,   jTextField41,   jTextField42,   jTextField31,   jTextField32,   jTextField33   },
             {       jTextField52,   jTextField53,   jTextField54,   jTextField43,   jTextField44,   jTextField45,   jTextField34,   jTextField35,   jTextField36   },
             {       jTextField55,   jTextField56,   jTextField57,   jTextField64,   jTextField65,   jTextField66,   jTextField73,   jTextField74,   jTextField75   },
             {       jTextField58,   jTextField59,   jTextField60,   jTextField67,   jTextField68,   jTextField69,   jTextField76,   jTextField77,   jTextField78   },
             {       jTextField61,   jTextField62,   jTextField63,   jTextField70,   jTextField71,   jTextField72,   jTextField79,   jTextField80,   jTextField81   }};
       /* 
        this.Suduko_Entery_Map = new int[][] {
            { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 }, { 2, 2 }, { 0, 3 },
            { 0, 4 }, { 0, 5 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 4 }, { 2, 5 }, { 0, 6 }, { 0, 7 },
            { 0, 8 }, { 1, 6 }, { 1, 7 }, { 1, 8 }, { 2, 6 }, { 2, 7 }, { 2, 8 }, { 3, 6 }, { 3, 7 }, { 3, 8 },
            { 4, 6 }, { 4, 7 }, { 4, 8 }, { 5, 6 }, { 5, 7 }, { 5, 8 }, { 3, 3 }, { 3, 4 }, { 3, 5 }, { 4, 3 },
            { 4, 4 }, { 4, 5 }, { 5, 3 }, { 5, 4 }, { 5, 5 }, { 3, 0 }, { 3, 1 }, { 3, 2 }, { 4, 0 }, { 4, 1 },
            { 4, 2 }, { 5, 0 }, { 5, 1 }, { 5, 2 }, { 6, 0 }, { 6, 1 }, { 6, 2 }, { 7, 0 }, { 7, 1 }, { 7, 2 },
            { 8, 0 }, { 8, 1 }, { 8, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 }, { 7, 3 }, { 7, 4 }, { 7, 5 }, { 8, 3 },
            { 8, 4 }, { 8, 5 }, { 6, 6 }, { 6, 7 }, { 6, 8 }, { 7, 6 }, { 7, 7 }, { 7, 8 }, { 8, 6 }, { 8, 7 }, { 8, 8 }
        };
        */
        this.Prev_Solution = new int[9][9];
        //Generate_Puzzle();
        //CheckPuzzle();
    }
  public class Generate_Puzzle_Task extends SwingWorker<Void, Void>
   {
        @Override
        protected Void doInBackground()throws Exception 
        {
            Generate_Puzzle();
            //CheckPuzzle();
            return null;
        }
    }
        public class Solve_Puzzle_Task extends SwingWorker<Void, Void>
         {
              @Override
              protected Void doInBackground()throws Exception 
              {
                  Solve_Puzzle();
                  return null;
              }
          }
   
        
    private void Generate_Puzzle(){
        Random rand = new Random();
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                Prev_Solution[i][j] = 0;
            }
        }

        //Resets Everting
        SudokuEnteries.ResetUserEntery();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField TextField = MyTextFields[i][j];
                TextField.setText("");
                TextField.setFont(getFont().deriveFont(22f));
                TextField.setEditable(true);
            }
        }
        //Generate Values
        for (int k = 0; k < 10; k++) {
            int i = rand.nextInt(9);
            int j = rand.nextInt(9);
            while(SudokuEnteries.GetEntry(i,j) != 0){
                i = rand.nextInt(9);
                j = rand.nextInt(9);
            }
            int Value = rand.nextInt(9) + 1;
            SudokuEnteries.AddUserEntery(Value, i, j);
            MyTextFields[i][j].setText(Integer.toString(Value));
            repaint();
            try {
                Thread.sleep(10); //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
            int[] row = SudokuEnteries.GetRow(i);
            int[] isDupRow = isDuplicateEntry(row);
            int[] col = SudokuEnteries.GetColumn(j);
            int[] isDupCol = isDuplicateEntry(col);
            int[] panelArray = SudokuEnteries.GetPanel(i,j);
            int[] isDupPan = isDuplicateEntry(panelArray); 
            if ((((isDupRow[0] == 1 & isDupRow[1] == Value ) | (isDupCol[0] == 1 & isDupCol[1] ==Value))
                | (isDupPan[0] == 1 & isDupPan[1] == Value )) & Value != 0 ){
                boolean Solution_Found = false;
                SudokuEnteries.PrintTable();
                while(Solution_Found == false) {
                    int NewValue = SudokuEnteries.Increment(i, j);
                    row = SudokuEnteries.GetRow(i);
                    col = SudokuEnteries.GetColumn(j);
                    panelArray = SudokuEnteries.GetPanel(i,j);;
                    isDupRow = isDuplicateEntry(row);
                    isDupCol = isDuplicateEntry(col);
                    isDupPan = isDuplicateEntry(panelArray); 
                    if (isDupRow[0] == 0 & isDupCol[0] == 0 & isDupPan[0]==0) {
                        Solution_Found = true;
                        MyTextFields[i][j].setText(Integer.toString(NewValue));
                        MyTextFields[i][j].setFont(getFont().deriveFont(Font.BOLD, 25f));
                        MyTextFields[i][j].setEditable(false);
                        //MyTextFields[i][j].invalidate();
                        //MyTextFields[i][j].repaint();
                        repaint();
                        try {
                            Thread.sleep(1); //1000 milliseconds is one second.
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }

                        break;
                    }
                }
            }else{
                MyTextFields[i][j].setFont(getFont().deriveFont(Font.BOLD, 25f));
                MyTextFields[i][j].setEditable(false);
            }
            
            
            
            
            /*
            SudokuEnteries.AddUserEntery(Value, row, col);
            JTextField TextField = MyTextFields[row][col];
            TextField.setText(Integer.toString(Value));
            TextField.setFont(getFont().deriveFont(Font.BOLD, 25f));
            TextField.setEditable(false);
            repaint();
            try {
            Thread.sleep(10);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
            }
*/
        }
        SudokuEnteries.PrintTable();
    }

    private int[] isDuplicateEntry(int[] Array){
        int value = 0;
        int flag = 0;
        HashSet <Integer> newset = new HashSet <Integer>();
        for(int i=0; i<Array.length; i++){
            if (Array[i] > 0){
                if (newset.add(Array[i]) == false){
                    flag = 1;
                    value = Array[i];
                    return new int[] {flag, value};
                }
            }
        }
        return new int[] {flag, value};
    }

    private void Generate_New_Value(int row, int col) {
        if (row < 9 & col < 9) {
            if(MyTextFields[row][col].isEditable() == true){

            int Entry_Value = SudokuEnteries.GetEntry(row, col);
            if (Entry_Value == 0) {
                SudokuEnteries.AddUserEntery(1, row, col);
            } else {
                SudokuEnteries.Increment(row, col);
            }
            MyTextFields[row][col].setText(Integer.toString(SudokuEnteries.GetEntry(row, col)));
        }
        }
        repaint();
        try {
            Thread.sleep(5); //1000 milliseconds is one second.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private boolean isSolution(int row, int col){
        int Entry_Value = SudokuEnteries.GetEntry(row, col);
        SudokuEnteries.AddUserEntery(Entry_Value,row,col);
        int[] rowArray = SudokuEnteries.GetRow(row);
        int[] isDupRow = isDuplicateEntry(rowArray);
        int[] colArray = SudokuEnteries.GetColumn(col);
        int[] isDupCol = isDuplicateEntry(colArray);
        int[] panelArray = SudokuEnteries.GetPanel(row,col);
        int[] isDupPan = isDuplicateEntry(panelArray); 
        if (((isDupRow[0] == 1 & isDupRow[1] == Entry_Value ) | (isDupCol[0] == 1 & isDupCol[1] ==Entry_Value))
        | (isDupPan[0] == 1 & isDupPan[1] == Entry_Value )){
            MyTextFields[row][col].setText("");
            return false;
            
        } 
        else if(Entry_Value == (int)0 | MyTextFields[row][col].isEditable() == false)
        {
            return false;
        }
        else{
            return true;
        }
        
    }
    private void Backtrack_Reset_Value(int row, int col){
        if (MyTextFields[row][col].isEditable() == true){
        SudokuEnteries.AddUserEntery(0,row,col);
        MyTextFields[row][col].setText("");
            repaint();
            try {
                Thread.sleep(10); //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    private int[] Backtack_Index(int i, int j){
        j = j - 1;
        if (j < 0 & i >= 0) {
            j = 8;
            i = i - 1;
            if (i < 0) {
                i = 0;
            }
        } else if(j < 0 & i <=0) {
            j = 0;
            i = 0;
        }
        return (new int[]{i,j});
    }

    private void CheckPuzzle() {
        //First Check Rows
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int Entry_Value = SudokuEnteries.GetEntry(i, j);
                if (Entry_Value > 0) {
                    int[] row = SudokuEnteries.GetRow(i);
                    int[] isDupRow = isDuplicateEntry(row);
                    int[] col = SudokuEnteries.GetColumn(j);
                    int[] isDupCol = isDuplicateEntry(col);
                    int[] panelArray = SudokuEnteries.GetPanel(i,j);
                    int[] isDupPan = isDuplicateEntry(panelArray); 
                    if ((((isDupRow[0] == 1 & isDupRow[1] == Entry_Value ) | (isDupCol[0] == 1 & isDupCol[1] ==Entry_Value))
                        | (isDupPan[0] == 1 & isDupPan[1] == Entry_Value )) & Entry_Value != 0 ){
                        boolean Solution_Found = false;
                        SudokuEnteries.PrintTable();
                        while(Solution_Found == false) {
                            int NewValue = SudokuEnteries.Increment(i, j);
                            row = SudokuEnteries.GetRow(i);
                            col = SudokuEnteries.GetColumn(j);
                            isDupRow = isDuplicateEntry(row);
                            isDupCol = isDuplicateEntry(col);
                            if (isDupRow[0] == 0 & isDupCol[0] == 0) {
                                Solution_Found = true;
                                MyTextFields[i][j].setText(Integer.toString(NewValue));
                                //MyTextFields[i][j].invalidate();
                                //MyTextFields[i][j].repaint();
                                repaint();
                                try {
                                    Thread.sleep(1); //1000 milliseconds is one second.
                                } catch (InterruptedException ex) {
                                    Thread.currentThread().interrupt();
                                }

                                break;
                            }
                        }
                    }
                }
            }
        }
        int a = 1;
    }
    public void Solve_Puzzle(){
        int i =0,j=0;
        boolean solution_found = false;
        boolean backtracking_enabled = false;
        int[] Index;
        while(i<9){
            while(j<9){
                
                solution_found = isSolution(i,j);
                //Moveforward if
                if((solution_found == true & Prev_Solution[i][j] != SudokuEnteries.GetEntry(i, j))
                   | MyTextFields[i][j].isEditable() == false & backtracking_enabled == false){
                       Prev_Solution[i][j] = SudokuEnteries.GetEntry(i, j);
                       j = j+1;
                       Generate_New_Value(i, j);
                   }
                //Movebackward if
                else if((/*solution_found == false &*/ SudokuEnteries.GetEntry(i, j) == 9)
                        | MyTextFields[i][j].isEditable() == false){
                        //| (Prev_Solution[i][j] == SudokuEnteries.GetEntry(i, j)
                        //& Prev_Solution[i][j]!= 0)){
                            Backtrack_Reset_Value(i,j);
                            Prev_Solution[i][j] = 0;
                            Index = Backtack_Index(i,j);
                            i = Index[0];
                            j = Index[1];
                            backtracking_enabled = true;
                            Prev_Solution[i][j] = SudokuEnteries.GetEntry(i, j);
                            //Generate_New_Value(i, j);              
                        }
                //Generate Next Value
                else{
                    Generate_New_Value(i, j);
                    backtracking_enabled = false;
                }
                
            }
            i = i +1;
            j = 0;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jTextField55 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        jTextField57 = new javax.swing.JTextField();
        jTextField58 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jTextField61 = new javax.swing.JTextField();
        jTextField62 = new javax.swing.JTextField();
        jTextField63 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jTextField64 = new javax.swing.JTextField();
        jTextField65 = new javax.swing.JTextField();
        jTextField66 = new javax.swing.JTextField();
        jTextField67 = new javax.swing.JTextField();
        jTextField68 = new javax.swing.JTextField();
        jTextField69 = new javax.swing.JTextField();
        jTextField70 = new javax.swing.JTextField();
        jTextField71 = new javax.swing.JTextField();
        jTextField72 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jTextField73 = new javax.swing.JTextField();
        jTextField74 = new javax.swing.JTextField();
        jTextField75 = new javax.swing.JTextField();
        jTextField76 = new javax.swing.JTextField();
        jTextField77 = new javax.swing.JTextField();
        jTextField78 = new javax.swing.JTextField();
        jTextField79 = new javax.swing.JTextField();
        jTextField80 = new javax.swing.JTextField();
        jTextField81 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jTextField1.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField2.setHorizontalAlignment(JTextField.CENTER);
        jTextField2.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField3.setHorizontalAlignment(JTextField.CENTER);
        jTextField3.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField4.setHorizontalAlignment(JTextField.CENTER);
        jTextField4.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField5.setHorizontalAlignment(JTextField.CENTER);
        jTextField5.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField6.setHorizontalAlignment(JTextField.CENTER);
        jTextField6.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField7.setHorizontalAlignment(JTextField.CENTER);
        jTextField7.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField8.setHorizontalAlignment(JTextField.CENTER);
        jTextField8.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField9.setHorizontalAlignment(JTextField.CENTER);
        jTextField9.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField10.setHorizontalAlignment(JTextField.CENTER);
        jTextField10.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField11.setHorizontalAlignment(JTextField.CENTER);
        jTextField11.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField12.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField12.setHorizontalAlignment(JTextField.CENTER);
        jTextField12.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField13.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField13.setHorizontalAlignment(JTextField.CENTER);
        jTextField13.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField14.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField14.setHorizontalAlignment(JTextField.CENTER);
        jTextField14.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField15.setHorizontalAlignment(JTextField.CENTER);
        jTextField15.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField16.setHorizontalAlignment(JTextField.CENTER);
        jTextField16.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField17.setHorizontalAlignment(JTextField.CENTER);
        jTextField17.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField18.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField18.setHorizontalAlignment(JTextField.CENTER);
        jTextField18.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextField19.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField19.setHorizontalAlignment(JTextField.CENTER);
        jTextField19.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField20.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField20.setHorizontalAlignment(JTextField.CENTER);
        jTextField20.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField21.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField21.setHorizontalAlignment(JTextField.CENTER);
        jTextField21.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField22.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField22.setHorizontalAlignment(JTextField.CENTER);
        jTextField22.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField23.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField23.setHorizontalAlignment(JTextField.CENTER);
        jTextField23.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField24.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField24.setHorizontalAlignment(JTextField.CENTER);
        jTextField24.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField25.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField25.setHorizontalAlignment(JTextField.CENTER);
        jTextField25.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField26.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField26.setHorizontalAlignment(JTextField.CENTER);
        jTextField26.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField27.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField27.setHorizontalAlignment(JTextField.CENTER);
        jTextField27.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextField28.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField28.setHorizontalAlignment(JTextField.CENTER);
        jTextField28.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField29.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField29.setHorizontalAlignment(JTextField.CENTER);
        jTextField29.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField30.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField30.setHorizontalAlignment(JTextField.CENTER);
        jTextField30.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField31.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField31.setHorizontalAlignment(JTextField.CENTER);
        jTextField31.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField32.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField32.setHorizontalAlignment(JTextField.CENTER);
        jTextField32.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField33.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField33.setHorizontalAlignment(JTextField.CENTER);
        jTextField33.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField34.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField34.setHorizontalAlignment(JTextField.CENTER);
        jTextField34.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField35.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField35.setHorizontalAlignment(JTextField.CENTER);
        jTextField35.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField36.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField36.setHorizontalAlignment(JTextField.CENTER);
        jTextField36.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextField37.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField37.setHorizontalAlignment(JTextField.CENTER);
        jTextField37.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField38.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField38.setHorizontalAlignment(JTextField.CENTER);
        jTextField38.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField39.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField39.setHorizontalAlignment(JTextField.CENTER);
        jTextField39.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField40.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField40.setHorizontalAlignment(JTextField.CENTER);
        jTextField40.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField41.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField41.setHorizontalAlignment(JTextField.CENTER);
        jTextField41.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField42.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField42.setHorizontalAlignment(JTextField.CENTER);
        jTextField42.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField43.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField43.setHorizontalAlignment(JTextField.CENTER);
        jTextField43.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField44.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField44.setHorizontalAlignment(JTextField.CENTER);
        jTextField44.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField45.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField45.setHorizontalAlignment(JTextField.CENTER);
        jTextField45.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextField46.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField46.setHorizontalAlignment(JTextField.CENTER);
        jTextField46.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField47.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField47.setHorizontalAlignment(JTextField.CENTER);
        jTextField47.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField48.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField48.setHorizontalAlignment(JTextField.CENTER);
        jTextField48.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField49.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField49.setHorizontalAlignment(JTextField.CENTER);
        jTextField49.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField50.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField50.setHorizontalAlignment(JTextField.CENTER);
        jTextField50.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField51.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField51.setHorizontalAlignment(JTextField.CENTER);
        jTextField51.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField52.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField52.setHorizontalAlignment(JTextField.CENTER);
        jTextField52.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField53.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField53.setHorizontalAlignment(JTextField.CENTER);
        jTextField53.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField54.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField54.setHorizontalAlignment(JTextField.CENTER);
        jTextField54.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField46, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextField55.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField55.setHorizontalAlignment(JTextField.CENTER);
        jTextField55.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField56.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField56.setHorizontalAlignment(JTextField.CENTER);
        jTextField56.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField57.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField57.setHorizontalAlignment(JTextField.CENTER);
        jTextField57.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField58.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField58.setHorizontalAlignment(JTextField.CENTER);
        jTextField58.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField59.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField59.setHorizontalAlignment(JTextField.CENTER);
        jTextField59.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField60.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField60.setHorizontalAlignment(JTextField.CENTER);
        jTextField60.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField61.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField61.setHorizontalAlignment(JTextField.CENTER);
        jTextField61.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField62.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField62.setHorizontalAlignment(JTextField.CENTER);
        jTextField62.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField63.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField63.setHorizontalAlignment(JTextField.CENTER);
        jTextField63.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextField61, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField62, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextField58, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField56, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField57, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField55, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField56, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField57, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField58, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField61, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField62, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField63, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextField64.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField64.setHorizontalAlignment(JTextField.CENTER);
        jTextField64.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField65.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField65.setHorizontalAlignment(JTextField.CENTER);
        jTextField65.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField66.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField66.setHorizontalAlignment(JTextField.CENTER);
        jTextField66.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField67.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField67.setHorizontalAlignment(JTextField.CENTER);
        jTextField67.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField68.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField68.setHorizontalAlignment(JTextField.CENTER);
        jTextField68.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField69.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField69.setHorizontalAlignment(JTextField.CENTER);
        jTextField69.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField70.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField70.setHorizontalAlignment(JTextField.CENTER);
        jTextField70.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField71.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField71.setHorizontalAlignment(JTextField.CENTER);
        jTextField71.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField72.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField72.setHorizontalAlignment(JTextField.CENTER);
        jTextField72.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField71, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField72, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField68, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField65, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField65, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField68, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField70, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField71, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField72, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextField73.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField73.setHorizontalAlignment(JTextField.CENTER);
        jTextField73.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField74.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField74.setHorizontalAlignment(JTextField.CENTER);
        jTextField74.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField75.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField75.setHorizontalAlignment(JTextField.CENTER);
        jTextField75.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField76.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField76.setHorizontalAlignment(JTextField.CENTER);
        jTextField76.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField77.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField77.setHorizontalAlignment(JTextField.CENTER);
        jTextField77.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField78.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField78.setHorizontalAlignment(JTextField.CENTER);
        jTextField78.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField79.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField79.setHorizontalAlignment(JTextField.CENTER);
        jTextField79.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField80.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField80.setHorizontalAlignment(JTextField.CENTER);
        jTextField80.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        jTextField81.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jTextField81.setHorizontalAlignment(JTextField.CENTER);
        jTextField81.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        jTextField81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                User_Modified_Value(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jTextField79, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField80, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField81, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jTextField76, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField77, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField78, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(jTextField73, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField74, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField75, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField73, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField74, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField75, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField76, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField77, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField78, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField79, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField80, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField81, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton2.setText("New Puzzle!");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Generate_Puzzle(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton3.setText("Check Answer!");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton4.setText("Solve!");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SolveButton(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SimSun", 0, 50)); // NOI18N
        jLabel2.setText("Lets Play Sudoku!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(105, 105, 105))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel1, jPanel2, jPanel3, jPanel4, jPanel5, jPanel6, jPanel7, jPanel8, jPanel9});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel2, jPanel3, jPanel4, jPanel5, jPanel6, jPanel7, jPanel8, jPanel9});

        pack();
    }//GEN-END:initComponents

    private void User_Modified_Value(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_User_Modified_Value
        // TODO add your handling code here:
                    Object source = evt.getSource();
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            if (source == MyTextFields[i][j]) {
                                JTextField TextField = MyTextFields[i][j];
                                String MyTextValue = TextField.getText();
                                if (MyTextValue.matches("[1-9]+") && MyTextValue.length() == 1) {
                                    int EnteredValue = Integer.valueOf(MyTextValue);
                                    SudokuEnteries.AddUserEntery(EnteredValue, i, j);
                                    System.out.println("User entered value is a digit between 1-9 ");
                                } else {
                                    System.out.println("User entered value is not a digit between 1-9");
                                    TextField.setText("");
                                }
                            }
                        }
                    }
    }//GEN-LAST:event_User_Modified_Value

    private void Generate_Puzzle(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Generate_Puzzle
    Generate_Puzzle_Task Gen_Task = new Generate_Puzzle_Task();
    Gen_Task.execute();
    }//GEN-LAST:event_Generate_Puzzle

    private void SolveButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SolveButton
    Solve_Puzzle_Task Solve_Task = new Solve_Puzzle_Task();
    Solve_Task.execute();
    }//GEN-LAST:event_SolveButton


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing
                                                                   .UIManager
                                                                   .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing
                         .UIManager
                         .setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util
                .logging
                .Logger
                .getLogger(view.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util
                .logging
                .Logger
                .getLogger(view.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util
                .logging
                .Logger
                .getLogger(view.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util
                .logging
                .Logger
                .getLogger(view.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt
            .EventQueue
            .invokeLater(new Runnable() {
                public void run() {
                    new view().setVisible(true);
                }
            });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField70;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField72;
    private javax.swing.JTextField jTextField73;
    private javax.swing.JTextField jTextField74;
    private javax.swing.JTextField jTextField75;
    private javax.swing.JTextField jTextField76;
    private javax.swing.JTextField jTextField77;
    private javax.swing.JTextField jTextField78;
    private javax.swing.JTextField jTextField79;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField80;
    private javax.swing.JTextField jTextField81;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
    private SudokuEnteries SudokuEnteries = new SudokuEnteries();
    private JTextField MyTextFields[][];
    private int[][] Prev_Solution;
    private int[][] Suduko_Entery_Map;
}
