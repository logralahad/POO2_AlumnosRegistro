/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import excepciones.CampoVacioException;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author logra
 */
public class CrearAlumnoDialogTextPanel extends JPanel{
    
    private JLabel lblNombre;
    private JTextField edtNombre;

    public CrearAlumnoDialogTextPanel(String texto) {
        super.setLayout(new BorderLayout());
        
        lblNombre = new JLabel(texto);
        edtNombre = new JTextField(15);
        
        super.add(lblNombre);
        super.add(edtNombre, BorderLayout.EAST);
    }

    public void clear(){
        this.edtNombre.setText("");
    }
    
    public String getTexto() throws CampoVacioException{
        if(!this.edtNombre.getText().isEmpty()){
            return this.edtNombre.getText(); 
        }else{
            this.edtNombre.requestFocus();
            throw new CampoVacioException("Debe rellenar el campo");
        } 
    }
    
    public void setTexto(String mensaje) {
        this.edtNombre.setText(mensaje);
    }
}
