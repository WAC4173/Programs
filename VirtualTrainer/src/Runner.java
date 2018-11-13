/*import java.util.Scanner;

public class Runner {
	Display display;
	RMove r;
	LMove l;
	UMove u;
	DMove d;
	FMove f;
	BMove b;
	RPrimeMove rp;
	LPrimeMove lp;
	UPrimeMove up;
	DPrimeMove dp;
	FPrimeMove fp;
	BPrimeMove bp;
	Corner wgo;
	Corner wbo;
	Corner wbr;
	Corner wgr;
	Corner ygo;
	Corner ybo;
	Corner ybr;
	Corner ygr;
	Scanner input = new Scanner(System.in);
	String key;
	Corner[] corners;
	public Runner(Corner wgo2 ,Corner wbo2, Corner wbr2, Corner wgr2, Corner ygo2, Corner ybo2, Corner ybr2, Corner ygr2) {
		wgo = wgo2;
		wbo = wbo2;
		wbr = wbr2;
		wgr = wgr2;
		ygo = ygo2;
		ybo = ybo2;
		ybr = ybr2;
		ygr = ygr2;		
		System.out.println("Hi");
		corners = new Corner[]{wgo, wbo, wbr, wgr, ygo, ybo, ybr, ygr};
		display = new Display(corners);
	}
	public void start() {
		System.out.println("Hi2");
		do {
			System.out.println("Hi3");
			key = input.next();
			switch(key) {
			case "i":
				for(int x = 0; x < corners.length; x++) {				
					r = new RMove(corners[x]);
					if(r.check()) {corners[x] = r.move();}
				}
				break;
			case "k":
				for(int x = 0; x < corners.length; x++) {				
					rp = new RPrimeMove(corners[x]);
					if(rp.check()) {corners[x] = rp.move();}
				}
				break;
			case "d":
				for(int x = 0; x < corners.length; x++) {				
					l = new LMove(corners[x]);
					if(l.check()) {corners[x] = l.move();}
				}
				break;
			case "e":
				for(int x = 0; x < corners.length; x++) {
					lp = new LPrimeMove(corners[x]);
					if(lp.check()) {corners[x] = lp.move();}
				}
				break;
			case "j":
				for(int x = 0; x < corners.length; x++) {				
					u = new UMove(corners[x]);
					if(u.check()) {corners[x] = u.move();}
				}
				break;
			case "f":
				for(int x = 0; x < corners.length; x++) {				
					up = new UPrimeMove(corners[x]);
					if(up.check()) {corners[x] = up.move();}
				}				
				break;
			case "s":
				for(int x = 0; x < corners.length; x++) {				
					dp = new DPrimeMove(corners[x]);
					if(dp.check()) {corners[x] = dp.move();}
				}
				break;
			case "l":
				for(int x = 0; x < corners.length; x++) {				
					d = new DMove(corners[x]);
					if(d.check()) {corners[x] = d.move();}
				}
				break;
			case "g":
				for(int x = 0; x < corners.length; x++) {				
					fp = new FPrimeMove(corners[x]);
					if(fp.check()) {corners[x] = fp.move();}
				}
				break;
			case "h":
				for(int x = 0; x < corners.length; x++) {				
					f = new FMove(corners[x]);
					if(f.check()) {corners[x] = f.move();}
				}
				break;
			case "w":
				for(int x = 0; x < corners.length; x++) {				
					b = new BMove(corners[x]);
					if(b.check()) {corners[x] = b.move();}
				}
				break;
			case "o":
				for(int x = 0; x < corners.length; x++) {				
					bp = new BPrimeMove(corners[x]);
					if(bp.check()) {corners[x] = bp.move();}
				}
				break;
		}
		} while(!(key.equals("n")));
		TempDisplayCube td = new TempDisplayCube(new Corner[] {wgo, wbo, wbr, wgr, ygo, ybo, ybr, ygr});
	}
}
	*/
