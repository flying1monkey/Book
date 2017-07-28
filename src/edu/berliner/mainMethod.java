package edu.berliner;
import java.util.*;

public class mainMethod {

	static String []skus={"Java1001","Java1002", "Orcl1003", "Python1004","Zombie1005","Rasp1006"}; 
	static String []titles={"Head First Java","Thinking in JavaOCP: Oracle Certified Professional","Java SE",
					 "Automate the Boring Stuff with Python","The Maker's Guide to the Zombie Apocalypse",
					 "Raspberry Pi Projects for the Evil Genius"}; 
	static String []authors={"Kathy Sierra and Bert Bates","Bruce Eckel","Jeanne Boyarsky","Al Sweigart","Simon Monk",
					  "Donald Norris"}; 
	static String []descriptions={"Easy to read Java workbook","Details about Java under the hood",
						   "Everything you need to know in one place","Fun with Python",
						   "Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi",
						   "A dozen fiendishly fun projects for the Raspberry Pi!"};
	static double []prices={47.5,20,45,10.5,16.5,14.75};
	static String []cats={"comp sci","comp sci","comp sci","comp sci","comp sci","comp sci",};
	
	static ArrayList<Book> bookList=new ArrayList<Book>();
	static Scanner scan;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instantiations
		scan = new Scanner(System.in);//new scanner object
		int choice=0;
		cheat();
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
					printAll();
					break;
				}
				default:
				{
					System.out.println("That's not a valid choice.");
				}
			}
		}
		
		System.out.println("Have a nice day! Good bye!");
		scan.close();
				
	}
	private static void selectBookByCat() {
		System.out.println("What category would you like to look for?");
		String catToFind=scan.nextLine();
		boolean found=false;
		for(int counter=0;counter<bookList.size(); counter++)
		{
			if(bookList.get(counter).getCategory().equalsIgnoreCase(catToFind))
			{
				printBook(bookList.get(counter));
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
		for(int counter=0;counter<bookList.size(); counter++)
		{
			if(bookList.get(counter).getAuthor().contains(authToFind))
			{
				printBook(bookList.get(counter));
				found=true;
			}
		}
		if(!found) System.out.println("No books match that author.");
	}
	/*returns a book object based on given sku*/
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
		System.out.println("What's the price?");
		book.setPrice(scan.nextDouble());
		System.out.println("What's the category?");
		book.setCategory(scan.nextLine());
		
		//add book to ArrayList(database)
		bookList.add(book);
		System.out.print("Book added: "); //Confirm book added
		printBook(bookList.get(bookList.size()-1)); //print last book
		
	}
	
	public static Book selectBookBySku()
	{

		System.out.println("What sku do you want to search for?");
		String skuToFind = scan.nextLine();
		for(int counter=0;counter<bookList.size(); counter++)
		{
			if(bookList.get(counter).getSku().equalsIgnoreCase(skuToFind))
			{
				//bookToPrint=bookList.get(counter);
				return bookList.get(counter);
				
			}
		}
		System.out.println("SKU not found");
		return null;
	}
	
	public static void printBook(Book bookToPrint)
	{
		if(bookToPrint!=null)
		//System.out.printf("For SKU \"%s\", the title is \"%s\", author(s) is/are \"%s\", price is $%.2f, and the description is \"%s\"%n",bookToPrint.getSku(),bookToPrint.getTitle(),bookToPrint.getAuthor(),bookToPrint.getPrice(),bookToPrint.getDescr());
		System.out.printf("%s %s %s %s $%.2f %s%n",bookToPrint.getSku(),bookToPrint.getTitle(),bookToPrint.getAuthor(),bookToPrint.getCategory(),bookToPrint.getPrice(),bookToPrint.getDescr());
	}
	
	
	
	
	public static void printAll()
	{
		for(int counter=0;counter<bookList.size(); counter++)
		{
			printBook(bookList.get(counter));
		}
	}
	
	public static Book cheat()
	{
		Book bookcheat=new Book();//make new book object
		
		for(int counter=0; counter<6; counter++)//check each sku
		{
				bookcheat=new Book();
				bookcheat.setSku(skus[counter]);
				bookcheat.setTitle(titles[counter]);
				bookcheat.setAuthor(authors[counter]);
				bookcheat.setDescr(descriptions[counter]);
				bookcheat.setPrice(prices[counter]);
				bookcheat.setCategory(cats[counter]);
				bookList.add(bookcheat);
			
		}
		return bookcheat;  //return filled book object
}
}
	