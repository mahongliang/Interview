package com.interview.designpattern;

interface Button{
	public void display();
}

class SpringButton implements Button{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("springbutton");
	}
}

class SummerButton implements Button{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("summerbutton");
	}
	
}

//文本框接口：抽象产品  
interface TextField {  
  public void display();  
}  

//Spring文本框类：具体产品  
class SpringTextField implements TextField {  
  public void display() {  
      System.out.println("显示绿色边框文本框。");  
  }  
}  

//Summer文本框类：具体产品  
class SummerTextField implements TextField {  
  public void display() {  
      System.out.println("显示蓝色边框文本框。");  
  }     
}  

//组合框接口：抽象产品  
interface ComboBox {  
  public void display();  
}  

//Spring组合框类：具体产品  
class SpringComboBox implements ComboBox {  
  public void display() {  
      System.out.println("显示绿色边框组合框。");  
  }  
}  

//Summer组合框类：具体产品  
class SummerComboBox implements ComboBox {  
  public void display() {  
      System.out.println("显示蓝色边框组合框。");  
  }     
}  

interface SkinFactory{
	public Button createButton();
	public TextField createTextField();
	public ComboBox createComboBox();
}

class SpringSkinFactroy implements SkinFactory{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new SpringButton();
	}

	@Override
	public TextField createTextField() {
		// TODO Auto-generated method stub
		return new SpringTextField();
	}

	@Override
	public ComboBox createComboBox() {
		// TODO Auto-generated method stub
		return new SpringComboBox();
	}
	
}

class SummerSkinFactory implements SkinFactory{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new SummerButton();
	}

	@Override
	public TextField createTextField() {
		// TODO Auto-generated method stub
		return new SummerTextField();
	}

	@Override
	public ComboBox createComboBox() {
		// TODO Auto-generated method stub
		return new SummerComboBox();
	}
	
}


public class AbstractFactoryTest {
	
	
	public static void main(String[] args) {
		SkinFactory factory = new SpringSkinFactroy();
		Button btButton = factory.createButton();
		TextField textField = factory.createTextField();
		ComboBox comboBox = factory.createComboBox();
		
		btButton.display();
		textField.display();
		comboBox.display();
	}

}
