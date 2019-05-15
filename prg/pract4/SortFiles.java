package pract4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Year;
import java.util.Scanner;
import pract4.utilPRG.CorrectReading;
/**
 * Clase SortFiles. 
 * 
 * @author (PRG) 
 * @version (2018/19)
 */
public class SortFiles {

    /** 
     * Constructor privado, no se utilizara 
     * en esta clase programa 
     */
    private SortFiles() { }
 
    public static void main(String[] args)  {
        Scanner keyB = new Scanner(System.in);
        String msg = "Año de los datos (hasta 10 años atrás): ";
        int currentY = Year.now().getValue();
        int year = CorrectReading.nextInt(keyB, msg, currentY - 10, currentY); 
        // Busca en la ubicacion indicada un directorio de nombre 
        // "dataFilesAAAA", siendo AAAA el año leido de teclado
        System.out.print("Ubicación del directorio con los ficheros a ordenar: ");
        String dirParent = "pract4" + File.separator + keyB.next(); 
        File f = new File(dirParent + "/dataFiles" + year);
        System.out.println("---> Iniciando proceso de " + f.getName() + " <---");
        if (f.isDirectory()) {
            // El resultado se deja en el directorio "resultFilesAAAA"
            File fResult = new File(dirParent + "/resultFiles" + year);
            if (!fResult.isDirectory()) { fResult.mkdir(); }
            reportedSortFiles(f.listFiles(), year, fResult);
        } else { 
            System.out.println("Error: " + f + " no es un directorio del sistema.");
        }
    System.out.println("---> Final de proceso <---");
    } 
    
    /** Clasifica los datos leidos de un array de ficheros de texto. 
     *  Los datos corresponden a fechas de un determinado año. Se filtran los 
     *  datos con algun defecto de formato, emitiendo un informe de errores. 
     *  Precondicion: El formato de linea reconocible es
     *        dia mes cantidad
     *  en donde dia y mes deben ser enteros correspondientes a una fecha 
     *  valida del año, y cantidad debe ser un entero > 0.
     *  En un fichero "result.out" se escriben en orden cronologico las 
     *  cantidades acumuladas para cada fecha. En un fichero "result.log" se 
     *  escriben las lineas con datos defectuosos, identificando primero al
     *  fichero al que corresponden, con una línea previa como la siguiente:
     *  ">>>>> File nombreFichero <<<<<"     
     *  Si hay problemas de acceso a alguno de los ficheros, el proceso 
     *  no se completa.
     *     
     *  @param listF File[], array de los ficheros fuente de los datos.
     *  @param year int, año al que corresponden los datos.
     *  @param place File, lugar del sistema en donde se guardan 
     *  los ficheros .out y .log.
     */
    public static void reportedSortFiles(File[] listF, int year, File place) {
       Scanner in = null;
       PrintWriter error  = null , out = null;
       File f = null;
       String fName = "";
       
       try{
           SortedRegister c = new SortedRegister(year);
           f = new File(place + "/result.log");
           error = new PrintWriter(f);
           for(int i = 0; i < listF.length; i++){
            f = listF[i];
            fName = f.getName();
            in = new Scanner(f);
            System.out.println("    ----> Procesando archivo: " + fName + " <----");
            error.println("    >> File " + fName + " <<");
            c.add(in, error);
            in.close();
           }
           f = new File(place + "/result.out");
           out = new PrintWriter(f);
           c.save(out);
           out.close();
        }catch(FileNotFoundException e){
            System.out.println("-!!- Proceso incorrecto al abrir" + f);
        }finally{
            if(error != null){error.close();}
        }
    }
}
