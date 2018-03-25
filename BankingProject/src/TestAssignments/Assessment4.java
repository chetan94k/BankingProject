package TestAssignments;



import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ObjectRepository.HomepageObjects;
import Resources.Initialisation;


public class Assessment4 extends Initialisation
{
	WebDriver driver;
@BeforeTest
public void beforetest()
{
	 driver=null;
}

//Test case to verify the login section by fetching data from Excel sheet using POI API
@Test
public void Test4() throws Throwable 
{
	// initialising the driver by calling the method
	driver =Base_initialisation();
	
	//Creating object of HomepageObjects class with driver as parameter
	HomepageObjects o1=new HomepageObjects(driver);
	
	//Fetching Credentials from Excel sheet
	FileInputStream fis=new FileInputStream("F:\\Credentials.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet ws=wb.getSheet("Sheet1");
	XSSFRow wr=ws.getRow(5);
	XSSFCell wc=wr.getCell(2);
	
	//getting the title of current webpage
	String hometitle=driver.getTitle();
	
	//passing value to username ,password and clicking login button
	o1.getusername().sendKeys(wc.getStringCellValue());
    wc=wr.getCell(3);
	o1.getpwd().sendKeys(wc.getStringCellValue());
    o1.getlogin().click();
    String newtitle=driver.getTitle();
    
    //validating both titles to check if the credentials provided are correct or not 
	Assert.assertNotEquals("Results", hometitle, newtitle);	

 }

@AfterTest
 public void AfterTest()
	{
		driver.close();
	}
	
	
	
}
