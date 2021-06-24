/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Imagen;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

public class PanelImagen2 extends JPanel implements PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private Imagen imagen;
	public PanelImagen2(Imagen img) {
		imagen = img;
	}
        
        public PanelImagen2(){
            
        }
      
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (imagen != null) {
			imagen.dibujar(g);
		}
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}
}