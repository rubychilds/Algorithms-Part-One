import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
 
 private Item[] queue;
 // construct an empty randomized queue
   public RandomizedQueue() { 
    queue = (Item[]) new Object[1];  
   }
   
   // is the queue empty?
   public boolean isEmpty() {    
    return size() == 0;
   }
   
   // return the number of items on the queue
   public int size() {
   return queue.length;
   }        
   
   // add the item
   public void enqueue(Item item) {
    if (!isEmpty()) {
     int size = size();
     Item[] newItem = (Item[]) new Object[size+1];
     System.arraycopy(queue, 0, newItem, 0, size);
         queue = newItem;
         queue[size] = item;
    }
    else throw new NoSuchElementException();
   }     
   
   // delete and return a random item
   public Item dequeue() {
    if (!isEmpty()) {
     int i = StdRandom.uniform(size());
     Item removal = queue[i];
     queue[i] = queue[size()-1];
     Item[] newItem = (Item[]) new Object[size()-1];
     System.arraycopy(queue, 0, newItem, 0, size()-1);
     queue = newItem;
     
     return removal;     
    }
    else throw new NoSuchElementException();
   }    
   
   // return (but do not delete) a random item
   public Item sample() {
    if (!isEmpty()) 
     return queue[StdRandom.uniform(size())];     
    else throw new NoSuchElementException();
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
     if (marker < length + 1)
         return true;
     return false;
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
}