package javabootcamp.oop.bookOptions;

public class BorrowableBook extends Book implements Borrowable{
	
	protected int borrowingPeriod;
	protected int borrowed ;
	
	public BorrowableBook(String title, String authorName, char authorGender, Genre jenre, int quantity, int borrowingPeriod) {
		super(title, authorName, authorGender, jenre, quantity);
		this.borrowingPeriod = borrowingPeriod;
		borrowed = 0;	
	}

	@Override
	public void approach() {
		System.out.println("This book available for reading and Borrowing, your options are:"
				+ "\n0: read | 1: return after reading | 2: borrow | 3: return after borrowing");
		int choise = (int)(Math.random()*4);
		System.out.println("You choose: "+ choise);
		switch(choise) {
		case 0 :
			readBook();
			break;
		case 1:
			returnBook();
			break;
		case 2:
			borrowBook();
			break;
		case 3:
			returnBorrowedBook();	
		}
		
	}

	@Override
	public void borrowBook() {
		if(available()) {
			borrowed--;
			System.out.println("You borrowed the book " + super.toString());
		}	
		else
			System.out.println("The book " + super.toString() + " is not available.");
	}

	@Override
	public boolean available() {
		if(borrowed+inReading<quantity)
			return true;
		return false;
	}

	@Override
	public void returnBorrowedBook() {
		borrowed--;
		System.out.println("You returned to book " + super.toString());
		
	}

	@Override
	public void bookStatus() {
		System.out.println("Quantity: " + quantity +", in reading:" + inReading + ", borrowed:" + borrowed);
		
	}
	



	
	
	

}
