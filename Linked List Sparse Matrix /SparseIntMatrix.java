//importing required modules
import java.io.*;
import java.util.*;

//declaration of class
public class SparseIntMatrix{
//instance variables
  private int intRows;
  private int intCols;
  private MatrixEntry[] theRow;
  private MatrixEntry[] theCol;

//constructor 1
  public SparseIntMatrix(int numRows, int numCols){
    this.intRows = intRows;
    this.intCols = intCols;
    theRow = new MatrixEntry[intRows];
    theCol = new MatrixEntry[intCols];
  }

//constructor 2
  public SparseIntMatrix(int numRows, int numCols, String inputFile){
    this.intRows = intRows;
    this.intCols = intCols;
    theRow = new MatrixEntry[intRows];
    theCol = new MatrixEntry[intCols];
    try{
    File file = new File(inputFile);
    Scanner scan = new Scanner(file);
    while(scan.hasNext()){
      int x,y,z;
      String line;
      String[] lineContent;
      line = scan.nextLine();
      System.out.println(line);
      lineContent = line.split(",");
      try {
   x= Integer.parseInt(lineContent[0]);
} catch (NumberFormatException nfe) {
  x= 0;
}
try {
y= Integer.parseInt(lineContent[1]);
} catch (NumberFormatException nfe) {
y=0;
}
try {
z= Integer.parseInt(lineContent[2]);
} catch (NumberFormatException nfe) {
z= 0;
}

      MatrixEntry node = new MatrixEntry(x,y,z);
      if(x==0 && y==0){
        theCol[0] = node;
        theRow[0] = node;
      }
      else if(x==0){
        theCol[y] = node;
      }
      else if(y==0){
        theRow[x] = node;
      }
      else{
        MatrixEntry tempRow = getNode(x,y-1);
        MatrixEntry tempCol = getNode(x-1,y);
        tempRow.setNextCol(node);
        tempCol.setNextRow(node);
      }
    }
  }
  catch(Exception ex){
    System.out.println("File not found");
  }
  }

//methods
  public int getElement(int row, int col){
    MatrixEntry elem = getNode(row,col);
    return elem.getData();
  }

  public boolean setElement(int row, int col, int data){
    if(row>=0&& row<intRows && col >= 0&& row < intCols){
      MatrixEntry elem = getNode(row,col);
      if (elem == null){
        elem = new MatrixEntry(row,col,data);
      }
      else{
      elem.setData(data);
    }
      return true;
    }
    else{
      return false;
    }
  }

  public boolean removeElement(int row, int col, int data){
      if (getNode(row,col) == null){
        return false;
      }
      else{
        MatrixEntry temp1= getNode(row-1,col);
        MatrixEntry temp2= getNode(row, col-1);
        MatrixEntry temp3= getNode(row,col);
        temp1.setNextCol(temp2.getNextCol());
        temp2.setNextRow(temp2.getNextRow());
        temp2 = null;
        return true;
      }
  }

  public int getNumCols(){
    return this.intCols;
  }

  public int getNumRows(){
    return this.intRows;
  }

//helper methods
  public MatrixEntry getNode(int row, int col){
    MatrixEntry tempX = theRow[row];
    for(int c=0; c< col; c++){
      tempX= tempX.getNextCol();
    }
    if((tempX.getRow() == row) && (tempX.getColumn() ==col)){
    return tempX;
  }
  else{
    return null;
  }
  }
  public boolean hasNext(){
 return false;
  }

  public static void main(String[] args) {
    SparseIntMatrix mat = new SparseIntMatrix(800,800,"matrix1_data.txt");
    MatrixViewer.show(mat);
  }
}
