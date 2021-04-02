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
public class BotonesCrearPanel extends JPanel{
    
    private JButton btnCrear;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private BotonesCrearPanelListener listener;
    private JPanel panel1;
    private JPanel panel2;
    
    public BotonesCrearPanel(){
        super.setLayout(new BorderLayout());
        
        panel1 = new JPanel();        
        panel2 = new JPanel();
        
        btnCrear = new IconoTextBoton("Crear alumno", "resources/check.png", 15);
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.crearButtonClick();;
            }
        });
                
        btnLimpiar = new IconoTextBoton("Limpiar", "resources/clear.png", 15);
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.limpiarButtonClick();;
            }
        });
        
        panel1.add(btnCrear);
        panel1.add(btnLimpiar);
        
        btnSalir = new IconoTextBoton("Salir", "resources/cancel.png", 15);
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.salirButtonClick();;
            }
        });
        panel2.add(btnSalir);
        
        super.add(panel1, BorderLayout.EAST);
        super.add(panel2, BorderLayout.WEST);
        
    }

    public void setListener(BotonesCrearPanelListener listener) {
        this.listener = listener;
    }
}
