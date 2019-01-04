package com.example.java.test;

import java.util.ArrayList;

public class help {
	ArrayList<Subject> mysubjects=new ArrayList<Subject>();
	ArrayList<Book> mybooks=new ArrayList<Book>();

	public Subject getsubject(long id) 
	{
		Subject subs = null;
		for (Object item : mysubjects) {
			subs = (Subject) item;
			if (subs.getSubjectid() == id) {
				return subs;
			}
		}
		return null;
	}
	
	public Book getbook(long id) 
	{
		Book bks = null;
		for (Object item : mybooks) {
			bks = (Book) item;
			if (bks.getBookid() == id) {
				return bks;
			}
		}
		return null;
	}
	
	
	public boolean addsubject(Subject subs)
	{
		return mysubjects.add(subs);
	}
	public boolean addbook(Book bks) {
		return mybooks.add(bks);
	}
	public boolean deletesubject(Subject subs)
	{
		return mysubjects.remove(subs);
	}
	public boolean deletebook(Book bks)
	{
		return mybooks.remove(bks);
	}
	public ArrayList<Book> getAllbooks() {
		return mybooks;
	}
	public ArrayList<Subject> getAllsubjects() {
		return mysubjects;
	}
}
