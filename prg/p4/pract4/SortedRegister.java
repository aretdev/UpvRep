package pract4;

import java.io.PrintWriter; 
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase SortedRegister: contiene un array bidimensional m en el que las filas son meses
 * y las columnas los dias de cada mes de manera que m[f][c] corresponde a la cantidad de 
 * accidentes acumulados el día c del mes f. 
 * La clase contiene los métodos necesarios para volcar la información leída desde un 
 * Scanner sobre la matriz y, a su vez, volcar la información de la matriz en un 
 * PrintWriter.
 * @author (PRG. ETSINF - UPV) 
 * @version (2018/19)  
 */
public class SortedRegister {
    private static int[] DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  
    private int year;
    private int[][] m;

    /** Crea un SortedRegister para el año dataYear.
     *  @param dataYear int.
     */
    public SortedRegister(int dataYear) {
        this.year = dataYear;
        boolean leap = isLeap(this.year);
        m = new int[13][]; 
        for (int month = 1; month <= 12; month++) {
            int numD = this.DAYS[month];
            if (month == 2 && leap) { numD++; }
            m[month] = new int[numD + 1];
        }    
    }    
    
    /** Clasifica ordenadamente los datos leidos del Scanner s.
     *  Precondicion: En cada linea de s los datos deben tener la forma
     *        dia mes cantidad
     *  en donde dia y mes deben ser enteros correspondientes a una fecha 
     *  valida, y cantidad debe ser un entero > 0.
     *  La cantidad leida se acumula en el registro que se lleva para el 
     *  dia del mes.
     *  Si alguna linea no cumple el formato, o contiene una fecha incorrecta,
     *  el metodo termina lanzando una excepcion.
     *  @param sc Scanner fuente de los datos.
     *  @throws NumberFormatExceptionException si se intenta leer un dato no entero. 
     *  @throws ArrayIndexOutOfBoundsException si se lee alguna fecha incorrecta.
     *  @throws IllegalArgumentException si una linea no contiene 3 datos.
     *  ...
     */
    public void add(Scanner sc){
        while (sc.hasNext()) {            
            handleLine(sc.nextLine().trim());
        }
    } 
    
    /** Clasifica ordenadamente los datos extraidos de la linea line.
     *  Precondicion: El scanner es diferente de null
     *  El formato de "line" debe ser que tenga la forma<br>
     *        dia mes cantidad
     *  <br>en donde dia y mes deben ser enteros correspondientes a una fecha 
     *  valida, y cantidad debe ser un entero > 0.
     *  La cantidad leida se acumula en el registro que se lleva para el 
     *  dia del mes.<br>
     *  Si line no cumple el formato, o contiene una fecha incorrecta,
     *  el metodo termina lanzando una excepcion.
     *  @param line String fuente de los datos.
     *  @throws NumberFormatExceptionException si se intenta leer un dato no entero. 
     *  @throws ArrayIndexOutOfBoundsException si se lee alguna fecha incorrecta.
     *  @throws IllegalArgumentException si la linea no contiene 3 datos.
     *  ...
     */    
    private void handleLine(String line) {
        String[] data = line.split("[ ]+");
        if (data.length != 3) { 
            throw new IllegalArgumentException("linea incorrecta.");
        }
        int day = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int amount = Integer.parseInt(data[2]);
        if (day == 0 || month == 0) {
            throw new ArrayIndexOutOfBoundsException();// Aunque modifiquemos el mensaje de error, seguirá mostrandose el estandar.
        } 
        // Completar lanzando la excepción IllegalArgumentException
        // con el mensaje "cantidad negativa" si amount, contiene un valor < 0
        if(amount < 0) { 
            throw new IllegalArgumentException("cantidad negativa.");
        }
        this.m[month][day] += amount;
    }
    
    /** Los datos registrados > 0 se escriben en p, linea a linea
     *  con el formato
     *        dia  mes  cantidad
     *  ordenados cronologicamente.
     *  @param pw Printwriter destino de los datos ordenados.
     */
    public void save(PrintWriter pw) {
        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day < this.m[month].length; day++) {
                int totalAmount = this.m[month][day];
                if (totalAmount > 0) {
                    pw.printf("%5d %5d %5d \n", day, month, totalAmount);
                }
            }
        }
    }

    /** Clasifica ordenadamente los datos leidos del Scanner s. Se filtran
     *  los datos que tuvieran algun defecto de formato, emitiendo un informe
     *  de errores. 
     *  Precondicion: El formato de linea reconocible es
     *        dia mes cantidad
     *  en donde dia y mes deben ser enteros correspondientes a una fecha 
     *  valida, y cantidad debe ser un entero > 0.
     *  La cantidad leida se acumula en el registro que se lleva para 
     *  el dia del mes.
     *  En err se escriben las lineas defectuosas, indicando el número de 
     *  linea.  
     *  @param sc Scanner fuente de los datos.
     *  @param err PrintWriter destino del informe de errores.
     */
    public void add(Scanner sc, PrintWriter err) {
        int line = 1;
        while(sc.hasNextLine()){
            String data = sc.nextLine().trim();
            try{
                handleLine(data); 
            }
            catch(NumberFormatException e){
                err.println(data);
                System.err.println("Linea " + line + ": " + "formato incorrecto.");
            }
            catch(IllegalArgumentException e){
                err.println(data);
                System.err.println("Linea " + line + ": " + e.getMessage());
            }
            catch(ArrayIndexOutOfBoundsException e){
                err.println(data);
                System.err.println("Linea " + line + ": " + "linea incorrecta.");
            }finally{
                line++;
            }
        }
    }
    
    /** Comprueba si year es bisiesto.
     *  @param year int
     *  @return true sii es bisiesto.
     */
    private static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
