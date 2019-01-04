package com.example.java.test;

import java.time.LocalDate;

public class Book  {

	public long bookid;
	public String title;
	public double price;
	public int volume;
	LocalDate publishDate = LocalDate.now(); 
	
	public Book(long bookid,String title,double price,int volume)
	{
		this.bookid=bookid;
		this.title=title;
		this.price=price;
		this.volume=volume;
	}
	
	/*public void Setbookid(long bookid)
	{
		this.bookid=bookid;
	}
	public void Setbooktitle(String title)
	{
		this.title=title;
	}
	public void Setbookprice(double price)
	{
		this.price=price;
	}
	public void Setbookvolume(int volume)
	{
		this.volume=volume;	
	}*/
	
	public long getBookid()
	{
		return bookid;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getVolume()
	{
		return volume;
	}
	
	public LocalDate getDate()
	{
		return publishDate;
	}
	@Override 
	public String toString ()
	{
		return "\nBook ID"+this.getBookid()+"\nBook Title:"+this.getTitle()+"\nBook Price:"+this.getPrice()+"\nBook Volume:"+this.getVolume()+"\nPublished Time:"+this.getDate();
	}
	
	}
	

