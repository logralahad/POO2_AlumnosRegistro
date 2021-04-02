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
public class CalificacionErroneaException extends Exception {

    /**
     * Creates a new instance of <code>CalificacionErroneaException</code>
     * without detail message.
     */
    public CalificacionErroneaException() {
    }

    /**
     * Constructs an instance of <code>CalificacionErroneaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CalificacionErroneaException(String msg) {
        super(msg);
    }
}
