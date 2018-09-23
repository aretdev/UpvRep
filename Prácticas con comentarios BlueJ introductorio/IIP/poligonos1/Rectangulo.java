/**
 * Define un rectangulo de determinadas base y altura
 * 
 * @version Curso 2018-19
 */

class Rectangulo {

    double base;
    double altura;

    /** Crea un rectangulo de base b, altura a */
    Rectangulo(double b, double a) {
        base = b; 
        altura = a; 
    }

    /** Devuelve el area del Rectangulo */
    double area() { 
        return base * altura; 
    }

    /** Devuelve el perimetro del Rectangulo */
    double perimetro() { 
        return 2 * (base + altura); 
    }

}
