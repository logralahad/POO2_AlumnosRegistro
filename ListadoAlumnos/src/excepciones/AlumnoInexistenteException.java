package excepciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logra
 */
public class AlumnoInexistenteException extends Exception {

    /**
     * Creates a new instance of <code>AlumnoInexistenteException</code> without
     * detail message.
     */
    public AlumnoInexistenteException() {
    }

    /**
     * Constructs an instance of <code>AlumnoInexistenteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public AlumnoInexistenteException(String msg) {
        super(msg);
    }
}
