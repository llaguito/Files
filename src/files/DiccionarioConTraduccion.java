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
        ArrayList <Palabra> lista = new ArrayList <> ();
        Palabra auxiliar = new Palabra();
        Palabra nueva;
        Object objeto;
        ObjectOutputStream salida = null;
        ObjectInputStream entrada = null;
        String palabra;
        String definicion;
        String traduccion;
        boolean comprobacion = false;
        int numero = 0;
        
        //Menu
        ArrayList <String> menu = new ArrayList <> ();
        menu.add("Altas");
        menu.add("Búsquedas");
        menu.add("Modificaciones");
        menu.add("Traducir");
        menu.add("Listado de palabras");
        menu.add("Salir");
        int opcionMenu = 1;
        
        ArrayList <String> modificar = new ArrayList <String> ();
        modificar.add("Palabra");
        modificar.add("Definición");
        modificar.add("Traducción");
        modificar.add("Salir");
        int respuestaModificar;
        
        //Creamos variable de lectura.
        try {
            entrada = new ObjectInputStream(new BufferedInputStream(new FileInputStream("diccionarioConTraduccion")));
        }
        catch ( Exception ex ) {
            System.out.print("\nLa creacion de las variable de acceso al archivo ha fallado.");
        }
        
        //Funcion que copia valores de un archivo a la estructura dinámica en caso de que el archivo exista.
        try {
             for (;;) {
                objeto = entrada.readObject();
                auxiliar = (Palabra) objeto;
                lista.add(auxiliar);
            }
        }
        catch ( Exception ex ) {
            System.out.print("\nLa lectura del archivo ha terminado.");
        }
        
        try {
            
            while ( !menu.get(opcionMenu - 1).equalsIgnoreCase(menu.get(menu.size() - 1)) ) {
                
                //Pasamos por pantalla el menu
                for ( int contador = 0; contador < menu.size(); contador++ ) {
                    System.out.print("\n"+(contador+1)+" - "+menu.get(contador));
                }
                
                System.out.print("\n¿Que opción escoges?    ");
                opcionMenu = leer.nextInt();

                switch (opcionMenu) {
                    
                    case 1 :
                        try {
                            salida = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("diccionarioConTraduccion")));
                            System.out.print("\nIntroduce nuevos valores.\nNueva palabra:  ");
                            palabra = leer.next();
                            leer.nextLine();
                            System.out.print("Definicion:  ");
                            definicion = leer.nextLine();
                            System.out.print("Traduccion:  ");
                            traduccion = leer.next();
                            lista.add(new Palabra(palabra, definicion, traduccion));
                            System.out.print("Alta dada con éxito.");
                            try {
                                salida = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("diccionarioConTraduccion")));
                            }
                            catch ( Exception ex ) {
                                System.out.print("\nLa creacion de las variable de escritura al archivo ha fallado.");
                            }
        
                            try {
                                for ( int contador = 0; contador < lista.size(); contador++ ) {
                                    salida.writeObject(lista.get(contador));
                                }
                            }
                            catch ( Exception ex ) {
                                System.out.print("\nEl proceso de guardado ha fallado.");
                            }
        
                            salida.close();
                            
                            }
                        catch ( Exception ex ) {
                                System.out.print("\nEl proceso de alta ha fallado.");
                        }
                        break;
                        
                    case 2 :
                        try {
                            System.out.print("\nIntroduce palabra para buscar:  ");
                            palabra = leer.next();
                                for ( int contador = 0; contador < lista.size(); contador++ ) {
                                    if (palabra.equalsIgnoreCase(lista.get(contador).getPalabra())) {
                                        comprobacion = true;
                                        numero = contador;
                                    }
                                }
                                if (comprobacion = true) {
                                    System.out.print("\nPalabra:  "+lista.get(numero).getPalabra()+"\nDefinición:  "+lista.get(numero).getDefinicion()+"\nTraduccion:  "+lista.get(numero).getTraduccion());
                                }
                                numero = 0;
                                comprobacion = false;
                        }
                        catch ( Exception ex ) {
                            System.out.print("\nEl proceso de búsqueda ha fallado.");
                        }
                        break;
                        
                    case 3 :
                         try {
                            System.out.print("\n¿Que palabra quieres modificar? ");
                            palabra = leer.next();
                            int contadorModificar = 0;
                            respuestaModificar = 0;
                            
                            leer.nextLine();
                        
                            for ( int contador = 0; contador < lista.size(); contador++ ) {
                                if ( palabra.equalsIgnoreCase(lista.get(contador).getPalabra()) ) {
                                    contadorModificar = contador;
                                }
                            }
                    
                            while ( !modificar.get(respuestaModificar).equalsIgnoreCase(modificar.get(modificar.size() - 1)) ) {
                                for ( int contador = 0; contador < modificar.size(); contador++ ) {
                                    System.out.print("\n"+(contador+1)+" - "+modificar.get(contador)+".");
                                }
            
                                System.out.print("\n¿Que quieres hacer? ");
                                respuestaModificar = leer.nextInt();
            
                                switch ( respuestaModificar ) {
                            
                                    case 1 :
                                        System.out.print("\n¿Modificación en la palabra? ");
                                        palabra = leer.next();
                                        lista.get(contadorModificar).setPalabra(palabra);
                                        break;
                                
                                    case 2 :
                                        leer.nextLine();
                                        System.out.print("\n¿Modificación en la definición? ");
                                        definicion = leer.nextLine();
                                        lista.get(contadorModificar).setDefinicion(definicion);
                                        leer.nextLine();
                                        break;
                                        
                                    case 3 :
                                        System.out.print("\n¿Modificación en la traducción? ");
                                        traduccion = leer.next();
                                        lista.get(contadorModificar).setTraduccion(traduccion);
                                        break;
                                        
                                }
                        
                        
                            }
                        }
                        catch ( Exception ex ) {
                            System.out.print("\nEl proceso de modificación ha fallado.");
                        }
                        try {
                            salida = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("diccionarioConTraduccion")));
                        }
                        catch ( Exception ex ) {
                            System.out.print("\nLa creacion de las variable de escritura al archivo ha fallado.");
                        }
        
                        try {
                            for ( int contador = 0; contador < lista.size(); contador++ ) {
                                salida.writeObject(lista.get(contador));
                            }
                        }
                        catch ( Exception ex ) {
                            System.out.print("\nEl proceso de guardado ha fallado.");
                        }
        
                        salida.close();
                         break;
                        
                    case 4 :
                         try {
                            System.out.print("\nIntroduce palabra para buscar:  ");
                            palabra = leer.next();
                                for ( int contador = 0; contador < lista.size(); contador++ ) {
                                    if (palabra.equalsIgnoreCase(lista.get(contador).getPalabra())) {
                                        comprobacion = true;
                                        numero = contador;
                                    }
                                }
                                if (comprobacion = true) {
                                    comprobacion = false;
                                    System.out.print("\nPalabra:  "+lista.get(numero).getPalabra()+"\nTraduccion:  "+lista.get(numero).getTraduccion());
                                }
                                numero = 0;
                        }
                        catch ( Exception ex ) {
                            System.out.print("\nEl proceso de traducción ha fallado.");
                        }
                        break;
                        
                    case 5 :
                        try {
                            for ( int contador = 0; contador < lista.size(); contador++ ) {
                                System.out.print(lista.get(contador).getPalabra()+"\n");
                            }
                        }
                        catch ( Exception ex ) {
                            System.out.print("\nEl proceso de listado ha fallado.");
                        }
                        break;
                    
                }
                
                
            }
            
        }
        catch ( Exception ex ) {
            System.out.print("\nEl menu ha fallado.");
        }    
        
    }

}
