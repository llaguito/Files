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
public class Diccionario {

    public static void main(String[] args) throws IOException {
        Scanner leer = new Scanner(System.in);
        BufferedReader leerPalabras = null;
        PrintWriter salidaDatos = null;
        ArrayList <String> palabrasDiccionario = new ArrayList <String> ();
        String palabra = "";
        int contadorLineas = 0;
        ArrayList <String> definiciones = new ArrayList <String> ();
        String definicion = "";
        
        //MENU
        int respuesta = 0;
        int opcionSalida = 0;
        String finaliza = "Salir";
        ArrayList <String> menu = new ArrayList <String> ();
        menu.add("Añadir palabra");
        menu.add("Consultar una palabra");
        menu.add("Listado de palabras");
        menu.add("Ordenar diccionario");
        menu.add("Salir");
        
        //Agregamos datos a las Pilas desde el archivo
        leerPalabras = new BufferedReader (new FileReader("Diccionario.txt"));
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
                opcionSalida = contador + 1;
            }
        }
        //Menu y diferentes opciones.
        while ( respuesta != opcionSalida) {
            for ( int contador = 0; contador < menu.size(); contador++ ) {
                System.out.print("\n"+(contador+1)+" - "+menu.get(contador)+".");
            }
            
            System.out.print("\n¿Que quieres hacer? ");
            respuesta = leer.nextInt();
            
            switch ( respuesta ) {
                
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
                    salidaDatos.printf(definicion);
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
                    
        
                    
                    
            }
        }
        
        leerPalabras.close();
        salidaDatos.close();
        
        
        
    }

}
