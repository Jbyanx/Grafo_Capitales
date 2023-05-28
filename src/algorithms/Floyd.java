/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms;

import datos.GrafoDeCiudades;
import data.Grafo;

/**
 *
 * @author HP
 */
public class Floyd {
    private double floyd[][];
    private int ruta[][];
    GrafoDeCiudades g;
    
    public Floyd(GrafoDeCiudades g){
        this.g = g;
        int n = g.getGrafodeaviones().orden();
        
        floyd = new double[n][n];
        ruta = new int[n][n];
        
        for(int i = 0; i < floyd.length; i++){
            for(int j = 0; j < floyd.length; j++){
                if(i!=j){
                    if(g.getGrafodeaviones().obtArista(i, j)==null){
                        floyd[i][j] = Grafo.inf;
                    }else{
                        floyd[i][j] = g.getGrafodeaviones().obtArista(i, j).getDistancia();
                    }
                    ruta[i][j] = -1;
                }
                
                
            }
        }
        caminominimoAvionDistancia();
    }
    
    public double costoMinimoDistancia(int i, int j){
        return floyd[i][j];
    }
    
    private void caminominimoAvionDistancia() {
        for(int k = 0; k < floyd.length; k++){
            for(int i = 0; i < floyd.length; i++){
                for(int j = 0; j < floyd.length; j++){
                    
                    if(floyd[i][k] + floyd[k][j] < floyd[i][j]){
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                        ruta[i][j] = k;
                    }
                    
                }
            }
        }
    }
    
    public String rutaAvionDistancia(int i, int j){
        String c="";
        int k = ruta[i][j];
        if(k != -1){
            rutaAvionDistancia(i, k);
            c+=" "+g.getGrafodeaviones().obtCiudad(k).toString();
            rutaAvionDistancia(k, j);
        }
        return c;
    }
    public String mostrar(){
        String l="";
        for (int i = 0; i < floyd.length; i++) {
            for (int j = 0; j < floyd.length; j++) {
                l+=" "+floyd[i][j];
                
            }
            l+="\n";
        }
        return l;
    }
    
}
