/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author logra
 */
public class BusquedaTextoPanel extends JPanel{
    
    private JLabel lblNombre;
    private JTextField edtNombre;

    public BusquedaTextoPanel(String texto) {
        super.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        lblNombre = new JLabel(texto);
        lblNombre.setFont(new Font("Lucila Grande", Font.BOLD, 18));
        
        edtNombre = new JTextField(15);    
        
        super.add(lblNombre);
        super.add(edtNombre);
    }

    public void clear(){
        this.edtNombre.setText("");
    }
    
    public String getTexto(){
        return this.edtNombre.getText(); 
    }
    
    public void setTexto(String mensaje) {
        this.edtNombre.setText(mensaje);
    }
}
