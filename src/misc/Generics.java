package misc;

import java.util.List;

public class Generics {
	public void addRectangle(List<? extends Shape> shapes) {
	    // Compile-time error!
	    /*shapes.add(0, new Shape(){public void draw(Canvas c){} });*/
	    
	    for(Shape s : shapes) System.out.println(s.toString());
	}
}


abstract class Shape {
    public abstract void draw(Canvas c);
}

class Circle extends Shape {
    private int x, y, radius;
    public void draw(Canvas c) {
        
    }
}

class Rectangle extends Shape {
    private int x, y, width, height;
    public void draw(Canvas c) {
    	
    }
}

class Canvas {
    public void draw(Shape s) {
        s.draw(this);
   }
}
