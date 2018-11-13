import java.awt.*;
import javax.swing.*;
public class Cube extends JFrame{
//public class Cube {
	static Corner wgo;
	static Corner wbo;
	static Corner wbr;
	static Corner wgr;
	static Corner ygo;
	static Corner ybo;
	static Corner ybr;
	static Corner ygr;
	static JFrame frame;
	static Display d;
public static void main(String[] args) {
	wgo = new Corner(-1,1,1,Color.ORANGE,Color.WHITE,Color.GREEN, "wgo");
	wbo = new Corner(-1,1,-1,Color.ORANGE,Color.WHITE,Color.BLUE, "wbo");
	wbr = new Corner(1,1,-1,Color.RED,Color.WHITE,Color.BLUE, "wbr");
	wgr = new Corner(1,1,1,Color.RED,Color.WHITE,Color.GREEN, "wgr");
	ygo = new Corner(-1,-1,1,Color.ORANGE,Color.YELLOW,Color.GREEN, "ygo");
	ybo = new Corner(-1,-1,-1,Color.ORANGE,Color.YELLOW,Color.BLUE, "ybo");
	ybr = new Corner(1,-1,-1,Color.RED,Color.YELLOW,Color.BLUE, "ybr");
	ygr = new Corner(1,-1,1,Color.RED,Color.YELLOW,Color.GREEN, "ygr");
	d = new Display(new Corner[] {wgo,wbo,wbr,wgr,ygo,ybo,ybr,ygr});
	frame = new JFrame("VirtualTrainer");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1000, 1000);
	frame.setFocusTraversalKeysEnabled(false);
	frame.add(d);
	frame.setVisible(true);
}
public void update() {
	frame.setVisible(false);
	frame.setVisible(true);
}
}
