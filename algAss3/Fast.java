public class Fast {
 public static void main(String[] args){
     Point[] points = readPoints(args[0]);

     for(int p = 0; p < points.length; p++){
         points[p].draw();
         for(int otherP = 0; otherP < points.length; p++ ){
             if(p != otherP)
                 points[p].slopeTo(points[otherP]);
         }
             
     
     }
         
         
 }
 
 
  private static Point[] readPoints(String filename) {
      In filein = new In(filename);
      int n = filein.readInt();
      Point[] points = new Point[n];
      for (int i = 0; i < n; i++)
         points[i] = new Point(filein.readInt(), filein.readInt());
      return points;
 }

}
