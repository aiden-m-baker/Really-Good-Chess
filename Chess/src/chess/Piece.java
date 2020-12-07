/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.*;

public class Piece {
    private Type type;
    private enum Type {PAWN,BISHOP,KNIGHT,ROOK,QUEEN,KING};   
    private Player player;
    
    Piece(Player _player)
    {
        player = _player;
    }
    public Player getPlayer()
    {
        return (player);
    }

    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) {
        g.setColor(Color.black);
        if(player == Player.getPlayer1())
            g.drawOval(Window.getX(column*xdelta+(xdelta/8)), Window.getY(row*ydelta+(ydelta/8)), 3*xdelta/4, 3*ydelta/4);
        else
            g.fillOval(Window.getX(column*xdelta+(xdelta/8)), Window.getY(row*ydelta+(ydelta/8)), 3*xdelta/4, 3*ydelta/4);
    }
    
}