/*
5) Crea unha clase palabra, cas variables de clase, pal,definición,traducción(palabra en ingles), fai un programa que permita crear un diccionario (altas,búsquedas,modificacions,e traducir un texto a ingles). 
*/
package files;

import Clases.Palabra;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @autor Santiago Losada Borrajo
 */
public class DiccionarioConTraduccion {

    public static void main(String[] args) throws IOException {
        Scanner leer = new Scanner(System.in);
        File archivo = new File("diccionarioConTraduccion");
        ArrayList <Palabra> lista = new ArrayList <Palabra> ();
        lista.add(new Palabra("hola", "un saludo", "hello"));
        Object auxiliar;
        Palabra objeto;
        ObjectOutputStream salida = null;
        ObjectInputStream entrada = null;
        
        //Menu
        ArrayList <String> menu = new ArrayList <String> ();
        menu.add("Altas");
        menu.add("Búsquedas");
        menu.add("Modificaciones");
        menu.add("Traducir");
        menu.add("Salir");
        int opcionMenu = 1;
        
        //Creamos variables de lectura y escritura.
        try {
            salida = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("diccionarioConTraduccion", true)));
        }
        catch ( Exception ex ) {
            System.out.print("\nLa creacion de las variable de escritura al archivo ha fallado.");
        }
        
        salida.writeObject(lista.get(0));
        salida.close();
                    
        try {
            entrada = new ObjectInputStream(new BufferedInputStream(new FileInputStream("diccionarioConTraduccion")));
        }
        catch ( Exception ex ) {
            System.out.print("\nLa creacion de las variable de acceso al archivo ha fallado.");
        }
        //Funcion que copia valores de un archivo a la estructura dinámica en caso de que el archivo exista.
        try {
            
            if ( !archivo.exists()) {                
                System.out.print("\nNo existe el archivo.");
            }
            else  {                
                while ( (auxiliar = entrada.readObject()) != null ){
                    objeto = (Palabra) auxiliar;
                    lista.add(objeto);
                }
            }
        }
        catch ( Exception ex ) {
            System.out.print("\nLa lectura del archivo ha fallado.");
        }
        
        try {
            
            while ( !menu.get(opcionMenu - 1).equalsIgnoreCase(menu.get(menu.size() - 1)) ) {
                
                //Pasamos por pantalla el menu
                for ( int contador = 0; contador < menu.size(); contador++ ) {
                    System.out.print("\n"+(contador+1)+" - "+menu.get(contador));
                }
                
                System.out.print("\n¿Que opción escoges?    ");
                opcionMenu = leer.nextInt();
            }
            
        }
        catch ( Exception ex ) {
            System.out.print("\nEl menu ha fallado.");
        }
    }

}
