package alexis;

public class SNode {
	private String name;
	private SNode next;
	
	public SNode(String n) {
		name = n;
		next = null;
	}
//	public SNode(String e, SNode n){
//		name = e;
//		next = n;
// 
//		}
	
	public String getName() {
		return name;
	}
	
	public SNode getNext() {
		return next;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setNext(SNode newNext) {
		next = newNext;
	}
	

}
