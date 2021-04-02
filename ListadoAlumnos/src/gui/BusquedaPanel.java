/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author logra
 */
public class BusquedaPanel extends JPanel{
    
    private JButton btnBuscar;
    private JButton btnEditar;
    private JButton btnBorrar;
    private JPanel pnlLateral;
    private BusquedaTextoPanel pnlBuscar;
    private BusquedaPanelListener listener;
    
    public BusquedaPanel(){
        super.setLayout(new BorderLayout());

        pnlBuscar = new BusquedaTextoPanel("Buscar: ");
        btnBuscar = new IconoBoton("resources/search.png");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.searchButtonClick();
            }
        });
        
        btnEditar = new IconoTextBoton("Editar alumno", "resources/edit.png", 13);
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.editButtonClick();
            }
        });
        
        btnBorrar = new IconoTextBoton("Borrar alumno","resources/delete.png", 13);
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                listener.deleteButtonClick();
            }
        });
        
        pnlLateral = new JPanel();
        pnlLateral.add(btnEditar);
        pnlLateral.add(btnBorrar);
        
        
        
        pnlBuscar.add(btnBuscar);
        super.add(pnlBuscar, BorderLayout.WEST);
        super.add(pnlLateral, BorderLayout.EAST);
    }

    public void setListener(BusquedaPanelListener listener) {
        this.listener = listener;
    }
    
    public String getBusqueda(){
        return pnlBuscar.getTexto();
    }
}
