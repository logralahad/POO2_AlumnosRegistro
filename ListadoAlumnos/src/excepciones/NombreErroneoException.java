/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author logra
 */
public class NombreErroneoException extends Exception {

    /**
     * Creates a new instance of <code>NombreErroneoException</code> without
     * detail message.
     */
    public NombreErroneoException() {
    }

    /**
     * Constructs an instance of <code>NombreErroneoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NombreErroneoException(String msg) {
        super(msg);
    }
}
