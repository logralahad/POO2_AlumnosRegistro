/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import excepciones.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import model.Alumno;

/**
 *
 * @author logra
 */
public class Controller implements Serializable{
    
    private ArrayList<Alumno> alumnos;

    public Controller() throws CargarArchivoException, ArchivoInvalidoException {
        load();
    }
    
    public boolean add(Alumno alumno) throws AlumnoExistenteException{
        if(alumnos.contains(alumno)){
            throw new AlumnoExistenteException("El numero de control ya esta asignado.");
        }
        return alumnos.add(alumno);
    }
    
    public boolean remove(Alumno alumno) throws AlumnoInexistenteException, ListaVaciaException{
        if(alumnos.contains(alumno)){
            return alumnos.remove(alumno);
        }
        else if(alumnos.isEmpty()){
            throw new ListaVaciaException("No hay alumnos registrados.");
        }
        else{
            throw new AlumnoInexistenteException("El numero de control no esta asignado.");
        }
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }
    
    public Integer cantidadAlumnos(){
        return this.alumnos.size();
    }
    
    public Integer camposAlumnos(){
        return Alumno.class.getDeclaredFields().length;
    }
    
    public Alumno getAlumno(Integer idx){
        if(idx == -1){
            return alumnos.get(0);
        }
        return alumnos.get(idx);
    }
    
    public void setAlumno(Alumno alumno, Integer idx){
        alumnos.set(idx, alumno);
    }

    public Alumno search(String noControl) throws AlumnoInexistenteException, BusquedaVaciaException{
        Integer idx = -1;
        for (Alumno alumno : alumnos) {
            if(noControl.compareTo(alumno.getNoControl()) == 0){
                idx = alumnos.indexOf(alumno);
            }
        }
        
        if(idx != -1){
            return alumnos.get(idx);
        }
        else if(noControl.isEmpty()){
            throw new BusquedaVaciaException("Escriba un numero de control");
        }
        else{
            throw new AlumnoInexistenteException("El numero de control no esta asignado.");
        }
    }
    
    public void save() throws GuardarArchivoException{
        try {
            File file = new File("alumnos.dat");
            FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(output);

            writer.writeObject(alumnos);

            writer.close();
            output.close();
        }
        catch(Exception ex){
            throw new GuardarArchivoException("Hubo un error al guardar los datos.");  
        }
    }
    
    public void load() throws CargarArchivoException, ArchivoInvalidoException{
        File file = new File("alumnos.dat");
        if(file.exists()){
            try {

                FileInputStream input = new FileInputStream(file);
                ObjectInputStream reader = new ObjectInputStream(input);

                alumnos = (ArrayList <Alumno>)reader.readObject(); 

                reader.close();
                input.close();
            }
            catch(IOException ex){
                throw new CargarArchivoException("Error al cargar el archivo inicial.");  
            }
            catch(ClassNotFoundException ex){
                throw new ArchivoInvalidoException("El archivo de origen esta corrupto.");  
            }
        }
        else{
            alumnos = new ArrayList<Alumno>();
        }
    }
    
}
