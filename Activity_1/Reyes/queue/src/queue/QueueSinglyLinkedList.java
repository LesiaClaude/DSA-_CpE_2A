package queue;

public class QueueSinglyLinkedList{

private static class Node {
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

private Node front;
private Node rear;

public QueueSinglyLinkedList(){
	front = rear = null;
}
public void enqueue(int value) {
	Node newNode = new Node(value);
	
	if (rear == null) {
		front = rear = newNode;
		return;
	}
	rear.next = newNode;
	rear = newNode;
}
public int dequeue() {
	if (front == null) {
		System.out.println("Queue is Empty!");
		return -1;
	}
	int value = front.data;
	front = front.next;
	
	if (front == null) {
		rear = null;
	}
	return value;
}
public int peek() {
	if (front == null) {
		System.out.println("Queue is Empty!");
		return -1;
	}
	return front.data;
}
public boolean isEmpty() {
	return front == null;
}
public void display() {
	if (front == null) {
		System.out.println("Queue is Empty!");
		return;
	}
	Node current = front;
	System.out.print("Queue: ");
	
	while (current != null) {
		System.out.print(current.data + " ");
		current = current.next;
	}
	System.out.println();
}
}