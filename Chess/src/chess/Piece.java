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
    
    Piece(Player _player, Type _type)
    {
        player = _player;
        type = _type;
        
    }
    
    public Player getPlayer()
    {
        return (player);
    }
    
    public Type getType(){
        return (type);
    }
    
    public void drawR(Graphics2D g,int row,int column,int xdelta,int ydelta) {
        
    }
    
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