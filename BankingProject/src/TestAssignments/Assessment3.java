package TestAssignments;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ObjectRepository.HomepageObjects;
import Resources.Initialisation;


public class Assessment3 extends Initialisation
{
	WebDriver driver;
@BeforeTest
public void beforetest()
{
	 driver=null;
}
//Test case to verify the login section with parameterization using DataProvider Annotation	
@Test(dataProvider="getdata")
public void Test3(String username,String password) throws Exception 
{
	// initialising the driver 
	driver =Base_initialisation();
	//Creating object of HomepageObjects class with driver as parameter
	HomepageObjects o1=new HomepageObjects(driver);
	//getting the title of current webpage
	String hometitle=driver.getTitle();
	//passing value to username ,password and clicking login button
    o1.getusername().sendKeys(username);
    o1.getpwd().sendKeys(password);
    o1.getlogin().click();
    String newtitle=driver.getTitle();
    //validating both titles to check if the credentials provided are correct or not 
	Assert.assertNotEquals("Results", hometitle, newtitle);	
}
@DataProvider
public String[][] getdata()
{
	String[][] obj=new String[1][2];
	obj[0][0]="mngr115711";
	obj[0][1]="aqYgUbU";
	return obj;
}
@AfterTest
public void AfterTest()
	{
		driver.close();
	}

}
