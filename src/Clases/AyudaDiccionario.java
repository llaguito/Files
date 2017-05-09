package Clases;


import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * @autor Santiago Losada Borrajo
 */
public class AyudaDiccionario {
    private ArrayList <String> frase = new ArrayList <String> ();
    
    public AyudaDiccionario (ArrayList palabrasDiccionario, ArrayList definiciones) {
        for ( int contador = 0; contador < palabrasDiccionario.size(); contador++ ) {
            this.frase.add(palabrasDiccionario.get(contador)+" "+definiciones.get(contador));
        }
    }
    
    public void Ordenar () {
        Collections.sort(this.frase);
    }
    
    public int Tamaño () {
        return this.frase.size();
    }
    
    public String DevolverpalabrasDiccionario(int contador) {
        StringTokenizer token = new StringTokenizer(frase.get(contador));
        String palabra = token.nextToken();
        return palabra;
    }
    
    public String DevolverDefinicion (int contador) {
        String definicion = frase.get(contador).substring((this.DevolverpalabrasDiccionario(contador).length() + 1), this.frase.get(contador).length());
        return definicion;
    }
    
    public void VaciarArrayList() {
        this.frase.clear();
    }
}
