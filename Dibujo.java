
package logica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logica.Quicksort;


public class Dibujo extends JPanel implements Runnable, Observer{
    private int [] arreglo;
    private final int NB = 700;
    private Quicksort ordenador;

   

    public void setArreglo(int[] arreglo) {
        this.arreglo = arreglo;
    }
    
    public Dibujo(){
       arreglo = new int[NB];
       
       for(int i=0; i< NB; i++){
           arreglo[i]=(int) (300* Math.random())+1;
       }
       this.ordenador = new Quicksort();
       this.ordenador.addObserver(this);
      
       this.setPreferredSize(new Dimension(800,400));
       this.setBackground (Color.BLACK);
       
       Thread t = new Thread(this);
       t.start();
   }
   
   
    @Override
    public void paintComponent (Graphics gc){
       super.paintComponent (gc);
       this.setForeground(Color.GREEN);
       for (int i = 0; i < NB; i++) {
           //gc.drawLine(0,1*2+1,arreglo[i],i*2+1);
           gc.drawLine(i+50,350,i+50,350 -arreglo[i]);
           
       }
   }
   
   public int[] getArreglo() {
        return arreglo;
    }

    @Override
    public void run() {
        ordenador.ordenar(arreglo);
        JOptionPane.showMessageDialog(this, "Arreglo Ordenado");
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

   
}
