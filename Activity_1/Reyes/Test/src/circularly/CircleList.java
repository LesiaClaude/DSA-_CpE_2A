package circularly;

public class CircleList {
	private CNode cursor;
	private int size;
	
	public CircleList() {
		cursor = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public CNode getCursor() {
		return cursor;
	}
	
	public void advance() {
		cursor = cursor.next;
	}
	
	public void add(CNode newNode) {
		if(cursor == null) {
			newNode.next = newNode;
			cursor = newNode;
		}
		else {
			newNode.next = cursor.next;
			cursor.next = newNode;
		}
		size++;
	}
	
	public CNode remove() {
		CNode oldNode = cursor.next;
		if (oldNode == cursor) {
			cursor = null;
		}
		else {
			cursor.next = oldNode.next;
			oldNode.next = null;
		}
		size--;
		return oldNode;
	}
	
	public String toString() {
		if (cursor == null) return "[]";
		String s = "[..." + cursor.data;
		CNode oldCursor = cursor;
		for (advance(); oldCursor != cursor; advance())
			s += ", " + cursor.data;
		return s + "...]";
	}
}
