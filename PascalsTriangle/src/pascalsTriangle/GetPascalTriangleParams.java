package pascalsTriangle;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GetPascalTriangleParams implements ActionListener {
	
	// class constants - window & text boxes sizes
	private static final int WINDOW_WIDTH = 275;
	private static final int WINDOW_HEIGHT = 250;
	private static final int TEXT_WIDTH = 20;
	private static final FlowLayout LAYOUT_STYLE = new FlowLayout(); // text boxes added one after the other
	
	// Pascals triangle constructor
	public GeneratePascalsTriangle g = new GeneratePascalsTriangle();

	private JFrame window = new JFrame("Pascal Triangle Parameters");
	
	// legend area - currently set to blank - 2 rows
	private JTextArea legendArea = new JTextArea("", 2, TEXT_WIDTH);
	
	// define option text & entry fields
	private String numLevelsMessage = new String("Enter # of Pascal Triangle Levels (1-" + GeneratePascalsTriangle.MAX_LEVELS + ")");
	private JLabel numLevelsTag = new JLabel(numLevelsMessage);
	private JTextField numLevelsText = new JTextField(TEXT_WIDTH);
	
	private String modulusMessage = new String("Enter # colors (2-" + GeneratePascalsTriangle.MAX_COLORS + ")");
	private JLabel modulusTag = new JLabel(modulusMessage);
	private JTextField modulusText = new JTextField(TEXT_WIDTH);

	private JButton runButton = new JButton("Create Triangle!");
	
	public GetPascalTriangleParams() {
		// configure GUI
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		legendArea.setEditable(false);
		legendArea.setLineWrap(true);
		legendArea.setWrapStyleWord(true);  // splits lines @ word boundaries
		legendArea.setBackground(window.getBackground());
		
		// run register event listener
		runButton.addActionListener((ActionListener) this);
		
		// arrange components in GUI
		window.setLayout(LAYOUT_STYLE);
		window.add(legendArea);
		window.add(numLevelsTag);
		window.add(numLevelsText);
		window.add(modulusTag);
		window.add(modulusText);
		window.add(runButton);
		
		MenuBar m = new MenuBar(window, g);
		
		window.setVisible(true);
	}
	
	public void actionPerformed (ActionEvent e) {
	    
		// get user's responses
		
		int rows = 0; int modulus = 999;
		
		if (pascalsTriangle.console) printActionEvent(e); 
		
		// get # of Pascal Triangle Rows
		String rowResponse = numLevelsText.getText();
		if (pascalsTriangle.console == true) System.out.println("Rows = " + rows + "X" + rowResponse + "X");
		try { rows = Integer.parseInt(rowResponse);
		}
		catch (NumberFormatException f) { 
			printError ("Error: non-numeric # of rows entered: ", rowResponse);
			return;
		}
		
		// get the divisor for each #
		String modResponse = modulusText.getText();
		if (pascalsTriangle.console == true) System.out.println("Modulus = " + modulus + "X" + modResponse + "X");
		try { modulus = Integer.parseInt(modResponse);
		}
		catch (NumberFormatException f) { 
			printError ("Error: non-numeric # of colors entered: ", modResponse);
			return;
		}
		
		// Error handling - rows or # colors out of range
		//	if in range, generate the triangle
		if ((rows < 1) || (rows > GeneratePascalsTriangle.MAX_LEVELS))
			printError ("He He!!!! You think you're funny!! - # Rows out of range ", rows);
		else if ((modulus < 2) || (modulus > GeneratePascalsTriangle.MAX_COLORS))
			printError ("Heh Heh!!! You're not funny @ all - # Colors out of range ", modulus);
		else
			g.printPascalsTriangle(rows,modulus);
	}
	
	// Error display - print error message in new frame - # argument
	private void printError (String s, int n){
		String msg = new String (s + n);
		JFrame frame2 = new JFrame("ERROR!");
		frame2.setVisible(true);
		frame2.setSize(400,100);
		JLabel label = new JLabel (msg);
		JPanel panel = new JPanel();
		frame2.add(panel);
		panel.add(label);
	}
	// Error display - print error message in new frame - string argument
	private void printError (String s, String s1){
		String msg = new String (s + s1);
		JFrame frame2 = new JFrame("ERROR!");
		frame2.setVisible(true);
		frame2.setSize(400,100);
		JLabel label = new JLabel (msg);
		JPanel panel = new JPanel();
		frame2.add(panel);
		panel.add(label);
	}
	
	// print ActionEvent info
	private void printActionEvent(ActionEvent e) {
		System.out.println("Action_First "+e.ACTION_FIRST);
		System.out.println("Action_Last "+e.ACTION_LAST);
		System.out.println("ACTION_PERFORMED "+e.ACTION_PERFORMED);
		System.out.printf("Masks (Alt Meta CtrlShift) %d %d %d %d\n",e.ALT_MASK,e.META_MASK, e.CTRL_MASK,e.SHIFT_MASK);
		// System.out.println("Meta_Mask"+e.META_MASK);
		// System.out.println("Ctrl_Mask"+e.CTRL_MASK);
		// System.out.println("Shift_Mask"+e.SHIFT_MASK);
		System.out.println("getModifiers()"+e.getModifiers());
		System.out.println("paramString()" + e.paramString());
	}
}
