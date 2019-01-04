package com.examples.java.one;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;

public class DeserializeFile {
	@SuppressWarnings("unchecked")
	public static void main(String [] args) {
	      //ArrayList<Subject> e = null;
	      Map<Long, Subject> e=null;
	      //Set<Book> f=null;
	      Map<Long,Book> f=null;
	      try {
	         FileInputStream fileIn = new FileInputStream("C:\\Users\\715328\\Desktop\\programcodeoutput\\libraryservice.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Map<Long, Subject>) in.readObject();
	         f=(Map<Long,Book>)in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Subject class not found");
	         c.printStackTrace();
	         return;
	      }
    	  System.out.println("Deserialized Subject...");
    	  ArrayList<Subject> list=new ArrayList<Subject>(e.values());
	      for (Subject run : list) 
	    	{
		      System.out.println("ID:" + run.subjectid);
		      System.out.println("Title:" + run.subtitle);
		      System.out.println("Duration:" + run.duration_in_hours);
	    	}
    	  System.out.println("Deserialized Book...");
    	  
    	  ArrayList<Book> line=new ArrayList<Book>(f.values());
	      for (Book run : line) 
	    	{
		      System.out.println("ID:" + run.getBookid());
		      System.out.println("Title:" + run.getTitle());
		      System.out.println("Price:" + run.getPrice());
		      System.out.println("Volume:" + run.getVolume());
		      System.out.println("Time:" + run.gettheDate());

	    	}
	      
	   }

}
