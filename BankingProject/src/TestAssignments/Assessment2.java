package TestAssignments;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import ObjectRepository.ChildpageObjects;
import ObjectRepository.HomepageObjects;
import Resources.Initialisation;
import Resources.Jdbcconnection1;


public class Assessment2 extends Initialisation
{
	WebDriver driver;
@BeforeTest
public void beforetest()
{
	 driver=null;
}
	
@Test
public void Test2() throws Throwable 
{
	
	driver =Base_initialisation();
	ChildpageObjects o2=new ChildpageObjects(driver);
	HomepageObjects o1=new HomepageObjects(driver);
    Jdbcconnection1 d=new Jdbcconnection1();
	String[] data=d.database();
    o1.getusername().sendKeys(data[0]);
    o1.getpwd().sendKeys(data[1]);
    o1.getlogin().click();
    String string1=o2.getid().getText();
    System.out.println(string1);
   //To validate the Dynamic Text
    Assert.assertEquals("Results","Manger Id: "+data[0],string1);
 
}

@AfterTest
 public void AfterTest()
	{
		driver.close();
	}
	
	
	
}
