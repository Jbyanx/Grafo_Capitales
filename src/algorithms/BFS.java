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
public class BFS<V,A> {
    public HashSet<V> visitados = new HashSet<>();
    public LinkedList<V> cola = new LinkedList<>();
    
    public void limpiar(){
        visitados.clear();
    }
    
    public String anchura(Grafo<V, A> g, V vertice){
        String c = "";
        DFS profundidad = new DFS();
        cola.addLast(vertice);
        while(!cola.isEmpty()){
            V verticeP = cola.removeFirst();
            c+=(verticeP.toString())+"\n";
            visitados.add(verticeP);
            ArrayList<V> sucesores = g.sucesores(profundidad.posicion(g, verticeP));    
            for(V suc: sucesores){
                if(!visitados.contains(suc)){
                    cola.addLast(suc);
                }
            }
        }
        return c;
    }    
}
