package stepDefinitions;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

// Hooks are the methods which are executed before and after every scenario and step


public class Hooks 
{

	 WebDriver driver; // webdriver object
	 Properties p;  // properties file object
     
	@Before // executes before every scenario - open browser and url
    public void setup() throws IOException
    {
    	driver=BaseClass.initilizeBrowser();
    	    	
    	p=BaseClass.getProperties();
    	driver.get(p.getProperty("appURL"));
    	driver.manage().window().maximize();
    
    }
		
    
    @After // executes after every scenario - close browser
    public void tearDown(Scenario scenario) 
    {
        		
       driver.quit();
       
    }
    

    @AfterStep // executes after every step - captures screenshot for failed step/scenario
   public void addScreenshot(Scenario scenario) 
    {
        
    	// this is for cucumber junit report
        if(scenario.isFailed()) 
        {
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }
      
    }
   
}

