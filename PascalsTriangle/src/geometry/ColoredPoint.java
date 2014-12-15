package geometry;

import java.awt.*;

/** Demonstrate basic AWT drawing with Graphics. **/

public class  ColoredPoint extends Point {
	// instance variable
	Color color;
	
	// ColorPoint (): default constructor
	public ColoredPoint() {
		setColor (Color.BLUE);
	}
	public ColoredPoint (int x, int y, Color C) {
		super(x,y);
		setColor(C);
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color c){
		color = c;
	}
	public Object clone() {
		int a = (int) getX();
		int b = (int) getY();
		Color c = getColor ();
		return new ColoredPoint(a,b,c);
	}
	public String toString() {
		int a = (int) getX();
		int b = (int) getY();
		Color c = getColor();
		return getClass() + "[" + a + "," + b + "," + c + "]";
	}
	public boolean equals (Object v) {
		if (v instanceof ColoredPoint) {
			Color c1 = getColor();
			Color c2 = ((ColoredPoint) v).getColor();
			return super.equals(v) && c1.equals(c2);
		}
		else {
			return false;
		}
	}
}