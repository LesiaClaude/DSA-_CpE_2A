package circularly;

import java.util.Random;

public class CMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleList C = new CircleList();
		
		int N = 3;
		CNode it;
		CNode goose;
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		String[] names = {"Bob","Jen","Pam","Tom","Ron","Vic","Sue","Joe"};
		
		for (int i = 0; i < names.length; i++) {
			C.add(new CNode(names[i], null));
			C.advance();
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println("Playing Duck, Duck, Goose for " + C.toString());
			it = C.remove();
			System.out.println(it.data + " is IT!");
			
			while (rand.nextBoolean() || rand.nextBoolean()) {
				C.advance();
				System.out.println(C.getCursor().data + " is a DUCK!");
			}
			goose = C.remove();
			System.out.println(goose.data + " is the GOOSE!");
			
			if (rand.nextBoolean()) {
				System.out.println("The goose won!");
				C.add(goose);
				C.advance();
				C.add(it);
			}
			
			else {
				System.out.println("The Goose Lost!");
				C.add(it);
				C.advance();
				C.add(goose);
			}
		}
		System.out.println("Final Circle is " + C.toString());

	}

}
