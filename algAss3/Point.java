import java.util.Comparator;

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
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
     public int getY() {
        return y;
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
        
       if (this.x == that.x){
            if (this.y == that.y)
                return Double.NEGATIVE_INFINITY; 
            return Double.POSITIVE_INFINITY;
        }
        else if (this.y == that.y)
            return 0.0;
        return ((double)that.y - this.y) /(that.x - this.x);
    }
    
    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        
        if(that.y == this.y) {
            return this.x - that.x;
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
