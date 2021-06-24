package imagenes.transformaciones;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import Logica.CodigoColor;
import Logica.Imagen;
import java.util.List;
import java.util.logging.Level;

public class ImgTransparente extends Transformacion {
    //esta clase convinara los colores de 2 imagenes para dibujarla

    List<CodigoColor> listaA;
    List<CodigoColor> listaB;

    public ImgTransparente(Imagen img, List<CodigoColor> listaA, List<CodigoColor> listaB) {
        imagenBase = img;
        this.listaA = listaA;
        this.listaB = listaB;
        LOGGER.log(Level.INFO, "Esta parte es donde hace la parte transparente a mitad de la imagen");
    }

    @Override
    public void hacer() {
        /*
     ESTE ES PARA LEER LA IMAGEN PIXEL POR PIXEL... EN SI NO SE ESTA AÑADIENDO LA IMAGEN SINO QUE SE ESTA DIBUJANDO MANUALMENTE
         */
        LOGGER.log(Level.INFO, "Lee la imagen de pixel a pixel, si no se añadio se pinta");
        int contador =13200;
        for (int i = 0; i < imagenBase.getAncho(); i++) {
            // pixel de la imagen A
            for (int j = 0; j < imagenBase.getAlto(); j++) {
                int r = listaA.get(contador).getR() >> 16;
                int g = listaA.get(contador).getG() >> 8;
                int b = listaA.get(contador).getB();
                // pixel de la imagen B
                int r2 = listaB.get(contador).getR() >> 16;
                int g2 = listaB.get(contador).getG() >> 8;
                int b2 = listaB.get(contador).getB();
                
                

                int nuevoR = ((r + r2) / 2) << 16;
                int nuevoG = ((g + g2) / 2) << 8;
                int nuevoB = (b + b2) / 2;

                int color = nuevoR | nuevoG | nuevoB;
                imagenBase.setPixel(color, i, j);
                contador++;
            }

        }

        imagenBase.cambioOk();
        LOGGER.log(Level.INFO, "Pinta el arreglo");
    }

}
