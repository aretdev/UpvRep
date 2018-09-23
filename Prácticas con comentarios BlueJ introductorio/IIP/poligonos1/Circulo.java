/** 
 * Define un círculo de un determinado radio
 *  
 * @version Curso 2018-19
*/ 

class Circulo {

    double radio; 
    
    /** Crea un Circulo de radio r */
    Circulo(double r)  {
        radio = r;  
    }
    
    /** Devuelve el area del Circulo */
    double area() { 
        return 3.14 * radio * radio; 
    }  
    
    /** Devuelve el perimetro del Circulo */
    double perimetro() { 
        return 2 * 3.14 * radio; 
    }
    
}