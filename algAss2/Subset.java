package queue;
import stdlib.StdIn;
import stdlib.StdOut;

public class Subset {
	 public static void main(String[] args){
		 int k = 0;
		 if (args.length == 1 ){
			 try {
				 k = Integer.parseInt(args[0]);
			 }
			 catch(NumberFormatException e) { 
			 }
		 }
		 else {
			 StdOut.printf("Not enough arguments.");
		 }
		 
		 RandomizedQueue<String> queue = new RandomizedQueue<String>();
		 
		   // gets values and opens corresponding grid condition
		   if (!StdIn.isEmpty()) {
	           String input = StdIn.readString();
	           queue.enqueue(input);
	           int index = 0;
	           while (index < k){
	        	   StdOut.println(queue.dequeue());
	        	   index++;
	           }
		   }
		   else
			   StdOut.printf("No input string");
		 
		   
	 }
}
