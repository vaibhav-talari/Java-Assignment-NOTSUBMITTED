package com.examples.java.one;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class libraryService {

	
	//ArrayList<Subject> subjects = new ArrayList<Subject>();
	Map<Long, Subject> subjects = new HashMap<>();
	//Set<Book> references=new HashSet<Book>();
	Map<Long,Book> references=new HashMap<>();

	/*public Subject getsubject(long id) 
	{
		Subject subs = null;
		for (Object item : subjects) {
			subs = (Subject) item;
			if (subs.getSubjectid() == id) {
				return subs;
			}
		}
		return null;
	}*/
	
				public Subject getsubject(long id)
				{
					return subjects.get(id);
				}
	
	/*public Book getbook(long id) 
	{
		Book bks = null;
		for (Object item : references) {
			bks = (Book) item;
			if (bks.getBookid() == id) {
				return bks;
			}
		}
		return null;
	}*/
				
				public Book getbook(long id)
				{
					return references.get(id);
				}
	
	
	/*public boolean addsubject(Subject subs)
	{
		return subjects.add(subs);
	}*/
	
			public boolean addsubject(Subject subs)
			{
				return subjects.put(subs.getSubjectid(),subs) != null ? false : true;
			}
	
	/*public boolean addbook(Book bks) 
	{
		return references.add(bks);
	}*/
			
			public boolean addbook(Book bks)
			{
				return references.put(bks.getBookid(),bks) != null ? false :true ;
			}
			
	/*public boolean deletesubject(Subject subs)
	{
		return subjects.remove(subs);
	}*/
	
				public boolean deletesubject(Subject subs) 
				{
					return subjects.remove(subs.getSubjectid()) != null ? true : false;
				}
	
	/*public boolean deletebook(Book bks)
	{
		return references.remove(bks);
	}*/
				
				public boolean deletebook(Book bks) 
				{
					return references.remove(bks.getBookid()) != null ? true : false;
				}	
				
	/*public Set<Book> getAllbooks() 
	{
		return references;
	}*/
	
				public List<Book> getAllbooks() 
				{
					return new ArrayList<>(references.values());
				}
	
	/*public ArrayList<Subject> getAllsubjects() 
	{
		return subjects;
	}*/
	
	
			public List<Subject> getAllsubjects() 
			{
				return new ArrayList<>(subjects.values());
			}
			
	
public List<Subject> searchsubjectwithtitle(String text)
{
		//return subjects.values().stream().filter(su->su.getSubjecttitle().startsWith(text)).map(su->su.getSubjecttitle()).collect(Collectors.toList());
		return subjects.values().stream().filter(su->su.getSubjecttitle().startsWith(text)).collect(Collectors.toList()); //if this is used then it return List<Subject> (change List<String to List<Subject>>) and vice versa.

}

public List<Book> searchbookwithtitle(String text)
{
	return references.values().stream().filter(bu->bu.getTitle().startsWith(text)).collect(Collectors.toList());
}

public List<Book> searchbookwithvolume(int num)
{
	return references.values().stream().filter(bu->bu.getVolume()>num).collect(Collectors.toList());
}


public List<Book> sortbooks()
{
	//return references.values().stream().filter(bu->bu.getVolume()>num).collect(Collectors.toList());
	return references.values().stream().filter(bu->bu.getVolume()>0).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
}

	public void data(){
	try {
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\715328\\Desktop\\programcodeoutput\\libraryservice.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(subjects);
		out.writeObject(references);
		out.close();
		fileOut.close();
		System.out.printf("Serialized data is saved to Path -> C:\\Users\\715328\\Desktop\\programcodeoutput\\libraryservice.ser");
	} catch (IOException i) {
		i.printStackTrace();
	}
}
	
	
	
	

}
	
