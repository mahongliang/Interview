package com.interview.designpattern;

abstract class Girl{
	String description = "no partiular";
	public String getDescription(){
		return description;
	}
}

class AmericanGirl extends Girl{
	public AmericanGirl(){
		description = "+American";
	}
}

class EuropeanGirl extends Girl{
	public EuropeanGirl() {
		// TODO Auto-generated constructor stub
		description = "+Europen";
	}
}

abstract class GirlDecorator extends Girl{
	 
	public abstract String getDescription();
}

class Science extends GirlDecorator{

	private Girl girl;
	public Science(Girl g) {
		// TODO Auto-generated constructor stub
		girl = g;
	}
	
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return girl.description+"+Like Science";
	}
	
	public void caltulateStuff() {
		System.out.println("scientific calculation!");
	}	
}

class Art extends GirlDecorator{
	private Girl girl;
	public Art(Girl g){
		this.girl = g;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return girl.getDescription()+"+Like Art";
	}
	
	public void draw() {
		System.out.println("draw pictures!");
	}
}

public class DecoratorTest {
	public static void main(String[] args) {
		Girl g1 = new AmericanGirl();
		System.out.println(g1.getDescription());
		
		Science g2 = new Science(g1);
		System.out.println(g2.getDescription());
		
		Art g3 = new Art(g2);
		System.out.println(g3.getDescription());
		
	}
}
