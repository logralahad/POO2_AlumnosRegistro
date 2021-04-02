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
public class ListaVaciaException extends Exception {

    /**
     * Creates a new instance of <code>ListaVaciaException</code> without detail
     * message.
     */
    public ListaVaciaException() {
    }

    /**
     * Constructs an instance of <code>ListaVaciaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ListaVaciaException(String msg) {
        super(msg);
    }
}
