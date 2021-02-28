package Persistent.moneycontrol;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_SearchTest_001 
{
	
	public static void main(String[] args) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.google.com/");
		
		Date d1=new Date();
		
		String date1=d1.toString().replaceAll(":","/");
		System.out.println(date1);
		WebElement s=driver.findElement(By.id("identifierId"));
		//TakesScreenshot ts=((TakesScreenshot)driver);
		File srcFile=s.getScreenshotAs(OutputType.FILE);
		File destFile=new File("C:\\javaPrograms\\moneycontrol\\TakeScreenshot"+date1+"capturess.png");
		FileUtils.copyFile(srcFile, destFile);
		System.getProperties();
		
		

		
	}
	
	
	

}
