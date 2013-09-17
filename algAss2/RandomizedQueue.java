import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
 
 private Item[] queue;
 private int size; 
// construct an empty randomized queue
   public RandomizedQueue() { 
    queue = (Item[]) new Object[1];
    size = 0;
   }
   
   // is the queue empty?
   public boolean isEmpty() {    
    return size() == 0;
   }
   
   // return the number of items on the queue
   public int size() {
       return size;
   }    

   // add the item
   public void enqueue(Item item) {
       if (item == null)
           throw new NullPointerException();  
       else {
        size++;
        Item[] newItem = (Item[]) new Object[size];
        System.arraycopy(queue, 0, newItem, 0, size-1);
        queue = newItem;
        queue[size-1] = item;
    }
   }     
   
   // delete and return a random item
   public Item dequeue() {
    if (isEmpty())
        throw new NoSuchElementException();     
    else if (size == 1) {
        size--;
        return queue[0];
    }
    else {
         int i = StdRandom.uniform(size());
         Item removal = queue[i];
         size--;
         queue[i] = queue[size];
         Item[] newItem = (Item[]) new Object[size];
         System.arraycopy(queue, 0, newItem, 0, size);
         queue = newItem;
         return queue[StdRandom.uniform(size)];     
    }
   }    
   
   // return (but do not delete) a random item
   public Item sample() {
    if (!isEmpty()) 
     return queue[StdRandom.uniform(size())];     
    else 
        throw new NoSuchElementException();
   }               
   
   // return an independent iterator over items in random order
   public Iterator<Item> iterator() {
    
    return new randomIt();
   }
   
   private class randomIt implements Iterator<Item> {
    
       private int marker;
       private int length;
       
       public randomIt() {
           length = size();
           StdRandom.shuffle(queue);
           marker = 0;
       }
       
       @Override
       public boolean hasNext() {
           return marker < length -1; 
       }
       
       @Override
       public Item next() {
           if (hasNext())
               return queue[marker++];
           else  
               throw new NoSuchElementException();
       }
       
       @Override
       public void remove() {
           throw new java.lang.UnsupportedOperationException();
       }   
   }
   
   
   public static void main(String[] args) {
       
       RandomizedQueue<Integer> temp = new RandomizedQueue<Integer>();
   
       for (int i = 0; i < 500; i++) {
           int current = StdRandom.uniform(50);
           temp.enqueue(current);   
       }
       for (int i = 0; i < 500; i++) {
           temp.dequeue();   
       }
       
   }
   
}