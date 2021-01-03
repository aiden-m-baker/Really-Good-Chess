/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Aiden Baker
 */
public class Knight extends Piece {
    
    private Player player;
    
    private Image image;
    
    Knight(Player _player, int _row, int _column){
        super(_player, Type.KNIGHT, _row, _column);
        player = _player;
        if(player == Player.getPlayer1()){
            image = Toolkit.getDefaultToolkit().getImage("./whiteknight.png");
        } else {
            image = Toolkit.getDefaultToolkit().getImage("./blackknight.png");
        }
    }
    
    public void draw(Graphics2D g, int row, int column, int xdelta, int ydelta){
        g.setColor(Color.black);
        
        Draw.drawImage(image, Window.getX((xdelta*column)+xdelta/2), Window.getY((ydelta*row)+ydelta/2), 0, 1, 1);
        
//        int x[] = {Window.getX((column*xdelta)+0)};
//        int y[] = {Window.getY((row*ydelta)+0)};
//        
//        g.drawPolygon(x, y, 7);
    }
    
    public boolean move(int sRow, int sColumn){
        int numRows = Board.getNumRows();
        int numColumns = Board.getNumColumns();
        Piece board[][] = Board.getBoard();
        if((sRow < numRows && sRow >= 0) && (sColumn < numColumns && sColumn >= 0)){
            if(sRow > row && sColumn > column){
                
                if((row+2 >= 0 && row+2 < numRows && column+1 >= 0 && column+1 < numColumns) && (row+2 == sRow && column+1 == sColumn)){
                    if(board[sRow][sColumn] == null){
                        return (true);
                    } else if(board[sRow][sColumn].getPlayer() != board[row][column].getPlayer()) {
                        return(true);
                    }
                } else if((row+1 >= 0 && row+1 < numRows && column+2 >= 0 && column+2 < numColumns) && (row+1 == sRow && column+2 == sColumn)) {
                    if(board[sRow][sColumn] == null){
                        return (true);
                    } else if(board[sRow][sColumn].getPlayer() != board[row][column].getPlayer()) {
                        return(true);
                    }
                }
            } else if(sRow < row && sColumn > column){
                
                if((row-2 >= 0 && row-2 < numRows && column+1 >= 0 && column+1 < numColumns) && (row-2 == sRow && column+1 == sColumn)){
                    if(board[sRow][sColumn] == null){
                        return (true);
                    } else if(board[sRow][sColumn].getPlayer() != board[row][column].getPlayer()) {
                        return(true);
                    }
                } else if((row-1 >= 0 && row-1 < numRows && column+2 >= 0 && column+2 < numColumns) && (row-1 == sRow && column+2 == sColumn)) {
                    if(board[sRow][sColumn] == null){
                        return (true);
                    } else if(board[sRow][sColumn].getPlayer() != board[row][column].getPlayer()) {
                        return(true);
                    }
                }
            } else if(sRow > row && sColumn < column){
                
                if((row+2 >= 0 && row+2 < numRows && column-1 >= 0 && column-1 < numColumns) && (row+2 == sRow && column-1 == sColumn)){
                    if(board[sRow][sColumn] == null){
                        return (true);
                    } else if(board[sRow][sColumn].getPlayer() != board[row][column].getPlayer()) {
                        return(true);
                    }
                } else if((row+1 >= 0 && row+1 < numRows && column-2 >= 0 && column-2 < numColumns) && (row+1 == sRow && column-2 == sColumn)) {
                    if(board[sRow][sColumn] == null){
                        return (true);
                    } else if(board[sRow][sColumn].getPlayer() != board[row][column].getPlayer()) {
                        return(true);
                    }
                }
            } else if(sRow < row && sColumn < column){
                
                if((row-2 >= 0 && row-2 < numRows && column-1 >= 0 && column-1 < numColumns) && (row-2 == sRow && column-1 == sColumn)){
                    if(board[sRow][sColumn] == null){
                        return (true);
                    } else if(board[sRow][sColumn].getPlayer() != board[row][column].getPlayer()) {
                        return(true);
                    }
                } else if((row-1 >= 0 && row-1 < numRows && column-2 >= 0 && column-2 < numColumns) && (row-1 == sRow && column-2 == sColumn)) {
                    if(board[sRow][sColumn] == null){
                        return (true);
                    } else if(board[sRow][sColumn].getPlayer() != board[row][column].getPlayer()) {
                        return(true);
                    }
                }
            }
            
        }
        
        return(false);
    }
    
}
