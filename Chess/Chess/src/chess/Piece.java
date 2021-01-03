/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.*;

public class Piece {
    private Type type;
    public static enum Type {PAWN,BISHOP,KNIGHT,ROOK,QUEEN,KING}; 
    //Pawn double move, promote, En Passant, and Castle
    private Player player;
    //private boolean validMovement;
    int row;
    int column;
    
    Piece(Player _player, Type _type, int _row, int _column)
    {
        player = _player;
        type = _type;
        row = _row;
        column = _column;
        //validMovement = false;
    }
    Piece()
    {
        
    }
    
    public Player getPlayer()
    {
        return (player);
    }
    
    public Type getType(){
        return (type);
    }
    
    public int getRow(){
        return(row);
    }
    public int getColumn(){
        return(column);
    }
    
    
    public static boolean Move(Piece selectedPiece, int sRow, int sCol){
        Piece board[][] = Board.getBoard();
        if((board[sRow][sCol] == null) || (board[sRow][sCol].player != selectedPiece.player)){
            if(selectedPiece.type == Type.PAWN){
                if(((Pawn)selectedPiece).move(sRow, sCol, selectedPiece)){
                    selectedPiece.row = sRow;
                    selectedPiece.column = sCol;
                    return(true);
                }
            } 
            if(selectedPiece.type == Type.BISHOP){
                if(((Bishop)selectedPiece).move(sRow, sCol, selectedPiece)){
                    selectedPiece.row = sRow;
                    selectedPiece.column = sCol;
                    return(true);
                }
            } 
            if(selectedPiece.type == Type.ROOK){
                if(((Rook)selectedPiece).move(sRow, sCol, selectedPiece)){
                    selectedPiece.row = sRow;
                    selectedPiece.column = sCol;
                    return(true);
                }
            } 
            if(selectedPiece.type == Type.KNIGHT){
                if(((Knight)selectedPiece).move(sRow, sCol)){
                    selectedPiece.row = sRow;
                    selectedPiece.column = sCol;
                    return(true);
                }
            } 
            if(selectedPiece.type == Type.QUEEN){
                if(((Queen)selectedPiece).move(sRow, sCol, selectedPiece)){
                    selectedPiece.row = sRow;
                    selectedPiece.column = sCol;
                    return(true);
                }
            } 
            if(selectedPiece.type == Type.KING){
                if(((King)selectedPiece).move(sRow, sCol, selectedPiece)){
                    selectedPiece.row = sRow;
                    selectedPiece.column = sCol;
                    return(true);
                }
            }
        }
        return(false);
    }
    /*
    public void validMovementTrue(){
        validMovement = true;
    }
    public void validMovementFalse(){
        validMovement = false;
    }
    public boolean getValidMovement(){
        return(validMovement);
    }
    */
    
/*
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) {
        g.setColor(Color.black);
        if(player == Player.getPlayer1()){
            if(type == Type.PAWN){
                Pawn.Draw(g, row, column, xdelta, ydelta);
            }
            else if(type == Type.BISHOP){
                Bishop.Draw(g, row, column, xdelta, ydelta);
            } else 
                g.drawOval(Window.getX(column*xdelta+(xdelta/8)), Window.getY(row*ydelta+(ydelta/8)), 3*xdelta/4, 3*ydelta/4);
        }
        else if(player == Player.getPlayer2()){
            if(type == Type.PAWN){
                Pawn.Fill(g, row, column, xdelta, ydelta);
            }
            else if(type == Type.BISHOP){
                Bishop.Fill(g, row, column, xdelta, ydelta);
            } else 
                g.fillOval(Window.getX(column*xdelta+(xdelta/8)), Window.getY(row*ydelta+(ydelta/8)), 3*xdelta/4, 3*ydelta/4);
        }
            //g.fillOval(Window.getX(column*xdelta+(xdelta/8)), Window.getY(row*ydelta+(ydelta/8)), 3*xdelta/4, 3*ydelta/4);
    // Circle pog
        
    }
    */
}