/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms;

import data.Grafo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author HP
 */
public class DFS<V, A> {
    HashSet<V> visitados = new HashSet<>();
    LinkedList<V> pila = new LinkedList<>();
    
    public String profundidad(Grafo<V, A> g, V vertice){
        String c = "";
        c+= vertice.toString()+"\n";
        visitados.add(vertice);
        int pos = posicion(g, vertice);
        ArrayList<V> sucesores = g.sucesores(pos);
        for (V sucesor: sucesores) {
            if(!visitados.contains(sucesor)){
                profundidad(g, sucesor);
            }
        }
        return c;
    }
    
    public String profundidadPila(Grafo<V, A> g, V vertice){
        String c = "";
        visitados.clear();
        pila.addLast(vertice);
        while(!pila.isEmpty()){
            V verticeP = pila.removeLast();
            c+=(verticeP)+"\n";
            visitados.add(verticeP);
            ArrayList<V> sucesores = g.sucesores(posicion(g, verticeP));
            sucesores = invertir(sucesores);
            for(V suc: sucesores){
                if(!visitados.contains(suc) && !pila.contains(suc)){
                    pila.addLast(suc);
                }
            }
        }
        return c;
    }
    
    public int posicion(Grafo<V,A> g, V vertice){
        for(int i=0;i<g.orden();i++){
            if(g.obtCiudad(i).equals(vertice)){
                return i;
            }
        }
        return -1;
    }

    public void limpiar() {
        pila.clear();
    }

    private ArrayList<V> invertir(ArrayList<V> sucesores) {
        ArrayList<V> aux = new ArrayList<>();
        for (int i = sucesores.size()-1; i >= 0; i--) {
            aux.add(sucesores.get(i));
        }
        return aux;
    }
}
