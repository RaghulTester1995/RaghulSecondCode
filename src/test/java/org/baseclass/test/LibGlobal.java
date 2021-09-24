package org.baseclass.test;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LibGlobal {
	WebDriver driver;
	
    public void getDriver(String browsername) {
	  try {
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\welcome\\eclipse-workspace\\MavenProject\\Driver\\chromedriver.exe");
			 driver = new ChromeDriver();
		}else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					"C:\\Users\\welcome\\eclipse-workspace\\MavenProject\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}else if (browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", 
					"C:\\Users\\welcome\\eclipse-workspace\\MavenProject\\Driver\\edgedriver.exe");
			driver = new EdgeDriver();
		}else {
			System.out.println("invalid browser");
		}
			
	} catch (Exception e) {
		System.out.println(e);
	}
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);	
    }
   public void launchurl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
    
   public WebElement findByElement(String data,String id ) {
	   WebElement findElement=null;  
	try {
		if (data.equalsIgnoreCase("id")) {
			findElement = driver.findElement(By.id(id));
		}else if (data.equalsIgnoreCase("name")) {
			 findElement = driver.findElement(By.name(id));
		}else if (data.equalsIgnoreCase("xpath")) {
			 findElement = driver.findElement(By.xpath(id));
		}else if (data.equalsIgnoreCase("classname")) {
			 findElement = driver.findElement(By.className(id));
			
		}else {
			System.out.println("no such element found");
		}		
	} catch (Exception e) {            
		System.out.println(e);
	}
    return findElement;
}
    public void sendkey(WebElement text,String data) {
		try {
			 text.sendKeys(data);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
    public void clickbtn(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
    public void moveToElement(WebElement target) {
		try {
			Actions actions=new Actions(driver);
			actions.moveToElement(target).perform();
		} catch (Exception e) {
			System.out.println(e);
			
		}

	}
    public void selectByDropdown(WebElement element,String name,String data) {
		try {
			Select select=new Select(element);
			if (name.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(data));	
			}else if (name.equalsIgnoreCase("visibletext")) {
				select.selectByVisibleText(data);	
			}else if (name.equalsIgnoreCase("value")) {
				select.selectByValue(data);	
			}else {
				System.out.println("invalid data");
			}			
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
    public void selectByJs(String data,WebElement element) {
		try {
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
    public String dataFromExcel(String path,String sheetname,int rowno,int cellno) {
    	
    	String value=null;
    	
    	try {
			File file=new File(path);
			FileInputStream ipStream= new FileInputStream(file);
			Workbook book = new XSSFWorkbook(ipStream);
			Sheet sheet = book.getSheet(sheetname);
			Row row = sheet.getRow(rowno);
			Cell cell = row.getCell(cellno);
			int cellType = cell.getCellType();
			if (cellType==1) {
				 value = cell.getStringCellValue();	
			}else if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
				  value = dateFormat.format(dateCellValue);		
			}else {
				 double numericCellValue = cell.getNumericCellValue();
				 long l =  (long) numericCellValue;
				 value = String.valueOf(l);
			}	
		} catch (Exception e) {
			System.out.println(e);
		}
		return value;

	}
    
}
