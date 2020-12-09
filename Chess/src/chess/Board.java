/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 8;
    private final static int NUM_COLUMNS = 8;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    private static Piece selectedPiece;
    private static int selectedPieceRow;
    private static int selectedPieceCol;
    
    public static void Reset() {
//Clear the board.
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)
                board[zrow][zcol] = null;
        Player.SwitchTurn();
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++){
                
                if(zrow == 0){
                    if(zcol == 0 || zcol == 7)
                        Board.AddPiecePixel(zrow, zcol, Piece.Type.ROOK);
                    else if(zcol == 1 || zcol == 6)
                        Board.AddPiecePixel(zrow, zcol, Piece.Type.KNIGHT);
                    else if(zcol == 2 || zcol == 5)
                        Board.AddPiecePixel(zrow, zcol, Piece.Type.BISHOP);
                    else if(zcol == 3)
                        Board.AddPiecePixel(zrow, zcol, Piece.Type.QUEEN);
                    else if(zcol == 4)
                        Board.AddPiecePixel(zrow, zcol, Piece.Type.KING);
                }
                if(zrow == 1){
                    Board.AddPiecePixel(zrow, zcol, Piece.Type.PAWN);
                    if(zcol == 7){
                        Player.SwitchTurn();
                    }
                }
                
                if(zrow == 6){
                    Board.AddPiecePixel(zrow, zcol, Piece.Type.PAWN);
                }
                if(zrow == 7){
                    if(zcol == 0 || zcol == 7)
                        Board.AddPiecePixel(zrow, zcol, Piece.Type.ROOK);
                    else if(zcol == 1 || zcol == 6)
                        Board.AddPiecePixel(zrow, zcol, Piece.Type.KNIGHT);
                    else if(zcol == 2 || zcol == 5)
                        Board.AddPiecePixel(zrow, zcol, Piece.Type.BISHOP);
                    else if(zcol == 3)
                        Board.AddPiecePixel(zrow, zcol, Piece.Type.QUEEN);
                    else if(zcol == 4)
                        Board.AddPiecePixel(zrow, zcol, Piece.Type.KING);
                }
            }
        selectedPiece = null;
        selectedPieceRow = 0;
        selectedPieceCol = 0;
    }
    
    public static void SelectPiecePixel(int xpixel,int ypixel) {
        //SELECTING A PIECE WILL CREATE A POINTER TO THAT PIECE. IF THAT PIECE IS CLICKED AGAIN THEN THE...
        //VARIABLE WILL BE CLEARED. IF ANOTHER PIECE IS CLICKED FROM THE SAME TEAM, THE VARIABLE WILL SWITCH.
        if (xpixel < 0 || xpixel > Window.getWidth2())
            return;
        if (ypixel < 0 || ypixel > Window.getHeight2())
            return;
        
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
        int column = xpixel/xdelta;
        int row = ypixel/ydelta;
        
        if(board[row][column] == null && selectedPiece == null){
            // If and empty square is clicked and no piece is selected
            System.out.println("No Piece Selected.");
            return;
        } 
        else if((board[row][column] != null && selectedPiece == null) && board[row][column].getPlayer() != Player.GetCurrentPlayer()){
            // If there is no selected piece and the piece clicked is on the wrong team
            System.out.println("Wrong Piece Selected.");
            return;
        }
        else if(selectedPiece != null && selectedPiece == board[row][column]){
            // If the same piece is selected twice, the piece will be deselected
            selectedPiece = null;
            selectedPieceRow = 0;
            selectedPieceCol = 0;
            return;
        }
        else if((board[row][column] != null && selectedPiece == null) || ((board[row][column] != null && selectedPiece != null) && board[row][column].getPlayer() == selectedPiece.getPlayer())){
            // If a piece is clicked, on the right team, and is not selected already
            System.out.println("Piece Selected.");
            selectedPiece = board[row][column];
            selectedPieceRow = row;
            selectedPieceCol = column;
            return;
        }
        else if((board[row][column] == null && selectedPiece != null) || (board[row][column] != null && board[row][column].getPlayer() != selectedPiece.getPlayer())){
            // Movement test
            board[row][column] = selectedPiece;
            board[selectedPieceRow][selectedPieceCol] = null;
            selectedPiece = null;
            selectedPieceRow = 0;
            selectedPieceCol = 0;
            Player.SwitchTurn();
        }
        
        
        
    }

    public static void AddPiecePixel(int row, int col,Piece.Type type) {
           
        
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
//Find the column to add the piece to.        
        
        
        if(board[row][col] == null){
            board[row][col] = new Piece(Player.GetCurrentPlayer(), type);
        
        }
        
    }
    

    public static void Draw(Graphics2D g) {
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;

//Draw the grid.        
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
        
//Draw the pieces on the board.        
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)        
            {
                if (board[zrow][zcol] != null)
                    board[zrow][zcol].draw(g, zrow, zcol,xdelta, ydelta);
                if (selectedPiece != null){
                    selectedPiece.draw(g, selectedPieceRow, selectedPieceCol,xdelta, ydelta);
                }
                    
            }
        }        
        
    }
    
    
}