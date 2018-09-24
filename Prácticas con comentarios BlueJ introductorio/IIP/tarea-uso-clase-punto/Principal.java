/**
 * Muestra la distancia al origen de dos puntos 
 * 
 * @version Curso 2018-2019
 */

public class Principal {

    public static void main(String[] args) {

        Punto p1 = new Punto(12,7);
        System.out.println("Coordenadas del Punto 1 :" + p1.toString());
        System.out.println("Distancia del Punto 1 a origen es " + p1.distOrigen() + "\n");
      
        
        Punto p2 = new Punto(24,12);
        System.out.println("Coordenadas del Punto 2 :"+  p2.toString());
        System.out.println("Distancia del Punto 2 a origen es " + p2.distOrigen());
    }
}