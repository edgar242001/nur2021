
package Logica;

import java.awt.*;
import javax.swing.*;
 
public class Secuencia extends JFrame {
 
 
   public Secuencia()
   {
      super( "QUICKSORT" );
 
      setSize( 700,400 );
      setVisible( true );
   }
 
   public void stop(int tiempo) {
 
		try{Thread.sleep(tiempo);}catch(Exception err){}
 
	}
 
 
 
   public  static void Quicksort(int A[], int b, int t)
 
{
     int pivote;
     if(b < t){
        pivote=colocar(A, b, t);
        Quicksort(A, b, pivote-1);
        Quicksort(A, pivote+1, t);
     }
}
 
 // Colocamos las lineas
  public static int colocar(int A[], int b, int t)
{
    int i;
    int pivote, valor_pivote;
    int temp;
 
    pivote = b;
    valor_pivote = A[pivote];
    for (i=b+1; i<=t; i++){
        if (A[i] > valor_pivote){
                 pivote++;
                temp=A[i];
                A[i]=A[pivote];
                A[pivote]=temp;
 
        }
    }
    temp=A[b];
    A[b]=A[pivote];
    A[pivote]=temp;
    return (int) pivote;
}
  public void paint( Graphics g )
   {
       int A[]=new int[470];
       int p=0,q=469;
      super.paint( g );
      g.setColor( Color.BLUE );
      g.drawLine(30,0,30,470);
       g.drawLine(30,470,500,470);
       for(int y=0;y<469;y++)
      {stop(50);
         int valor = 1 + ( int ) ( Math.random() *469 );
         A[y]=valor;
      g.setColor( Color.BLUE );
      g.drawLine(30+y,470,30+y,valor);
      System.out.print (" Arreglo Desordenado "+"<"+A[y]+">");
            System.out.print ("\n");
      }
 
 
 
 //Pintamos los graficos al igual del desorden
   
 
       g.setColor(java.awt.Color.white);
    g.fillRect(0,0,500,500);
    g.setColor(java.awt.Color.black);
        Quicksort(A,p,q);
       for(int x=0;x<469;x++)
      {stop(50);
 
      g.setColor( Color.BLUE );
      g.drawLine(30+x,470,30+x,A[x]);
      System.out.print (" Arreglo Ordenado "+"<"+A[x]+">");
            System.out.print ("\n");
      }
 
   }
   public static void main( String args[] )
   {
      Secuencia application = new Secuencia();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }
 
}

    
 