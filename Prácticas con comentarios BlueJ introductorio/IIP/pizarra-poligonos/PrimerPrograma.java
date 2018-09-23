/**
 * Clase PrimerPrograma: PROGRAMA que dibuja en una cierta pizarra 
 * un circulo y dos rectangulos de caracteristicas dadas; para ello, 
 * USA las clases Pizarra, Circulo y Rectangulo 
 * 
 * @version Curso 2016-2017
 */

public class PrimerPrograma {
    
    public static void main(String[] args) {
        
        // Crear la Pizarra miPizarra, de titulo "ESPACIO DIBUJO"
        // y tamaño 300 x 300 píxeles
        Pizarra miPizarra = new Pizarra("ESPACIO DIBUJO", 500, 500); 
        
        // Crear un Circulo c1 de radio 50, amarillo y con centro 
        // en (100, 100)
        Circulo c1 = new Circulo(50, "amarillo", 250, 250);
        Circulo c2 = new Circulo(40, "rojo", 30, 100);
        // Agnadir c1 a miPizarra, dibujandolo
        miPizarra.add(c1);
        miPizarra.add(c2);
        // Crear un Rectangulo r1 30 x 30, azul y con centro
        // en (125, 125)
        Rectangulo r1 = new Rectangulo(30, 30, "azul", 125, 125);
        
        // Agnadir r1 a miPizarra, dibujandolo
        miPizarra.add(r1);
        
        // Crear un Rectangulo r2 100 x 10, rojo y con centro 
        // en (50, 155)
        Rectangulo r2 = new Rectangulo(100, 10, "rojo", 50, 155);
        Rectangulo r3 = new Rectangulo();
        // Agnadir r2 a miPizarra, dibujandolo
        miPizarra.add(r2);
                miPizarra.add(r3);
    }
}