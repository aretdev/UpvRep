
/**
 * Write a description of class Map here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map{
    private int x;
    private int y;
    private int[][] dim;
    
    private int posX = 0;
    private int posY = 0;
    
    Map(int coordX ,int coordY){
        this.x = coordX;
        this.y = coordY;
        dim = new int[this.x][this.y];
  
    }
    
    
    public void generateMap(){
        for(int i = 0; i < this.y; i++){
        
            for(int j = 0; j < this.x; j++){
                dim[i][j]=0;
            }
    }   
    }
    
     public void showMap(){
         for(int i = 0; i < this.y; i++){
        
             for(int j = 0; j < this.x; j++){
                 System.out.print(dim[i][j] + " ");
                }
       System.out.println();
    }   
    }
    
    public void setPos(int x , int y , boolean traza){  
        if(traza == false){
            dim[posX][posY]=0;
        }
        this.posX = x;
        this.posY = y;
        
        
      try {
         if (dim[x][y] != 0){
            dim[x][y]+=1;
        }else{
            dim[x][y]=1;
        }
         
      }catch(ArrayIndexOutOfBoundsException s) {
          
         
      }
        
     
            
         
        
    }
    
    
}
 

