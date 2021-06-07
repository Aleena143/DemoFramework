package demo.steps;
import io.cucumber.java.en.Given;
import static demo.runner.TestRunner.driver;

import demo.pages.MobileHomePage;
import io.cucumber.java.en.Then;
public class MobileHomePageSteps {
	
	
	@Given("verify title and elements on screen")
	public void verifyScreen() throws InterruptedException {
		System.out.println("Inside step");
	
		Thread.sleep(5000);
	}
	
	@Then("tap on \"([^\"]*)\" ")
	public void clickOnGivenButton(String elementwritten) throws Throwable
	{
		try
		{
			MobileHomePage mbhgobj = new MobileHomePage(driver);
			mbhgobj.clickOnButtonSpecified(elementwritten);
			
		
		}
		catch(Exception e)
		{
			
		}
		
	}
	@Then("tap on EN and click NoNo button")
	public void clickOnENButton() throws Throwable
	{
		try
		{
			MobileHomePage mbhgobj = new MobileHomePage(driver);
			mbhgobj.clickOnENButton();
			
		
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	

}
