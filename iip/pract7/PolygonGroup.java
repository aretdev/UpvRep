package pract7;

import pract5.Point;
/**
 * Clase PolygonGroup. Grupo de poligonos en el plano.
 * Los poligonos estan en orden segun la secuencia en que se añaden
 * al grupo, de manera que se considera que cada poligono esta mas 
 * arriba en el grupo que los poligonos anteriores, o dicho de otro 
 * modo, se superpone a los anteriores. 
 * Se supone que el orden del grupo da la secuencia en que se dibujan
 * los poligonos, de manera que cada uno se dibuja por encima de los
 * anteriores, superponiendose a aquellos con los que solape.
 * 
 * Ademas de añadir poligonos al grupo, se puede seleccionar un poligono
 * para eliminarlo, para trasladar sus coordenadas en el plano, o para
 * cambiar su posicion relativa en el grupo: llevarlo al frente (arriba 
 * del todo), llevarlo al fondo (debajo del todo), ...
 * 
 * La manera de seleccionar el poligono a mover en el grupo, es dando un
 * punto visible del poligono, es decir, dando un punto que no pertenezca
 * a los poligonos que aparecen superpuestos en el dibujo.
 *
 * @author IIP - Practica 7
 * @version Curso 2018/19
 */




public class PolygonGroup {
public static final int MAX = 10;
private Polygon[] group;
private int size = 0;
    /**
     * Crea un grupo de 0 poligonos.
     */
    public PolygonGroup() {
        group = new Polygon[MAX];
        
    }
    
    /** Añade al grupo, arriba del todo, un poligono dado. 
     *  Si se excede la capacidad del grupo, el poligono 
     *  no se añade.
     *  @param pol Polygon, el poligono.
     */
    public void add(Polygon pol) {
        if(size != MAX) {
            group[size] = pol;
            size++;
        }
    }
    
    /** Devuelve el numero de poligonos del grupo,  
     *  esto es, la talla del grupo.
     *  return int, la talla.
     */
    public int getSize() { return size; }
    
    /** Elimina del grupo el poligono seleccionado 
     *  mediante el punto p. El metodo no hace nada si no 
     *  hay ningun poligono que contenga a p.
     *  @param p Point, el punto.
     */
    public void remove(Point p) {
        if(search(p) != -1) {
        for (int j = search(p); j < size - 1;j++) {
            group[j] = group[j + 1];
        }
        size--;
    }
    }
    /** Busca en el grupo descendentemente, de mas arriba
     *  a mas abajo, el primer poligono que contiene a un 
     *  punto dado, devolviendo su posicion en el grupo.
     *  Si no existe, devuelve -1.
     *  @param Point p, el punto.
     *  
     *  @return int, posicion en el grupo del poligono que  
     *  contiene al punto o -1 si no existe.
     */
    private int search(Point p) {
        for(int i = size - 1; i >= 0; i--) {
            if(group[i].inside(p) == true) {return i;}
        }
        return -1;
    }
    
    /** Situa al frente del grupo el poligono seleccionado 
     *  mediante el punto p. El metodo no hace nada si no 
     *  hay ningun poligono que contenga a p.
     *  @param p Point, el punto.
     */
    public void toFront(Point p) {
       if(search(p) != -1) {
       Polygon front = group[search(p)];
       for(int i = search(p); i < size - 1; i++) {
           group[i] = group[i + 1];
       }
       group[size - 1] = front;
    }
    }    
    /** Situa al fondo del grupo el poligono seleccionado 
     *  mediante el punto p. El metodo no hace nada si no 
     *  hay ningun poligono que contenga a p.
     *  @param p Point, el punto.
     */
    public void toBack(Point p) {
       if(search(p) != -1) {
       Polygon back = group[search(p)];
       for(int i = search(p); i > 0 ; i--) {
           group[i] = group[i - 1];
        }
       group[0] = back; 
    }
    }
    /** Traslada en el plano el poligono seleccionado 
     *  mediante el punto p. Las abscisas y las ordenadas 
     *  de sus vertices se incrementan o decrementan en dos 
     *  valores dados. El metodo no hace nada si no 
     *  hay ningun poligono que contenga a p.
     *  @param p Point, el punto.
     *  @param incX double, el incremento o decremento de las abscisas.
     *  @param incY double, el incremento o decremento de las ordenadas.
     */
    public void translate(Point p, double incX, double incY) {
        if(search(p) != -1) {group[search(p)].translate(incX, incY);}
    }
    
    /** Devuelve un array con la secuencia de poligonos del grupo, 
     *  por orden desde el de mas abajo al de mas arriba.
     *  @return Polygon[], el array.
     */
    public Polygon[] toArray() {
        Polygon[] res = new Polygon[size];
        for(int i = 0; i < size; i++) {
            res[i] = group[i];
        }
        return res;
    } 
}
