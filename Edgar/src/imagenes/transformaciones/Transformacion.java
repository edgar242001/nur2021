package imagenes.transformaciones;

import Logica.Imagen;
import java.awt.image.BufferedImage;

public abstract class Transformacion {
	protected Imagen imagenBase;
        protected BufferedImage colores;
	
	
	
	public abstract void hacer();
        
}
