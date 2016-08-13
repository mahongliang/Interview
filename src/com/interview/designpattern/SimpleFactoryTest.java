package com.interview.designpattern;

interface Chart{
	public void display();
}

class HistogramChart implements Chart{
	public HistogramChart() {
		// TODO Auto-generated constructor stub
		System.out.println("crate histogram");
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("display histogram");
	}
	
	
}

class PieChart implements Chart{
	public PieChart(){
		System.out.println("create piechar");
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("display piechar");
	}
	
}

class LineChart implements Chart{
	public LineChart(){
		System.out.println("create linechart");
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("display linechart");
	}
}

class ChartFactory{
	public static Chart getChart(String type){
		Chart chart = null;
		if (type.equalsIgnoreCase("histogram")) {
			chart = new HistogramChart();
		}else if(type.equalsIgnoreCase("pie")){
			chart = new PieChart();
		}else {
			chart = new LineChart();
		}
		return chart;
	}
}



public class SimpleFactoryTest {
	public static void main(String[] args) {
		Chart chart = ChartFactory.getChart("pie");
		chart.display();
	}
}


