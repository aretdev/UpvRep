/**
 * Clase Rectangulo: define un rectangulo de determinados base, altura, color 
 * y posicion de su centro, con la funcionalidad que aparece a continuacion
 * 
 * @version Curso 2016-17
 */

public class Rectangulo {
    
    private double base;
    private double altura;
    private String color;
    private int centroX, centroY;
    
    /** Crea un rectangulo de base b, altura a, color c y centro en (x, y) */
    public Rectangulo(double b, double a, String c, int x, int y) {
        base = b; 
        altura = a; 
        color = c; 
        centroX = x; centroY = y;
    }
    
    /** Crea un rectangulo estandar, i.e. de base 50, altura 30, color negro 
     *  y centro en (100, 100) */
    public Rectangulo() {
        base = 80; 
        altura = 30; 
        color = "negro"; 
        centroX = 100; centroY = 100;
    }

    /** Devuelve la base del Rectangulo */
    public double getBase() { return base; }
    
    /** Devuelve la altura del Rectangulo */
    public double getAltura() { return altura; }  
    
    /** Devuelve el color del Rectangulo */
    public String getColor() { return color; }
    
    /** Devuelve la abscisa del centro del Rectangulo */
    public int getCentroX() { return centroX; }
    
    /** Devuelve la la ordenada del centro del Rectangulo */
    public int getCentroY() { return centroY; }
    
    /** Actualiza a nueva la base del Rectangulo */
    public void setBase(double nueva) { base = nueva; }
    
    /** Actualiza a nueva la altura del Rectangulo */
    public void setAltura(double nueva) { altura = nueva; } 
    
    /** Actualiza a nuevo el color del Rectangulo */
    public void setColor(String nuevo) { color = nuevo; }
    
    /** Actualiza a (x, y) el centro del Rectangulo */
    public void setCentro(int x, int y) { 
        centroX = x; centroY = y; 
    }
    /** Desplaza el centro del Rectangulo 10 unidades a la derecha */
    public void aLaDerecha() { this.centroX += 10; }
    
    /** Incrementa un 30% la base y altura del Rectangulo */
    public void crece() { 
        base = base * 1.3; altura = altura * 1.3; 
    }
    /** Decrementa un 30% la base y altura del Rectangulo */
    public void decrece() { 
        base = base / 1.3; altura = altura / 1.3; 
    }      
    
    /** Devuelve el area del Rectangulo */
    public double area() { return base * altura; }
    
    /** Devuelve el perimetro del Rectangulo */
    public double perimetro() { return 2 * (base + altura); }
    
    /** Devuelve un String con las componentes del Rectangulo en el
     *  formato que figura a continuacion: 
     *  Rectangulo de base b, altura a, color c y centro (x, y) */
    public String toString() {
        String res = "Rectangulo de base " + base;
        res += ", altura " + altura;
        res += ", color " + color + " y centro (" + centroX + "," 
               + centroY + ")";
        return res;
    }
}
