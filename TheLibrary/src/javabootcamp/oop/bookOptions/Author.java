package javabootcamp.oop.bookOptions;

public class Author {
	
	private String authorName;
	private char authorGender;
	
	public Author(String authorName, char authorGender) {
		this.authorName = authorName;
		setAuthorGender(authorGender);
	}
	
	private void setAuthorGender(char authorGender) {
		if(authorGender=='f' || authorGender=='m')
			this.authorGender = authorGender;
		else
			this.authorGender = 'u';
	}

	public String getAuthorName() {
		return authorName;
	}

	public char getAuthorGender() {
		return authorGender;
	}


	
	
	
	
	

}
