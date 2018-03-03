package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;


public class Initialisation {
	public static WebDriver driver;
	public WebDriver Base_initialisation() throws Exception 
	{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\chetan\\git\\BankingProject\\BankingProject\\src\\Resources\\Stored_data.properties");
		prop.load(fis);
		String geturl=prop.getProperty("url");
		if(prop.getProperty("browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C://geckodriver-v0.18.0-win32//geckodriver.exe");
	         driver=new FirefoxDriver();
			driver.get(geturl);

		}
		else if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			 driver=new ChromeDriver();
			driver.get(geturl);
			
		}
		else
		{
			 driver=new InternetExplorerDriver();
				driver.get(geturl);
		}
		
		// Implicit wait 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	// method to take screenshot and save it in local
	public void Screenshot(String name) throws Exception
	{  
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("C://Banking//"+name+".png"));
	}

}
