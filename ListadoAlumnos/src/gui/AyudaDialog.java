/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author logra
 */
public class AyudaDialog extends JDialog{
    
    private JLabel lblAyuda;
    private JPanel pnlInfo;
    
    public AyudaDialog(JFrame parent){
        super(parent, true);
        super.setTitle("Acerca de");
        super.setSize(300, 200);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        
        lblAyuda = logoLabel();
        pnlInfo = panelInfo();
        
        super.add(lblAyuda);
        super.add(pnlInfo, BorderLayout.SOUTH);
    }
    
    private JPanel panelInfo(){
        JPanel panel = new JPanel();     
        panel.add(new JLabel("Proyecto: Registros de alumnos."));
        
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Rafael Antonio Lopez Garcia"));
        
        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("© 2021 - Oaxaca"));
        
        JPanel conjunto = new JPanel();
        conjunto.setLayout(new BoxLayout(conjunto, BoxLayout.PAGE_AXIS));
        conjunto.add(panel);
        conjunto.add(panel2);
        conjunto.add(panel3);
        
        return conjunto;
    }
    
    private JLabel logoLabel(){
        ImageIcon temp = new ImageIcon("resources/ulsalogo.png");
        Image imgBoton = temp.getImage().getScaledInstance(250, 90, Image.SCALE_SMOOTH);
        
        JLabel lbl = new JLabel(new ImageIcon(imgBoton));
        lbl.setBackground(Color.WHITE);

        return lbl;
    }
}
