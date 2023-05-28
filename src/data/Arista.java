/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author HP
 */
public class Arista<V, A> {
    private V sucesor;
    private A costo;

    public Arista(V vertice, A costo) {
        this.sucesor = vertice;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Arista{" + "sucesor=" + sucesor + ", costo=" + costo + '}';
    }

    public V getSucesor() {
        return sucesor;
    }

    public void setSucesor(V vertice) {
        this.sucesor = vertice;
    }

    public A getCosto() {
        return costo;
    }

    public void setCosto(A costo) {
        this.costo = costo;
    }
}
