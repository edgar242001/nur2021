package aritmetico;

import java.util.logging.Logger;

public class Operador extends ElementoAritmetico {

    private String simbolo;
    private String nombre;
    Logger log = Logger.getLogger("logger");

    public Operador(String s) {
        simbolo = s;
        if (s.equals("+")) {
            nombre = "Suma";
        }

        if (s.equals("-")) {
            nombre = "Resta";
        }

        if (s.equals("*")) {
            nombre = "Multiplica";
        }

        if (s.equals("/")) {
            nombre = "Divide";
        }
        log.info("La operacion es " + nombre);
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }

}