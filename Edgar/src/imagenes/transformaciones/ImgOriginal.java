package imagenes.transformaciones;

import Logica.CodigoColor;
import Logica.Imagen;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImgOriginal extends Transformacion {

    List<CodigoColor> lista;

    public ImgOriginal(Imagen img, BufferedImage color) {
        imagenBase = img;
        colores = color;
        lista = new ArrayList();
    }

    @Override
    public void hacer() {

        for (int i = 0; i < imagenBase.getAncho(); i++) {
            // altura del pintado
            for (int j = 0; j < imagenBase.getAlto(); j++) {
                int pixel = colores.getRGB(i, j); // codigo de color sacado de la imagen
                Color color = new Color(pixel); // color rgb obtenido
               
                int R = color.getRed() << 16;
                int G = color.getGreen() << 8;
                int B = color.getBlue();
                lista.add(new CodigoColor(R, G, B));
                int rgb = R | G | B; // color obtenido 
                imagenBase.setPixel(rgb, i, j);
            }
        }

        imagenBase.cambioOk();
    }
    public List<CodigoColor> listaRGB(){
        return lista;
    }

}
