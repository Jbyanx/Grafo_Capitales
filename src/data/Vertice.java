/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Vertice<V, A> {
    private V vertice;
    private ArrayList<Arista<V,A>> aristas = new ArrayList<>();

    public Vertice(V vertice) {
        this.vertice = vertice;
    }

    @Override
    public String toString() {
        return "Vertice{" + "vertice=" + vertice + '}';
    }
    
    public void addArista(Arista<V,A> arista){
        aristas.add(arista);
    }
    
    public V getVertice() {
        return vertice;
    }

    public void setVertice(V vertice) {
        this.vertice = vertice;
    }

    public ArrayList<Arista<V, A>> getAristas() {
        return aristas;
    }
}
