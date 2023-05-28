package datos;

import algorithms.BFS;
import algorithms.DFS;
import algorithms.arista;
import data.GrafoImplementacion;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class GrafoDeCiudades {
    private GrafoImplementacion<String, arista> grafodeaviones = new GrafoImplementacion<>();
    
    public GrafoImplementacion<String, arista> getGrafodeaviones() {
        return grafodeaviones;
    }

    public void setGrafodeaviones(GrafoImplementacion<String, arista> grafodeaviones) {
        this.grafodeaviones = grafodeaviones;
    }

    /*DATA INSERCTION*/
    
    public void grafoAviones(){
        //---------------VERTICES O CIUDADES----------------
        grafodeaviones.insCiudad("Bogotá");
        grafodeaviones.insCiudad("Londres");
        grafodeaviones.insCiudad("París");
        grafodeaviones.insCiudad("Tokio");
        grafodeaviones.insCiudad("Roma");
        grafodeaviones.insCiudad("Ciudad de México");
        grafodeaviones.insCiudad("Madrid");
        grafodeaviones.insCiudad("Berlín");
        grafodeaviones.insCiudad("Pekín");
        grafodeaviones.insCiudad("Sídney");
        grafodeaviones.insCiudad("Atenas");
        grafodeaviones.insCiudad("Nueva York");
        grafodeaviones.insCiudad("Río de Janeiro");
        grafodeaviones.insCiudad("El Cairo");
        grafodeaviones.insCiudad("Moscú");
        grafodeaviones.insCiudad("Toronto");
        grafodeaviones.insCiudad("Nueva Delhi");
        grafodeaviones.insCiudad("Bangkok");
        grafodeaviones.insCiudad("Estambul");
        grafodeaviones.insCiudad("Sidney");
        
        //---------------ARISTAS----------------
        grafodeaviones.insArista(0, 1, new arista(250.50, 5.5, 8000));
        grafodeaviones.insArista(0, 2, new arista(350.25, 9.75, 9000));
        grafodeaviones.insArista(1, 3, new arista(450.75, 11.25, 9500));
        grafodeaviones.insArista(2, 3, new arista(300.60, 7.8, 7500));
        grafodeaviones.insArista(3, 4, new arista(200.35, 4.5, 6000));
        grafodeaviones.insArista(1, 4, new arista(380.50, 8.25, 8200));
        grafodeaviones.insArista(1, 5, new arista(420.75, 9.5, 8400));
        grafodeaviones.insArista(2, 4, new arista(310.25, 7.75, 8900));
        grafodeaviones.insArista(2, 6, new arista(380.60, 8.8, 8600));
        grafodeaviones.insArista(3, 5, new arista(250.35, 6.5, 7200));
        grafodeaviones.insArista(3, 6, new arista(290.20, 6.75, 7800));
        grafodeaviones.insArista(4, 7, new arista(200.40, 4.25, 5500));
        grafodeaviones.insArista(5, 8, new arista(320.80, 7.75, 8700));
        grafodeaviones.insArista(6, 9, new arista(410.90, 9.25, 9200));
        grafodeaviones.insArista(7, 10, new arista(240.45, 5.5, 6300));
        grafodeaviones.insArista(8, 11, new arista(280.55, 6.75, 7400));
        grafodeaviones.insArista(9, 12, new arista(380.70, 8.5, 8100));
        grafodeaviones.insArista(10, 13, new arista(400.30, 9.5, 8900));
        grafodeaviones.insArista(11, 14, new arista(220.65, 5.25, 6100));
        grafodeaviones.insArista(12, 15, new arista(340.95, 7.75, 9300));

    }
    
    
    public String mostrar(GrafoImplementacion g) {
        return g.mostrar();
    }
    
    public void aislarCiudad(int pos, GrafoImplementacion g){
        for (int i = 0; i < g.orden(); i++) {
            g.elimArista(i, pos);
            g.elimArista(pos, i);
        }
        JOptionPane.showMessageDialog(null,"Ciudad Aislada correctamente");
    }
    
    public String ciudadConMasSalida(GrafoImplementacion g){
        String aux = "";
        int mayor = 0;
        for (int i = 0; i < g.orden(); i++) {
            if(g.sucesores(i).size()>mayor){
                aux = g.obtCiudad(i).toString();
                mayor = g.sucesores(i).size();
            }
            
        }
        return aux;
    }
    
    public String profundidad(GrafoDeCiudades g, int pos){
        String c="";
        c+="\n\nMaximo recorrido desde: ";
        DFS recorridoAnchura =new DFS();
        c += recorridoAnchura.profundidad(g.grafodeaviones, g.grafodeaviones.obtCiudad(pos))+"\n";
        recorridoAnchura.limpiar();
        c += "\n"+recorridoAnchura.profundidadPila(grafodeaviones, grafodeaviones.obtCiudad(pos));
        
        return c;
    }
    
    public String anchura(GrafoDeCiudades g, int pos){
        BFS recorridoAnchura =new BFS();
        recorridoAnchura.limpiar();
        
        return recorridoAnchura.anchura(g.grafodeaviones, g.grafodeaviones.obtCiudad(pos));
    }
}
