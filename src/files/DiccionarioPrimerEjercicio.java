/*
4.)Fai un programa que permita guardar nun archivo un diccionario, co seguinte formato:
Palabra:
Definicion:
En líneas distintas, fai un pequeño menú que permita consultar unha palabra e a sua definición, e introducir novas palabras.

*/
package files;

import Clases.AyudaDiccionario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @autor Santiago Losada Borrajo
 */
public class DiccionarioPrimerEjercicio {

    public static void main(String[] args) throws IOException {
        Scanner leer = new Scanner(System.in);
        BufferedReader leerPalabras = null;
        PrintWriter salidaDatos = null;
        ArrayList <String> palabrasDiccionario = new ArrayList <String> ();
        String palabra = "";
        int contadorLineas = 0;
        ArrayList <String> definiciones = new ArrayList <String> ();
        String definicion = "";
        int contadorModificar;
        
        //MENU
        int respuestaMenu = 0;
        int opcionSalidaMenu = 0;
        String finaliza = "Salir";
        ArrayList <String> menu = new ArrayList <String> ();
        menu.add("Añadir palabra");
        menu.add("Consultar una palabra");
        menu.add("Listado de palabras");
        menu.add("Ordenar diccionario");
        menu.add("Modificar una palabra");
        menu.add("Borrar una palabra");
        menu.add("Salir");
        
        int respuestaModificar;
        int opcionSalidaModificar = 0;
        ArrayList <String> modificar = new ArrayList <String> ();
        modificar.add("Palabra");
        modificar.add("Definicion");
        modificar.add("Salir");
        
        //Agregamos datos a las Pilas desde el archivo
        leerPalabras = new BufferedReader (new FileReader("Diccionario.txt"));
        try {
            while ( ( palabra = leerPalabras.readLine() ) != null) {
                if ( contadorLineas % 2 == 0 ) {
                    palabrasDiccionario.add(palabra);
                    contadorLineas++;
                }
                else {
                    definiciones.add(palabra);
                    contadorLineas++;
                }
            }
        
            //Buscamos opcion de salida.
            for ( int contador = 0; contador < menu.size(); contador++ ){
                if ( finaliza.equalsIgnoreCase(menu.get(contador)) ) {
                    opcionSalidaMenu = contador + 1;
                }
            }
        
            for ( int contador = 0; contador < modificar.size(); contador++ ){
                if ( finaliza.equalsIgnoreCase(modificar.get(contador)) ) {
                    opcionSalidaModificar = contador + 1;
                }
            }
            //Menu y diferentes opciones.
            while ( respuestaMenu != opcionSalidaMenu) {
                for ( int contador = 0; contador < menu.size(); contador++ ) {
                    System.out.print("\n"+(contador+1)+" - "+menu.get(contador)+".");
                }
            
                System.out.print("\n¿Que quieres hacer? ");
                respuestaMenu = leer.nextInt();
                if ( (respuestaMenu < 1) || (respuestaMenu > menu.size())){
                    System.out.print("\nEl valor introducido no es válido.\nIntroduce de nuevo la opción que quieres.\nOpción: ");
                    respuestaMenu = leer.nextInt();                    
                }
            
                switch ( respuestaMenu ) {
                
                    case 1 :
                        salidaDatos = new PrintWriter(new FileWriter("diccionario.txt", true));
                        System.out.print("\nIntroduce nueva palabra: ");
                        palabra = leer.next();
                        while ( palabrasDiccionario.contains(palabra) ) {
                            System.out.print("\nYa existe la palabra.\nEscribe otra: ");
                            palabra = leer.next();
                        }
                    
                        leer.nextLine();
                    
                        palabrasDiccionario.add(palabra);
                        salidaDatos.println(palabra);
                        System.out.print("\nDefinición: ");
                        definicion = leer.nextLine();
                        definiciones.add(definicion);
                        salidaDatos.println(definicion);
                        salidaDatos.close();
                        break;
                    
                    case 2 :
                        System.out.print("\n¿Que palabra quieres consultar? ");
                        palabra = leer.next();
                    
                        for ( int contador = 0; contador < palabrasDiccionario.size(); contador++ ) {
                            if ( palabra.equalsIgnoreCase(palabrasDiccionario.get(contador)) ) {
                                System.out.print("\nPalabra: "+palabrasDiccionario.get(contador)+"\nDefinición: "+definiciones.get(contador)+"\n");
                            }
                        }
                        break;
                    
                    case 3 :
                        System.out.print("\nListado de PALABRAS: ");
                        for ( int contador = 0; contador < palabrasDiccionario.size(); contador++ ) {
                            System.out.print("\n"+palabrasDiccionario.get(contador));
                        }
                        System.out.print("\n");
                        break;
                    
                    case 4 :
                        salidaDatos = new PrintWriter(new FileWriter("diccionario.txt"));
                        AyudaDiccionario ordenar = new AyudaDiccionario(palabrasDiccionario, definiciones);
                        ordenar.Ordenar();
                        palabrasDiccionario.clear();
                        definiciones.clear();
                    
                        for ( int contador = 0; contador < ordenar.Tamaño(); contador++ ) {
                            palabrasDiccionario.add(ordenar.DevolverpalabrasDiccionario(contador));
                            definiciones.add(ordenar.DevolverDefinicion(contador));
                        }
                    
                        System.out.print("\nOrdenado con éxito.\n");
                    
                        for ( int contador = 0; contador < palabrasDiccionario.size(); contador++ ) {
                            salidaDatos.println(palabrasDiccionario.get(contador));
                            salidaDatos.println(definiciones.get(contador));
                        }
                    
                        ordenar.VaciarArrayList();
                        salidaDatos.close();
                        break;
                    
                    case 5 :
                        try {
                            salidaDatos = new PrintWriter(new FileWriter("diccionario.txt"));
                            System.out.print("\n¿Que palabra quieres modificar? ");
                            palabra = leer.next();
                            contadorModificar = 0;
                            respuestaModificar = 0;
                            
                            leer.nextLine();
                        
                            for ( int contador = 0; contador < palabrasDiccionario.size(); contador++ ) {
                                if ( palabra.equalsIgnoreCase(palabrasDiccionario.get(contador)) ) {
                                contadorModificar = contador;
                                }
                            }
                    
                            while ( respuestaModificar != opcionSalidaModificar) {
                                for ( int contador = 0; contador < modificar.size(); contador++ ) {
                                    System.out.print("\n"+(contador+1)+" - "+modificar.get(contador)+".");
                                }
            
                                System.out.print("\n¿Que quieres hacer? ");
                                respuestaModificar = leer.nextInt();
            
                                switch ( respuestaModificar ) {
                            
                                    case 1 :
                                        System.out.print("\n¿Modificación en la palabra? ");
                                        palabra = leer.next();
                                        palabrasDiccionario.set(contadorModificar, palabra);
                                        break;
                                
                                    case 2 :
                                        leer.nextLine();
                                        System.out.print("\n¿Modificación en la definición? ");
                                        definicion = leer.nextLine();
                                        definiciones.set(contadorModificar, definicion);
                                        leer.nextLine();
                                        break;
                                }
                        
                        
                            }
                            for ( int contador = 0; contador < palabrasDiccionario.size(); contador++ ) {
                                salidaDatos.println(palabrasDiccionario.get(contador));
                                salidaDatos.println(definiciones.get(contador));
                                }
                            salidaDatos.close();
                        }
                        catch (Exception ex) {
                            System.out.print("\nError de Modificación.\n");
                            salidaDatos.close();
                        }
                        break;
                    
                    case 6 :
                        salidaDatos = new PrintWriter(new FileWriter("diccionario.txt"));
                        System.out.print("\n¿Que palabra quieres borrar? ");
                        palabra = leer.next();
                        contadorModificar = 0;
                    
                        for ( int contador = 0; contador < palabrasDiccionario.size(); contador++ ) {
                            if ( palabra.equalsIgnoreCase(palabrasDiccionario.get(contador)) ) {
                                contadorModificar = contador;
                            }
                        }
                    
                        palabrasDiccionario.remove(contadorModificar);
                        definiciones.remove(contadorModificar);
                    
                        System.out.print("\nBorrado con éxito.\n");
                    
                        for ( int contador = 0; contador < palabrasDiccionario.size(); contador++ ) {
                            salidaDatos.println(palabrasDiccionario.get(contador));
                            salidaDatos.println(definiciones.get(contador));
                        }
                    
                        salidaDatos.close();
                        break;
                }
            }
        }
        catch (Exception ex) {
            System.out.print("ERROR");
            salidaDatos.close();
        }
               
        
    }

}
