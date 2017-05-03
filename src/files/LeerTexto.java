/*
Ejercicio que lea un archivo y imprima palabras en diferentes lineas.
*/

package files;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @autor Santiago Losada Borrajo
 */
public class LeerTexto {

    public static void main(String[] args) throws IOException {
        try (FileReader entrada = new FileReader ("texto.txt")) {
            int ascii;
            char c;
            
            
            while ((ascii = entrada.read()) != -1){
                c = (char) ascii;
                if ( c == ' ') {
                    System.out.print("\n");
                }
                else {
                    System.out.print(c+"");
                }
            }
        }
    }

}
