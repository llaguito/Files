package files;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author santiago && Santiago Losada Borrajo
 */
public class BuscarPalabraModificado {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException {
        FileReader entrada=null;
        entrada=new FileReader("palabras.txt");
        int c;
        char a;
        String pal="";
        String buscada="";
        int cont=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca a palabra a buscar");
        buscada=sc.next();
        
        while ((c = entrada.read()) != -1){
                a = (char) c;
                if ( (a == ' ') || ( a == '\r' ) || (a == '\n') ) {
                    if (pal.equalsIgnoreCase(buscada)) {
                        cont++;
                    }
                    pal = "";                    
                }
                else {
                    pal+= a;
                }
            }
        
        if (pal.equalsIgnoreCase(buscada)) {
                cont++;
        }
        System.out.println(cont);
        entrada.close();   // TODO code application logic here
    
    }
}
