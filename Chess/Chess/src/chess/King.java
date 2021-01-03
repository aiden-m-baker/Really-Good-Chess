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
public class King extends Piece{
    
    private Player player;
    public static enum Position {CHECK, CHECKMATE, STALEMATE}
    private Image image;
    
    King(Player _player, int _row, int _column){
        super(_player, Type.KING, _row, _column);
        player = _player;
        if(player == Player.getPlayer1()){
            image = Toolkit.getDefaultToolkit().getImage("./whiteking.png");
        } else {
            image = Toolkit.getDefaultToolkit().getImage("./blackking.png");
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
    
    public boolean move(int sRow, int sColumn, Piece selectedPiece){
        int numRows = Board.getNumRows();
        int numColumns = Board.getNumColumns();
        Piece board[][] = Board.getBoard();
        if((sRow < numRows && sRow >= 0) && (sColumn < numColumns && sColumn >= 0)){
            if(sRow > row && sColumn > column){
            
            
                if((row+1 > numRows || row+1 < 0) || (column+1 > numColumns || column+1 < 0)){
                    return(false);
                }

                if(board[row+1][column+1] == null){
                    if(row+1 == sRow && column+1 == sColumn){
                        return(true);
                    }
                } else if((board[row+1][column+1] != null) && (row+1 != sRow && column+1 != sColumn)){
                    return(false);
                } else if(board[sRow][sColumn] != null){
                    if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row+1 == sRow && column+1 == sColumn)){
                        return(true);
                    }
                }

                
            
            } else if(sRow < row && sColumn > column){
            
            
                if((row-1 > numRows || row-1 < 0) || (column+1 > numColumns || column+1 < 0)){
                    return(false);
                }

                if(board[row-1][column+1] == null){
                    if(row-1 == sRow && column+1 == sColumn){
                        return(true);
                    }
                } else if((board[row-1][column+1] != null) && (row-1 != sRow && column+1 != sColumn)){
                    return(false);
                } else if(board[sRow][sColumn] != null){
                    if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row-1 == sRow && column+1 == sColumn)){
                        return(true);
                    }
                }

                
            
            } else if(sRow > row && sColumn < column){
            
            
                if((row+1 > numRows || row+1 < 0) || (column-1 > numColumns || column-1 < 0)){
                    return(false);
                }

                if(board[row+1][column-1] == null){
                    if(row+1 == sRow && column-1 == sColumn){
                        return(true);
                    }
                } else if((board[row+1][column-1] != null) && (row+1 != sRow && column-1 != sColumn)){
                    return(false);
                } else if(board[sRow][sColumn] != null){
                    if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row+1 == sRow && column-1 == sColumn)){
                        return(true);
                    }
                }

                
            
            } else if(sRow < row && sColumn < column){
            
            
                if((row-1 > numRows || row-1 < 0) || (column-1 > numColumns || column-1 < 0)){
                    return(false);
                }

                if(board[row-1][column-1] == null){
                    if(row-1 == sRow && column-1 == sColumn){
                        return(true);
                    }
                } else if((board[row-1][column-1] != null) && (row-1 != sRow && column-1 != sColumn)){
                    return(false);
                } else if(board[sRow][sColumn] != null){
                    if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row-1 == sRow && column-1 == sColumn)){
                        return(true);
                    }
                }

                
            
            }
            //Add Rook movement code here uwu
            if(sRow > row){
            
            
                if(row+1 > numRows || row+1 < 0){
                    return(false);
                }

                if(board[row+1][column] == null){
                    if(row+1 == sRow && column == sColumn){
                        return(true);
                    }
                } else if((board[row+1][column] != null) && (row+1 != sRow)){
                    return(false);
                } else if(board[sRow][sColumn] != null){
                    if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row+1 == sRow && column == sColumn)){
                        return(true);
                    }
                }

                
            
            } else if(sRow < row){
            
            
                if(row-1 > numRows || row-1 < 0){
                    return(false);
                }

                if(board[row-1][column] == null){
                    if(row-1 == sRow && column == sColumn){
                        return(true);
                    }
                } else if((board[row-1][column] != null) && (row-1 != sRow)){
                    return(false);
                } else if(board[sRow][sColumn] != null){
                    if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row-1 == sRow && column == sColumn)){
                        return(true);
                    }
                }

                
            
            } else if(sColumn < column){
            
            
                if(column-1 > numColumns || column-1 < 0){
                    return(false);
                }

                if(board[row][column-1] == null){
                    if(row == sRow && column-1 == sColumn){
                        return(true);
                    }
                } else if((board[row][column-1] != null) && (column-1 != sColumn)){
                    return(false);
                } else if(board[sRow][sColumn] != null){
                    if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row == sRow && column-1 == sColumn)){
                        return(true);
                    }
                }

                
            
            } else if(sColumn > column){
            
            
                if(column+1 > numColumns || column+1 < 0){
                    return(false);
                }

                if(board[row][column+1] == null){
                    if(row == sRow && column+1 == sColumn){
                        return(true);
                    }
                } else if((board[row][column+1] != null) && (column+1 != sColumn)){
                    return(false);
                } else if(board[sRow][sColumn] != null){
                    if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row == sRow && column+1 == sColumn)){
                        return(true);
                    }
                }

                
            
            }
            
            
        }
        
        return(false);
    }
    
}
