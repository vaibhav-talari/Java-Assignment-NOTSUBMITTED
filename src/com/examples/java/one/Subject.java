package com.examples.java.one;

import java.util.ArrayList;

//import java.util.Scanner;

public class Subject implements java.io.Serializable {
	
	private static final long serialVersionUID = -7987392421065096694L;
	public long subjectid;
	public String subtitle;
	public int duration_in_hours;
	public ArrayList<Long> listofid=new ArrayList<Long>();
	

	
	
	
	public void SetsubjectID(long subjectid)
	{
		this.subjectid=subjectid;

	}
	public void Setsubjecttitle(String subtitle)
	{
		this.subtitle=subtitle;

	}
	public void Settimeduration(int duration_in_hours)
	{
		this.duration_in_hours=duration_in_hours;	

	}
	
	public long getSubjectid()
	{
		return subjectid;
	}
	
	public String getSubjecttitle()
	{
	return subtitle;
	}
	
	public int getTime()
	{
		return duration_in_hours;
	}
	
	public void setreferenceID(long id)
	{
		listofid.add(id);
	}
	
	public ArrayList<Long> getreference()
	{
		return listofid;
	}
	}

