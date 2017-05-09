/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author santiago
 */
public class BuscarPalabra {

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
    while ((c=entrada.read())!=-1){
          a=(char)c;
          if((a!=' ')&&(a!='\r')&&(a!='\n')){
         pal+=a;
         }
          else {
              if (pal.equals(buscada)){
              cont++;
              }
         pal="";
    }
    }
    System.out.println(cont);
    entrada.close();   // TODO code application logic here
    
    
}
}