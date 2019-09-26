public class MatrixEntry{
  //instance variables:
  private int row;
  private int col;
  private int data;
  private MatrixEntry nextInRow;
  private MatrixEntry nextInCol;

  //constructor
  public MatrixEntry(int row, int col, int data){
    this.row = row;
    this.col = col;
    this.data = data;
  }

// setters and getters for the stored data
  public int getColumn(){
    return this.col;
  }

  public void setColumn(int col){
    this.col = col;
  }

  public int getRow(){
    return this.row;
  }

  public void setRow(int row){
    this.row = row;
  }

  public int getData(){
    return this.data;
  }

  public void setData(int data){
    this.data = data;
  }

  public MatrixEntry getNextRow(){
    return nextInRow;
  }
  public void setNextRow(MatrixEntry el){
    this.nextInRow = el;
  }
  public MatrixEntry getNextCol(){
    return nextInCol;
  }
  public void setNextCol(MatrixEntry el){
    this.nextInCol = el;
  }

}
