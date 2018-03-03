package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomepageObjects
{    
    WebDriver driver;
	public HomepageObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username=By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input");
	By pwd=By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input");
	By login=By.xpath("html/body/form/table/tbody/tr[3]/td[2]/input[1]");
	By text=By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[3]/td");
	
	 
	public WebElement getid()
	{
		return driver.findElement(text);
	}
	public WebElement getusername()
	{
		return driver.findElement(username);
	}
	public WebElement getpwd()
	{
		return driver.findElement(pwd);
	}
	public WebElement getlogin()
	{
		return driver.findElement(login);
	}
	
}
