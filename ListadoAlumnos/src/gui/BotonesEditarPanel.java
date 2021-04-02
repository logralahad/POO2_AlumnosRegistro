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
public class BotonesEditarPanel extends JPanel{
    
    private JButton btnCrear;
    private JButton btnCancelar;
    private BotonesEditarPanelListener listener;
    private JPanel panel1;
    private JPanel panel2;
    
    public BotonesEditarPanel(){
        super.setLayout(new BorderLayout());
        
        panel1 = new JPanel();        
        panel2 = new JPanel();
        
        btnCrear = new IconoTextBoton("Guardar", "resources/check.png", 15);
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.guardarButtonClick();
            }
        });
        panel1.add(btnCrear);
        
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

    public void setListener(BotonesEditarPanelListener listener) {
        this.listener = listener;
    }
}
