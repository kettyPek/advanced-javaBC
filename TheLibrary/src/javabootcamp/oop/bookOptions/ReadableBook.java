package javabootcamp.oop.bookOptions;

public class ReadableBook extends Book {
	
	
	public ReadableBook(String title, String authorName, char authorGender, Genre jenre, int quantity) {
		super(title, authorName, authorGender, jenre, quantity);
	}

	@Override
	public void approach() {
		System.out.println("This book available for reading only, your options are: "
				+ "\n0: read | 1: return");
		int choise = (int)(Math.random()*2);
		System.out.println("You choose: " + choise);
		if(choise==0)
			readBook();
		else
			returnBook();
		
	}
	
	@Override
	public void bookStatus() {
		System.out.println("Quantity: " + quantity +", in reading:" + inReading );
		
	}

}
