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
public class BusquedaVaciaException extends Exception {

    /**
     * Creates a new instance of <code>BusquedaVaciaException</code> without
     * detail message.
     */
    public BusquedaVaciaException() {
    }

    /**
     * Constructs an instance of <code>BusquedaVaciaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BusquedaVaciaException(String msg) {
        super(msg);
    }
}
