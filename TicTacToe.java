import java.util.*;
import java.io.*;

class TicTacToe {
  private Board board; 
  char playerX;
  char playerO;
  char currentPlayer;
  
  int roundCount;

  public TicTacToe() {
    // YOUR WORK HERE
    board = new Board();
    board.printBoard();
    playerX = 'x';
    playerO = 'o';
    currentPlayer = playerX;
    roundCount = 9;
  }

  public void play() {
    // YOUR WORK HERE
    if(roundCount > 0){
      System.out.println("curent player is " + currentPlayer);

      System.out.println("To play the piece, type 0 - 2 for row and column: ");
      // System.out.println("To play the piece, type 0 - 2 for column: ");
      // read in user's input
      
      Scanner sc = new Scanner(System.in);
      int i = sc.nextInt();
      int row = i / 10;
      int col = i % 10;
      if(row > 2 || row < 0 || col > 2 || col < 0){
        printInvalidMove();
        play();
      } else {
        playRound(row, col); 
      }
      
    } else {
      declareTie();
    }
    
  }

  public void playRound(int row, int col) {
    // YOUR WORK HERE
   
   if( board.canPlacePiece(row, col)) {
     board.placePiece(row, col, currentPlayer);
    if (board.checkWinCondtion(currentPlayer)) {
      // interface with TicTacToe reference
      declareWinner(currentPlayer);
    // } else if(roundCount == 0){
    //   // tie
    //   declareTie() 
    } else {
      // board.printBoard();
      decrementRounds();
      switchPlayer();
      play();
    }
   } else {
     // cannot place piece
     printInvalidMove();
     play();
   }


  }

  public void printCurrentPlayersTurn() {
    // YOUR WORK HERE
  }

  public void decrementRounds() {
    // YOUR WORK HERE
    roundCount--;
    // System.out.println("round count:"+ roundCound);
  }

  public void declareWinner(char player) {
    // YOUR WORK HERE
    System.out.println(player + " won!!");
  }

  public void declareTie() {
    // YOUR WORK HERE
    System.out.println("Tie!!");
  }

  public void printInvalidMove(){
    // YOUR WORK HERE
    System.out.println("invalid move!!! type another position");
  }

  public void printCurrentMove(int row, int col) {
    // YOUR WORK HERE
  }

  public void switchPlayer() {
    // YOUR WORK HERE
    if(currentPlayer == 'x') {
      currentPlayer = 'o';
    } else {
      currentPlayer = 'x';
    }

  }

}



class Board {

  public char[][] tictoeBoard;

  public Board() {
    // YOUR WORK HERE
    tictoeBoard = new char[3][3];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        tictoeBoard[i][j] = ' ';
      }
    }
  }

  public void printBoard() {
    // YOUR WORK HERE
    System.out.println("========start display board==============");
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        System.out.print("|" + tictoeBoard[i][j]);
      }
    System.out.print("|");
    System.out.println();
    }
    
    System.out.println("========end of display board==============");
  }

  public boolean canPlacePiece(int row, int col) {
    // YOUR WORK HERE
    return tictoeBoard[row][col] == ' ' ? true : false;
  }

  public void placePiece(int row, int col, char player) {
    // YOUR WORK HERE
    tictoeBoard[row][col] = player;
    printBoard();
    // if (checkWinCondtion(player)) {
    //   // interface with TicTacToe
    //   // reference
    //   declareWinner(player);
    // } else {
    //   printBoard();
    // }
  }

  public boolean checkWinCondtion(char player) {
    // YOUR WORK HERE
    // boolean winning = false;
    // row
    // column
    // diagnoals
    if (checkDiagonals(player) || checkRows(player) || checkColumns(player)) {
      return true;
    } 
    return false;
  }

  public boolean checkDiagonals(char player) {
    // YOUR WORK HERE
    boolean dig0 = true;
    boolean dig1 = true;
    for(int i = 0; i <3 ; i++){
      if (tictoeBoard[i][i] != player){
        dig0 =false;
        break;
      }
    }
    
    for(int i = 0; i <3 ; i++){
      if (tictoeBoard[i][2-i] != player){
        dig1 =false;
        break;
      }
    }
    // System.out.println("dig0 || dig1" + Boolean.toString(dig0 || dig1));
    return dig0 || dig1;
  }

  public boolean checkRows(char player) {
    boolean row0 = true;
    boolean row1 = true; 
    boolean row2 = true;

    // first column
    for(int i = 0; i < 3; i++){
      if(tictoeBoard[0][i] != player){
        row0 = false;
        break;
      }
    }

    for(int i = 0; i < 3; i++){
      if(tictoeBoard[1][i] != player){
        row1 = false;
        break;
      }
    }
    for(int i = 0; i < 3; i++){
      if(tictoeBoard[2][i] != player){
        row2 = false;
        break;
      }
    }
    // System.out.println("row0 || row1 || row2" + Boolean.toString(row0||row1||row2));
    return row0 || row1 || row2;

  }

  public boolean checkColumns(char player) {
    // YOUR WORK HERE
    boolean col0 = true;
    boolean col1 = true; 
    boolean col2 = true;

    // first column
    for(int i = 0; i < 3; i++){
      if(tictoeBoard[i][0] != player){
        col0 = false;
        break;
      }
    }

    for(int i = 0; i < 3; i++){
      if(tictoeBoard[i][1] != player){
        col1 = false;
        break;
      }
    }
    for(int i = 0; i < 3; i++){
      if(tictoeBoard[i][2] != player){
        col2 = false;
        break;
      }
    }
    // System.out.println("col0 || col1 || col2" + Boolean.toString(col0 || col1 || col2));
    return col0 || col1 || col2;
  }
}

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    // Board boardTest = new Board();
    // boardTest.printBoard();
    TicTacToe t = new TicTacToe();
    t.play();
  }
}
