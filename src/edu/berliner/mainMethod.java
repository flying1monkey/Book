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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instantiations	
		Random rand=new Random();
		
		requestBook(skus[rand.nextInt(6)]);//request random book
		
		
		//printBook(requestBook(skus[rand.nextInt(6)]));
		
	}
	/*returns a book object based on given sku*/
	public static Book requestBook(String skuToFind)
	{
		Book book=new Book();//make new book object
		
		for(int counter=0; counter<6; counter++)//check each sku
		{
			if(skus[counter].equals(skuToFind))//when sku matches sku looked for, set book details
			{
				book.setSku(skus[counter]);
				book.setTitle(titles[counter]);
				book.setAuthor(authors[counter]);
				book.setDescr(descriptions[counter]);
				book.setPrice(prices[counter]);
			}
		}
		return book;  //return filled book object
	}
	
	public static void printBook(Book bookToPrint)
	{
		System.out.printf("For SKU \"%s\", the title is \"%s\", author(s) is/are \"%s\", price is $%.2f, and the description is \"%s\"%n",bookToPrint.getSku(),bookToPrint.getTitle(),bookToPrint.getAuthor(),bookToPrint.getPrice(),bookToPrint.getDescr());
	}
	

}
	