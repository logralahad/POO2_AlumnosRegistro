/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controlador.*;
import excepciones.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author logra
 */
public class AlumnoMenu extends JMenu{
    
    
    private JFrame parent;
    private JMenuItem miAlumnos;
    private JMenuItem miEditar;
    private JMenuItem miEliminar;
    private JMenuItem miSalir;
    private JMenuItem miGuardar;
    private CrearAlumnoDialog dlgAlumno;
    private EditarAlumnoDialog dlgEditar;
    private EliminarAlumnoDialog dlgEliminar;
    
    public AlumnoMenu(JFrame parent, Controller oC, JTable alumnos){
        super("Alumnos");
        
        this.parent = parent;
        dlgAlumno = new CrearAlumnoDialog(parent, oC);
        dlgAlumno.setListener(new CrearAlumnoDialogListener() {
            @Override
            public void actualizarTabla(AlumnosTableModel model) {
                alumnos.setModel(model);
            }
        });
        
        dlgEditar = new EditarAlumnoDialog(parent, oC, 0); 
        dlgEliminar = new EliminarAlumnoDialog(parent, oC, 0);
        
        miAlumnos = new JMenuItem("Crear");
        miAlumnos.setMnemonic(KeyEvent.VK_N);
        miAlumnos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        miAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dlgAlumno.setVisible(true);
                fireMenuChanges(oC);
            }
        });
        
        miEditar = new JMenuItem("Editar");
        miEditar.setMnemonic(KeyEvent.VK_O);
        miEditar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        miEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dlgEditar.setVisible(true);
                alumnos.setModel(dlgEditar.obtenerModelo());
                fireMenuChanges(oC);
            }
        });
        
        miEliminar = new JMenuItem("Eliminar");
        miEliminar.setMnemonic(KeyEvent.VK_E);
        miEliminar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        miEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dlgEliminar.setVisible(true);
                alumnos.setModel(dlgEliminar.obtenerModelo());
                fireMenuChanges(oC);
            }
        });
        
        miSalir = new JMenuItem("Salir");
        miSalir.setMnemonic(KeyEvent.VK_X);
        miSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        miSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        }); 
        
        miGuardar = new JMenuItem("Guardar");
        miGuardar.setMnemonic(KeyEvent.VK_S);
        miGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        miGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    oC.save();
                } catch (GuardarArchivoException ex) {
                    JOptionPane.showMessageDialog(parent, ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        super.add(miAlumnos);
        super.add(miEditar);
        super.add(miEliminar);
        super.addSeparator();
        super.add(miGuardar);
        super.addSeparator();
        super.add(miSalir);        
    }
    
    public void fireMenuChanges(Controller oC){
        dlgEliminar.fireComboBoxChange(oC);
        dlgEliminar = new EliminarAlumnoDialog(parent, oC, 0);
        
        dlgEditar.fireComboBoxChange(oC);
        dlgEditar = new EditarAlumnoDialog(parent, oC, 0);
    }
}
