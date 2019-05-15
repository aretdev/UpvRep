  
 
// Importa la classe Graph2D (en el paquete graph2D).
import graph2D.Graph2D;
// Importa la classe Color (en el paquete java.awt) para poder
// cambiar los colores de los elementos que se representen.
import java.awt.Color;
import java.awt.Font;
/**
 * Dibujo de figuras "Recursive Square".
 * De "Introduction to Programming in Java",
 * Sedgewick & Wayne, Princeton.
 * @author IIP-PRG-DSIC-ETSINF. pmarques
 * @version Curso 2018-19
 */
public class RSquare {
    
    /** No hay objetos de esta clase. */
    private RSquare() { }
    
    /** Dibuja en la ventana gd un cuadrado solido de color gris y enmarcado
     *  en azul, con centro en (cX, cY) y lado l.
     */
    public static void drawCentSquare(Graph2D gd, 
                                      double cX, double cY, double l) {
        delay();                                           
        // Calculo de la esquina superior izquierda (luX, luY) del cuadrado
        // a partir de su centro (cX, cY) y del lado l:
        double luX =cX - (l / 2); // COMPLETAR
        double luY =cY + (l / 2); // COMPLETAR
        
        // Dibujo de un rectangulo solido de color gris, de lados l x l, 
        // y cuya esquina superior izquierda se encuentra en (luX, luY):
        gd.fillRect(luX, luY, l, l, Color.LIGHT_GRAY, 2);
        // Dibujo de un rectangulo de color azul, de lados l x l, 
        // y cuya esquina superior izquierda se encuentra en (luX, luY):
        gd.drawRect(luX, luY, l, l, Color.BLUE, 2);
    }
    
    /** Suspende temporalmente la ejecucion durante 100 ms. */
    private static void delay() {
        try { Thread.sleep(100); } catch (Exception e) { ; }
    }
    
    /** Dibuja en la ventana gd una RSquare-A de orden n >= 1, 
     *  con centro en (cX, cY) y cuadrado central de lado l.
     */
    public static void rSquareA(Graph2D gd, int n, 
                                double cX, double cY, double l) {
        if(n == 1) {
            drawCentSquare(gd, cX, cY, l);
            System.out.println("Cuadrado final generado ");
        }else{
            rSquareA(gd,n - 1, cX + l / 2, cY + l / 2, l / 2);
            drawCentSquare(gd, cX + l / 2, cY + l / 2, l / 2);
            
            
            rSquareA(gd,n - 1, cX - l / 2, cY + l / 2, l / 2);
            drawCentSquare(gd, cX - l / 2, cY + l / 2, l / 2);
            
            
            rSquareA(gd,n - 1, cX - l / 2, cY - l / 2, l / 2);
            drawCentSquare(gd, cX - l / 2, cY - l / 2, l / 2);
            
             
            rSquareA(gd,n - 1, cX + l / 2, cY - l / 2, l / 2);
            drawCentSquare(gd, cX + l / 2, cY - l / 2, l / 2);
        }
    } 
    
    /** Dibuja una RSquare-A de orden n >= 1, 
     *  longitud 1 y centrada en (0, 0). 
     */
    public static void rSquareA(int n) {
        String tit = "Cuadrado fractal" + n;

        double minX = -1.0, maxX = 1.0;
        double minY = -1.0, maxY = 1.0;
        
        Graph2D gd = new Graph2D(minX, maxX, minY, maxY);
        gd.setTitle(tit); 
        rSquareA(gd, n, 0, 0, 1);
        drawCentSquare(gd, 0, 0, 1);
    }
    
    /** Dibuja en la ventana gd una RSquare-B de orden n >= 1, 
     *  con centro en (cX, cY) y cuadrado central de lado l.
     */
    public static void rSquareB(Graph2D gd, int n, 
                                double cX, double cY, double l) {
        if(n == 1) {
            drawCentSquare(gd, cX, cY, l);
            System.out.println("Cuadrado final generado ");
        }else{
            drawCentSquare(gd, cX + l / 2, cY + l / 2, l / 2);
            rSquareA(gd,n - 1, cX + l / 2, cY + l / 2, l / 2);
            
            drawCentSquare(gd, cX - l / 2, cY + l / 2, l / 2);
            rSquareA(gd,n - 1, cX - l / 2, cY + l / 2, l / 2);
            
            drawCentSquare(gd, cX - l / 2, cY - l / 2, l / 2);
            rSquareA(gd,n - 1, cX - l / 2, cY - l / 2, l / 2);

            drawCentSquare(gd, cX + l / 2, cY - l / 2, l / 2);
            rSquareA(gd,n - 1, cX + l / 2, cY - l / 2, l / 2);
        }
        
    }     
    
    /** Dibuja una RSquare-B de orden n >= 1, 
     *  longitud 1 y centrada en (0, 0). 
     */
    public static void rSquareB(int n) {
        String tit = "Cuadrado fractal" + n;

        double minX = -1.0, maxX = 1.0;
        double minY = -1.0, maxY = 1.0;
        
        Graph2D gd = new Graph2D(minX, maxX, minY, maxY);
        gd.setTitle(tit); 
        drawCentSquare(gd, 0, 0, 1);
        rSquareB(gd, n, 0, 0, 1);               
    }    
}