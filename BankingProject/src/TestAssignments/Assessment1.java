package TestAssignments;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ObjectRepository.HomepageObjects;
import Resources.Initialisation;
import Resources.Jdbcconnection1;


public class Assessment1 extends Initialisation
{
	WebDriver driver;
@BeforeTest
public void beforetest()
{
	 driver=null;
}
//Test case to verify the login section with valid UserId and Password	
@Test
public void Test1() throws Throwable 
{
	// initialising the driver by calling the method
	driver =Base_initialisation();
	
	//Creating object of HomepageObjects class with driver as parameter
	HomepageObjects o1=new HomepageObjects(driver);
	
	//creating object of Jdbcconnection1 class 
	Jdbcconnection1 d=new Jdbcconnection1();
	
	//Storing value from database method of Jdbcconnection1 class
	String[] data=d.database();
	
	//getting the title of current webpage
	String hometitle=driver.getTitle();
	
	//passing value to username ,password and clicking login button
    o1.getusername().sendKeys(data[0]);
    o1.getpwd().sendKeys(data[1]);
    o1.getlogin().click();
    String newtitle=driver.getTitle();
    
    //validating both titles to check if the credentials provided are correct or not 
	Assert.assertEquals("Results", hometitle, newtitle);	

 
}

@AfterTest
 public void AfterTest()
	{
		driver.close();
	}
	
	
	
}
