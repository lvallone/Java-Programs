package pascalsTriangle;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MenuBar extends JPanel implements ItemListener {
	//Where the GUI is created:
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	JMenuItem menuItem0B, menuItem0R;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;
	JCheckBoxMenuItem cbMenuItemAt, cbMenuItemO, cbMenuItemStar;
	JRadioButtonMenuItem rbMenuItemAt, rbMenuItemO, rbMenuItemStar, rbMenuItemNum;
	
	public MenuBar(JFrame window, GeneratePascalsTriangle g) {
		//Create the menu bar.
		menuBar = new JMenuBar();
		colorMenu (window);
		// miscMenu (window);
		
		//Build symbol menu to select which character is displayed
		//  Use radio buttons for choices
		menu = new JMenu("Symbol Menu");
		menu.setMnemonic(KeyEvent.VK_S);
		menu.getAccessibleContext().setAccessibleDescription(
		        "Pascal's Triangle symbol selection");
		menuBar.add(menu);
		
		ButtonGroup rbCharacterGroup = new ButtonGroup();
		
		rbMenuItemAt = new JRadioButtonMenuItem("@");
		rbMenuItemAt.setSelected(true);
		rbCharacterGroup.add(rbMenuItemAt);
		rbMenuItemAt.setMnemonic(KeyEvent.VK_A);
		rbMenuItemAt.addItemListener(this);
		menu.add(rbMenuItemAt);
		
		rbMenuItemO = new JRadioButtonMenuItem("O");
		rbMenuItemO.setSelected(true);
		rbCharacterGroup.add(rbMenuItemO);
		rbMenuItemO.setMnemonic(KeyEvent.VK_O);
		rbMenuItemO.addItemListener(this);
		menu.add(rbMenuItemO);
		
		rbMenuItemStar = new JRadioButtonMenuItem("*");
		rbMenuItemStar.setSelected(true);
		rbCharacterGroup.add(rbMenuItemStar);
		rbMenuItemStar.setMnemonic(KeyEvent.VK_S);
		rbMenuItemStar.addItemListener(this);
		menu.add(rbMenuItemStar);
		
		rbMenuItemNum = new JRadioButtonMenuItem("Number");
		rbMenuItemNum.setSelected(true);
		rbCharacterGroup.add(rbMenuItemNum);
		rbMenuItemNum.setMnemonic(KeyEvent.VK_N);
		rbMenuItemNum.addItemListener(this);
		menu.add(rbMenuItemNum);
		
		window.setJMenuBar(menuBar);
		System.out.println(GeneratePascalsTriangle.getCharacter());
	}

	public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
		if (pascalsTriangle.console) printItemEvent(e);
		
        String c = "-";
        Object source = e.getItemSelectable();
 
        if (source == rbMenuItemAt) {
            c = "@";
        } else if (source == rbMenuItemO) {
            c = "O";
        } else if (source == rbMenuItemStar) {
            c = "*";
        } else if (source == rbMenuItemNum) {
        	c = "9";
        } else if (source == menuItem0B) {
        	System.out.println("Color 0, Blue");
        } else if (source == menuItem0R) {
        	System.out.println("Color 0, Red");
        } else {
            c = "-";
        }
        GeneratePascalsTriangle.setCharacter(c);
		System.out.println(GeneratePascalsTriangle.getCharacter());
		if (pascalsTriangle.console) printItemEvent(e);
	}
	
	// print ActionEvent info
	private void printItemEvent(ItemEvent e) {
		System.out.printf("DESELECTED %d\tSELECTED %d",e.DESELECTED, e.SELECTED);
		System.out.println("Item_First "+e.ITEM_FIRST);
		System.out.println("Item_Last "+e.ITEM_LAST);
		System.out.println("ITEM_STATE_CHANGED "+e.ITEM_STATE_CHANGED);
		System.out.println("getItem()"+e.getItem());
		System.out.println("getItemSelectable()"+e.getItemSelectable());
		System.out.println("getStateChange()"+e.getStateChange());
		System.out.println("paramString()" + e.paramString());
	}
	
	public void colorMenu(JFrame window) {
		//Build the color menu.
				menu = new JMenu("Color Menu");
				menu.setMnemonic(KeyEvent.VK_C);
				menu.getAccessibleContext().setAccessibleDescription(
				        "Color Menu");
				menuBar.add(menu);
				
				submenu = new JMenu("Color 0");
				submenu.setMnemonic(KeyEvent.VK_0);
			
				menuItem0B = new JMenuItem("Blue");
				menuItem0B.addItemListener(this);
				submenu.add(menuItem0B);
			
				menuItem0R = new JMenuItem("Red");
				menuItem0R.addItemListener(this);
				submenu.add(menuItem0R);
				menu.add(submenu);
				
				submenu = new JMenu("Color 1");
				submenu.setMnemonic(KeyEvent.VK_1);
			
				menuItem = new JMenuItem("Blue");
				submenu.add(menuItem);
			
				menuItem = new JMenuItem("Red");
				submenu.add(menuItem);
				menu.add(submenu);
	}
	
	private void miscMenu(JFrame window) {
		//Build the color menu.
				menu = new JMenu("Misc Menu");
				menu.setMnemonic(KeyEvent.VK_M);
				menu.getAccessibleContext().setAccessibleDescription(
				        "Miscellaneous Menu");
				menuBar.add(menu);
			
				// add menu items for each possible color
				for (int i = 0; i <= GeneratePascalsTriangle.MAX_COLORS; i++) {
					String menuString = "color" + i;
					menuItem = new JMenuItem(menuString, KeyEvent.VK_0);
				// menuItem.setAccelerator(KeyStroke.getKeyStroke(
				   //     KeyEvent.VK_1, ActionEvent.ALT_MASK));
				// menuItem.getAccessibleContext().setAccessibleDescription(
				        // "This doesn't really do anything");
					menu.add(menuItem);
				}
				menuItem = new JMenuItem(new ImageIcon("images/BlueCircle.gif"));
				menuItem.setMnemonic(KeyEvent.VK_D);
				menu.add(menuItem);
				
				window.setJMenuBar(menuBar);
				window.setVisible(true);
				
				//a group of radio button menu items
				menu.addSeparator();
				ButtonGroup group = new ButtonGroup();
			
				rbMenuItem = new JRadioButtonMenuItem("Radio Button 1");
				rbMenuItem.setSelected(true);
				rbMenuItem.setMnemonic(KeyEvent.VK_R);
				group.add(rbMenuItem);
				menu.add(rbMenuItem);
			
				rbMenuItem = new JRadioButtonMenuItem("Radio Button 2");
				rbMenuItem.setMnemonic(KeyEvent.VK_O);
				group.add(rbMenuItem);
				menu.add(rbMenuItem);
			
				//a group of check box menu items
				menu.addSeparator();
				cbMenuItem = new JCheckBoxMenuItem("Checkbox 1");
				cbMenuItem.setMnemonic(KeyEvent.VK_C);
				menu.add(cbMenuItem);
			
				cbMenuItem = new JCheckBoxMenuItem("Checkbox 2");
				cbMenuItem.setMnemonic(KeyEvent.VK_H);
				menu.add(cbMenuItem);
			
				//a submenu
				menu.addSeparator();
				submenu = new JMenu("SubMenu");
				submenu.setMnemonic(KeyEvent.VK_S);
			
				menuItem = new JMenuItem("An item in the submenu");
				menuItem.setAccelerator(KeyStroke.getKeyStroke(
				        KeyEvent.VK_2, ActionEvent.ALT_MASK));
				submenu.add(menuItem);
			
				menuItem = new JMenuItem("Another item");
				submenu.add(menuItem);
				menu.add(submenu);
			
	}

}

