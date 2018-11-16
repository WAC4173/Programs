import java.io.*;
import java.util.*;



public class GrabAlg {
    private Scanner pulling;
    private String[] returner;
    
    public void openFile(String fileName){
        try{pulling = new Scanner(new File(fileName));
//           System.out.println("this part worked");
        }
        catch(Exception e){     
        }
    }
    
    public void readFileFirst(){
        int i = 0;
        
       if (pulling != null) {while(pulling.hasNext()){
            String a = pulling.nextLine();
 //           System.out.println(a);
            i++;
        
    }}
    returner = new String[i];
    
    
        
}
    public String[][] readFileSecond(){
    ReadAlgorithm ra = new ReadAlgorithm();
    int i = 0;
       
      if(pulling !=null){  while(pulling.hasNext()){
            String a = pulling.nextLine();
            returner[i] = a;
            i++;
        
    }}
        String[][] flipped = new String[returner.length][];
        int x  = 0;
        for (String s: returner) {
        	s = ra.invertScramble(s); 
        	flipped[x] = ra.makeArray(s);       	
        	x++;
        }
    return flipped;
    }
    
    
    public void closeFile(){
        pulling.close();
    }
    
        
    }