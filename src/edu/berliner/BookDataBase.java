package edu.berliner;

import java.util.ArrayList;

public class BookDataBase {
	
	ArrayList<Book> bookList = new ArrayList<Book>();

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}
	
	public void addBook(Book bookToAdd)
	{
		bookList.add(bookToAdd);
	}
	
	

}
