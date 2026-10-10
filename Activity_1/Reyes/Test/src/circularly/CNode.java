package circularly;

public class CNode {
	protected String data;
	protected CNode next;
	
	public CNode(String data, CNode next) {
		this.data = data;
		this.next = next;
	}
}
