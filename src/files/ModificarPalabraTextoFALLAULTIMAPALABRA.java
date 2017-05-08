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
        System.out.print("Vamos cambiar todas las palabras tal en el archivo texto.txt por la palabra como en el archivo textoVolcado.txt\n");
        FileReader entrada = new FileReader ("textoVolcado.txt");
        try (FileWriter auxiliar = new FileWriter ("textoAux.txt")) {
            String palabra = "";
            char letra = 0;
            int ascii;
            
            while ((ascii = entrada.read()) != -1){
                letra = (char) ascii;
                if ( (letra == ' ') || ( letra == '\r' ) || (letra == '\n') ) {
                    if (palabra.equalsIgnoreCase("tal")) {
                        palabra = "como";
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
                palabra = "como";
            }
            auxiliar.write(palabra);
            System.out.printf("\n"+palabra);
            entrada.close();

            auxiliar.close();
           
        }
      
    }

}
