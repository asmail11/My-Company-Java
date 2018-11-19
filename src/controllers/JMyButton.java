/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author drmas
 */
public class JMyButton extends JButton {
 
      public JMyButton(){
        setOpaque(false); 
        setContentAreaFilled(false);
        setForeground(Color.white);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(new Color(63, 127, 191));
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
     
        super.paintComponent(g);
    } 
    @Override
    protected void paintBorder(Graphics g){
        g.setColor(Color.BLUE);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    }
}
