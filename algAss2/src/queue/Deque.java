package queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private int size;
	private Node<Item> head;
	private Node<Item> tail;
	// construct an empty deque
   public Deque(){
	   this.head = null;
	   this.tail = null;
	   size = 0;
   }
   
   // is the deque empty?
   public boolean isEmpty(){
	   return size == 0;
   }           
   
   public int size(){
	   return size;
   }                  // return the number of items on the deque
   
   public void addFirst(Item item){
	   if(item == null)
		   throw new NoSuchElementException();
	   

   }    // insert the item at the front
   
   public void addLast(Item item){
	   if(item == null)
		   throw new NoSuchElementException();
	   
   }     // insert the item at the end
   
   public Item removeFirst(){
	   
	   if(!isEmpty()){
		   Item item = head.getItem();
		   size--;
		   if(isEmpty()){
			   head = null;
			   tail = null;
		   }
		   else {
			   head.getNext().setPrev(null);
			   head = head.getNext();
		   }
		
		   return item;
	   }
	   else 
		   throw new NoSuchElementException();
   }          // delete and return the item at the front
   
   public Item removeLast(){
	   if(!isEmpty()){
		   
	   }
	   else 
		   throw new NoSuchElementException();
	   
   }           // delete and return the item at the end
   
   public Iterator<Item> iterator(){
	   return new DequeIt();
   }   // return an iterator over items in order from front to end

   private class DequeIt implements Iterator<Item>{
	   
		public DequeIt(){
			
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
   }
   
   private static class Node<Item>{
	   
	   private Item item;
	   private Node<Item> next;
	   private Node<Item> prev;
	   
	   // deals with the node itself
	   public Item getItem(){
		   return item;
	   }
	   public void setItem(Item item){
		   this.item = item;
	   }
	   // deals with next item to the node
	   public Node<Item> getNext(){
		   return next;
	   }
	   public void setNext(Node<Item> next){
		   this.next = next;
	   }
	   // deals with previous element to the node
	   public Node<Item> getPrev(){
		   return prev;
	   }
	   public void setPrev(Node<Item> prev){
		   this.prev = prev;
	   }
	   
   }
   
}