
public class ReadAlgorithm {	
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

	public String invertScramble(String currentSetup){
        currentSetup += " ";
        String translation = "";
        
        for (int i = 0; i < currentSetup.length(); i++){
            if (currentSetup.charAt(i)=='R' ||currentSetup.charAt(i) == 'L' || currentSetup.charAt(i) == 'F' 
            || currentSetup.charAt(i)=='B' ||currentSetup.charAt(i) == 'U' || currentSetup.charAt(i) == 'D' ){
                translation = currentSetup.charAt(i) + translation;
         }
         if (currentSetup.charAt(i) == ' ' && (currentSetup.charAt(i-1)=='R' ||currentSetup.charAt(i-1) == 'L' || currentSetup.charAt(i-1) == 'F' 
            || currentSetup.charAt(i-1)=='B' ||currentSetup.charAt(i-1) == 'U' || currentSetup.charAt(i-1) == 'D')){
                translation = translation.substring(0,1) + '\'' + translation.substring(1, (translation.length()));
            }
         if (currentSetup.charAt(i)== ' '){
                translation = ' ' + translation;
            }
         if (currentSetup.charAt(i) == '2'){
             translation = translation.substring(0,1) + '2' + translation.substring(1, (translation.length()));
            }
        }
       
        return(translation.substring(1, translation.length())); 
    }
	
	public String[] makeArray(String moves){
        int moveCount = 0;
        String[] ismove = {"R","r","U","u","F","f","L","l","d","D","B","b"};
         
        for(int i = 0; i < moves.length(); i++)
            for(int j = 0; j< ismove.length;j++){
                if (moves.substring(i,i+1).equals(ismove[j])){
                    moveCount ++;
                   }
            }
        String[] moveArray = new String[moveCount];
        
        String holder = "";
        int arpos = 0;
        for (int i = 0; i < moves.length(); i++){
            int button = 0;
            
            for (int j = 0; j < ismove.length;j++)
            {if(moves.charAt(i)==(ismove[j]).charAt(0)){
                button = 1;
            }
            
        }
        if (button == 1 && (arpos <= moveCount - 1)){
            holder += moves.charAt(i);
                if(i<moves.length()-1 && moves.charAt(i+1)!=' '){
                    holder += moves.charAt(i+1);
                    moveArray[arpos]= holder;
                    arpos ++;
                    holder = "";
                } else if(arpos <= moveCount - 1){ 
                    moveArray[arpos]= holder;
                    arpos++;
                    holder = "";
                }
            }
        }
        return moveArray;
    }
	public Corner[] execute(Corner[] corners, String[] s) {
		for(String move:  s) {
			System.out.println(move);
			switch(move) {
			case "R":
				for(int x = 0; x < corners.length; x++) {				
					r = new RMove(corners[x]);
					if(r.check()) {corners[x] = r.move();
					System.out.println("RMove");}
				}
				break;
			case "R'":
				for(int x = 0; x < corners.length; x++) {				
					rp = new RPrimeMove(corners[x]);
					if(rp.check()) {corners[x] = rp.move();
					System.out.println("R' Move");}
				}
				break;
			case "L":
				for(int x = 0; x < corners.length; x++) {				
					l = new LMove(corners[x]);
					if(l.check()) {corners[x] = l.move();
					System.out.println("LMove");}
				}
				break;
			case "L'":
				for(int x = 0; x < corners.length; x++) {
					lp = new LPrimeMove(corners[x]);
					if(lp.check()) {corners[x] = lp.move();
					System.out.println("L' Move");}
				}
				break;
			case "U":
				for(int x = 0; x < corners.length; x++) {				
					u = new UMove(corners[x]);
					if(u.check()) {corners[x] = u.move();
					System.out.println("UMove");}
				}
				break;
			case "U'":
				for(int x = 0; x < corners.length; x++) {				
					up = new UPrimeMove(corners[x]);
					if(up.check()) {corners[x] = up.move();
					System.out.println("U' Move");}
				}				
				break;
			case "D'":
				for(int x = 0; x < corners.length; x++) {				
					dp = new DPrimeMove(corners[x]);
					if(dp.check()) {corners[x] = dp.move();}
					System.out.println("D' Move");
				}
				break;
			case "D":
				for(int x = 0; x < corners.length; x++) {				
					d = new DMove(corners[x]);
					if(d.check()) {corners[x] = d.move();
					System.out.println("DMove");}
				}
				break;
			case "F'":
				for(int x = 0; x < corners.length; x++) {				
					fp = new FPrimeMove(corners[x]);
					if(fp.check()) {corners[x] = fp.move();
					System.out.println("F' Move");}
				}
				break;
			case "F":
				for(int x = 0; x < corners.length; x++) {				
					f = new FMove(corners[x]);
					if(f.check()) {corners[x] = f.move();
					System.out.println("FMove");}
				}
				break;
			case "B":
				for(int x = 0; x < corners.length; x++) {				
					b = new BMove(corners[x]);
					if(b.check()) {corners[x] = b.move();
					System.out.println("bMove");}
				}
				break;
			case "B'":
				for(int x = 0; x < corners.length; x++) {				
					bp = new BPrimeMove(corners[x]);
					if(bp.check()) {corners[x] = bp.move();
					System.out.println("B'Move");}
				}
				break;
			case "R2":
				for(int x = 0; x < corners.length; x++) {				
					r = new RMove(corners[x]);
					if(r.check()) {corners[x] = r.move();
					System.out.println("RMove");}
				}
				for(int x = 0; x < corners.length; x++) {				
					r = new RMove(corners[x]);
					if(r.check()) {corners[x] = r.move();
					System.out.println("RMove");}
				}
				break;
			case "L2":
				for(int x = 0; x < corners.length; x++) {				
					lp = new LPrimeMove(corners[x]);
					if(lp.check()) {corners[x] = lp.move();
					System.out.println("R' Move");}
				}
				for(int x = 0; x < corners.length; x++) {				
					lp = new LPrimeMove(corners[x]);
					if(lp.check()) {corners[x] = lp.move();
					System.out.println("R' Move");}
				}
				break;
			case "F2":
				for(int x = 0; x < corners.length; x++) {				
					f = new FMove(corners[x]);
					if(f.check()) {corners[x] = f.move();
					System.out.println("LMove");}
				}
				for(int x = 0; x < corners.length; x++) {				
					f = new FMove(corners[x]);
					if(f.check()) {corners[x] = f.move();
					System.out.println("LMove");}
				}
				break;
			case "B2":
				for(int x = 0; x < corners.length; x++) {
					bp = new BPrimeMove(corners[x]);
					if(bp.check()) {corners[x] = bp.move();
					System.out.println("L' Move");}
				}
				for(int x = 0; x < corners.length; x++) {
					bp = new BPrimeMove(corners[x]);
					if(bp.check()) {corners[x] = bp.move();
					System.out.println("L' Move");}
				}
				break;
			case "U2":
				for(int x = 0; x < corners.length; x++) {				
					u = new UMove(corners[x]);
					if(u.check()) {corners[x] = u.move();
					System.out.println("UMove");}
				}
				for(int x = 0; x < corners.length; x++) {				
					u = new UMove(corners[x]);
					if(u.check()) {corners[x] = u.move();
					System.out.println("UMove");}
				}
				break;
			case "D2":
				for(int x = 0; x < corners.length; x++) {				
					dp = new DPrimeMove(corners[x]);
					if(dp.check()) {corners[x] = dp.move();
					System.out.println("U' Move");}
				}	
				for(int x = 0; x < corners.length; x++) {				
					dp = new DPrimeMove(corners[x]);
					if(dp.check()) {corners[x] = dp.move();
					System.out.println("U' Move");}
				}	
				break;
		}
		}
		return corners;
	}
	
}
