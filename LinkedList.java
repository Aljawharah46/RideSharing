
class Node<T> {
	public Node<T> next ;
	public T data ; 
	
	public Node() {
		data = null ; 
		next = null ;
	}
	
	public Node(T val) {
		data = val ;
		next = null ;
	}

} //end class


public class LinkedList<T> implements List<T> {
	private Node<T> head;
	private Node<T> current;
	
	public LinkedList() {
		head = current = null;
	}
	
	public boolean empty() {
		return head == null;
	}
	
	public boolean last() {
		return current.next == null;
	}
	
	public boolean full() {
		return false;
	}
	
	public void findFirst() {
		current = head; 
	}
	
	public void findNext() {
		current = current.next;
	}
	
	public T retrieve() {
		return current.data;
	}
	
	public void update(T val) {
		current.data = val;
	}
	
	public void insert(T val) {
		Node<T> tmp ;
		if( head == null )
			head = current = new Node<T>(val) ;
		else {
			tmp = current.next;
			current.next = new Node<T> (val);
			current = current.next;
			current.next = tmp; }
 	}
	
	public void remove () {
		if (current == head) 
		head = head.next;
		else {
			Node<T> tmp = head;
			while (tmp.next != current)
				tmp = tmp.next;
			
			tmp.next = current.next;
			}
		if (current.next == null)
		current = head;
		else
		current = current.next;
		}
	
	public String toString() {
		String history= "";
		Node<T> N = head; 
		while( N != null ) {
			history = history + N.data + "\n"; 
			N = N.next; }
		return history;
	}
	
	public void insertBefore(T val) {
		Node<T> temp = new Node<T>(val);
		if ( head == null || head == current ) {
			temp.next = head;
			head = current = temp; } 
			
		else { Node<T> previous = head ;
			while( previous.next != current ) 
				previous = previous.next;
			temp.next= current; 
			previous.next = temp; 
			current = temp;
			}
		}

		}//end class



	
