package javabootcamp.oop.libraryRunner;

import javabootcamp.oop.bookOptions.Book;
import javabootcamp.oop.bookOptions.Book.Genre;
import javabootcamp.oop.bookOptions.BorrowableBook;
import javabootcamp.oop.bookOptions.ReadableBook;
import javabootcamp.oop.bookOptions.SaleableBook;

public class Runner {

	public static void main(String[] args) {
		

		Genre cooking = Genre.COOKING;
		Genre novels = Genre.NOVEL;
		Genre dictionery = Genre.DICTIONERY;
		
		Book [] library  = new Book[6];
		library[0]= new BorrowableBook("Cooking guide", "Guy.T",'m',cooking,2,10);
		library[1]= new BorrowableBook("English dictionery", "miream",'f',dictionery,1,10);
		library[2]= new SaleableBook("Cooking master", "Guy.T",'m',cooking,1,10,30);
		library[3]= new SaleableBook("Java", "Guy.m",'m',novels,2,2,100);
		library[4]= new ReadableBook("Java to English", "Guy.T",'m',dictionery,1);
		library[5]= new ReadableBook("Cooking for begginers","Ketty.P",'f',cooking,5);
		
		for(Book lib:library) {
			lib.approach();
			lib.bookStatus();
			System.out.println("-----------");
		}
		

	}

}
