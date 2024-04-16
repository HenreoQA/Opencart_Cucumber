package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage 
{

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement linkMyaccount;

	@FindBy(xpath ="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement linkRegister;

	@FindBy(linkText = "Login") 
	WebElement linkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
	WebElement txtSearchbox;
	
	@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
	WebElement btnSearch;
	
	
		
	// Action Methods
	public void clickMyAccount() 
	{
		linkMyaccount.click();
	}

	public void clickRegister() 
	{
		linkRegister.click();
	}
	
	public void clickLogin()   
	{
		linkLogin.click();
	}
	
	public void enterProductName(String pname)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pname);
	}
	
	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}
	
	
	
}

