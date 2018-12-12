package pract6;

/**
 * Clase IIPMath: clase de utilidades que implementa algunas operaciones 
 * matematicas: IIPMath.sqrt(double) y IIPMath.log(double).
 *
 * @author IIP
 * @version Curso 2018-19
 */
public class IIPMath {
    /** Valor aproximado de log(2). */
    /* COMPLETAR */
    private static final double LOG2 = 0.6931471805599453;
    /** No se pueden crear objetos de esta clase. */
    private IIPMath() { }    
    
    /**
     * Devuelve la raíz cuadrada de x >= 0, con error epsilon > 0. 
     * // COMPLETAR COMENTARIOS 
     */
    public static double sqrt(double x, double epsilon) {
        double term = (1 + x) / 2;
        System.out.println("Término 1 = " + term);

        double error;
        double termPrevio = term;
        
        do {
            termPrevio = term;
            term = (term + x / term) / 2;
            error = termPrevio - term;
        }  while (error >=  epsilon);
        
        return term;
    }            

    /**
     * Devuelve la raíz cuadrada de x >= 0, con error 1e-15. 
     * // COMPLETAR COMENTARIOS 
     */
    public static double sqrt(double x) {    
       return sqrt(x, 1e-15);
    }               
                   
    /**
     * Devuelve log(z), 1/2 <= z < 1, con error epsilon > 0.
     * // COMPLETAR COMENTARIOS
     */
    public static double logBase(double z, double epsilon) {
        double y = (1 - z) / (1 + z);
        
        double u = y;
        
        double uPrev;
        double suma = u;
        double error;
        int i = 1;
        do{
            uPrev = u;
            u = y * y * (2 * i - 1) / (2 * i + 1) * u;
            suma += u;
            error = uPrev - u;
            i++;
        }while(error >= epsilon); 
        
            return -2 * suma;
    }
            
    /**
     * Devuelve log(x), x > 0, con error epsilon > 0.
     * // COMPLETAR COMENTARIOS
     */
    public static double log(double x, double epsilon) { 
        double res = logBase(x, epsilon);
        if(x > 1) {
            double z = x;
            int m = 1;
            do{
                z /= 2;
                m++;
            }while(z > 1);
            res = m * LOG2 * logBase(z, epsilon);
        }else if(x < 0.5) {
            /*double z = x;
            int m = 0;
            while(z > 1){
                z = z * 2;
                m++;
            }
            res = -m * LOG2 * logBase(z, epsilon);*/
            res = -log(1 / x);
        }else if(x == 0){
            res = 0;
        }
        return res;
    }

    /**
     * Devuelve log(x), x > 0, con error 1e-15.
     * // COMPLETAR COMENTARIOS
     */
    public static double log(double x) {    
       return logBase(x, 1e-15);
    }
}
