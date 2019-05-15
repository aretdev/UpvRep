package pract5;
/**
 * Clase PolygonGroup. Grupo de poligonos en el plano.
 * Los poligonos estan en orden segun la secuencia en que se añaden
 * al grupo, de manera que se considera que cada poligono esta mas 
 * arriba en el grupo que los poligonos anteriores, o dicho de otro 
 * modo, se superpone a los anteriores. 
 * Se supone que el orden del grupo da la secuencia en que se dibujan
 * los poligonos, de manera que cada uno se dibuja por encima de los
 * anteriores, superponiendose a aquellos con los que solape.
 * 4r3T
 * Ademas de añadir poligonos al grupo, se puede seleccionar un poligono
 * para eliminarlo, para trasladar sus coordenadas en el plano, o para
 * cambiar su posicion relativa en el grupo: llevarlo al frente (arriba 
 * del todo), llevarlo al fondo (debajo del todo), ...
 * 
 * La manera de seleccionar el poligono a mover en el grupo, es dando un
 * punto visible del poligono, es decir, dando un punto que no pertenezca
 * a los poligonos que aparecen superpuestos en el dibujo.
 *
 * @author PRG - Practica 5
 * @version Curso 2018/19
 */
public class PolygonGroup {    
    private static NodePol front , back;
    private static int size;
    
    /**
     * Crea un grupo de 0 poligonos.
     */
    public PolygonGroup() {
        this.size = 0;
        this.front = null;
        this.back = null;
    }
    
    /** Añade al grupo, arriba del todo, un poligono dado. 
     *  @param pol Polygon, el poligono.
     */
    public void add(Polygon pol) {
        NodePol polygon = new NodePol(pol, front);
        if(size == 0) {back = polygon;}
        this.front = polygon;
        size++;
    }
    
    /** Devuelve el numero de poligonos del grupo,  
     *  esto es, la talla del grupo.
     *  return int, la talla.
     */
    public int getSize() { 
        return this.size;
    }
    
    /** Devuelve un array con la secuencia de poligonos del grupo, 
     *  por orden desde el de mas abajo al de mas arriba.
     *  @return Polygon[], el array.
     */
    public Polygon[] toArray() {
        Polygon[] result = new Polygon[size];
        NodePol aux = front;
        for (int i = size - 1; i >= 0; i--) {
            result[i] = aux.data;
            aux = aux.next;
        }
        return result;
    } 
        
    /** Busca en el grupo descendentemente, de mas arriba
     *  a mas abajo, el primer poligono que contiene a un 
     *  punto dado. Devuelve un array de NodePol tal que:
     *  - la componente 1 es el nodo con el poligono que contiene 
     *    a p (null si no hubiera ninguno)
     *  - la componente 0 es el nodo anterior (null si no está definido).
     *  @param p Point, el punto.
     *  @return NodePol[], el array resultado.
     */
    private NodePol[] search(Point p) {
        NodePol auxPunto = this.front, auxPrev = null;
        while(auxPunto != null && !auxPunto.data.inside(p)) {
            auxPrev = auxPunto;
            auxPunto = auxPunto.next;
        }
        NodePol[] result = {auxPrev, auxPunto};
        return result;
        
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
        NodePol[] polys = this.search(p);
        if(polys[1] != null) {
        NodePol mark = polys[1];
        mark.data.translate(incX, incY); } 
    }
    /** Elimina del grupo el poligono seleccionado 
     *  mediante el punto p. El metodo no hace nada si no 
     *  hay ningun poligono que contenga a p.
     *  @param p Point, el punto.
     */
    public void remove(Point p) {
        NodePol[] polys = this.search(p);
        if(polys[1] != null) { 
            NodePol pointing = polys[1] , prev = polys[0];
            
            if(pointing == back){back = prev;}
            else if(pointing == front){front = pointing.next; }
            else{prev.next = pointing.next;}
            pointing = null;
            size--;
        }
    }
    
    /** Situa al frente del grupo el poligono seleccionado 
     *  mediante el punto p. El metodo no hace nada si no 
     *  hay ningun poligono que contenga a p.
     *  @param p Point, el punto.
     */
    public void toFront(Point p) {
        NodePol[] polys = this.search(p);
        if(polys[1] != null && polys[1] != this.front) {// Si ya esta front para que ejecutar
            NodePol pointing = polys[1] , prev = polys[0];
            prev.next = pointing.next;
            pointing.next = this.front;
            this.front = pointing;
            if(pointing == this.back) {back = prev; prev.next = null;} // En el caso que desplacemos el ultimo elemento , el prev será el nuevo back.
        }
        
    }
    /** Situa al fondo del grupo el poligono seleccionado 
     *  mediante el punto p. El metodo no hace nada si no 
     *  hay ningune poligono que contenga a p.
     *  @param p eePoint, el punto.
     */
    public void toBack(Point p) {
        NodePol[] polys = this.search(p);
        if(polys[1] != null && polys[1] != this.back) {// Si ya esta back para que ejecutar
            NodePol pointing = polys[1] , prev = polys[0];
            if(prev != null) {prev.next = pointing.next; } // si prev == null (pointing == front), el prev es null , generaría un error
            else if(prev == null) {front = pointing.next;} // Al serlo , el nuevo front sería el siguiente.
            this.back.next = pointing;
            this.back = pointing;
            pointing.next = null;
        }
    }
    

}
