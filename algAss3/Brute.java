import java.util.Arrays;

public class Brute {
 
 // HELPER FUNCTIONS FOR SETUP
 // this reads in the points from a given filename
 private static Point[] readPoints(String filename) {
      In filein = new In(filename);
      int n = filein.readInt();
      Point[] points = new Point[n];
      for (int i = 0; i < n; i++)
         points[i] = new Point(filein.readInt(), filein.readInt());
      return points;
 }
 
 private static void setupDrawing() {
     // default it between 0-1.0
     StdDraw.setXscale();
     StdDraw.setYscale();
     // must be no-negative else illegal arg excption thrown
     StdDraw.setPenRadius(0.05); // random guess of 5 - may need altering
     // need to show image - can pass through a paramter for how many milliseconds you want to show it for
     StdDraw.show();
 }
 
 // COLLINERARITY
 // checks whether points are collinear
 private static boolean collinear(Point[] points) {
     // if points length is 2 then we return true
     if (points.length == 2)
         return true;
     else {
         Point comparator = points[0];
         Double slope = comparator.slopeTo(points[1]);
         
         for (int index = 2; index < points.length; index++) {
             if (slope != comparator.slopeTo(points[index]))
                 return false;
         }
     return true;
     }   
 }
 
 // ORDERING OF POINTS
 // function which checks that the points are in order - TO DO
 private static boolean sorted(Point[] points) {
     
     int length = points.length;
   //  StdOut.print("in sorted length: " + length);
     // if we have a single el, or no elements, return true as sorted
     if (length < 2)
         return true;
     for (int index = 0; index < length -1; index++) {
        // StdOut.print(" x: "  + points[index].getX() + " x next : " + points[index+1].getX() + " y: " + points[index+1].getY() + "y next: "  + points[index+1].getY());    
         if (points[index].getY() == points[index+1].getY() &&  points[index].getX() <= points[index+1].getX() )
             continue;
         else if(points[index].getY() < points[index+1].getY())
             continue;
         else
             return false;
     }
     return true;
 }
 

// OUTPUT AND DISPLAY FUNCTIONS 
// prints out points as a string
 private static void printLineSegment(Point[] points) {
     assert sorted(points);
     int end = points.length - 1;
     if (end > 0) {
         for (int i = 0; i < end; i++) {
             StdOut.print(points[i] + " -> ");
         }
         StdOut.print(points[end] + "\n");
     }
 }

 // draws points and lines from one another
 private static void drawPoints(Point[] points) {
     assert sorted(points);
     for (Point p : points) {
         p.draw();
     }
     for (Point p1 : points) {
         for (Point p2 : points) {
             if (p1 != p2)
                 p1.drawTo(p2);
         }
     }
 }
 

 private static void output(Point[] points) {
     // sort the points
     Arrays.sort(points); // uses compareTo in Point
// prints to StdOut
     
     printLineSegment(points);
     // Display points on canvas
     drawPoints(points);
 }
 
 // MAIN FUNCTION
  public static void main(String[] args) {

     // gets filename
     String filename = args[0];
     //reads in points
     Point[] points = readPoints(filename);
     // sets up the drawing
     setupDrawing();
     
     Point[] threePoints = new Point[3];
     Point[] fourPoints = new Point[4];
     int[] indice = {0, 0, 0, 0};
     int length = points.length;
     
     for (indice[0] = 0; indice[0] < length; indice[0]++) {
         points[indice[0]].draw();
         for (indice[1] = indice[0] + 1; indice[1] < length; indice[1]++) {
             for (indice[2] = indice[1] + 1; indice[2] < length; indice[2]++) {
                 for (int g = 0; g < 3; g++) 
                     threePoints[g] = points[indice[g]];
                 if (!collinear(threePoints))
                     continue;
                 for (indice[3] = indice[2] + 1; indice[3] < length; indice[3]++) {
                     for (int g = 0; g < 4; g++)
                         fourPoints[g] = points[indice[g]];
                     if (collinear(fourPoints))
                         output(fourPoints);
                 }
             }
         }
        }
     // shows output
     StdDraw.show(0);
  }
}
