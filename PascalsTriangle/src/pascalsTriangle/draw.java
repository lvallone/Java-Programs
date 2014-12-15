package pascalsTriangle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class draw extends JPanel{
	static int x;
	static int y;
	static Color c;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void drawing(Color c1, int x1, int y1) {
		x = x1;
		y = y1;
		c = c1;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(c);
		g.fillOval(x,y,20,20);
		// g.drawRect(100,150,200,350);
	}
}

// Example code - not currently used
//   Drawing
//	Buttons & action listener

/*
JFrame w2 = new JFrame("Pascal's Triangle Options");
w2.setSize(200,200);
w2.setVisible(true);
w2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel buttonpanel = new JPanel();
w2.add(buttonpanel);

JButton button16 = new JButton("16 Levels");
button16.setForeground(Color.red);
buttonpanel.add(button16);
button16.addActionListener(new Action16());

JButton button24 = new JButton("24 Levels");
button24.setForeground(Color.red);
buttonpanel.add(button24);
button24.addActionListener(new Action24());

buttonpanel.updateUI();  // flush output buffer for line
*/

// draw object = new draw ();
// w1.add(panel);
// w1.add(object);

// object.drawing(Color.red, x+10,y+10);
// object.drawing(Color.blue, x,y);

// JPanel panel = new JPanel();
// w1.add(panel);

/* // Red Button
JButton buttonRED = new JButton("Haley");
buttonRED.setForeground(Color.red);
buttonRED.setBackground(Color.red);
panel.add(buttonRED);
buttonRED.addActionListener(new Action());
*/

/*
static class Action implements ActionListener{
public void actionPerformed (ActionEvent e) {
	JFrame frame2 = new JFrame("Clicked");
	frame2.setVisible(true);
	frame2.setSize(200,200);
	JLabel label = new JLabel ("He He!!!!");
	JPanel panel = new JPanel();
	frame2.add(panel);
	panel.add(label);
}
}
static class Action16 implements ActionListener{
public void actionPerformed (ActionEvent e) {
	GeneratePascalsTriangle g = new GeneratePascalsTriangle();
	System.out.println("Button16");
	g.printPascalsTriangle(16,4);
}
}

static class Action24 implements ActionListener{
public void actionPerformed (ActionEvent e) {
	GeneratePascalsTriangle g = new GeneratePascalsTriangle();
	System.out.println("Button24");
	g.printPascalsTriangle(24, 4);
}
}

public void actionPerformed(ActionEvent event) {
System.out.println("Action command" + event.getActionCommand());
}
*/