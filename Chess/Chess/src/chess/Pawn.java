/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Aiden Baker
 */
public class Pawn extends Piece {
    
    private Player player;
    private Image image;
    private boolean startMove;
    
    Pawn (Player _player, int _row, int _column){
        super(_player, Type.PAWN, _row, _column);
        player = _player;
        if(player == Player.getPlayer1()){
            image = Toolkit.getDefaultToolkit().getImage("./whitepawn.png");
        } else {
            image = Toolkit.getDefaultToolkit().getImage("./blackpawn.png");
        }
        startMove = true;
    }
    
    public void draw(Graphics2D g, int row, int column, int xdelta, int ydelta){
//        g.setColor(Color.black);
//        int x[] = {Window.getX((column*xdelta)+xdelta/2), Window.getX((column*xdelta)+3*xdelta/4), Window.getX((column*xdelta)+xdelta),Window.getX(column*xdelta), Window.getX((column*xdelta)+xdelta/4)};
//        int y[] = {Window.getY(row*ydelta), Window.getY((row*ydelta)+3*ydelta/4),Window.getY((row*ydelta)+ydelta), Window.getY((row*ydelta)+ydelta), Window.getY((row*ydelta)+3*ydelta/4)};

//        if(player == Player.getPlayer1())
//            g.drawPolygon(x, y, 5);
//        else
//            g.fillPolygon(x, y, 5);
        
        Draw.drawImage(image, Window.getX((xdelta*column)+xdelta/2), Window.getY((ydelta*row)+ydelta/2), 0, 1, 1);
        
    }
    
    public boolean move(int sRow, int sColumn, Piece selectedPiece){
        int numRows = Board.getNumRows();
        int numColumns = Board.getNumColumns();
        Piece board[][] = Board.getBoard();
        //Used to move the pawn forwards. Inversed as rows are counted top to bottom.
        int moveNum = -1;
        if((sRow < numRows && sRow >= 0) && (sColumn < numColumns && sColumn >= 0)){
            if(selectedPiece.getPlayer() == Player.getPlayer2()){
                moveNum = 1;
            }
            if(row+moveNum > numRows || row+moveNum < 0){
                return (false);
            }
            if(startMove == true){
                if((board[row+moveNum][column] == null) && (row+moveNum == sRow || row+(moveNum*2) == sRow) && sColumn == column){
                    startMove = false;
                    return(true);
                } else if(board[row+moveNum][column] != null){
                    return(false);
                } else if(board[sRow][sColumn] != null){
                    if(sColumn == column){
                        return (false);
                    } 
                    if(board[row+moveNum][column+1] != null){
                        if(board[row+moveNum][column+1].getPlayer() != selectedPiece.getPlayer() && (row+moveNum == sRow && column+1 == sColumn)){
                            return(true);
                        }
                    } else if(board[row+moveNum][column-1] != null){
                        if(board[row+moveNum][column-1].getPlayer() != selectedPiece.getPlayer() && (row+moveNum == sRow && column-1 == sColumn)){
                            return(true);
                        }
                    }
                }
            } else {
                if(board[row+moveNum][column] == null && row+moveNum == sRow && sColumn == column){
                    return(true);
                } else if(board[sRow][sColumn] != null){
                    
                    if(board[row+moveNum][column+1] != null && (row+moveNum == sRow && column+1 == sColumn)){
                        if(board[row+moveNum][column+1].getPlayer() != selectedPiece.getPlayer()){
                            return(true);
                        }
                    } else if(board[row+moveNum][column-1] != null && (row+moveNum == sRow && column-1 == sColumn)){
                        if(board[row+moveNum][column-1].getPlayer() != selectedPiece.getPlayer()){
                            return(true);
                        }
                    }
                }
                
//                if(row+moveNum == numRows-1 || row+moveNum == 0){
//                    //Insert promotion code here pog
//                    return(true);
//                }
                
            }
        }
        return (false);
    }
    
}
