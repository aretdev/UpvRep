import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase Pizarra: define una pizarra sobre la que se pueden dibujar 
 * circulos y rectangulos
 * 
 * @version Curso 2016 - 2017
 */

public class Pizarra extends JFrame {  
      
    // Elementos por defecto de la Pizarra:
    private static int DIM_X = 200;
    private static int DIM_Y = 200;
    private static int NUM_MIN = 8;
    
    // Constantes figuras posibles
    private static final int DESCONOCIDO = -1;
    private static final int CIRCULO = 0;
    private static final int RECTANGULO = 1;
    private static final Color COLOR_POR_DEFECTO = Color.black;
    
    // Constantes arrays de colores
    private static final String[] NOM_COLS = {"rojo", "amarillo", "verde", 
                                              "azul", "naranja", "negro", 
                                              "blanco", "gris", "rosa"};
            
    private static final Color[] COLS = {Color.red, Color.yellow, Color.green, 
                                         Color.blue, Color.orange, Color.black, 
                                         Color.white, Color.gray, Color.pink};
    
    // Atributos almacen objetos graficos
    private Object[] gOL = new Object[NUM_MIN];
    private int numGO = 0;
             
    /** Crea una Pizarra con titulo t, tamagno ancho x alto (pixeles) 
     *  y vacia, sin dibujos */   
    public Pizarra(String t, int ancho, int alto) {
        super(t);
        setSize(ancho, alto);
        setContentPane(initPanel());    
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /** Crea una Pizarra por defecto (estandar), i.e. de titulo  
     *  "La pizarra por defecto", tamagno 200 x 200 (pixeles)  
     *  y vacia, sin dibujos */         
    public Pizarra() {
        super("La pizarra por defecto");
        setSize(DIM_X, DIM_Y);
        setContentPane(initPanel());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /** Agnade el objeto o (circulo o rectangulo) a la Pizarra y lo dibuja */
    public void add(Object o) {
        if (numGO == gOL.length) { dupMem(); }
        gOL[numGO++] = o;
        repaint();
    }
    
    /** Vuelve a dibujar todos los objetos que hay en la Pizarra, 
     *  actualizando su estado */
    public void dibujaTodo() { repaint(); }
    
    private void dupMem() {
        Object[] aux = new Object[2 * gOL.length];
        for (int i = 0; i < gOL.length; i++) { aux[i] = gOL[i]; }
        gOL = aux;
    }
           
    private JPanel initPanel() {
        JPanel jp = new JPanel() {           
            // sobreescritura de paintComponent
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                for (int i = 0; i < numGO; i++) {
                    int tipo = tipoClase(gOL[i]);
                                        
                    switch (tipo) {                         
                        case CIRCULO: 
                            dibCirculo(gOL[i], g); 
                            break;                        
                        case RECTANGULO: 
                            dibRectangulo(gOL[i], g); 
                            break;                                        
                        default: 
                            break;
                    } 
                    
                }                
            };            
        };
        return jp;
    } 
    
    private int tipoClase(Object o) {
        if (o instanceof Circulo) { return CIRCULO; }
        else if (o instanceof Rectangulo) { return RECTANGULO; }        
        else { return DESCONOCIDO; }
    }
    
    private Color elColor(String c) {
        int i = 0;
        for (; i < NOM_COLS.length 
               && !NOM_COLS[i].equalsIgnoreCase(c); i++) { ; }
        
        if (i >= NOM_COLS.length) { return COLOR_POR_DEFECTO; }
        else { return COLS[i]; }
    }    
    
    /* ***************************************************************** */
    /*             Metodos para dibujar cada tipo de figura.             */
    /* ***************************************************************** */    
    
    private void dibCirculo(Object o, Graphics g) {
        Circulo c = (Circulo) o;
        
        int rad = (int) Math.round(c.getRadio());
        int diametro = (int) Math.round(c.getRadio() * 2.0);
        int cX = c.getCentroX();
        int cY = c.getCentroY();
        
        g.setColor(elColor(c.getColor()));        
        g.fillOval(cX - rad, cY - rad, diametro, diametro); 
    }        
       
    private void dibRectangulo(Object o, Graphics g) {
        Rectangulo r = (Rectangulo) o;
        
        int base = (int) Math.round(r.getBase());
        int altura = (int) Math.round(r.getAltura());
        int semibase = (int) Math.round(r.getBase() / 2.0);
        int semialtura = (int) Math.round(r.getAltura() / 2.0);        
        
        int esqX = r.getCentroX() - semibase;
        int esqY = r.getCentroY() - semialtura;
        
        g.setColor(elColor(r.getColor()));
        g.fillRect(esqX, esqY, base, altura);
    }  
}
