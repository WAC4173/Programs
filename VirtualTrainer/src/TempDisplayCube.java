import java.lang.reflect.Array;
import java.util.Arrays;

public class TempDisplayCube {
	Corner[] display;
public Corner[] rearrange (Corner[] corners) {
	if(corners != null) {
	display = new Corner[] {null,null,null,null,null,null,null,null};
	for(Corner c: corners) {
		if(Arrays.equals(c.getCoords(),(new int[] {-1,1,1}))) {
			display[0] = c;
		}
		if(Arrays.equals(c.getCoords(),(new int[] {-1,1,-1}))) {
			display[1] = c;
		}
		if(Arrays.equals(c.getCoords(),(new int[] {1,1,-1}))) {
			display[2] = c;
		}
		if(Arrays.equals(c.getCoords(),(new int[] {1,1,1}))) {
			display[3] = c;
		}
		if(Arrays.equals(c.getCoords(),(new int[] {-1,-1,1}))) {
			display[4] = c;
		}
		if(Arrays.equals(c.getCoords(),(new int[] {-1,-1,-1}))) {
			display[5] = c;
		}
		if(Arrays.equals(c.getCoords(),(new int[] {1,-1,-1}))) {
			display[6] = c;
		}
		if(Arrays.equals(c.getCoords(),(new int[] {1,-1,1}))) {
			display[7] = c;
		}
	}
	}
	return display;
	}
}
