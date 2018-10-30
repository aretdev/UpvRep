package pract3;

import java.util.Scanner;

/**
 *  Clase Test3.
 *  Una primera clase con lectura de datos desde teclado, 
 *  y uso de operaciones con int, long, Math y String.
 *  Contiene tres errores de compilacion.
 *  @author IIP 
 *  @version Curso 2018-19
 */
 
public class Test3{
    public static void main(String[] args){
        
        Scanner kbd = new Scanner(System.in);
        System.out.println("Lectura de teclado de una hora.");
        System.out.print("   -> Introduzca las horas (entre 0 y 23): ");
        
        int h = kbd.nextInt();
        String hora0 = "0" + h;
        String hora = hora0.substring(hora0.length() - 2);
        
        System.out.print("   -> Introduzca los minutos (entre 0 y 59): ");
        int m = kbd.nextInt();
        String min0 = "0" + m;
        String min = min0.substring(min0.length() - 2);
        
        System.out.println("Hora introducida: " + hora + ":" + min);
        
        long MinsAct = System.currentTimeMillis() / (60*1000);
        
        int currentMin = (int) (MinsAct % (24 * 60));
        String currentHAux = "0" + (currentMin / 60);
        int currentMin1 = (int) currentMin % 60;
        
        String currentH = currentHAux.substring(currentHAux.length() -2);
        
        System.out.println("La hora actual es : " + currentH + ":" + currentMin1);
        
        int minutos_actuales = (h * 60) + m;
        int diferenciaMin = Math.abs(minutos_actuales - currentMin);
        int horasDif = Math.abs(diferenciaMin / 60);
        int minDif = Math.abs(diferenciaMin % 60); 
        System.out.println("La diferencia entre la hora introducida y la actual es : " + diferenciaMin + "(" + horasDif + "h y " + minDif + "m )");
        
        boolean ant =  (currentMin / 60) < h;
        System.out.println("¿Es " + currentH + ":" + currentMin1 + " anterior a " + hora + ":" + min + "? " + ant);
        
        String minFst = "" + currentMin1;
        boolean capicua = currentH.substring(0) == minFst.substring(0);
    }    
 
}
