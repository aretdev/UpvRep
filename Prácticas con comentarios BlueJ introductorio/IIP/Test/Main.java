
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner; 
public class Main {
        public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            int x = 0;
            int y = 0;
            
            
            Map aja = new Map(15,15);
            aja.generateMap();
            
            while(true){
            String Tcl = sc.next();
            if(Tcl.equals("w")){
            y--;
            }else if(Tcl.equals("s")){
            y++;
            
            }else if(Tcl.equals("d")){
            x++;
            }else if(Tcl.equals("a")){
            x--;
            
            }else{
            System.out.println("wasd only");
            }
            aja.setPos(y,x,false);
            blank();
            aja.showMap();
            
            
            

        }
        
}

public static void blank(){
        for(int i = 0; i < 20; i++){
            System.out.println(" ");
        
        }
    }
}
