import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Spliterator;

public class DList <E> {
	
	private Node head;
	private Node tail;
	private int size;
	
	public int getSize() {
		return size;
	}

	private class Node{
		private E data;
		private Node next;
		private Node prev;

		public Node() {
			this(null);
		}
		public Node(E data) {
			this.data = data;
		}
	}
	
	public DList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		head.prev = null;
		tail.next = null;
		tail.prev = head;
		size = 0;
	}
	
	public E get(int idx) {
		Node p = head.next;
		
		for (int i = 0; i < idx; i++) {
			p = p.next;
		}
		
		return p.data;
	}
	
	//끝 추가
	public void add(E data) {
		add(size, data);
	}
	
	public void add(int idx, E data) {
		if (idx > size) {
			return ;
		}
		Node p = head;
		for (int i = 0; i < idx; i++) {
			p = p.next;
		}
		//p는 삽입 노드 앞
		Node n = new Node(data);
		n.prev = p;
		n.next = p.next;
		p.next.prev = n;
		p.next = n;
		size++;
	}
	
	//앞 삭제
	public void remove() {
		remove(0);
	}
	//인덱스 번째 삭제
	public void remove(int idx) {
		Node d = (Node)find(idx);
		d.prev.next = d.next;
		d.next.prev = d.prev;
		size--;
	}
	
	//해당 객체
	public void remove(E obj) {
		int delidx = find(obj);
		remove(delidx);
	}
	
	public Object find(int idx) {
		Node p = head.next;
		for (int i = 0; i < idx; i++) {
			p = p.next;
		}
		return p;
	}
	
	public int find(Object obj) {
		Node p = head.next;
		int cnt = 0;
		while (p != tail) {
			if (obj.equals(p.data)) {
				return cnt;
			}
			else {
				p = p.next;
			}
			cnt++;
		}
		return -1;
	}
	
	//------------------여기부터-------------------
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		return get(size);
	}
	
	public E removeFirst() {
		E obj= head.next.data;
		remove(0);
		return obj;
	}

	public E removeLast() {
		E obj= tail.prev.data;
		remove(size-1);
		return obj;
	}
	
	public void addFirst(E e) {
		add(0, e);
	}

	public void addLast(E e) {
		add(e);
	}

	public boolean contains(E o) {
		if (find(o) == -1) return false;
		else return true;
	}

	public int size() {
		return this.getSize();
	}
/*
	public boolean addAll(Collection c) {
		
	}

	public boolean addAll(int index, Collection c) {
		;
	}
*/
	public void clear() {
		for (int i = 0; i < size; i++){
			remove(i);
		}
	}

	public int indexOf(E o) {
		return find(o);
	}

	public int lastIndexOf(E o) {
		return this.getSize()-1;
	}

	public E peek() {
		E obj= tail.prev.data;
		return obj;
	}
/*
	public E element() {
		return super.element();
	}
*/
	public E poll() {
		E obj= head.next.data;
		remove(0);
		return obj;
	}

	public boolean offer(E e) {
		add(e);
		return true;
	}

	public boolean offerFirst(E e) {
		add(0, e);
		return true;
	}

	public boolean offerLast(E e) {
		add(e);
		return true;
	}

	public E peekFirst() {
		E obj= head.next.data;
		return obj;
	}

	public E peekLast() {
		E obj= tail.prev.data;
		return obj;
	}

	public E pollFirst() {
		E obj= head.next.data;
		remove(size-1);
		return obj;
	}

	public E pollLast() {
		E obj= tail.prev.data;
		remove(size-1);
		return obj;
	}

	public void push(E e) {
		add(e);
	}

	public E pop() {
		E obj= tail.prev.data;
		remove(size-1);
		return obj;
	}

	public boolean removeFirstOccurrence(E o) {
		if (find(o) == -1) return false;
		remove(o);
		return true;
	}

	public boolean removeLastOccurrence(E o) {
		Node p = tail.prev;
		int cnt = size-1;
		while (p != head) {
			if (o.equals(p.data)) {
				p.prev.next = p.next;
				p.next.prev = p.prev;
				size--;
				return true;
			}
			else {
				p = p.prev;
			}
			cnt--;
		}
		return false;
	}
/*
	public ListIterator<E> listIterator(int index) {
		ListIterator L = new ListIterator();
		return L;
	}

	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return super.descendingIterator();
	}
*/
	public E clone() {
		E obj = (E) new Object();
		return obj;
	}

	public E[] toArray() {
		E[] arr = (E[]) new Object[size];
		Node p = head.next;
		for (int i = 0; i < size && p != tail; i++){
			arr[i] = p.data;
			p = p.next;
		}
		return arr;
	}

	public E[] toArray(E[] a) {
		E[] arr = (E[]) new Object[a.length];
		Node p = head.next;
		for (int i = 0; i < a.length && p != tail; i++){
			arr[i] = p.data;
			p = p.next;
		}
		return arr;
	}
/*
	public Spliterator<E> spliterator() {
		;
	}
	*/
}







