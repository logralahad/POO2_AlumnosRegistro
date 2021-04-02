/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controlador.*;
import excepciones.*;
import model.*;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author logra
 */
public class PrincipalFrame extends JFrame{

    /**
     * @param args the command line arguments
     */
    private Controller oController;
    private JTable tblAlumnos;
    private BusquedaPanel pnlBusqueda;
    private TableRowSorter trsAlumnos;
    private JMenuBar mbBarra;
    private AlumnoMenu mmAlumnos;
    private AyudaMenu mmAyuda;
    private CrearAlumnoDialog dlgCrearAlumno;
    
    public PrincipalFrame(){
        super("Control Escolar");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(800, 500);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);
        
        try {
            oController = new Controller();
        } catch (CargarArchivoException ex) {
            JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArchivoInvalidoException ex) {
            JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        tblAlumnos = new JTable(new AlumnosTableModel(oController));
        trsAlumnos = new TableRowSorter<TableModel>(tblAlumnos.getModel());
        tblAlumnos.setRowSorter(trsAlumnos);
        
        mbBarra = makeMenuBar();

        pnlBusqueda = new BusquedaPanel();
        pnlBusqueda.setListener(new BusquedaPanelListener() {
            @Override
            public void searchButtonClick() {
                try {
                    Alumno resultado = oController.search(pnlBusqueda.getBusqueda());
                    Integer indice = oController.getAlumnos().indexOf(resultado);
                    tblAlumnos.setRowSelectionInterval(indice, indice);
                } 
                catch (AlumnoInexistenteException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (BusquedaVaciaException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            @Override
            public void editButtonClick() {
                try {
                    Alumno resultado = oController.search(pnlBusqueda.getBusqueda());
                    Integer indice = oController.getAlumnos().indexOf(resultado);
                    EditarAlumnoDialog dlgEditar = new EditarAlumnoDialog(PrincipalFrame.this, oController, indice);
                    mmAlumnos.fireMenuChanges(oController);
                    dlgEditar.setVisible(true);
                    tblAlumnos.setModel(new AlumnosTableModel(oController));
                } 
                catch (AlumnoInexistenteException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (BusquedaVaciaException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                } 
            }
            
            @Override 
            public void deleteButtonClick() {
                try {
                    Alumno resultado = oController.search(pnlBusqueda.getBusqueda());
                    oController.remove(resultado);
                    tblAlumnos.setModel(new AlumnosTableModel(oController));
                    mmAlumnos.fireMenuChanges(oController);
                } 
                catch (AlumnoInexistenteException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (BusquedaVaciaException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (ListaVaciaException ex) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this, ex.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }                 
            }
        });
        
        super.add(new JScrollPane(tblAlumnos), BorderLayout.CENTER);
        super.add(mbBarra, BorderLayout.NORTH);
        super.add(pnlBusqueda, BorderLayout.SOUTH);
        super.setVisible(true);
    }
    
    private JMenuBar makeMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        
        mmAlumnos = new AlumnoMenu(this, oController, tblAlumnos);
        mmAyuda = new AyudaMenu(this);
        
        menuBar.add(mmAlumnos);
        menuBar.add(mmAyuda);
        return menuBar;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalFrame();
            }
        });
    }
    
}
