package TestRest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouse {

	public static void main(String[] args) {
		
		
		WebDriver dr= new  ChromeDriver();
		dr.get("http://www.whiteboxqa.com/");
		WebElement el = dr.findElement(By.linkText("RESOURCES"));
			
		dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

     Actions action = new Actions(dr);
     action.moveToElement(el).build().perform();
     dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

     
     dr.findElement(By.linkText("Recordings")).click();
     

				
	)	
      
		
		
		
		
	}	
		

	
}
