/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author logra
 */
public class BotonesEliminarPanel extends JPanel{
    
    private JButton btnEliminar;
    private JButton btnCancelar;
    private BotonesEliminarPanelListener listener;
    private JPanel panel1;
    private JPanel panel2;
    
    public BotonesEliminarPanel(){
        super.setLayout(new BorderLayout());
        
        panel1 = new JPanel();        
        panel2 = new JPanel();
        
        btnEliminar = new IconoTextBoton("Eliminar", "resources/delete.png", 15);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.eliminarButtonClick();
            }
        });
        panel1.add(btnEliminar);
        
        btnCancelar = new IconoTextBoton("Cancelar", "resources/cancel.png", 15);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.cancelarButtonClick();;
            }
        });
        panel2.add(btnCancelar);
        
        super.add(panel1, BorderLayout.EAST);
        super.add(panel2, BorderLayout.WEST);
        
    }

    public void setListener(BotonesEliminarPanelListener listener) {
        this.listener = listener;
    }
}
