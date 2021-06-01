/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.util.logging.Level;

/**
 *
 * @author EDGAR ROJAS
 */
public class NewClass {
    
    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "IMPRIME 3");
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
    }
    
}
