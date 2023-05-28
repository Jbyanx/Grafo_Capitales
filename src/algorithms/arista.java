/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms;

/**
 *
 * @author HP
 */
public class arista {
    private double precio;
    private double tiempo;
    private double distancia;

    public arista(double precio, double tiempo, double distancia) {
        this.precio = precio;
        this.tiempo = tiempo;
        this.distancia = distancia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "arista{" + "precio=" + precio + ", tiempo=" + tiempo + ", distancia=" + distancia + '}';
    }
    
}
