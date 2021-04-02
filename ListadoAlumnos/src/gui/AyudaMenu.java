/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author logra
 */
public class AyudaMenu extends JMenu{
    
    private JMenuItem miAcerca;
    private AyudaDialog dlgAyudaDialog;
    
    public AyudaMenu(JFrame parent){
        super("Ayuda");
        
        dlgAyudaDialog = new AyudaDialog(parent);
        
        miAcerca = new JMenuItem("Acerca de...");
        miAcerca.setMnemonic(KeyEvent.VK_F1);
        miAcerca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        miAcerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dlgAyudaDialog.setVisible(true);
            }
        }); 
        
        super.add(miAcerca);
    }
    
}
