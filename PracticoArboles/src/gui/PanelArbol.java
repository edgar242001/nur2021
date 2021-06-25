package gui;

import aritmetico.ArbolAritmetico;
import aritmetico.ElementoAritmetico;
import aritmetico.Numero;
import aritmetico.Operador;
import base.Arbol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Logger;


public class PanelArbol extends JPanel implements MouseListener, PropertyChangeListener {

    private ArbolAritmetico modelo;
    Logger log = Logger.getLogger("logger");

    public PanelArbol(ArbolAritmetico obj) {
        modelo = obj;
        this.addMouseListener(this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(10000, 10000);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (modelo != null) {
            DibujoArbol dibujoArbol = new DibujoArbol(modelo);
            dibujoArbol.dibujar(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (modelo == null)
            return;
        Arbol.Contenedor<ElementoAritmetico> raiz = modelo.getRaiz();
        Arbol.Contenedor<ElementoAritmetico> seleccionado = accederPosicion(raiz, e);
        ArbolAritmetico prueba = null;
        try {
            if (seleccionado != null) {
                prueba = new ArbolAritmetico(toStringAritmetico(seleccionado));
                prueba.setRaiz(seleccionado);
                String operacion = prueba.toString();
                JOptionPane.showMessageDialog(null, operacion);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Arbol.Contenedor<ElementoAritmetico> accederPosicion(Arbol.Contenedor<ElementoAritmetico> contenedor,
                                                                MouseEvent e) {
        Arbol.Contenedor<ElementoAritmetico> seleccionado = null;
        for (Arbol.Contenedor<ElementoAritmetico> hijo : contenedor.getHijos()) {
            seleccionado = accederPosicion(hijo, e);
            if (seleccionado != null) {
                break;
            }
        }

        if (e.getX() >= contenedor.getPosX() && e.getX() <= (contenedor.getPosX() + 40)) {
            log.info("Se ha echo un click en " + e.getX() + " y " + e.getY());
            if (e.getY() >= contenedor.getPosY() && e.getY() <= (contenedor.getPosY() + 40)) {
                log.info("Haz interactuado con un objeto");
                return contenedor;
            }
        }

        return seleccionado;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    public ArbolAritmetico getModelo() {
        return modelo;
    }

    public void setModelo(ArbolAritmetico modelo) {
        this.modelo = modelo;
    }

    public String toStringAritmetico(Arbol.Contenedor<ElementoAritmetico> nodo) {
        ElementoAritmetico elementoAritmetico = nodo.getContenido();
        if (elementoAritmetico instanceof Numero) {
            return String.valueOf(((Numero) elementoAritmetico).getValor());
        }

        Operador operacion = (Operador) elementoAritmetico;
        String operacionString = operacion.getSimbolo();

        StringBuilder resultado = new StringBuilder();
        log.info("el resultado es " + resultado);
        String separador = "";
        for (Arbol.Contenedor<ElementoAritmetico> hijo : nodo.getHijos()) {
            String hijoString = toStringAritmetico(hijo);
            resultado.append(separador).append(hijoString);
            separador = operacionString;
        }
        return resultado.toString();
    }
}