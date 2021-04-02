/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import excepciones.*;
import java.io.Serializable;

/**
 *
 * @author logra
 */
public class Alumno implements Serializable{
    
    private String noControl;
    private String nombre;
    private String paterno;
    private String materno;
    private Double calificacion;
    private Carrera carrera;

    public Alumno(String noControl, String nombre, String paterno, String materno, 
        Double calificacion, Carrera carrera) throws CalificacionErroneaException, NombreErroneoException {
        this.noControl = noControl;
        setNombre(nombre);
        this.paterno = paterno;
        this.materno = materno;
        this.setCalificacion(calificacion);
        this.carrera = carrera;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Alumno){
            Alumno alumno = (Alumno)o;
            if(this.noControl.compareTo(alumno.getNoControl()) == 0){
                return true;
            }
        }
        return false;
    }

    public String getNoControl() {
        return noControl;
    }

    public void setNoControl(String noControl) {
        this.noControl = noControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws NombreErroneoException {
        if(!nombre.matches(".*\\d.*")){
            this.nombre = nombre;
        }
        else{
            throw new NombreErroneoException("Nombre invalido, ingrese de nuevo"
                    + " el nombre");
        }
        
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) throws NombreErroneoException {
        if(!paterno.matches(".*\\d.*")){
            this.paterno = paterno;
        }
        else{
            throw new NombreErroneoException("Nombre invalido, ingrese de nuevo"
                    + " el nombre");
        }
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) throws NombreErroneoException {
        if(!materno.matches(".*\\d.*")){
            this.materno = materno;
        }
        else{
            throw new NombreErroneoException("Nombre invalido, ingrese de nuevo"
                    + " el nombre");
        }
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) throws CalificacionErroneaException {
        if(calificacion >= 0.0 && calificacion <= 10.0){
            this.calificacion = calificacion;
        }
        else{
            throw new CalificacionErroneaException("La calificacion debe estar"
                    + " entre 0 y 10.");
        }
        
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    
    
}
