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
    
    Pawn (Player _player){
        super(_player, Type.PAWN);
        player = _player;
        if(player == Player.getPlayer1()){
            image = Toolkit.getDefaultToolkit().getImage("./whitepawn.png");
        } else {
            image = Toolkit.getDefaultToolkit().getImage("./blackpawn.png");
        }
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
    
}
