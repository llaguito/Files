/*
3)Fai un programa que pida duas palabras A e B, e sustitua  todas as aparicions da palabra A pola palabra B no fichero dado.
*/

package files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @autor Santiago Losada Borrajo
 */
public class ModificarPalabraTextoFALLAULTIMAPALABRA {

    public static void main(String[] args) throws IOException {
        System.out.print("Vamos cambiar todas las palabras tal en el archivo texto.txt por **** en el archivo textoVolcado.txt\n");
        FileReader entrada = new FileReader ("textoVolcado.txt");
        FileWriter auxiliar = new FileWriter ("textoAux.txt");
        try  {
            String palabra = "";
            char letra = 0;
            int ascii;
            int contadorPalabras = 0;
            
            while ((ascii = entrada.read()) != -1){
                letra = (char) ascii;
                if ( (letra == ' ') || ( letra == '\r' ) || (letra == '\n') ) {
                    if (palabra.equalsIgnoreCase("tal")) {
                        palabra = "****";
                        contadorPalabras++;
                    }
                    auxiliar.write(palabra);
                    auxiliar.write(letra);
                    System.out.print(palabra);
                    System.out.print(letra);
                    palabra = "";                    
                }
                else {
                    palabra = palabra + letra;
                }

            }

            if (palabra.equalsIgnoreCase("tal")) {
                palabra = "****";
                contadorPalabras++;
                auxiliar.write(palabra);
                System.out.print(palabra);               
            }

            System.out.printf("\nSe cambiaron "+contadorPalabras+" palabras.");
           
        }

        finally {
            entrada.close();
            auxiliar.close();
        }
        
    }

}
