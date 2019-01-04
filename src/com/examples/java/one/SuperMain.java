package com.examples.java.one;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.examples.java.exception.*;


public class SuperMain 
{

	private static Scanner scanner = null;
	private static libraryService libservice = null;
	
	public static void main(String[] args) {
		int option;
		scanner = new Scanner(System.in);
		libservice = new libraryService();
		System.out.println("Welcome to the LIBRARY!!!");
		try
		{
		do{
				System.out.println();
				System.out.println("1. Add Subject");
				System.out.println("2. Add Book");
				System.out.println("3. Delete Subject");
				System.out.println("4. Delete Book");
				System.out.println("5. Search Subject");
				System.out.println("6. Search Book");
				System.out.println("7. Print Subject reference");

				System.out.println("8. Exit");
				System.out.print("\nEnter your option: ");
				option = scanner.nextInt();
					try{		
					switch (option) 
					{
					case 1:
						createSubject();
						break;
					case 2:
						createBook();
						break;
					case 3:
						deleteSubject();
						break;
					case 4:
						deleteBook();
						//listselectedbooks(libservice.sortbooks());
						break;
					case 5:
						searchSubject();
						break;
					case 6:
						searchBook();
						break;
					case 7:
						printReference();
						break;
					case 8:
						exit();
						break;
						
					default:
						System.out.println("Invalid option entered. Please enter correct option.");
						break;
					}
					}catch(exception1|exception2 e)
					{
						System.out.println(e.getMessage());
					}
		
		}while(option!=8);
		System.out.println("\nThank you!!!");
	}finally{scanner.close();}
	}
private static void createSubject() throws exception1
	{
	Subject subject = new Subject();

	System.out.println("\n-----Enter Subject details-----");
	System.out.print("\nEnter Subject ID: ");
	try{
		long id = Long.parseLong(scanner.next());
		scanner.nextLine();
		subject.SetsubjectID(id);
		}catch(InputMismatchException|NumberFormatException e)
			{
			throw new exception1("\n-+-+-+-\nInvalid Subject ID.\nPlease enter valid ID.\n-+-+-+-");
			}
		captureDetailSubject(subject);
		boolean isCreateSuccess = libservice.addsubject(subject);
		String message = isCreateSuccess ? "Subject created successfully." : "Subject creation failed.";
		System.out.println(message);
			
		
	}
private static void createBook()throws exception1
	{
	Book book = new Book();
	System.out.println("\nEnter Book details...");
	System.out.print("\nEnter Book ID: ");
	try{
	long id = Long.parseLong((scanner.next()));
	scanner.nextLine();
	book.Setbookid(id);
	}catch(NumberFormatException|InputMismatchException e)
		{
		throw new exception1("\n-+-+-+-\nInvalid Book ID.\nPlease enter valid ID.\n-+-+-+-");
		}
	captureDetailBook(book);
	boolean isCreateSuccess = libservice.addbook(book);
	String message = isCreateSuccess ? "Book created successfully." : "Book creation failed.";
	System.out.println(message);
	}
private static void deleteSubject() throws exception2
	{
	System.out.print("---Avaliable SUBJECTS---\n");
	listallsubjects();
	System.out.print("\nEnter ID of SUBJECT to delete:");
	long id = scanner.nextLong();
	Subject subject = libservice.getsubject(id);
	if(subject==null)
	{
		throw new exception2("\n-+-+-+-\nNo SUBJECT found with ID:"+id+"\n-+-+-+-");
	}
	boolean isDeleteSuccess = libservice.deletesubject(subject);
	String message = isDeleteSuccess ? "Subject deleted successfully." : "Subject deletion failed.";
	System.out.println(message);
	System.out.print("---SUBJECTS after deletion\n---");
	listallsubjects();
	}
private static void deleteBook() throws exception2
	{
	System.out.print("---Avaliable BOOKS---\n");
	listallbooks();
	System.out.print("\nEnter ID of BOOK to delete:");
	long id = scanner.nextLong();
	Book book = libservice.getbook(id);
	if(book==null)
	{
		throw new exception2("\n-+-+-+-\nNo BOOK found with ID:"+id+"\n-+-+-+-");
	}
	boolean isDeleteSuccess = libservice.deletebook(book);
	String message = isDeleteSuccess ? "Book deleted successfully." : "Book deletion failed.";
	System.out.println(message);
	System.out.print("---BOOKS after deletion---\n");
	listallbooks();
	}
private static void searchSubject() throws exception2
	{
	System.out.println("\nEnter 1<-- Search with ID\nEnter 2<--Search with'Subjects starting with-'-X-X-':");
	System.out.print("\nEnter choice:");
	int searchoption=scanner.nextInt();
if(searchoption==1)
	{
	System.out.print("\nEnter ID of SUBJECT to view:");
	long id = scanner.nextLong();
	Subject subject = libservice.getsubject(id);
	if(subject==null)
	{
		throw new exception2("\n-+-+-+-\nNo RECORD of SUBJECT found with ID:"+id+"\n-+-+-+-");
	}
	printHeadersubject();
	printDetailSubject(subject);
	System.out.println();
	}
	
if(searchoption==2)
{
	
	System.out.print("Enter the Subject Title you want to Search:");
	scanner.nextLine();
	String searchsubtitle=scanner.nextLine();
	listselectedsubjects(libservice.searchsubjectwithtitle(searchsubtitle));
	
	
}
}
private static void searchBook() throws exception2
	{
	System.out.println("\nEnter 1<-- Search with ID\nEnter 2<--Search with'Book starting with-'-X-X-'\nEnter 3<--Search Book with Volume greater than '-X-X-':");
	System.out.print("\nEnter choice:");
	int searchoption=scanner.nextInt();
	if(searchoption==1)
	{
	System.out.print("\nEnter ID of BOOK to view: ");
	long id = scanner.nextLong();
	Book book = libservice.getbook(id);
	if(book==null)
	{
		throw new exception2("\n-+-+-+-\nNo RECORD of Book found with ID:"+id+"\n-+-+-+-");
	}
	printHeaderbook();
	printDetailBook(book);
	System.out.println();
	}
	if(searchoption==2)
	{
		System.out.print("Enter the Book Title you want to Search:");
		scanner.nextLine();
		String searchbkstitle=scanner.nextLine();
		listselectedbooks(libservice.searchbookwithtitle(searchbkstitle));
	}
	if(searchoption==3)
		{
		System.out.print("Enter the Book Volume you want to Search and list:");
		 int searchbkspub=scanner.nextInt();
		 listselectedbooks(libservice.searchbookwithvolume(searchbkspub));

		}
	}
private static void captureDetailSubject(Subject subject)  
	{
	int i;
	System.out.print("Enter SUBJECT Title:");
	subject.Setsubjecttitle(scanner.nextLine());
	System.out.print("Enter duration of SUBJECT:");
	int time = Integer.parseInt(scanner.next());
	subject.Settimeduration(time);
	System.out.println("Enter the number of reference you want to Enter:");
	int no=scanner.nextInt();
	for(i=0;i<no;i++)
	{
		System.out.print("Enter the ID of Book:");
		long ref=scanner.nextLong();
		subject.setreferenceID(ref);
	}
	}
private static void captureDetailBook(Book book) throws exception1
	{
	System.out.print("Enter Book title: ");
	book.Setbooktitle(scanner.nextLine());
	try
	{
	System.out.print("Enter Book price: ");
	int cost = Integer.parseInt(scanner.next());
	book.Setbookprice(cost);
	}catch(InputMismatchException|NumberFormatException e)
	{
		throw new exception1("\n-+-+-+-\nEnter Valid Price\n-+-+-+-");
	}
	try
	{
	System.out.print("Enter Book Volume: ");
	int vol=Integer.parseInt(scanner.next());
	book.Setbookvolume(vol);
	}catch(InputMismatchException|NumberFormatException e)
	{
		throw new exception1("\n-+-+-+-\nEnter Valid Volume\n-+-+-+-");
	}
	System.out.print("Enter Book Published Year: ");
	int year=Integer.parseInt(scanner.next());
	System.out.print("Enter Book Published Month: ");
	int month=Integer.parseInt(scanner.next());
	System.out.print("Enter Book Published Date: ");
	int date=Integer.parseInt(scanner.next());
	book.settheDate(year,month,date);
	}
private static void printHeadersubject()
	{
	System.out.format("\n%5s%10s%15s", "ID", "TITLE", "Time Duration");
	}
private static void printHeaderbook()
{
System.out.format("\n%5s %10s %15s %20s %30s", "ID", "TITLE", "Price","Volume","Published Time");
}
private static void printDetailSubject(Subject subject) {
	if (subject == null) {
		return;
	}

	System.out.format("\n%5d%10s%15d", subject.getSubjectid(), subject.getSubjecttitle(), subject.getTime());
}
private static void printDetailBook(Book book) 
	{
	if (book == null) {
		return;
	}

	System.out.format("\n%5d %10s %15f %20d %25tA, %tB' %td", book.getBookid(), book.getTitle(), book.getPrice(),book.getVolume(),book.gettheDate(),book.gettheDate(),book.gettheDate());
	}
private static void listallsubjects() 
	{

	List<Subject> subject = libservice.getAllsubjects();


	printHeadersubject();

	for (Object run : subject)
	{
		printDetailSubject((Subject) run);
	}
	System.out.println();
	}


private static void listselectedsubjects(List<Subject> sub) 
{
printHeadersubject();

for (Object run : sub)
{
	printDetailSubject((Subject) run);
}
System.out.println();
}




private static void listallbooks() 
	{

	List<Book> book = libservice.getAllbooks();

	printHeaderbook();

	for (Object run : book) 
	{
		printDetailBook((Book) run);
	}
	System.out.println();
	}



private static void listselectedbooks(List<Book> bks) 
	{

	printHeaderbook();

	for (Object run : bks) 
	{
		printDetailBook((Book) run);
	}
	System.out.println();
	}

public static void printReference() throws exception2
{
	System.out.println("Enter the Subject ID to print references:");
	long id = scanner.nextLong();
	Subject subject = libservice.getsubject(id);
	if(subject==null)
	{
		throw new exception2("\n-+-+-+-\nNo RECORD of SUBJECT found with ID:"+id+"\n-+-+-+-");
	}
	ArrayList<Long> ref=subject.getreference();
	if(ref.isEmpty())
	{
		System.out.print("\n-+-+-+-\nNo reference avaliable\n-+-+-+-\n");
	}
	else{
		System.out.println(ref);
	printHeaderbook();
	for(Long element: ref)
	{
		//System.out.println(element);
		Book book = libservice.getbook(element);
		if(book==null)
		{
			throw new exception2("\n-+-+-+-\nSorry there are no BOOK's for the specified SUBJECT ID\nThe Book listed in the reference is Deleted or not listed in database\nThe ID of the reference BOOK is:"+element+"\n-+-+-+-");
		}
		printDetailBook(book);
		System.out.println();
	}
	}
	
}



private static void exit() 
	{
	//libservice.data();
	System.out.println("\nThank you. File has been Saved!!!");
	System.exit(0);
	}
}


