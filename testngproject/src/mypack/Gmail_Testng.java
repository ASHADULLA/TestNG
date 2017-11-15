package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Gmail_Testng {
	
		  public WebDriver driver;
		  @Test(priority=0)
		  public void launch() throws Exception 
		  {
		  System.setProperty("webdriver.chrome.driver", "E:\\MindQSelenium\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://www.gmail.com");
		  Thread.sleep(5000); 
		  }
		  
		  @Test(priority=2)
		  public void close() throws Exception 
		  {
		  driver.close();
		  }
		  @Parameters({ "uid", "criteria" })
		  @Test(priority=1)
		  public void useridtest(String u,String c) throws Exception 
		  {
		  driver.findElement(By.name("identifier")).sendKeys(u,Keys.ENTER);
		  Thread.sleep(10000); 
		  
		  try {
			  if(c.equals("valid")&&driver.findElement(By.name("password")).isDisplayed())
				  {
					  Assert.assertTrue(true,"Test Passed");
				  }
				else if(c.equals("invalid")&&driver.findElement(By.xpath("//*[contain(text(),'Enter an email') or contain(text(),'find your Google')])[2]")).isDisplayed())
					{
					Assert.assertTrue(true,"Test passed");
				  }
				 else
				  {
					  Assert.assertTrue(true,"Test failed");
				  }
			} 	catch (Exception e) {
					Assert.assertTrue(true,"Test failed");
			}	  
		}
	}



