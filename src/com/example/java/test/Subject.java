package com.example.java.test;

public class Subject {
	
	public long subjectid;
	public String subtitle;
	public int duration_in_hours;
	//public Book reference;
	
	
	public Subject(long subjectid,String subtitle, int duration_in_hours)
	{
		this.subjectid=subjectid;
		this.subtitle=subtitle;
		this.duration_in_hours=duration_in_hours;
	}
	/*public void SetsubjectID(long subjectid)
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

	}*/
	
	public Long getSubjectid()
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
	@Override 
	public String toString ()
	{
		return "\nSubject ID:"+this.getSubjectid()+"\nSubject Title:"+this.getSubjecttitle()+"\nSubject Duration:"+this.getTime();
	}
	
	}

