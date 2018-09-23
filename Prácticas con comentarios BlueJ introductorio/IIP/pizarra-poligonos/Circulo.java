/** 
 * Clase Circulo: define un circulo de un determinado radio, color y
 * posicion de su centro, con la funcionalidad que aparece a continuacion
 *  
 * @version Curso 2016-17
*/ 

public class Circulo {

    private double radio; 
    private String color; 
    private int centroX, centroY;   
    
    /** Crea un Circulo de radio r, color c y centro en (x, y) */
    public Circulo(double r, String c, int x, int y)  {
        radio = r;  
        color = c; 
        centroX = x; centroY = y; 
    }
    
    /** Crea un Circulo por defecto (estandar), i.e. de radio 50.0, color negro 
     *  y centro en (100, 100) */
    public Circulo() {
        radio = 50.0; 
        color = "negro"; 
        centroX = 100;  centroY = 100; 
    }  

    /** Devuelve el radio del Circulo */
    public double getRadio() { return radio; }  
    
    /**  Devuelve el color del Circulo */
    public String getColor() { return color; }  
    
    /**  Devuelve la abscisa del centro del Circulo */
    public int getCentroX() { return centroX; }  
    
    /** Devuelve la ordenada del centro del Circulo */
    public int getCentroY() { return centroY; }
 
    /** Actualiza el radio del Circulo a nuevoRadio */
    public void setRadio(double nuevoRadio) { radio = nuevoRadio; }   
    
    /** Actualiza el color del Circulo a nuevoColor */
    public void setColor(String nuevoColor) { color = nuevoColor; }   
    
    /** Actualiza el centro del Circulo a (nuevoCentroX, nuevoCentroY) */
    public void setCentro(int nuevoCentroX, int nuevoCentroY) { 
        centroX = nuevoCentroX; centroY = nuevoCentroY; 
    }  
    /** Desplaza el centro del Circulo 10 unidades a la derecha */
    public void aLaDerecha() { centroX = centroX + 10; }   
    
    /** Incrementa un 30% el radio del Circulo */
    public void crece() { radio = radio * 1.3; }    
    
    /** Decrementa un 30% el radio del Circulo */
    public void decrece() { radio = radio / 1.3; }      
  
    /** Devuelve el area del Circulo */
    public double area() { return 3.14 * radio * radio; }  
    
    /** Devuelve el perimetro del Circulo */
    public double perimetro() { return 2 * 3.14 * radio; }
    
    /** Devuelve un String con las componentes del Circulo en el
     *  siguiente formato: Circulo de radio r, color c y centro (x, y) */
    public String toString() { 
        return "Circulo de radio " + radio + ", color " + color
               + " y centro (" + centroX + ", " + centroY + ")";
    }
}