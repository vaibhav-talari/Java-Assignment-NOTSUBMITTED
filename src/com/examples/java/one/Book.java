
package com.examples.java.one;
//import java.util.Scanner;
import java.time.LocalDate;

public class Book implements java.io.Serializable {

	private static final long serialVersionUID = -342534524065096694L;
	public long bookid;
	public String title;
	public double price;
	public int volume;
	
	public LocalDate publishDate;
	public int month,year,date;
	
	public void Setbookid(long bookid)
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
	}
	
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
	
	public void settheDate(int year,int month,int date)
	{
		this.year=year;
		this.month=month;
		this.date=date;
		publishDate = LocalDate.of(year, month, date);
	}
	
	public LocalDate gettheDate()
	{
		return publishDate;
	}
		
	
	
	}
	

