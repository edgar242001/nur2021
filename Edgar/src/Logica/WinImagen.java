package Logica;

import Logica.PanelImagen2;
import Logica.PanelImagen;
import Logica.ImgParteOriginal;
import Logica.Imagen;
import imagenes.transformaciones.ImgOriginal;
import imagenes.transformaciones.ImgTransparente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class WinImagen extends JFrame {

    
    private static final long serialVersionUID = 1L;
    PanelImagen2 panelA;
    PanelImagen2 panelB;
    PanelImagen2 panel1;
    PanelImagen2 panel2;
    PanelImagen2 panel3;


    Imagen imgB;
    Imagen imgA;

    Imagen imgC;
    Imagen imgC1;
    Imagen imgC2;


    ImgOriginal imagen1;
    ImgOriginal imagen2;

    ImgParteOriginal parte1;
    ImgTransparente parte2;
    ImgParteOriginal parte3;

    private Imagen modelo;

    public WinImagen() {
        init();
    }

    public void init() {
        this.setSize(800, 700);
        modelo = new Imagen(900, 800);
        imgA = new Imagen(200, 200);
        this.setLayout(null);

        PanelImagen panel = new PanelImagen(modelo);
        imgB = new Imagen(200, 200); // tamaño de la imagen
        panelB = new PanelImagen2(imgB);
        panelA = new PanelImagen2(imgA);
        panelB.setBounds(100, 100, 200, 200);
        panelA.setBounds(400, 100, 200, 200);
        imgC = new Imagen(66, 200);
        imgC1 = new Imagen(66, 200);
        imgC2 = new Imagen(66, 200);

        panel1 = new PanelImagen2(imgC);

        panel1.setBounds(200, 350, 66, 200);
        panel2 = new PanelImagen2(imgC1);
        panel2.setBounds(266, 350, 66, 200);
        panel3 = new PanelImagen2(imgC2);
        panel3.setBounds(332, 350, 66, 200);


        modelo.addObserver(panelA);
        modelo.addObserver(panelB);

        modelo.addObserver(panel1);
        modelo.addObserver(panel2);
        modelo.addObserver(panel3);


        this.getContentPane().add(panelA);
        this.getContentPane().add(panelB);

        this.getContentPane().add(panel1);
        this.getContentPane().add(panel2);
        this.getContentPane().add(panel3);


        modelo.addObserver(panel);
        
        JMenuBar menuBar = new JMenuBar();

        JMenu mnuImagen = new JMenu("Imagen");

        JMenuItem item = new JMenuItem("Imagen");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                cargar_imagen_original();
            }
        });

        mnuImagen.add(item);

        item = new JMenuItem("Imagen2");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cargar_imagen_original2();
            }
        });

        mnuImagen.add(item);
        item = new JMenuItem("UNIR");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cargar_imagen_transparente();
            }
        });
        mnuImagen.add(item);

        menuBar.add(mnuImagen);

        this.setJMenuBar(menuBar);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    protected void cargar_imagen_original() {

        imagen1 = new ImgOriginal(imgB, buffer_imagen("FONDO.jpg"));
        imagen1.hacer();
        repaint();

    }

    protected void cargar_imagen_original2() {

        imagen2 = new ImgOriginal(imgA, buffer_imagen("PruebaB.jpg"));
        imagen2.hacer();
        repaint();

    }

    protected void cargar_imagen_transparente() {

        parte1 = new ImgParteOriginal(imgC, imagen1.listaRGB(), true);
        parte1.hacer();
        parte2 = new ImgTransparente(imgC1, imagen1.listaRGB(), imagen2.listaRGB());
        parte2.hacer();
        parte3 = new ImgParteOriginal(imgC2, imagen2.listaRGB(), false);
        parte3.hacer();
        repaint();

    }

    private BufferedImage buffer_imagen(String archivo) {
        InputStream entrada;
        ImageInputStream imageninput;
        BufferedImage image = null;
        try {
            entrada = new FileInputStream("src\\imagenes\\" + archivo);
            imageninput = ImageIO.createImageInputStream(entrada);
            image = ImageIO.read(imageninput);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WinImagen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WinImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

}
