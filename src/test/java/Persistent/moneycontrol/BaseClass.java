package Persistent.moneycontrol;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	static WebDriver driver;
	
	@BeforeTest
    public void lanchApp() 
    {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.moneycontrol.com/");
		WebElement search=driver.findElement(By.id("search_str"));
		Assert.assertTrue(search.isDisplayed());
    }

	@Test
	public void searchingForElement() throws InterruptedException
	{
		WebElement searchBox=driver.findElement(By.id("search_str"));
		searchBox.click();
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//span[contains(text(),'INE002A01018, RELIANCE, 500325')])[1]")).click();
		

		
		
		List<WebElement> list=driver.findElements(By.xpath("(//ul[@class=\"suglist\"])[1]//li/a"));
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getText().contains("Reliance"))
			{
				WebElement reliance=list.get(i);
				reliance.click();
				break;

			}
		}

		WebElement reliance=driver.findElement(By.xpath("//h1[contains(text(),\"Reliance Industries Ltd. \")]"));
		Assert.assertTrue(reliance.isDisplayed());
		
	}
	
	@AfterTest
	public void closeApp()
	{
		driver.quit();
		
	}
	
	
	

    
    
    
    
    
}
