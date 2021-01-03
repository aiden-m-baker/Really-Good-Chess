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
public class Queen extends Piece {
    
    private Player player;
    
    private Image image;
    
    Queen (Player _player, int _row, int _column){
        super(_player, Type.QUEEN, _row, _column);
        player = _player;
        if(player == Player.getPlayer1()){
            image = Toolkit.getDefaultToolkit().getImage("./whitequeen.png");
        } else {
            image = Toolkit.getDefaultToolkit().getImage("./blackqueen.png");
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
                int i = 1;
                while(row+i <= sRow && column+i <= sColumn){
                    if((row+i > numRows || row+i < 0) || (column+i > numColumns || column+i < 0)){
                        return(false);
                    }
                    
                    if(board[row+i][column+i] == null){
                        if(row+i == sRow && column+i == sColumn){
                            return(true);
                        }
                    } else if((board[row+i][column+i] != null) && (row+i != sRow && column+i != sColumn)){
                        return(false);
                    } else if(board[sRow][sColumn] != null){
                        if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row+i == sRow && column+i == sColumn)){
                            return(true);
                        }
                    }
                    
                    i++;
                }
            } else if(sRow < row && sColumn > column){
                int i = 1;
                while(row-i >= sRow && column+i <= sColumn){
                    if((row-i > numRows || row-i < 0) || (column+i > numColumns || column+i < 0)){
                        return(false);
                    }
                    
                    if(board[row-i][column+i] == null){
                        if(row-i == sRow && column+i == sColumn){
                            return(true);
                        }
                    } else if((board[row-i][column+i] != null) && (row-i != sRow && column+i != sColumn)){
                        return(false);
                    } else if(board[sRow][sColumn] != null){
                        if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row-i == sRow && column+i == sColumn)){
                            return(true);
                        }
                    }
                    
                    i++;
                }
            } else if(sRow > row && sColumn < column){
                int i = 1;
                while(row+i <= sRow && column-i >= sColumn){
                    if((row+i > numRows || row+i < 0) || (column-i > numColumns || column-i < 0)){
                        return(false);
                    }
                    
                    if(board[row+i][column-i] == null){
                        if(row+i == sRow && column-i == sColumn){
                            return(true);
                        }
                    } else if((board[row+i][column-i] != null) && (row+i != sRow && column-i != sColumn)){
                        return(false);
                    } else if(board[sRow][sColumn] != null){
                        if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row+i == sRow && column-i == sColumn)){
                            return(true);
                        }
                    }
                    
                    i++;
                }
            } else if(sRow < row && sColumn < column){
                int i = 1;
                while(row-i >= sRow && column-i >= sColumn){
                    if((row-i > numRows || row-i < 0) || (column-i > numColumns || column-i < 0)){
                        return(false);
                    }
                    
                    if(board[row-i][column-i] == null){
                        if(row-i == sRow && column-i == sColumn){
                            return(true);
                        }
                    } else if((board[row-i][column-i] != null) && (row-i != sRow && column-i != sColumn)){
                        return(false);
                    } else if(board[sRow][sColumn] != null){
                        if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row-i == sRow && column-i == sColumn)){
                            return(true);
                        }
                    }
                    
                    i++;
                }
            }
            //Add Rook movement code here uwu
            if(sRow > row){
                int i = 1;
                while(row+i <= sRow){
                    if(row+i > numRows || row+i < 0){
                        return(false);
                    }
                    
                    if(board[row+i][column] == null){
                        if(row+i == sRow && column == sColumn){
                            return(true);
                        }
                    } else if((board[row+i][column] != null) && (row+i != sRow)){
                        return(false);
                    } else if(board[sRow][sColumn] != null){
                        if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row+i == sRow && column == sColumn)){
                            return(true);
                        }
                    }
                    
                    i++;
                }
            } else if(sRow < row){
                int i = 1;
                while(row-i >= sRow){
                    if(row-i > numRows || row-i < 0){
                        return(false);
                    }
                    
                    if(board[row-i][column] == null){
                        if(row-i == sRow && column == sColumn){
                            return(true);
                        }
                    } else if((board[row-i][column] != null) && (row-i != sRow)){
                        return(false);
                    } else if(board[sRow][sColumn] != null){
                        if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row-i == sRow && column == sColumn)){
                            return(true);
                        }
                    }
                    
                    i++;
                }
            } else if(sColumn < column){
                int i = 1;
                while(column-i >= sColumn){
                    if(column-i > numColumns || column-i < 0){
                        return(false);
                    }
                    
                    if(board[row][column-i] == null){
                        if(row == sRow && column-i == sColumn){
                            return(true);
                        }
                    } else if((board[row][column-i] != null) && (column-i != sColumn)){
                        return(false);
                    } else if(board[sRow][sColumn] != null){
                        if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row == sRow && column-i == sColumn)){
                            return(true);
                        }
                    }
                    
                    i++;
                }
            } else if(sColumn > column){
                int i = 1;
                while(column+i <= sColumn){
                    if(column+i > numColumns || column+i < 0){
                        return(false);
                    }
                    
                    if(board[row][column+i] == null){
                        if(row == sRow && column+i == sColumn){
                            return(true);
                        }
                    } else if((board[row][column+i] != null) && (column+i != sColumn)){
                        return(false);
                    } else if(board[sRow][sColumn] != null){
                        if((board[sRow][sColumn].getPlayer() != selectedPiece.getPlayer()) && (row == sRow && column+i == sColumn)){
                            return(true);
                        }
                    }
                    
                    i++;
                }
            }
            
            
        }
        
        return(false);
    }
    
}
