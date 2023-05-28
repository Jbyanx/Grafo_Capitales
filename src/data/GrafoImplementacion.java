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
public class GrafoImplementacion<V, A> implements Grafo<V, A> {
    ArrayList<Vertice> vertices = new ArrayList<>();

    @Override
    public void insCiudad(V ciudad) {
        vertices.add(new Vertice(ciudad));
    }

    @Override
    public void insArista(int vi, int vf, A arista) {
        if((vi >= 0 && vi < vertices.size()) && (vf >= 0 && vf < vertices.size()) && vi != vf) 
            vertices.get(vi).addArista(new Arista(vertices.get(vf).getVertice(), arista));
    }

    @Override
    public V obtCiudad(int pos) {
        if(pos >= 0 && pos < vertices.size()) return (V) vertices.get(pos).getVertice();
       return null;
    }

    @Override
    public A obtArista(int vi, int vf) {
        if((vi >= 0 && vi < vertices.size()) && (vf >= 0 && vf < vertices.size())){
            ArrayList<Arista> aux = vertices.get(vi).getAristas();
            for (Arista arista : aux) {
                if(arista.getSucesor().equals(vertices.get(vf).getVertice()))
                    return (A) arista.getCosto();
            }
        }
        return null;
    }

    @Override
    public void elimArista(int vi, int vf) {
        if((vi >= 0 && vi < vertices.size()) && (vf >= 0 && vf < vertices.size())){
            ArrayList<Arista> aux = vertices.get(vi).getAristas();
            for (int i = 0; i < aux.size(); i++) {
                if(aux.get(i).getSucesor().equals(vertices.get(vf).getVertice()))
                    aux.remove(i);
            }
        }
    }

    @Override
    public int orden() {
        return vertices.size();
    }

    @Override
    public ArrayList<V> sucesores(int pos) {
        ArrayList<V> suc = new ArrayList<>();
        if(pos >= 0 && pos < vertices.size()){
            ArrayList<Arista> aux = vertices.get(pos).getAristas();
            for (Arista arista : aux) {
                suc.add((V) arista.getSucesor());
            }
        }
        return suc;
    }

    @Override
    public String mostrar() {
        String con = "";
        for (Vertice vertice : vertices) {
            con += "Vertice: "+vertice.getVertice().toString();
            con += "\nAristas: "+vertice.getAristas().toString()+"\n\n";
        }
        return con;
    }
    
}
