import java.awt.Color;
public class UMove {
	int amount;
	Corner piece;
	Color[] colorSwap;
	int x;
	int y;
	int z;
	int[] coords;
	public UMove(Corner p) {
		piece = p;
		if(piece != null) {
			colorSwap = new Color[] {(piece.getColors())[2], (piece.getColors())[1], (piece.getColors())[0]};
		}
		coords = piece.getCoords(); 
		x = coords[0];
		y = coords[1];
		z = coords[2];
	}
	public boolean check(){
		if(piece != null && y== 1) {
			return true;			
		}
		return false;
	}
	public Corner move() {
	if(x==-1 && z==1) {
		piece.setCoords(new int[]{-1,1,-1});
		piece.setColors(colorSwap);
	}
	if(x==-1 && z==-1) {
		piece.setCoords(new int[]{1,1,-1});
		piece.setColors(colorSwap);
	}
	if(x==1 && z==-1) {
		piece.setCoords(new int[]{1,1,1});
		piece.setColors(colorSwap);
	}
	if((x==1 && z ==1)) {
		piece.setCoords(new int[]{-1,1,1});
		piece.setColors(colorSwap);
	}
	return piece;
	}
}