/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagenes;

import java.awt.Color;

/**
 *
 * @author Oveja
 */
public class consola {

    public static void main(String[] args) {
        // EJEMPLO DE LOGICA DEL RGB
        // rojo
        int r = 16711680 >> 16;
        int g = 65280 >> 8;
        int b = 0;
        // amarillo
        int r2 = 14876672 >> 16;
        int g2 = 0 >> 8;
        int b2 = 27;
        // sumo los dos rgb y se tiene que dividir para obtener el codigo rgb para obtener el medio
        System.out.println((r + r2)/2);
        int nuevoR =(r + r2)/2;
        System.out.println((g + g2)/2);
        int nuevoG =(g + g2)/2;
        System.out.println((b + b2)/2);
        int nuevoB = (b + b2)/2;
        
        System.out.println("final");
        System.out.println(nuevoR << 16);
        System.out.println(nuevoG << 8);
        System.out.println(nuevoB);
        
        // LUEGO SE DIVIDE ENTRE 2
       
    }
}
