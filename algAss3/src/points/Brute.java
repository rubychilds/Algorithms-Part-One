package points;

import stdlib.StdDraw;

public class Brute {
	
	public static void main(String[] args){
		
		
	}
	
	
	private boolean collinear(Point p, Point q, Point r, Point s){
		
		
		return false;
	}
	
	// draws points and lines from one another
	private void drawPoints(Point[] points){
		
		for(Point p : points){
			p.draw();
		}
		for(Point p1 : points){
			for(Point p2 : points){
				if(p1 != p2)
					p1.drawTo(p2);
			}
		}
	}
	
}
