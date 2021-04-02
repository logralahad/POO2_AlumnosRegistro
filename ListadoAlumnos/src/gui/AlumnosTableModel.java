/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controlador.*;
import model.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author logra
 */
public class AlumnosTableModel extends AbstractTableModel{
    
    private Controller oControl;

    public AlumnosTableModel(Controller oC) {
        oControl = oC;
    }

    @Override
    public int getRowCount() {
        return oControl.cantidadAlumnos();
    }

    @Override
    public int getColumnCount() {
        return oControl.camposAlumnos();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno alumno = oControl.getAlumno(rowIndex);
        switch (columnIndex) {
            case 0:
                return alumno.getNoControl();
                
            case 1:
                return alumno.getNombre();
                
            case 2:
                return alumno.getPaterno();
                
            case 3:
                return alumno.getMaterno();
                
            case 4:
                return alumno.getCalificacion();
                
            case 5:
                return alumno.getCarrera();
                
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No. Control";
                
            case 1:
                return "Nombre";
                
            case 2:
                return "Apellido paterno";
                
            case 3:
                return "Apellido Materno";
                
            case 4:
                return "Calificacion";
                
            case 5:
                return "Carrera";
                
            default:
                throw new AssertionError();
        }
    }
    
}
