/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author santiago
 */
public class Palabrasrepetidas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
         FileReader entrada=null;
    entrada=new FileReader("palabras.txt");
    int c;
    char a;
    String pal="";
    String buscada="";
    int cont=0;
    TreeSet <String> Palabras= new TreeSet <String>();
     
    while ((c=entrada.read())!=-1){
          a=(char)c;
          if((a!=' ')&&(a!='\r')&&(a!='\n')){
         pal+=a;
         }
          else {
             System.out.println(pal);
             Palabras.add(pal);
              pal="";
              }
       }
    System.out.println(Palabras.size());
    entrada.close();   
    }
    
}
