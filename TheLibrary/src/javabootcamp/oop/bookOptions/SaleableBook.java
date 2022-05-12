package javabootcamp.oop.bookOptions;

public class SaleableBook extends BorrowableBook implements Saleable{

	protected float price;
	public SaleableBook(String title, String authorName, char authorGender, Genre jenre, int borrowingPeriod, int quantity, float price) {
		super(title, authorName, authorGender, jenre, borrowingPeriod, quantity);
		this.price = price;
	}
	
	@Override
	public void approach() {
		System.out.println("This book available for reading, Borrowing and buying, your options are:"
			+ "\n0: read | 1: return after reading | 2: borrow | 3: return after borrowing | 4: buy");
		int choise = (int)(Math.random()*5);
		System.out.println("You choose: " + choise);
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
			break;
		case 4:
			buyBook();
		}
	}

	@Override
	public boolean available() {
		if( quantity-borrowed-inReading>0)
			return true;
		return false;
	}

	@Override
	public void buyBook() {
		if(available()) {
			quantity--;
			System.out.println("You bought the book " + super.toString());
		}
		else
			System.out.println("The book is not available.");	
	}
	


}
