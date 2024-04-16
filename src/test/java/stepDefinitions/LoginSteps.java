package stepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class LoginSteps 
{
	WebDriver driver; //webdriver object
    HomePage hp;   // homepage object
    LoginPage lp;  // loginpage object
    MyAccountPage macc;  // myaccountpage object
    
    List<HashMap<String, String>> datamap; //Data driven. We use List because we are using key or row to get the data. We can use only HashMap if we are not using key to get the data.
 
    
	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() 
	{
		BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
    	
		hp=new HomePage(BaseClass.getDriver());
    	
    	hp.clickMyAccount();
    	hp.clickLogin();
	    
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) throws IOException 
	{
        BaseClass.getLogger().info("Entering email and password.. ");
    	
    	lp=new LoginPage(BaseClass.getDriver());
    	
        lp.setEmail(email);
        lp.setPassword(pwd); 
    	
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() 
	{
		 lp.clickLogin();
		
		 BaseClass.getLogger().info("clicked on login button...");
	  
	}

	@Then("the user should be redirected to the MyAccount Page")
	public void the_user_should_be_redirected_to_the_my_account_page() 
	{
		macc=new MyAccountPage(BaseClass.getDriver());
		boolean targetpage=macc.isMyAccountPageExists();
				
		Assert.assertEquals(targetpage, true);
		
		BaseClass.getLogger().info("Checked if My Account page is displayed.. ");
	}
	
	
	 //*******   Data Driven test **************
    @Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
	{
        datamap=DataReader.data(System.getProperty("user.dir")+"\\TestData\\LoginData.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

        lp=new LoginPage(BaseClass.getDriver());
        lp.setEmail(email);
        lp.setPassword(pwd);

        lp.clickLogin();
        
        macc=new MyAccountPage(BaseClass.getDriver());
        try
        {
            boolean targetpage=macc.isMyAccountPageExists();
            System.out.println("target page: "+ targetpage);
        
			if(exp_res.equals("Valid"))
            {
                if(targetpage==true)
                {
                    MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
                    myaccpage.clickLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equals("Invalid"))
            {
                if(targetpage==true)
                {
                    macc.clickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
      }

    // Approach2
	
   
 /*	@When("the user enters the email and password with excel row {string}")
	public void the_user_enters_the_email_and_password_with_excel_row(String rows) 
	{
        datamap=DataReader.data(System.getProperty("user.dir")+"\\TestData\\LoginData.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

        lp=new LoginPage(BaseClass.getDriver());
        lp.setEmail(email);
        lp.setPassword(pwd);

        lp.clickLogin();
	}
        
    	@Then("the user should be redirected to MyAccount Page")
    	public void the_user_should_be_redirected_to_my_account_page() 
    	{
    	  
    	macc=new MyAccountPage(BaseClass.getDriver());
        try
        {
            boolean targetpage=macc.isMyAccountPageExists();
            System.out.println("target page: "+ targetpage);
            Object exp_res = "res";
			if(exp_res.equals("Valid"))
            {
                if(targetpage==true)
                {
                    MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
                    myaccpage.clickLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equals("Invalid"))
            {
                if(targetpage==true)
                {
                    macc.clickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
      } */

}
