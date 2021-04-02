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
import javax.swing.*;



/**
 *
 * @author logra
 */
public class CrearAlumnoDialog extends JDialog{
    
    private JPanel pnlCampos;
    private JLabel imgAlumno;
    private JComboBox carrera;
    private Controller oController;
    private CrearAlumnoDialogListener listener;
    private BotonesCrearPanel pnlBotones;
    private CrearAlumnoDialogTextPanel noControl;
    private CrearAlumnoDialogTextPanel nombre;
    private CrearAlumnoDialogTextPanel paterno;
    private CrearAlumnoDialogTextPanel materno;
    private CrearAlumnoDialogTextPanel calificacion;
    
    public CrearAlumnoDialog(JFrame parent, Controller oC){
        super(parent, true);
        super.setTitle("Crear nuevo alumno");
        super.setSize(500, 300);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());
        
        oController = oC;
        imgAlumno = logoLabel();
        pnlCampos = crearAlumno();
        
        pnlBotones = new BotonesCrearPanel();
        pnlBotones.setListener(new BotonesCrearPanelListener() {
            @Override
            public void crearButtonClick() {
                try {
                    Carrera licenciatura = (Carrera)carrera.getSelectedItem();
                    Alumno alumno = new Alumno(noControl.getTexto(), nombre.getTexto(), paterno.getTexto(),
                        materno.getTexto(), Double.parseDouble(calificacion.getTexto()), licenciatura); 
                    oController.add(alumno);
                    listener.actualizarTabla(new AlumnosTableModel(oController));
                    clear();
                    JOptionPane.showMessageDialog(CrearAlumnoDialog.this, "Se agrego el alumno", 
                            "Creacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                catch (CalificacionErroneaException ex) {
                    JOptionPane.showMessageDialog(CrearAlumnoDialog.this, ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (AlumnoExistenteException ex) {
                    JOptionPane.showMessageDialog(CrearAlumnoDialog.this, ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (NombreErroneoException ex) {
                    JOptionPane.showMessageDialog(CrearAlumnoDialog.this, ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (CampoVacioException ex) {
                    JOptionPane.showMessageDialog(CrearAlumnoDialog.this, ex.getMessage(), 
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void limpiarButtonClick() {
                clear();
            }

            @Override
            public void salirButtonClick() {
                setVisible(false);
            }
        }); 
        
        super.add(pnlCampos, BorderLayout.EAST);
        super.add(pnlBotones, BorderLayout.SOUTH);
        super.add(imgAlumno);
    }

    private void clear(){
        noControl.clear();
        nombre.clear();
        paterno.clear();
        materno.clear();
        calificacion.clear();
        carrera.setSelectedIndex(0);
    }

    private JPanel crearAlumno(){
        JPanel conjunto = new JPanel();
        conjunto.setLayout(new BoxLayout(conjunto, BoxLayout.PAGE_AXIS));
        
        noControl = new CrearAlumnoDialogTextPanel("Num. de control: ");
        nombre = new CrearAlumnoDialogTextPanel("Nombre: ");
        paterno = new CrearAlumnoDialogTextPanel("Apellido Paterno: ");
        materno = new CrearAlumnoDialogTextPanel("Apellido materno: ");
        calificacion = new CrearAlumnoDialogTextPanel("Calificacion: ");
        JPanel cmbCarrera = comboPanel();
        
        conjunto.add(noControl);
        conjunto.add(nombre);
        conjunto.add(paterno);
        conjunto.add(materno);
        conjunto.add(calificacion);
        conjunto.add(cmbCarrera);
        
        return conjunto;
    }
    
    private JPanel comboPanel(){
        JPanel combo = new JPanel();
        combo.setLayout(new BorderLayout());
        
        JLabel opciones = new JLabel("Carrera: ");
        carrera = new JComboBox(Carrera.values());
        
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
    
    public void setListener(CrearAlumnoDialogListener listener) {
        this.listener = listener;
    }
}
