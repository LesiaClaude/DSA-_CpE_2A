package alexis;

public class SLinkList {
	private SNode head;
	private SNode tail;
	private int size;
	
	public SLinkList() {
		head = null;
		tail = null;
		size = 0;
	}


	public void addFirst(SNode elementa) {
			elementa.setNext(head);
			head = elementa;
			
			if (tail == null) {
				tail = head;
			}
			size++;
	}

	public void addLast(SNode elementb) {
		elementb.setNext(null);
		if(tail != null) {
			tail.setNext(elementb);
		}
		tail = elementb;
		if (head == null) {
			head = elementb;
		}
		size++;

	}
	
	public void print() {
		SNode current = head;
		while (current != null) {
			System.out.println(current.getName());
			current = current.getNext();
		}
		System.out.println("null");
	}

}
