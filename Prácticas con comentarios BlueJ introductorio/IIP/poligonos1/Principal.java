/**
 * Informa, a partir de un rectángulo y de un círculo qué área de ambos es la mayor 
 * 
 * @version Curso 2018-2019
 */

public class Principal {

    public static void main(String[] args) {

        // Crea un Rectangulo de base 30 y altura 20
        Rectangulo r1 = new Rectangulo(30, 20);

        // Crea un Circulo de radio 10
        Circulo c1 = new Circulo(10);

        double areaDelRectangulo = r1.area();
        double areaDelCirculo =  c1.area();

        if (areaDelRectangulo > areaDelCirculo) {
            System.out.println("El área del rectángulo es mayor que la del círculo");
        } else if (areaDelCirculo > areaDelRectangulo) {
            System.out.println("El área del círculo es mayor que la del rectángulo");
        } else {
            System.out.println("El área del rectángulo y la del círculo son iguales");
        }

        double perimetroDelRectangulo = r1.perimetro();
        double perimetroDelCirculo =  c1.perimetro();

        if (perimetroDelRectangulo > perimetroDelCirculo) {
            System.out.println("El perímetro del rectángulo es mayor que el del círculo");
        } else if (perimetroDelCirculo > perimetroDelRectangulo) {
            System.out.println("El perímetro del círculo es mayor que el del rectángulo");
        } else {
            System.out.println("El perímetro del rectángulo y el del círculo son iguales");
        }

    }
}