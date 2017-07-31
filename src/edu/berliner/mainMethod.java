package edu.berliner;
import java.util.*;

public class mainMethod {
/*
 * Comments on program go here-ran out of time
 */
	
	
	static Scanner scan;

	static BookDataBase bookDB = new BookDataBase();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instantiations and variables
		scan = new Scanner(System.in);
		int choice=0;
		
		
		while(choice!=5)
		{
			System.out.printf("Welcome to the Library.  What would you like to do?%n"
					+ "1-Add a book%n"
					+ "2-Search by SKU%n"
					+ "3-Search by Author%n"
					+ "4-Search by Category%n"
					+ "5-Quit%n");
			
			choice=scan.nextInt();
			scan.nextLine();
			switch(choice)
			{
				case 1:
				{
					addBook();
					break;
				}
				case 2:
				{
					printBook(selectBookBySku());
					break;
				}
				case 3:
				{
					selectBookByAuthor();
					break;
				}
				case 4:
				{
					selectBookByCat();
					break;
				}
				case 5:
				{
					System.out.println("Have a nice day! Good bye!");
					scan.close();
					break;
				}
				default:
				{
					System.out.println("That's not a valid choice.");
				}
			}
		}
		
		
				
	}
	private static void selectBookByCat() {
		
		System.out.println("What category would you like to look for?");
		String catToFind=scan.nextLine();
		boolean found=false;
		for(int counter=0;counter< bookDB.getBookList().size(); counter++)
		{
			if(bookDB.getBookList().get(counter).getCategory().equalsIgnoreCase(catToFind))
			{
				printBook(bookDB.getBookList().get(counter));
				found=true;
			}
		}
		if(!found) System.out.println("No books match that category.");
	}
	
	private static void selectBookByAuthor() {
		//TODO
		System.out.println("What author would you like to look for?");
		String authToFind=scan.nextLine();
		boolean found=false;
		for(int counter=0;counter<bookDB.getBookList().size(); counter++)
		{
			if(bookDB.getBookList().get(counter).getAuthor().contains(authToFind))
			{
				printBook(bookDB.getBookList().get(counter));
				found=true;
			}
		}
		if(!found) System.out.println("No books match that author.");
	}
	
	
	public static void addBook()
	{
		Book book=new Book();//make new book object
		
		//prompt for entries
		System.out.println("What's the SKU?");
		book.setSku(scan.nextLine());
		System.out.println("What's the title?");
		book.setTitle(scan.nextLine());
		System.out.println("Who is/are the author/s?");
		book.setAuthor(scan.nextLine());
		System.out.println("What's the description?");
		book.setDescr(scan.nextLine());
		System.out.println("What's the category?");
		book.setCategory(scan.nextLine());
		System.out.println("What's the price?");
		book.setPrice(scan.nextDouble());
		
		
		//add book to ArrayList(database)
		bookDB.addBook(book);
		
		System.out.print("Book added: "); //Confirm book added
		printBook(bookDB.getBookList().get(bookDB.getBookList().size()-1));
		//printBook(bookList.get(bookList.size()-1)); //print last book
		
	}
	
	/*returns a book object based on given sku*/
	public static Book selectBookBySku()
	{

		System.out.println("What sku do you want to search for?");
		String skuToFind = scan.nextLine();
		for(int counter=0;counter<bookDB.getBookList().size(); counter++)
		{
			if(bookDB.getBookList().get(counter).getSku().equalsIgnoreCase(skuToFind))
			{
				//bookToPrint=bookList.get(counter);
				return bookDB.getBookList().get(counter);
				
			}
		}
		System.out.println("SKU not found");
		return null;
	}
	
	public static void printBook(Book bookToPrint)
	{
		if(bookToPrint!=null)
		System.out.printf("SKU:%s Title:%s Author(s):%s Category:%s Price:$%.2f Description:%s%n",bookToPrint.getSku(),bookToPrint.getTitle(),bookToPrint.getAuthor(),bookToPrint.getCategory(),bookToPrint.getPrice(),bookToPrint.getDescr());
	}
	

	
	
}
	