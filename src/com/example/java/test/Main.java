package com.example.java.test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Main 
{
	static int number=0,i,j,count_subject=0,count_book=0;
	static Scanner main = new Scanner(System.in);
	/*static ArrayList<Subject> mysubjects=new ArrayList<Subject>();
	static ArrayList<Book> mybooks=new ArrayList<Book>();*/
	static help serve=null;

	public static void main(String[] args)
	{
		

		while(number!=7)
			{
		System.out.println("----------------------------------------");
		System.out.print("Enter 1 <--Add Subject\nEnter 2 <--Add Book\nEnter 3 <--Delete Subject\nEnter 4 <--Delete Book\nEnter 5 <--Search Subject\nEnter 6 <--Search Book\nEnter 7 <--Exit\n\nEnter your choice-->");
		number=main.nextInt();
		switch(number)
				{
		case 1:
			createSubject();
			break;
		/*case 2:
			createBook();
			break;
		case 3:
			deleteSubject();
			break;
		case 4:
			deleteBook();
			break;
		case 5:
			SearchSubject();
			break;
		case 6:
			SearchBook();
			break;*/
		case 7:
			exit();
			break;
			default:
				System.out.println("Enter Correct option.");
				break;
		}
	}
		System.out.print("Thank you u have exited the Menu");
		main.close();	
	}
	
	public static void createSubject()
	{
		System.out.println("----------------------------------------");

		System.out.println("------Enter Details For the Subject------");
		
		
		System.out.print("Enter the subject ID:");
		long subjectid=main.nextLong();
		main.nextLine();
		System.out.print("Enter the subject title:");
		String subtitle=main.nextLine();
		System.out.print("Enter the subject time duration in hours:");
		int duration_in_hours=main.nextInt();
		System.out.println("----------------------------------------");
		
		Subject sub=new Subject(subjectid,subtitle,duration_in_hours);
		
		boolean isCreateSuccess = serve.addsubject(sub);
		String message = isCreateSuccess ? "Employee created successfully." : "Employee creation failed.";
		System.out.println(message);
		/*mysubjects.add(count_subject,sub);
		count_subject++;		
		System.out.println("Subject count size:"+count_subject);

		}
		System.out.println("Thank you for entering the details");
		System.out.println("Array size of subjects:"+mysubjects.size());*/
	
	}
	/*public static void createBook()
	{
		System.out.println("------Enter Details For the Book------");
		System.out.print("Enter the number of Books you want to enter-");
		int maxbook=main.nextInt();
		for(j=0;j<maxbook;j++)
		{
		System.out.print("Enter the book ID:");
		long bookid=Long.parseLong(main.next());
		main.nextLine();// To consume the\n character left by the previous scanner input check link 'https://stackoverflow.com/questions/23036062/cant-use-scanner-nextint-and-scanner-nextline-together'
		System.out.print("Enter the book title:");
		String title=main.nextLine();


		System.out.print("Enter the book price:");
		double price=main.nextDouble();
		System.out.print("Enter the book volume:");
		int volume=main.nextInt();	
		System.out.println("----------------------------------------");
		
		Book book=new Book(bookid,title,price,volume);
		mybooks.add(count_book,book);
		count_book++;		
		System.out.println("Book count size:"+count_book);
		}
		System.out.println("Thank you for entering the details");
		System.out.println("Array size of books:"+mybooks.size());
	}
	public static void SearchSubject()
	{
		System.out.print("Select How you want to Search subject-\n1-->With ID \n2-->With Title\n3-->With Duration\nEnter choice:");
		int subjectselect=main.nextInt();
		
		switch(subjectselect)
		{
		case 1:
			System.out.print("Enter the Subject ID you want to Search:");
			long delsubid=main.nextLong();
			for(Subject item:mysubjects)
			{
				if(item.getSubjectid()==delsubid)
				{
				System.out.println("Viola Id");
				}
			
			}
			break;
		case 2:
			System.out.print("Enter the Subject Title you want to Search:");
			String delsubtitle=main.next();
			for(Subject item:mysubjects)
			{
				String name=item.getSubjecttitle();
				if(name.equals(delsubtitle))
				{
				System.out.println("Viola Title");
				
				}			
			}
			break;
		case 3:
			System.out.print("Enter the Subject Duration you want to Search:");
			int delsubduration=main.nextInt();
			for(Subject item:mysubjects)
			{
				if(item.getTime()==delsubduration)
				{
				System.out.println("Viola Time");
				}
			
			}
			break;
		}		
	}
	public static void deleteSubject()
	{
		System.out.println("Arraylist of Objects for subjects before delete:");
		printsubjectheader();
		printallsubjects();
		System.out.println("\n----------------------------------------");
		Iterator<Subject> itr=mysubjects.iterator();
		System.out.print("\nSelect How you want to Delete subject-\n1-->With ID \n2-->With Title\nEnter choice:");
		int subjectdelete=main.nextInt();
		switch(subjectdelete)
			{
			case 1:
				System.out.print("Enter the Id of subject to delete:");
				long delid=main.nextLong();			
				
				for(Subject item:mysubjects)
				{
				if(item.getSubjectid()==delid)
				{
					mysubjects.remove(item);
				}
				
				}
				
	
			
			break;
			case 2:
				System.out.print("Enter the Subject Title you want to Delete:");
				String delsubtitle=main.next();
				for(Subject item:mysubjects)
				{
					String name=item.getSubjecttitle();
					if(name.equals(delsubtitle))
					{
						mysubjects.remove(item);
					
					}			
				}
				
				break;
		}
		//System.out.println("\n----------------------------------------");
		//System.out.println("Arraylist of Objects for subjects after delete:");
		//printsubjectheader();
		//printallsubjects();
	}
	public static void deleteBook()
	{
		System.out.println("Arraylist of Objects for ooks before delete:");
		System.out.println("Arraylist of Objects for subjects after delete:"+mybooks);

		System.out.print("Select How you want to Delete Book-\n1-->With ID \n2-->With Title\nEnter choice:");
		int bookdelete=main.nextInt();
		switch(bookdelete)
			{
			case 1:
				System.out.println("Enter the Id of Book to delete:");
				long delid=main.nextLong();
				for(Book item:mybooks)
				{
				if(item.getBookid()==delid)
				{
					mybooks.remove(item);
				}
				}
				System.out.println("Arraylist of Objects for subjects after delete:"+mybooks);
	
			
			break;
			case 2:
				System.out.print("Enter the Book Title you want to Delete:");
				String delbktitle=main.next();
				for(Book item:mybooks)
				{
					String name=item.getTitle();
					if(name.equals(delbktitle))
					{
						mybooks.remove(item);
					
					}			
				}
				break;
	}
	}
	public static void SearchBook()
	{
		System.out.print("Select How you want to Search Book-\n1-->With ID \n2-->With Title\nEnter choice:");
		int bookselect=main.nextInt();
		
		switch(bookselect){
		case 1:
			System.out.print("Enter Book ID:");
			long bookId=main.nextLong();
			
			for(Book item: mybooks)
			{
				if(item.getBookid()==bookId)
				{
					System.out.println("Yoo Book found:");
				}
				
			}
		case 2:
			System.out.print("Enter Title");
			String bookTitle=main.next();
			for (Book item:mybooks)
			{
				String input=item.getTitle();
				if(input.equals(bookTitle))
				{
					System.out.print("Found Book with title-");
				}
			}

		}
	}*/
	/*public static void printbookheader()
	{
		System.out.format("\n%5s %15s %10s %10s %15s", "ID", "TITLE", "Price","Volume","Published Time");
	}
	public static void printsubjectheader()
	{
		System.out.format("\n%5s%15s%5s", "ID", "TITLE", "Time Duration");
	}
	public static void printbooks(Book book)
	{
		{
			if (book == null) {
				return;
			}

			System.out.format("\n%5d %15s %10f %10d %15tA, %tB' %td", book.getBookid(), book.getTitle(), book.getPrice(),book.getVolume(),book.getDate(),book.getDate(),book.getDate());
			}
	}
	public static void printsubjects(Subject subject)
	{
		if (subject == null)
		{
			return;
		}

		System.out.format("\n%5d%15s%5d", subject.getSubjectid(), subject.getSubjecttitle(), subject.getTime());
	}
	public static void printallsubjects()
	{
		for (Subject sub : mysubjects) {
			printsubjects(sub);
		}
	}
	public static void printallbooks()
	{
		for (Book bks : mybooks) {
			printbooks(bks);
		}
	}*/
	public static void exit(){
		
	}

}
	
	

	

