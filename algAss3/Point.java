package points;
import java.util.Comparator;
import stdlib.StdDraw;

public class Point implements Comparable<Point> {
   
    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>(){

		@Override
		public int compare(Point arg0, Point arg1) {
			// could just use double's compare(d1,d2) function 
			
			double slope1 = slopeTo(arg0);
			double slope2 = slopeTo(arg1);
			// if equal returns 1
			if(slope1 == slope2)
				return 0;
			// returns neg in i d1 < d2
			else if(slope1 < slope2)
				return -1;
			// returns pos in 
			else 
				return 1;
		}
    		
    };       // YOUR DEFINITION HERE

    private int x;                              // x coordinate
    private int y;                              // y coordinate

    // create the point (x, y)
    public void Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
    	return (that.y - this.y) /(that.x - this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {

    	if((that.y == this.y && this.x < that.x)){
    		return that.x - this.x;
    	}
    	else 
    		return this.y - that.y;
    }	

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

 // the slope between this point and that point
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}              
