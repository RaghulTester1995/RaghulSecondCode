package org.mainclass.test;

import org.baseclass.test.LibGlobal;
import org.openqa.selenium.WebElement;


public class SubClass extends LibGlobal{

	public static void main(String[] args) {
		LibGlobal global=new LibGlobal();
		global.getDriver("chrome");
		global.launchurl("https://en-gb.facebook.com/");
		WebElement element = global.findByElement("id", "email");
		global.sendkey(element, "greens");
		
		
		
		
		
		
		
		
		
//		global.getDriver("chrome");
//        global.launchurl("https://en-gb.facebook.com/");
//        WebElement findByElement = global.findByElement("id", "email");
//        global.sendkey(findByElement, "greens javaaa");
//        WebElement pswrd = global.findByElement("Name", "pass");
//        global.sendkey(pswrd, "password");
//        WebElement lgn = global.findByElement("name", "login");
//        global.clickbtn(lgn);
//        WebElement creatacc = global.findByElement("xpath","(//a[@role='button'])[2]");
//        global.clickbtn(creatacc);
//        WebElement day = global.findByElement("xpath", "//select[@title='Day']");
//        global.selectByDropdown(day, "value", "4");
//        WebElement radiobtn = global.findByElement("xpath", "(//input[@type='radio'])[2]");
//        global.clickbtn(radiobtn);
//        WebElement name = global.findByElement("xpath", "(//input[@type='text'])[2]");
//        global.selectByJs("java", name);
//        
//        String dataFromExcel = global.dataFromExcel("C:\\Users\\welcome\\eclipse-workspace\\MavenProject\\Excel\\Book1.xlsx", "Product", 0, 0);
//        System.out.println(dataFromExcel);  
	}

}
