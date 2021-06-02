/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Quicksort extends Observable{
    
    private  void quicksort(int a[], int izq, int der) {
        int i = izq;
        int j = der;
        int pivote = a[(izq + der) / 2];
        do {
            while (a[i] < pivote) {
                i++;
            }
            while (a[j] > pivote) {
                j--;
            }
            if (i <= j) {
                int aux = a[i];
                a[i]= a[j];
                a[j]= aux;
                i++;
                j--;
                setChanged();
                notifyObservers();
                
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Quicksort.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } while (i <= j);
        if (izq < j) {
            quicksort(a, izq, j);
        }
        if (der > i) {
            quicksort(a, i, der);
        }
    }
    public void ordenar (int arreglo []){
        quicksort(arreglo, 0, arreglo.length - 1);
    }
    
}
