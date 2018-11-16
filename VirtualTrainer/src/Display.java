import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
public class Display extends JPanel {
	private JButton scrambleButton;
	private int offset;
	private int boxLen;
	private RMove r;
	private LMove l;
	private UMove u;
	private DMove d;
	private FMove f;
	private BMove b;
	private RPrimeMove rp;
	private LPrimeMove lp;
	private UPrimeMove up;
	private DPrimeMove dp;
	private FPrimeMove fp;
	private BPrimeMove bp;
	private Corner wgo;
	private Corner wbo;
	private Corner wbr;
	private Corner wgr;
	private Corner ygo;
	private Corner ybo;
	private Corner ybr;
	private Corner ygr;
	private String key;
	private Corner[] corners;
	private Graphics2D g2d;
	private Color[] piece1;
	private Color[] piece2;
	private Color[] piece3;
	private Color[] piece4;
	private Color[] piece5;
	private Color[] piece8;
	private double magnifier;
	private TempDisplayCube rearrange;
	private GrabAlg ga = new GrabAlg();
	public Display(Corner[] c) {
		wgo = c[0];
		wbo = c[1];
		wbr = c[2];
		wgr = c[3];
		ygo = c[4];
		ybo = c[5];
		ybr = c[6];
		ygr = c[7];		
		corners = c;
		piece1 = c[0].getColors();
		piece2 = c[1].getColors();
		piece3 = c[2].getColors();
		piece4 = c[3].getColors();
		piece5 = c[4].getColors();
		piece8 = c[7].getColors();
		rearrange = new TempDisplayCube();
		scrambleButton = new JButton("New Scramble");
        scrambleButton.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        scrambleButton.setHorizontalTextPosition(AbstractButton.CENTER);
        scrambleButton.setRequestFocusEnabled(false);
        add(scrambleButton);
		setFocusTraversalKeysEnabled(false);
		setFocusable(true);
		requestFocusInWindow();
		KeyListening kl = new KeyListening();
		addKeyListener(kl);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setSize(1000,1000);
		g2d = (Graphics2D)g;
		offset = 100;
		magnifier = 1;
		boxLen = (int)(100*magnifier);
		g2d.setColor(piece2[1]);
		g2d.fillRect(offset, offset, boxLen, boxLen);
		g2d.setColor(piece3[1]);
		g2d.fillRect(offset+ boxLen, offset, boxLen, boxLen);
		g2d.setColor(piece1[1]);
		g2d.fillRect(offset, offset + boxLen, boxLen, boxLen);
		g2d.setColor(piece4[1]);
		g2d.fillRect(offset + boxLen, offset + boxLen, boxLen, boxLen);
		
		g2d.setColor(piece2[2]);
		g2d.fillRect(offset,  offset-10, boxLen, 10);
		g2d.setColor(piece3[2]);
		g2d.fillRect(offset + boxLen,  offset-10, boxLen, 10);
		g2d.setColor(piece2[0]);
		g2d.fillRect(offset-10,  offset, 10, boxLen);
		g2d.setColor(piece1[0]);
		g2d.fillRect(offset -10,  offset + boxLen, 10, boxLen);
		
		g2d.setColor(piece5[1]);
		g2d.fillRect(offset,  offset + 4*boxLen +10, boxLen, 10);
		g2d.setColor(piece8[1]);
		g2d.fillRect(offset + boxLen,  offset + 4*boxLen + 10, boxLen, 10);
		g2d.setColor(piece1[0]);
		g2d.fillRect(offset-10,  offset + 2*boxLen, 10, boxLen);
		g2d.setColor(piece5[0]);
		g2d.fillRect(offset -10,  offset + 3*boxLen, 10, boxLen);
		
		g2d.setColor(piece1[2]);
		g2d.fillRect(offset, offset + 2*boxLen, boxLen, boxLen);
		g2d.setColor(piece4[2]);
		g2d.fillRect(offset+ boxLen, offset + 2*boxLen, boxLen, boxLen);
		g2d.setColor(piece5[2]);
		g2d.fillRect(offset, offset + 3*boxLen, boxLen, boxLen);
		g2d.setColor(piece8[2]);
		g2d.fillRect(offset + boxLen, offset + 3*boxLen, boxLen, boxLen);
		
		g2d.setColor(piece3[0]);
		g2d.fillRect(offset + 2*boxLen,  offset, 10, boxLen);
		g2d.setColor(piece4[0]);
		g2d.fillRect(offset + 2*boxLen,  offset + boxLen, 10, boxLen);
		g2d.setColor(piece4[0]);
		g2d.fillRect(offset + 2*boxLen,  offset + 2*boxLen, 10, boxLen);
		g2d.setColor(piece8[0]);
		g2d.fillRect(offset + 2*boxLen,  offset + 3*boxLen, 10, boxLen);
	}
	public void update(Corner[] c, boolean check){
		wgo = c[0];
		wbo = c[1];
		wbr = c[2];
		wgr = c[3];
		ygo = c[4];
		ybo = c[5];
		ybr = c[6];
		ygr = c[7];		
		corners = c;
		piece1 = c[0].getColors();
		piece2 = c[1].getColors();
		piece3 = c[2].getColors();
		piece4 = c[3].getColors();
		piece5 = c[4].getColors();
		piece8 = c[7].getColors();
		
		g2d.setColor(piece2[1]);
		g2d.fillRect(offset, offset, boxLen, boxLen);
		g2d.setColor(piece3[1]);
		g2d.fillRect(offset+ boxLen, offset, boxLen, boxLen);
		g2d.setColor(piece1[1]);
		g2d.fillRect(offset, offset + boxLen, boxLen, boxLen);
		g2d.setColor(piece4[1]);
		g2d.fillRect(offset + boxLen, offset + boxLen, boxLen, boxLen);
		
		g2d.setColor(piece2[2]);
		g2d.fillRect(offset,  offset-10, boxLen, 10);
		g2d.setColor(piece3[2]);
		g2d.fillRect(offset + boxLen,  offset-10, boxLen, 10);
		g2d.setColor(piece2[0]);
		g2d.fillRect(offset-10,  offset, 10, boxLen);
		g2d.setColor(piece1[0]);
		g2d.fillRect(offset -10,  offset + boxLen, 10, boxLen);
		g2d.setColor(piece1[2]);
		g2d.fillRect(offset, offset + 2*boxLen, boxLen, boxLen);
		g2d.setColor(piece4[2]);
		g2d.fillRect(offset+ boxLen, offset + 2*boxLen, boxLen, boxLen);
		g2d.setColor(piece5[2]);
		g2d.fillRect(offset, offset + 3*boxLen, boxLen, boxLen);
		g2d.setColor(piece8[2]);
		g2d.fillRect(offset + boxLen, offset + 3*boxLen, boxLen, boxLen);
		
		g2d.setColor(piece5[1]);
		g2d.fillRect(offset,  offset + 4*boxLen +10, boxLen, 10);
		g2d.setColor(piece8[1]);
		g2d.fillRect(offset + boxLen,  offset + 4*boxLen + 10, boxLen, 10);
		g2d.setColor(piece1[0]);
		g2d.fillRect(offset-10,  offset + 2*boxLen, 10, boxLen);
		g2d.setColor(piece5[0]);
		g2d.fillRect(offset -10,  offset + 3*boxLen, 10, boxLen);
		
		g2d.setColor(piece3[0]);
		g2d.fillRect(offset + 2*boxLen,  offset, 10, boxLen);
		g2d.setColor(piece4[0]);
		g2d.fillRect(offset + 2*boxLen,  offset + boxLen, 10, boxLen);
		g2d.setColor(piece4[0]);
		g2d.fillRect(offset + 2*boxLen,  offset + 2*boxLen, 10, boxLen);
		g2d.setColor(piece8[0]);
		g2d.fillRect(offset + 2*boxLen,  offset + 3*boxLen, 10, boxLen);
		revalidate();
		repaint();
		if (check) {checkSolved();
		System.out.println("checked");}else {System.out.println("Not checked");}
	}	
	
	public void scramble() {
		ReadAlgorithm ra = new ReadAlgorithm();
		ga.openFile("scrams1.txt");
		ga.readFileFirst();
		ga.closeFile();
		ga.openFile("scrams1.txt");
		String[][] list = ga.readFileSecond();
		//
		ga.closeFile();
		Random r = new Random();
		int randInt = r.nextInt(list.length);
		String[] moves = list[randInt];
		corners = ra.execute(corners, moves);
		corners = rearrange.rearrange(corners);
		update(corners, false);
		System.out.println("Scrambled");
	}
	public void checkSolved(){
		corners = rearrange.rearrange(corners);
		Corner[] uFace = new Corner[] {corners[0], corners[1], corners[2], corners[3]};
		Corner[] dFace = new Corner[] {corners[4], corners[5], corners[6], corners[7]};
		Corner[] fFace = new Corner[] {corners[0], corners[3], corners[4], corners[7]};
		Corner[] bFace = new Corner[] {corners[1], corners[2], corners[5], corners[6]};
		Corner[] rFace = new Corner[] {corners[2], corners[3], corners[6], corners[7]};
		int matches = 0;
		int solvedFaces = 0;
		for(Corner testColors: uFace) {
			if(testColors.getColors()[1]==uFace[0].getColors()[1]) {matches++;}
		} if (matches==4) {solvedFaces++;}
		matches = 0;
		for(Corner testColors: dFace) {
			if(testColors.getColors()[1]==dFace[0].getColors()[1]) {matches++;}
		} if (matches==4) {solvedFaces++;}
		matches = 0;
		for(Corner testColors: fFace) {
			if(testColors.getColors()[2]==fFace[0].getColors()[2]) {matches++;}
		} if (matches==4) {solvedFaces++;}
		matches = 0;
		for(Corner testColors: bFace) {
			if(testColors.getColors()[2]==bFace[0].getColors()[2]) {matches++;}
		} if (matches==4) {solvedFaces++;}
		matches = 0;
		for(Corner testColors: rFace) {
			if(testColors.getColors()[0]==rFace[0].getColors()[0]) {matches++;}
		} if (matches==4) {solvedFaces++;}
		if(solvedFaces==5) {
			scramble();
			System.out.println("solved");
		}
	}
	private class KeyListening implements KeyListener{
		boolean pressed = false;
		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {
			 {
				pressed = true;
			int key = e.getKeyCode();
				switch(key) {
				case 73:
					for(int x = 0; x < corners.length; x++) {				
						r = new RMove(corners[x]);
						if(r.check()) {corners[x] = r.move();}
					}
					break;
				case 75:
					for(int x = 0; x < corners.length; x++) {				
						rp = new RPrimeMove(corners[x]);
						if(rp.check()) {corners[x] = rp.move();}
					}
					break;
				case 68:
					for(int x = 0; x < corners.length; x++) {				
						l = new LMove(corners[x]);
						if(l.check()) {corners[x] = l.move();}
					}
					break;
				case 69:
					for(int x = 0; x < corners.length; x++) {
						lp = new LPrimeMove(corners[x]);
						if(lp.check()) {corners[x] = lp.move();}
					}
					break;
				case 74:
					for(int x = 0; x < corners.length; x++) {				
						u = new UMove(corners[x]);
						if(u.check()) {corners[x] = u.move();}
					}
					break;
				case 70:
					for(int x = 0; x < corners.length; x++) {				
						up = new UPrimeMove(corners[x]);
						if(up.check()) {corners[x] = up.move();}
					}				
					break;
				case 76:
					for(int x = 0; x < corners.length; x++) {				
						dp = new DPrimeMove(corners[x]);
						if(dp.check()) {corners[x] = dp.move();}
					}
					break;
				case 83:
					for(int x = 0; x < corners.length; x++) {				
						d = new DMove(corners[x]);
						if(d.check()) {corners[x] = d.move();}
					}
					break;
				case 71:
					for(int x = 0; x < corners.length; x++) {				
						fp = new FPrimeMove(corners[x]);
						if(fp.check()) {corners[x] = fp.move();}
					}
					break;
				case 72:
					for(int x = 0; x < corners.length; x++) {				
						f = new FMove(corners[x]);
						if(f.check()) {corners[x] = f.move();}
					}
					break;
				case 87:
					for(int x = 0; x < corners.length; x++) {				
						b = new BMove(corners[x]);
						if(b.check()) {corners[x] = b.move();}
					}
					break;
				case 79:
					for(int x = 0; x < corners.length; x++) {				
						bp = new BPrimeMove(corners[x]);
						if(bp.check()) {corners[x] = bp.move();}
					}
					break;
			}
				corners = rearrange.rearrange(corners);
				update(rearrange.rearrange(corners), true);
				
				
		}
			}
		public void keyReleased(KeyEvent e) {	
			pressed = false;
		}
		
	}
}
