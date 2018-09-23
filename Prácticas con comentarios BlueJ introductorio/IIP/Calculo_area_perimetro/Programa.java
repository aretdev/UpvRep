
/** Informa, a partir de un rectángulo y de un círculo qué área de ambos es la mayor */

public class Programa {

    public static void main(String[] args) {
        //Círculo
        double radioCirc = 10;
        
        double perimetroCirc = 2 * 3.14 * radioCirc;
        System.out.println("El perímetro del  círculo es " + perimetroCirc);
        
        double areaCirc = 3.14 * radioCirc * radioCirc;
        System.out.println("El área del círculo es " + areaCirc );
        
        
        //rectángulo
        double ladoRectA = 20; 
        double ladoRectB = 10;
        
        double perimetroRect = ladoRectA * 2 + ladoRectB * 2;
        System.out.println("El perímetro del  rectángulo es " + perimetroRect);
        
        double areaRect = ladoRectA * ladoRectB;
        System.out.println("El área del rectángulo es " + areaRect);
        
        
        //Cuadrado
        double ladoCuadr = 5;
        
        double perimetroCuadr = ladoCuadr * 4;
        System.out.println("El perímetro del  cuadrado es " + perimetroCuadr);
        
        double areaCuadr = ladoCuadr * ladoCuadr;
        System.out.println("El área del  cuadrado es " + areaCuadr);
        
       
        //Triángulo Rectángulo
        double ladoTriA = 10;
        double ladoTriB = 8;
        double ladiTriC = Math.sqrt( (ladoTriA*ladoTriA) + (ladoTriB*ladoTriB) );
        
        double perimetroTri = ladoTriA + ladoTriB + ladiTriC;
        System.out.println("El perímetro del  Triángulo Rectángulo es " + perimetroTri);
        
        double areaTri = (ladoTriA*ladoTriB)/2;
        System.out.println("El área del  Triángulo Rectángulo es " + areaTri);
        
    }
}
