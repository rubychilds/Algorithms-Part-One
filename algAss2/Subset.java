import java.util.Iterator;

public class Subset {
  public static void main(String[] args) {
  
   RandomizedQueue<String> queue = new RandomizedQueue<String>();
   int k = Integer.parseInt(args[0]);
   
   while (!StdIn.isEmpty()) {
       String current = StdIn.readString();
       queue.enqueue(current);
   }
   
   if (k > queue.size())
       k = queue.size();  
  
  Iterator<String> iterate = queue.iterator();
  
  while (k >= 0 && iterate.hasNext()) {
      StdOut.println(" " + iterate.next());
      k--;
  }
}
}
