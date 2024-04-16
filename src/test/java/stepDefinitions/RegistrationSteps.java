package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class RegistrationSteps 
{

	WebDriver driver;
    HomePage hp;
   // LoginPage lp;
    AccountRegistrationPage regpage;
    
    
	@Given("the user navigates to Register Account page")
	public void the_user_navigates_to_register_account_page() 
	{

		BaseClass.getLogger().info("Goto my account-->Click on Register.. ");
		
		hp=new HomePage(BaseClass.getDriver());
    	hp.clickMyAccount();
        hp.clickRegister();
	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable) 
	{
		BaseClass.getLogger().info("Entering the details into the fields.. ");
		
 Map<String, String> dataMap = dataTable.asMap(String.class,String.class); // converting the data from dataTable into HashMap
	    
		regpage=new AccountRegistrationPage(BaseClass.getDriver());
		regpage.setFirstName(dataMap.get("firstName"));
		regpage.setLastName(dataMap.get("lastName"));
		regpage.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
		regpage.setTelephone(dataMap.get("telephone"));
		regpage.setPassword(dataMap.get("password"));
		regpage.setConfirmPassword(dataMap.get("password")); 
		
	/*	regpage.setFirstName("Mark");
		regpage.setLastName("Robert");
		regpage.setEmail("test246@gmail.com ");
		regpage.setTelephone("1234567890");
		regpage.setPassword("test246");
		regpage.setConfirmPassword("test246");
	    */
	}

	@When("the user selects Privacy Policy")
	public void the_user_selects_privacy_policy() 
	{
		BaseClass.getLogger().info("Clicking on Privacy Policy.. ");
	   
		regpage.setPrivacyPolicy();
	}

	@When("the user clicks on Continue button")
	public void the_user_clicks_on_continue_button() 
	{
		BaseClass.getLogger().info("Clicking on Continue button.. ");
	   
		regpage.clickContinue();
	}

	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() 
	{
		BaseClass.getLogger().info("Checking the confirmation message.. ");
		
		String confmsg= regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}


}
