package demo.steps;

import io.cucumber.java.en.Given;
import static demo.runner.TestRunner.driver;

import io.cucumber.java.en.Then;
import demo.pages.HomePage;




public class HomePageSteps {


	@Given("user is on home Page")
	public void homePageLoaded() throws Exception {
		//System.out.println("Inside step");
		HomePage home = new HomePage(driver);
		home.navigateToHomePage();
	}



	@Then("tap on \"([^\"]*)\" element")
	public void clickOnGivenButton(String elementwritten) 
	{
		try
		{

			//	home.clickOnButtonSpecified(elementwritten);


		}
		catch(Exception e)
		{

		}

	}





	@Then("verify jquery homepage is opened")
	public void verifyhomepageopeneds()
	{
		try
		{
			HomePage home = new HomePage(driver);
			home.verifywebhomepageisopened();
		}
		catch(Exception e)
		{

		}
	}

	@Then("perform drag and drop")
	public void verifydroppisperformed()
	{
		try
		{
			HomePage home = new HomePage(driver);
			home.selectDroppableButton();

		}
		catch(Exception e)
		{

		}
	}

@Then("select controlgroup")
public void verifycontrolgroupsareselected()
{
	try
	{
		HomePage home = new HomePage(driver);
		home.selectcontrolgroup();

	}
	catch(Exception e)
	{

	}
}

	
	@Then("select itemshomepage")
	public void verifyitemsareselectedindropdown()
	{
		try
		{
			HomePage home = new HomePage(driver);
			home.selectitems();

		}
		catch(Exception e)
		{

		}
		
	
}



}
