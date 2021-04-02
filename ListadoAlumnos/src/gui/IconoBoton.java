/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;



/**
 *
 * @author logra
 */
public class IconoBoton extends JButton{
    
    private Image imgBoton;
    private ImageIcon icnBoton;

    public IconoBoton(String direccion) {
        ImageIcon temp = new ImageIcon(direccion);
        imgBoton = temp.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        
        icnBoton = new ImageIcon(imgBoton);
        super.setIcon(icnBoton);
    }
    
}
