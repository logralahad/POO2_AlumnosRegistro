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
public class CampoVacioException extends Exception {

    /**
     * Creates a new instance of <code>CampoVacioException</code> without detail
     * message.
     */
    public CampoVacioException() {
    }

    /**
     * Constructs an instance of <code>CampoVacioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CampoVacioException(String msg) {
        super(msg);
    }
}
