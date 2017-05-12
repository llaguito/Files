/*
5) Crea unha clase palabra, cas variables de clase, pal,definición,traducción(palabra en ingles), fai un programa que permita crear un diccionario (altas,búsquedas,modificacions,e traducir un texto a ingles). 
*/
package Clases;

import java.io.Serializable;

/**
 *
 * @autor Santiago Losada Borrajo
 */
public class Palabra implements Serializable {
    private String palabra;
    private String definicion;
    private String traduccion;
    
    public Palabra() {}
    
    public Palabra(String palabra, String definicion, String traduccion) {
        this.palabra = palabra;
        this.definicion = definicion;
        this.traduccion = traduccion;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }
}
