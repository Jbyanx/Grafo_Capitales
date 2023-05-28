/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public interface Grafo<V, A> {
    void insCiudad(V ciudad);
    void insArista(int vi, int vf, A arista);
    V obtCiudad(int pos);
    A obtArista(int vi, int vf);
    void elimArista(int vi, int vf);
    int orden();
    ArrayList<V> sucesores(int pos);
    String mostrar();
    
    double inf = 999999.0;
}
