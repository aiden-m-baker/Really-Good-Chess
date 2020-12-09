package chess;

import java.awt.*;

public class Piece
{
    private Type type;
    public static enum Type {PAWN,BISHOP,KNIGHT,ROOK,QUEEN,KING};   
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

    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) {
        g.setColor(Color.black);
        if(player == Player.getPlayer1())
            g.drawOval(Window.getX(column*xdelta+(xdelta/8)), Window.getY(row*ydelta+(ydelta/8)), 3*xdelta/4, 3*ydelta/4);
        else if(player == Player.getPlayer2())
            g.fillOval(Window.getX(column*xdelta+(xdelta/8)), Window.getY(row*ydelta+(ydelta/8)), 3*xdelta/4, 3*ydelta/4);
    // Circle pog
    // yes Aiden, circle pog indeed
    }
}
