package com.interview.designpattern;

import java.util.ArrayList;

interface Observer{
	public void update(Subject s);
}

interface Subject{
	public void registerObserver(Observer o);
	public void removerObserver(Observer o);
	public void notifyAllObserver();
}

class HeadHunter implements Subject{

	private ArrayList<Observer> userList;
	private ArrayList<String> jobs;
	
	public HeadHunter() {
		// TODO Auto-generated constructor stub
		userList = new ArrayList<>();
		jobs = new ArrayList<>();
	}
	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		userList.add(o);
	}

	@Override
	public void removerObserver(Observer o) {
		// TODO Auto-generated method stub
		int a = userList.indexOf(o);
		userList.remove(a);
	}

	@Override
	public void notifyAllObserver() {
		// TODO Auto-generated method stub
		for (Observer o : userList) {
			o.update(this);
		}
	}
	
	public void addJob(String job){
		this.jobs.add(job);
		notifyAllObserver();
	}
	
	public ArrayList<String> getJobs() {
		return jobs;
	}
 
	public String toString(){
		return jobs.toString();
	}
}

class JobSeeker implements Observer{
	private String name;
	public JobSeeker(String name) {
		this.name = name;
	}

	@Override
	public void update(Subject s) {
		// TODO Auto-generated method stub
		System.out.println(this.name+" get notified!");
		System.out.println(s);	
	}
	
}

public class ObserverTest{
	public static void main(String[] args) {
		HeadHunter hh = new HeadHunter();
		hh.registerObserver(new JobSeeker("Mike"));
		hh.registerObserver(new JobSeeker("Chris"));
		hh.registerObserver(new JobSeeker("Jeff"));
		
		hh.addJob("Google job");
		hh.addJob("Yahoo Job");
		
		
	}
}




