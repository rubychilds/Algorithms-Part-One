package points;

import stdlib.StdDraw;

public class Brute {
 
 public static void main(String[] args){
  
  
 }
 
 
 private boolean collinear(Point[] points){
     // if points length is 2 then we return true
     if(Points.length == 2)
         return true;
     else{
         Point comparator = points[0];
         Double slope = comparator.slopeTo(points[1]);
         
         for(int index = 2; index < points.length; index++){
             if(slope != comparator.slppeTo(points[index]))
                 return false;
         }
     }
     return true;
 }
 
 // function which checks that the points are in order - TO DO
 private static boolean sorted(Point[] points){
     return false;
 }
 
 // prints out points as a string
 private static void printLineSegment(Point[] points) {
     assert sorted(points);
     int end = points.length - 1;
     if (end > 0) {
         for (int i = 0; i < end; i++) {
             System.out.print(points[i] + " -> ");
         }
     }
     System.out.println(points[end]);
 }
 
 // must set up drawing here - TO DO
 private static void setupDrawing(){
 
 
 }
 
 // draws points and lines from one another
 private static void drawPoints(Point[] points){
  
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
