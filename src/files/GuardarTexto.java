/*
Leer palabras por pantalla y escribir en un archivo.
*/
package files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @autor Santiago Losada Borrajo
 */
public class GuardarTexto {

    public static void main(String[] args) throws IOException {
        Scanner leer = new Scanner(System.in);
        FileReader entrada = new FileReader ("texto.txt");
        try (FileWriter salida = new FileWriter ("textoVolcado.txt")) {
            String frase = "";
            String palabra = "";
            char letra;
            int contador = 0;
            
            System.out.print("Introduce palabras ( para terminar salir ): ");
            while ( !palabra.equalsIgnoreCase("salir")) {
                palabra = leer.next();
                contador++;
                
                if (contador == 1) {
                    frase = frase + palabra;
                }
                else if (palabra.equalsIgnoreCase("salir")){}
                else {
                    frase = frase + " " + palabra;
                }
            }
            System.out.print("\nfrase: ");
            salida.write(frase);
            System.out.print(frase);
            salida.write("\r\n");
            System.out.print("\nbucle: ");
            for ( int contador1 = 0; contador1 < frase.length(); contador1++ ) {
                letra = frase.charAt(contador1);
                
                System.out.print(letra);
                salida.write(letra);
            }
        }
    }

}
