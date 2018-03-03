package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChildpageObjects
{    
    WebDriver driver;
	public ChildpageObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By text=By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[3]/td");
	
	 
	public WebElement getid()
	{
		return driver.findElement(text);
	}
		
}
