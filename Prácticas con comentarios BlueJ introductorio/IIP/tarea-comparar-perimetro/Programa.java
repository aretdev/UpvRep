
/** Informa, a partir de un rectángulo y de un círculo qué perímetro de ambos es la mayor */

public class Programa {

    public static void main(String[] args) {

        double ladoRectA = 30;
        double ladoRectB = 20;
        

        double radioDelCirculo = 10;
        
        double perimetroRect = (ladoRectA * 2)+ (ladoRectB * 2);
        double perimetroCirculo =2 * 3.14 * radioDelCirculo;
         
        if (perimetroRect > perimetroCirculo) {
            System.out.println("El perímetro del rectángulo es mayor que la del círculo");
			
        } else if (perimetroCirculo > perimetroRect) {
            System.out.println("El perímetro del círculo es mayor que la del rectángulo");
			
        } else {
            System.out.println("El perímetro del rectángulo y la del círculo son iguales");
        }
    }
}
