package pract4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;
import pract4.utilPRG.CorrectReading;
/**
 * Clase TestSortedRegister. Test de la clase SortedRegister.
 * 
 * @author (PRG. ETSINF - UPV)
 * @version (2018/19)
 */
public class TestSortedRegister {
    /** No hay objetos de esta clase. */ 
    private TestSortedRegister() { }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyB = new Scanner(System.in);
        int option = 0;
        do{
            try{
                System.out.println("Seleccione una opción : ");
                System.out.println("1.- Ordenar los datos correctos.");
                System.out.println("2.- Filtrar los dato erroneos.");
                option = keyB.nextInt();
            }catch(InputMismatchException e){
                System.out.println("El valor introducido no es numérico!");
                keyB.nextLine(); //vaciamos Buffer
            }
        }while(option > 2 || option < 1);
        String msg = "Año de los datos (hasta 10 años atrás): ";
        
        int currentY = Year.now().getValue();
        int year = CorrectReading.nextInt(keyB, msg, currentY - 10, currentY);
        
        Scanner in = null;
        PrintWriter out = null, err = null;
        
        System.out.print("Nombre del fichero a ordenar: "); 
        String nameIn = keyB.next();
        
        File f = new File("pract4/data/" + nameIn);
        File fErr ;
        in = new Scanner(f);
        
        f = new File("pract4/data/" + "result.out");
        fErr = new File("pract4/data/" + "result.log");
        out = new PrintWriter(f);
        err = new PrintWriter(fErr);
        
        if(option == 1) { testUnreportedSort(year, in, out); }else{ testUnreportedSort(year, in, out,err); }
        System.out.println("Fichero " + nameIn + " procesado.");
        
        in.close();
        err.close();
        out.close();
    }
  
    /** Metodo de prueba de add(Scanner) y save(PrintWriter) de SortedRegister. */
    public static void testUnreportedSort(int year, Scanner in, PrintWriter out) {
        try{
        SortedRegister c = new SortedRegister(year);
        c.add(in); 
        c.save(out);
        System.out.println("testUnreportedSort finalizado");
        }catch(NumberFormatException e){
            System.err.println("Fichero incorrecto : dato no entero.");
        }catch(IllegalArgumentException e){
            System.err.println("Fichero incorrecto : " + e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Fichero incorrecto : fecha incorrecta.");
        }
    }
    public static void testUnreportedSort(int year, Scanner in, PrintWriter out, PrintWriter err) {
        //Los datos incorrectos están siendo tratados en c.add(arg, arg)
        SortedRegister c = new SortedRegister(year);
        c.add(in, err); 
        c.save(out);
        System.out.println("testUnreportedSort finalizado");
    }
}