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
public class Rook extends Piece {
    
    private Player player;
    
    private Image image;
    
    Rook (Player _player, int _row, int _column){
        super(_player, Type.ROOK, _row, _column);
        player = _player;
        if(player == Player.getPlayer1()){
            image = Toolkit.getDefaultToolkit().getImage("./whiterook.png");
        } else {
            image = Toolkit.getDefaultToolkit().getImage("./blackrook.png");
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
    
}
