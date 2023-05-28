/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import algorithms.Floyd;
import data.Arista;
import data.Grafo;
import datos.GrafoDeCiudades;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        GrafoDeCiudades g = new GrafoDeCiudades();
        g.grafoAviones();
        JOptionPane.showMessageDialog(null,"Grafo creado exitosamente!!!");
        menu(g);
    }

    private static void menu(GrafoDeCiudades g) {
        int op;
        int vi, vf;
        String c;
        
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido\n"
                    + "1.$Consultar los datos de una ciudad$\n"//excelente
                    + "2.$Costo y Ruta minima entre dos ciudades$\n"
                    + "3.$Dada una ciudad decir los Tiempos hacia las demas ciudades$\n"
                    + "4.$Dada una ciudad hasta donde se puede llegar$\n"//excelente
                    + "5.Distancia Mas larga entre dos ciudades\n"
                    + "6.$Aislar ciudad por daño en el aeropuerto$\n"//excelente
                    + "7.Dada una ciudad reconectar como estaba antes\n"
                    + "8.$Listar todo$\n"//excelente
                    + "0.$Salir$"));//excelente
            
            switch(op){
                case 0:
                    JOptionPane.showMessageDialog(null,"Adios! vuelva pronto...");
                    break;
                case 1:
                    int ciudadPos = Integer.parseInt(JOptionPane.showInputDialog("Digite la posición de la ciudad a consultar: "));
                    ArrayList<Arista> aristas = g.getGrafodeaviones().obtAristas(ciudadPos);

                    JTextArea jTextArea = new JTextArea(10, 30);
                    jTextArea.setText("Aristas de la ciudad en la posición " + ciudadPos + ":\n");

                    for (Arista arista : aristas) {
                        jTextArea.append(arista.toString() + "\n");
                    }

                    JScrollPane scrollPane = new JScrollPane(jTextArea);
                    JOptionPane.showMessageDialog(null, scrollPane, "Datos de la ciudad", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    vi = Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion de la ciudad a consultar su costo y ruta minima "));
                    vf = Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion de la ciudad a consultar su costo y ruta minima "));
                    
                    Floyd f = new Floyd(g);
                    double d = f.costoMinimoDistancia(vi, vf);
                    
                    JTextArea j1 = new JTextArea(10,30);
                    
                    j1.setText("El costo minimo es:\n");
                    
                    if ((d == Grafo.inf) || (d == 0)) {
                        j1.append("No hay ruta");
                    } else {
                        c = String.valueOf(d);
                        j1.append(c);
                    }
                    
                    j1.append("\n\nLa ruta minima es:\n");
                    
                    c = f.rutaAvionDistancia(vi, vf);


                    if (c.equals("")) {
                        j1.append("No hay ruta");
                    } else {
                        j1.append(c);
                    }
                    
                    scrollPane = new JScrollPane(j1);
                    
                    JOptionPane.showMessageDialog(null, scrollPane, "Costo y ruta minima", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    vi = Integer.parseInt(JOptionPane.showInputDialog("Digite la posición de la ciudad para consultar los tiempos hacia las demás ciudades: "));

                    ArrayList<Double> tiempos = g.getGrafodeaviones().tiemposHaciaOtrasCiudades(vi);

                    JTextArea j2 = new JTextArea(10, 30);
                    j2.setText("Tiempos hacia las demás ciudades desde la ciudad en la posición " + vi + ":\n");

                    if (tiempos.isEmpty()) {
                        j2.append("No hay ciudades disponibles.");
                    } else {
                        for (int i = 0; i < tiempos.size(); i++) {
                            double tiempo = tiempos.get(i);

                            if (tiempo == Double.POSITIVE_INFINITY) {
                                j2.append("No hay ruta hacia la ciudad en la posición " + i);
                            } else {
                                j2.append("Ciudad en la posición " + i + ": " + tiempo + " horas");
                            }

                            j2.append("\n");
                        }
                    }

                    JScrollPane scrollPane2 = new JScrollPane(j2);

                    JOptionPane.showMessageDialog(null, scrollPane2, "Tiempos hacia las demás ciudades", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 4:
                    vi = Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion de la ciudad a consultar su maximo recorrido"));
                    c = g.profundidad(g, vi);
                    
                    JOptionPane.showMessageDialog(null,"Desde la ciudad en la posicion "+vi+"\n"
                            + "Se puede hacer el siguiente recorrido :\n"+ c);
                    break;
                case 5:
                    
                    break;
                case 6:
                    vi = Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion de la ciudad a aislar"));
                    g.aislarCiudad(vi, g.getGrafodeaviones());
                    JOptionPane.showMessageDialog(null,"Ciudad Aislada exitosamente!!!");
                    break;
                case 7:
                    
                    break;
                case 8:
                    JTextArea textArea = new JTextArea(20, 50);
                    textArea.setText(g.mostrar(g.getGrafodeaviones()));

                    // Crear un JScrollPane y agregar el JTextArea
                    scrollPane = new JScrollPane(textArea);

                    // Establecer el JTextArea dentro del JOptionPane
                    JOptionPane.showMessageDialog(null, scrollPane, "grafo", JOptionPane.INFORMATION_MESSAGE);
                    
                    //JOptionPane.showMessageDialog(null, "Grafo:\n"+g.mostrar(g.getGrafodeaviones()));
                    
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion invalida, intente nuevamente");
                    break;    
            }
            
        } while(op != 0);
    }
}
