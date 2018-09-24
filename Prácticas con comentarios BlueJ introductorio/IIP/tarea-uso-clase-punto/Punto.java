/** 
 *  Clase Punto: define puntos en un espacio bidimensional entero 
 *  con la funcionalidad que se indica a continuacion.
 *  @author Libro IIP-PRG
 *  @version 2016
 */
public class Punto {
    private int x; // abscisa del punto
    private int y; // ordenada del punto
    
    /** Crea un Punto (abs, ord). */
    public Punto(int abs, int ord) { x = abs; y = ord; }  
	
    /** Crea un punto (0, 0). */
    public Punto() { this(0, 0); }

    /** Devuelve la abscisa del Punto. */
    public int getX() { return x; }
    
    /** Devuelve la ordenada del Punto. */
    public int getY() { return y; }

    /** Actualiza la abscisa del Punto a nuevaX. */
    public void setX(int nuevaX) { x = nuevaX; }

    /** Actualiza la ordenada del Punto a nuevaY. */
    public void setY(int nuevaY) { y = nuevaY; }
    
    /** Actualiza las cooordenadas del Punto a nuevaX y nuevaY. */
    public void asignar(int nuevaX, int nuevaY) { x = nuevaX; y = nuevaY; }
   
    /** Devuelve la distancia del Punto al origen. */
    public double distOrigen() { return Math.sqrt(x * x + y * y); }
    
    /** Devuelve un String con las coordenadas del punto en el formato  
     *  matemático habitual: (abscisa, ordenada).  */
    public String toString() { return "(" + x + ", " + y + ")"; }
}
