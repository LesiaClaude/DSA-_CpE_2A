package queue;

public class Main {
public static void main(String[] args) {
	QueueSinglyLinkedList q = new QueueSinglyLinkedList();
	
	q.enqueue(10);
	q.enqueue(20);
	q.enqueue(30);
	q.enqueue(40);
	q.enqueue(50);
	
	q.display();
	
	System.out.println("Dequeued: " + q.dequeue());
	q.display();
	
	System.out.println("Front element: " + q.peek());
}
}