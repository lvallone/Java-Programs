package pascalsTriangle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

// 
// Max is # of Pascal Triangle rows to generate
// Modulus is modulo divider for individual elements - large # would generate a pure Pascal triangle

public class GeneratePascalsTriangle {
	
	// class variables - static so can set outside of GeneratePascalsTriangle
	
	public static int MAX_COLORS = 9;		// Maximum # of unique colors (ie 0 = Red, ... MAX-1 = Blue, MAX+any = default)
	private static Color[] color = new Color[MAX_COLORS+1];			// Color associated with each number
	public static int MAX_LEVELS = 100;
	private static Font font = new Font("Serif", Font.ITALIC, 2);

	private static int numPixelsPerChar = 24;	// for sizing frame, # pixels per character
	private static String character = "@";
	private static boolean prtDigits = false;
	
	// variable declarations
	private int [] a, b;	// a[] previous row, b[] current row
	private int N;			// N current row #
	private JFrame w1;				// Frame handle
	private JPanel panel;			// Panel handle in frame
	private GridBagConstraints c;	// Grid handle
	
	public GeneratePascalsTriangle() {

		color[0] = Color.red;
		color[1] = Color.black;
		color[2] = Color.blue;
		color[3] = Color.green;
		color[4] = Color.orange;
		color[5] = Color.magenta;
		color[6] = Color.cyan;
		color[7] = Color.pink;
		color[8] = Color.lightGray;
		color[9] = Color.yellow;
	}
	
	public void printPascalsTriangle(int Max, int Modulus) {

		a = new int[MAX_LEVELS];
		b = new int[MAX_LEVELS+1];
		
		// Generate  Frame for Pascal's triangle output
		// size frame to fit projected triangle size
		
		w1 = new JFrame("Pascal's Triangle Frame");
		w1.setSize(numPixelsPerChar*Max,numPixelsPerChar*Max);
		w1.setVisible(true);
		

		// w1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Use Grid layout to align output
		panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		panel.setFont(font);
		// JScrollPane scrollBar=new JScrollPane(w1);
		// w1.add(scrollBar);
		w1.getContentPane().add(panel, BorderLayout.CENTER);
		c = new GridBagConstraints();
		c.insets = new Insets (0,0,0,0);
		
		// initial triangle
		//   a[] is previous row, row starts at index 1, but need a[0] for start case
		//   b[] is current row
		a[0] = 0;	// a[] initialization is likely unnecessary if N starts @ 1
		a[1] = 1;
		a[2] = 1;
		N = 1; 		// # of elements in row
		int i;		// scratch variable - loop counter
		
		while(N <= Max)
		{
			b[1]=1;
			b[N]=1;
			for (i = 2; i < N; i++) {
				b[i] = (a[i-1] + a[i]) % Modulus;
			}
			
			// Console printing option, indent row
			if (pascalsTriangle.console)
				for (i = 1; i <= ((6*(Max - N))/2); i++) {
					System.out.printf (" ");
				}
			
			// print current row (N)
			int y = 20*N;
			for (i = 1; i <= N; i++) {
				if (pascalsTriangle.console == true) System.out.printf ("%6d",b[i]); // Console printing option, print #
				int x = (Max-N+(2*i));
				c.gridx = x; c.gridy = y;
				JLabel label1 = new JLabel();
				if (GeneratePascalsTriangle.prtDigits)
					label1.setText(Integer.toString(b[i])); // only applicable if printing # vs. @
				else
					label1.setText(character);
				
				// JLabel label2 = new JLabel(blueicon);
				if (b[i]>= MAX_COLORS)
					label1.setForeground(color[MAX_COLORS]);
				else
					label1.setForeground(color[b[i]]);
				panel.add (label1, c);  // print # or @ with appropriate color
			}
			panel.updateUI();  // flush output buffer for line
			
			if (pascalsTriangle.console == true) System.out.println(""); // Console printing option, next line

			// Copy current row to pevious row & increment N to next row
			for (i = 1; i <= N; i++) {
				a[i] = b[i];
			}
			N = N + 1;
		}

	}

	public void setColor (Color c, int colorNo) {
		color[colorNo] = c;
	}
	
	public static Color getColor (int colorNo) {
		return color[colorNo];
	}
	
	public static void setCharacter (String c) {
		if (c.equals("9"))
				GeneratePascalsTriangle.prtDigits = true;
		else {
				GeneratePascalsTriangle.prtDigits = false;
				character = c;
		}
	}
	
	public static String getCharacter () {
		return character;
	}
}
