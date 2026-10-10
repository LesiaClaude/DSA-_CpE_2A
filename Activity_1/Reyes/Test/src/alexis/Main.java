package alexis;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLinkList list = new SLinkList();
//		SNode node = new SNode();
		SNode a = new SNode("Kyle");
		SNode b = new SNode("Ana");
		SNode c = new SNode("Grace");
//		list.addFirst(a);
//		list.addFirst(b);
		list.addFirst(c);
		list.addLast(a);
		list.addLast(b);
//		list.addLast(c);
		list.print();
//		list.removeFirst();
	}

}
