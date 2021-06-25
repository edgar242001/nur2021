package gui;

import aritmetico.ArbolAritmetico;
import aritmetico.ElementoAritmetico;
import aritmetico.Numero;
import aritmetico.Operador;
import base.Arbol;

import java.awt.*;
import java.util.logging.Logger;


public class DibujoArbol implements IDibujo {

    public static final int ANCHO_CONTENEDOR = 40;
    public static final int ESPACIO_VERTICAL = 80;
    public static final int ESPACIO_HORIZONTAL = 50;
    Logger log = Logger.getLogger("logger");

    private ArbolAritmetico modelo;

    public DibujoArbol(ArbolAritmetico obj) {
        modelo = obj;
    }

    @Override
    public void dibujar(Graphics g) {
        Arbol.Contenedor<ElementoAritmetico> raiz = modelo.getRaiz();
        dibujarContenedor(raiz, 10, 10, g);
    }

    public void dibujarContenedor(Arbol.Contenedor<ElementoAritmetico> contenedor, int x, int y, Graphics g) {
        log.info("Nuevo Dibujo");
        int ancho = getAncho(contenedor);
        int xh = x;
        int yh = y + ESPACIO_VERTICAL;
        int anchoHijo = 0;

        for (Arbol.Contenedor<ElementoAritmetico> hijo : contenedor.getHijos()) {
            anchoHijo = getAncho(hijo);

            // lineas
            g.drawLine(x + (ancho / 2), y + ANCHO_CONTENEDOR / 2, xh + anchoHijo / 2, yh + ANCHO_CONTENEDOR);

            dibujarContenedor(hijo, xh, yh, g);
            xh += (anchoHijo + ESPACIO_HORIZONTAL);
        }


        g.setColor(Color.WHITE);
        g.fillArc(x + (ancho / 2) - (ANCHO_CONTENEDOR / 2), y, ANCHO_CONTENEDOR, ANCHO_CONTENEDOR, 0, 360);
        g.setColor(Color.BLACK);
        g.drawArc(x + (ancho / 2) - (ANCHO_CONTENEDOR / 2), y, ANCHO_CONTENEDOR, ANCHO_CONTENEDOR, 0, 360);

        contenedor.setPosX(x + (ancho / 2) - (ANCHO_CONTENEDOR / 2));
        contenedor.setPosY(y);

        ElementoAritmetico elementoAritmetico = contenedor.getContenido();
        if (elementoAritmetico instanceof Numero) {
            g.drawString(String.valueOf(((Numero) elementoAritmetico).getValor()), x + (ancho / 2), y + ANCHO_CONTENEDOR / 2);
        } else {
            Operador operacion = (Operador) elementoAritmetico;
            String operacionString = operacion.getSimbolo();
            g.drawString(operacionString, x + (ancho / 2), y + ANCHO_CONTENEDOR / 2);
        }
    }


    private int getAncho(Arbol.Contenedor<ElementoAritmetico> contenedor) {
        if (contenedor.getHijos().tamano() == 0)
            return ANCHO_CONTENEDOR;

        int result = 0;
        int espacio = 0;
        for (Arbol.Contenedor<ElementoAritmetico> hijo : contenedor.getHijos()) {
            result += espacio + getAncho(hijo);
            espacio = ESPACIO_HORIZONTAL;
        }
        return result;
    }
}
