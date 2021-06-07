package demo.utilities;

import static demo.runner.TestRunner.driver;

public class commonFunctionalities {
	ConfigReader con = new ConfigReader();
	

	public void LaunchApplication() throws Exception
	{
		try
		{
			
			String url = con.getApplicationUrl();
		    driver.get(url);
		    
		}
		catch(Exception e)
		{
			System.err.println("Exception thrown");
		}
		
	}
	public void verifytext(String texthello,String textinconfig)
	{
		
	String hellotextfromconfig = con.getPropertyFromConfig(textinconfig);
	if(texthello.equalsIgnoreCase(hellotextfromconfig))
	{
		System.out.println("text verifed");
	
	}
	}
}
