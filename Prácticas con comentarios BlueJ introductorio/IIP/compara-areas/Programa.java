
/** Informa, a partir de un rectángulo y de un círculo qué área de ambos es la mayor */

public class Programa {

    public static void main(String[] args) {

        double baseDelRectangulo = 30;
        double alturaDelRectangulo = 10;

        double radioDelCirculo = 10;
        
        double areaDelRectangulo = baseDelRectangulo * alturaDelRectangulo;
        double areaDelCirculo =  3.14 * radioDelCirculo * radioDelCirculo;
         
        if (areaDelRectangulo > areaDelCirculo) {
            System.out.println("El área del rectángulo es mayor que la del círculo");
			
        } else if (areaDelCirculo > areaDelRectangulo) {
            System.out.println("El área del círculo es mayor que la del rectángulo");
			
        } else {
            System.out.println("El área del rectángulo y la del círculo son iguales");
        }
    }
}
