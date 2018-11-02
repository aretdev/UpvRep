package pract4;
import java.util.Scanner;

/**
 * Write a description of class Test4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test4
{
    public static void main(String[] args){
        
        Scanner kbd = new Scanner(System.in);
        System.out.println("Lectura de teclado de una hora.");
        System.out.print("   -> Introduzca las horas (entre 0 y 23): ");
        int h = kbd.nextInt();
        
        System.out.print("   -> Introduzca los minutos (entre 0 y 59): ");
        int m = kbd.nextInt();
        TimeInstant case1 = new TimeInstant(h, m);
        
        System.out.println("Hora introducida: " + case1);
        
        TimeInstant currentTime = new TimeInstant();
        System.out.println("La hora actual es : " + currentTime);
        
        int minutos_kbd = (h * 60) + m;
        int diferenciaMin = Math.abs(minutos_kbd - (currentTime.getMinutes() + currentTime.getHours() * 60));
        int horasDif = Math.abs(diferenciaMin / 60);
        int minDif = Math.abs(diferenciaMin % 60);
        System.out.println("La diferencia entre la hora introducida y la actual es : " + diferenciaMin + "(" + horasDif + "h y " + minDif + "m )");
        
        boolean ant = currentTime.getHours() < h;
        System.out.println("¿Es " + currentTime + " anterior a " + case1 + "? " + ant);
        
    }    
}
