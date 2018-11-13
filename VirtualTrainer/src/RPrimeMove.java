import java.awt.Color;
public class RPrimeMove {
	int amount;
	Corner piece;
	Color[] colorSwap;
	int x;
	int y;
	int z;
	int[] coords;
	public RPrimeMove(Corner p) {
		piece = p;
		if(piece != null) {
			colorSwap = new Color[] {(piece.getColors())[0], (piece.getColors())[2], (piece.getColors())[1]};
		}
		coords = piece.getCoords(); 
		x = coords[0];
		y = coords[1];
		z = coords[2];
	}
	public boolean check(){
		if(piece != null &&(x==1)) {
			return true;			
		}
		return false;
	}
	public Corner move() {
	if(y==1 && z==1) {
		piece.setCoords(new int[]{1,-1,1});
		piece.setColors(colorSwap);
	}
	if(y==1 && z==-1) {
		piece.setCoords(new int[]{1,1,1});
		piece.setColors(colorSwap);
	}
	if(y==-1 && z==-1) {
		piece.setCoords(new int[] {1,1,-1});
		piece.setColors(colorSwap);
	}
	if((y==-1 && z ==1)) {
		piece.setCoords(new int[]{1,-1,-1});
		piece.setColors(colorSwap);
	}
	return piece;
	}
}