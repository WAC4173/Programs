import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.*;
public class Display extends JPanel {
	int offset;
	int boxLen;
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
	String key;
	Corner[] corners;
	Graphics2D g2d;
	Color[] piece1;
	Color[] piece2;
	Color[] piece3;
	Color[] piece4;
	Color[] piece5;
	Color[] piece8;
	double magnifier;
	TempDisplayCube rearrange;
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
		revalidate();
		repaint();
		setFocusTraversalKeysEnabled(false);
		setFocusable(true);
		requestFocusInWindow();
		KeyListening kl = new KeyListening();
		addKeyListener(kl);
	}
	public void update(Corner[] c){
		System.out.println("The update method is called");
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
		revalidate();
		repaint();
	}	
	private class KeyListening implements KeyListener{
		boolean pressed = false;
		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {
			System.out.println(e.getKeyCode());
			if (!pressed) {
				System.out.println(pressed);
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
				case 83:
					for(int x = 0; x < corners.length; x++) {				
						dp = new DPrimeMove(corners[x]);
						if(dp.check()) {corners[x] = dp.move();}
					}
					break;
				case 76:
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
				update(rearrange.rearrange(corners));
				
		}
			}
		public void keyReleased(KeyEvent e) {	
			pressed = false;
		}
		
	}
}
