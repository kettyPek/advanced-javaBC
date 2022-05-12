package javabootcamp.oop.bookOptions;

/**
 * This class describes a book.
 * @author ketty
 *
 */
public abstract class Book implements Readable {

	protected String title;
	protected Author aouther;
	protected final Genre jenre;
	protected int quantity;
	protected int inReading;

	public Book(String title, String authorName, char authorGender, Genre jenre, int quantity) {
		this.title = title;
		aouther = new Author(authorName, authorGender);
		this.jenre = jenre;
		this.quantity = quantity;
		inReading = 0;
	}

	@Override
	public String toString() {
		return title + ", by " + aouther.getAuthorName();
	}

	public void readBook() {
		if(available()) {
			System.out.println("You took the book " + toString() + " for reading in the library.");
			inReading++;
		}
		else
			System.out.println("The book " + toString() + " is not available for reading.");
	}

	public void returnBook() {
		inReading--;
		System.out.println("You retruned the book " + toString() + " to the library.");
	}

	public abstract void approach();

	public  boolean available() {
		if(quantity-inReading>0)
			return true;
		return false;
	}
	
	public abstract void bookStatus();

	public static enum Genre {
		COOKING, NOVEL, DICTIONERY;
	}

}
