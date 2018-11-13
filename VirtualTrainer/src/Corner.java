import java.awt.*;
/**
 * Write a description of class Corner here.
 *
 * @Will_Callan 
 * @1.0
 */
public class Corner
{    
    Color[] pieceColors;
    int[] pieceCoords;
    String name;
    /*
     * initializes colors and coordinates of the piece
     */
    Corner(int x, int y, int z, Color cx, Color cy, Color cz, String n) {
    	pieceColors = new Color[]{cx, cy, cz};
    	pieceCoords = new int[] {x,y,z};
    	name = n;
    }
    
    public void setCoords(int[] newCoords) {
    	pieceCoords = newCoords;
    }
    public void setColors(Color[] newColors) {
    	pieceColors = newColors;
    }
    public int[] getCoords() {
    	return pieceCoords;
    }
    public Color[] getColors() {
    	return pieceColors;
    }
    public String getName() {
    	return name;
    }
   


}