/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import model.*;
import controlador.*;
import excepciones.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;



/**
 *
 * @author logra
 */
public class EliminarAlumnoDialog extends JDialog{
    
    private JPanel pnlCampos;
    private JPanel pnlAlumnos;
    private JLabel imgAlumno;
    private JComboBox carrera;
    private Controller oController;
    private BotonesEliminarPanel pnlBotones;
    private JComboBox noControl;
    private CrearAlumnoDialogTextPanel nombre;
    private CrearAlumnoDialogTextPanel paterno;
    private CrearAlumnoDialogTextPanel materno;
    private CrearAlumnoDialogTextPanel calificacion;
    
    public EliminarAlumnoDialog(JFrame parent, Controller oC, Integer idx){
        super(parent, true);
        super.setTitle("Eliminar alumno");
        super.setSize(500, 300);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        
        oController = oC;
        imgAlumno = logoLabel();
        pnlAlumnos = comboPanelAlumnos(idx);
        editarAlumno(idx);

        pnlBotones = new BotonesEliminarPanel();
        pnlBotones.setListener(new BotonesEliminarPanelListener() {
            @Override
            public void eliminarButtonClick() {
                try {
                    Alumno alumno = oController.getAlumno(noControl.getSelectedIndex());
                    oController.remove(alumno);
                    fireComboBoxChange(oController);
                    dispose();
                }
                catch (AlumnoInexistenteException ex) {
                    JOptionPane.showMessageDialog(EliminarAlumnoDialog.this, ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                } 
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(EliminarAlumnoDialog.this, "No hay alumnos que borrar.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void cancelarButtonClick() {
                dispose();
            }
        }); 
        
        
        super.add(pnlCampos, BorderLayout.EAST);
        super.add(pnlBotones, BorderLayout.SOUTH);
        super.add(imgAlumno);
    }

    private void editarAlumno(Integer idx){
        pnlCampos = new JPanel();
        pnlCampos.setLayout(new BoxLayout(pnlCampos, BoxLayout.PAGE_AXIS));

        nombre = new CrearAlumnoDialogTextPanel("Nombre: ");
        paterno = new CrearAlumnoDialogTextPanel("Apellido Paterno: ");
        materno = new CrearAlumnoDialogTextPanel("Apellido materno: ");
        calificacion = new CrearAlumnoDialogTextPanel("Calificacion: ");
        JPanel cmbCarrera = comboPanelCarreras(Carrera.SISTEMAS); 
        
        if(oController.cantidadAlumnos() != 0){
            Alumno alumno = oController.getAlumno(idx);
            nombre.setTexto(alumno.getNombre());
            paterno.setTexto(alumno.getPaterno());
            materno.setTexto(alumno.getMaterno());
            calificacion.setTexto(String.valueOf(alumno.getCalificacion()));
            cmbCarrera = comboPanelCarreras(alumno.getCarrera()); 
        }

        pnlCampos.add(pnlAlumnos);
        pnlCampos.add(nombre);
        pnlCampos.add(paterno);
        pnlCampos.add(materno);
        pnlCampos.add(calificacion);
        pnlCampos.add(cmbCarrera);
    }

    private JPanel comboPanelAlumnos(Integer idx){
        JPanel combo = new JPanel();
        combo.setLayout(new BorderLayout());

        JLabel opciones = new JLabel("No. Control: ");
        ArrayList<Alumno> temp = oController.getAlumnos();
        
        String[] nombres = new String[oController.cantidadAlumnos()];
        for (int i = 0; i < oController.cantidadAlumnos(); i++) {
            nombres[i] = oController.getAlumno(i).getNoControl();
        }
        if(nombres.length != 0){
            noControl = new JComboBox(nombres);
            noControl.setSelectedIndex(idx);
        }else{
            noControl = new JComboBox();
        }
        
        noControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Alumno alumno = oController.getAlumno(noControl.getSelectedIndex());
                nombre.setTexto(alumno.getNombre());
                paterno.setTexto(alumno.getPaterno());
                materno.setTexto(alumno.getMaterno());
                calificacion.setTexto(String.valueOf(alumno.getCalificacion()));
                carrera.setSelectedItem(alumno.getCarrera());
            }
        }); 

        combo.add(opciones);
        combo.add(noControl, BorderLayout.EAST);
        return combo;
    }
    
    private JPanel comboPanelCarreras(Carrera licenciatura){
        JPanel combo = new JPanel();
        combo.setLayout(new BorderLayout());
        
        JLabel opciones = new JLabel("Carrera: ");
        carrera = new JComboBox(Carrera.values());
        carrera.setSelectedItem(licenciatura);
        
        combo.add(opciones);
        combo.add(carrera, BorderLayout.EAST);
        return combo;
    }
    
    private JLabel logoLabel(){
        ImageIcon temp = new ImageIcon("resources/alumno.png");
        Image imgBoton = temp.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        
        JLabel lbl = new JLabel(new ImageIcon(imgBoton));
        lbl.setBackground(Color.WHITE);

        return lbl;
    }
    
    public void fireComboBoxChange(Controller oC){
        oController = oC;        
        pnlAlumnos = comboPanelAlumnos(0);
        pnlCampos.remove(0);
        pnlCampos.add(pnlAlumnos, 0);
        revalidate();
    }
    
    public AlumnosTableModel obtenerModelo(){
        return new AlumnosTableModel(oController);
    }
    
}
