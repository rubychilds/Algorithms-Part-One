import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
 
 private int size;
 private Node<Item> head;
 private Node<Item> tail;
 // construct an empty deque
   public Deque() {
    head = null;
    tail = null;
    size = 0;
   }
   
   // is the deque empty?
   public boolean isEmpty() {
    return size == 0;
   }           
   
   // return the number of items on the deque
   public int size() {
    return size;
   }                  
   
   // insert the item at the front
   public void addFirst(Item item) {
    if (item == null)
     throw new NullPointerException();
    else {
        
        Node<Item> current = new Node<Item>();   
        current.setItem(item);
        current.setNext(head);
        current.setPrev(null);
        if (isEmpty()) {
            head = tail = current;
        }
        else {
            head.setPrev(current);
            head = current;
        }
        size++;   
     }
   }   
   
   // insert the item at the end
   public void addLast(Item item) {
    if (item == null)
     throw new NullPointerException();
    else {
        Node<Item> current = new Node<Item>();
        current.setItem(item);
        current.setPrev(tail);
        current.setNext(null);
        
        if (isEmpty()) {
            head = tail = current; 
        }
        else {
            tail.setNext(current);
            tail = current;
        }
        size++;
    }   
   }     

   // delete and return the item at the front
   public Item removeFirst() {
    if (isEmpty()) {
         throw new NoSuchElementException();
     }
      
    else {
     Item item = head.getItem(); 
     
     if (head.getNext() == null) {
         head = null;   
     }
     else {
      head.getNext().setPrev(null);
      head = head.getNext();
     }
      size--;
      return item; 
    } 
   }         
   
   // delete and return the item at the end
   public Item removeLast() {
     if (isEmpty()) {
         throw new NoSuchElementException();
     }
     
     else {
         Item item = tail.getItem();
         if (tail.getPrev() == null) {
             tail = null;   
         }
         else {
             tail.getPrev().setNext(null);
             tail = tail.getPrev();
         }
         size--;
         return item;
     }
   }   
   
    public Iterator<Item> iterator() {
       return new DequeIt();
   }   // return an iterator over items in order from front to end
   
   private class DequeIt implements Iterator<Item> {
       private Node<Item> current = head;
       
       @Override
       public boolean hasNext() {
           return current != null;
       }
       
       @Override
       public Item next() {
           if (current == null)
               throw new NoSuchElementException();
           else {
               Item temp = current.getItem();
               current = current.getNext();
               return temp;    
           }
       }

  @Override
  public void remove() {
   throw new UnsupportedOperationException();
  }
   }
   
   private static class Node<Item> {
    
    private Item item;
    private Node<Item> next;
    private Node<Item> prev;
    
    private Node() {
        next = null;
        prev = null;
    }
    
    // deals with the node itself
    public Item getItem() {
     return item;
    }
    public void setItem(Item that) {
     item = that;
    }
    // deals with next item to the node
    public Node<Item> getNext() {
     return next;
    }
    public void setNext(Node<Item> that) {
     next = that;
    }
    // deals with previous element to the node
    public Node<Item> getPrev() {
     return prev;
    }
    public void setPrev(Node<Item> that) {
     prev = that;
    }
    
   }

  
}