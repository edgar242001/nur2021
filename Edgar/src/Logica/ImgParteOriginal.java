/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Imagen;
import Logica.CodigoColor;
import imagenes.transformaciones.Transformacion;
import java.util.List;

/**
 *
 * @author Edgar
 */
public class ImgParteOriginal extends Transformacion {

    List<CodigoColor> lista;
    boolean parte;

    public ImgParteOriginal(Imagen img, List<CodigoColor> lista, boolean comprobacion) {
        imagenBase = img;
        this.lista = lista;
        parte = comprobacion;

    }

    @Override
    public void hacer() {
        int contador;
        if (parte == true) {
            // principio
            contador = 0;
        } else {

            // la formula es 2/3 * el tamaño del panel
            contador = 26400;
        }

        for (int i = 0; i < imagenBase.getAncho(); i++) {
            // altura del pintado
            for (int j = 0; j < imagenBase.getAlto(); j++) {
                int color = lista.get(contador).getR() | lista.get(contador).getG() | lista.get(contador).getB();
                imagenBase.setPixel(color, i, j);
                contador++;
            }

        }

        imagenBase.cambioOk();
    }
    // el objetivo de esta clase es dibujar solo la parte exacta de la imagen sin ningun cambio

}
