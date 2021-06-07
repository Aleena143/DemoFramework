package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.utilities.ConfigReader;
import demo.utilities.commonFunctionalities;


public class MobileHomePage {
	WebDriver driver = null;
	
	public MobileHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	ConfigReader con = new ConfigReader();
	commonFunctionalities cm = new commonFunctionalities();
		By  enButton =  By.xpath("//android.widget.Button[@content-desc='buttonTestCD']");
		By  NonoButton = By.id("android:id/button2");
		By chromelogo = By.xpath("//android.widget.ImageButton[@content-desc='buttonStartWebviewCD']");
		By emaillink = By.xpath("");
		By displaytoast = By.xpath("//android.widget.Button[@content-desc='showToastButtonCD']");
		By displaypopupwindow = By.xpath("");
		By textfieldinhomepage = By.xpath("//android.widget.EditText[@content-desc='my_text_fieldCD']");
		By showprogressbarbutton = By.xpath("//android.widget.Button[@content-desc='waitingButtonTestCD']");
		By acceptadscheckbox = By.xpath("(//android.widget.LinearLayout[@content-desc='imageViewCD'])[2]/android.widget.CheckBox");
		By displaytextview = By.xpath("//android.widget.Button[@content-desc='visibleButtonTestCD']");
		By presstothrowunhandledexception = By.xpath("//android.widget.Button[@content-desc='exceptionTestButtonCD']");
		By typetothrowunhandledexception = By.xpath("");
		By displayandfocusonlayout = By.xpath("");

	
	
	
	
	public void clickOnButtonSpecified(String givenButtonname)
	{
		try
		{
			if(givenButtonname.equalsIgnoreCase("EN"))
			{
			driver.findElement(enButton).click();
			clickOnButtonSpecified("NoNo");
			}
			
			if(givenButtonname.equalsIgnoreCase("NoNo"))
			{
			driver.findElement(NonoButton).click();
			
			}
			
			if(givenButtonname.equalsIgnoreCase("chromelogo"))
			{
			driver.findElement(chromelogo).click();
			
			By hellotext = By.xpath("");
			String hellotextname = driver.findElement(hellotext).getText();
			cm.verifytext(hellotextname,"configtext");
		    }
			if(givenButtonname.equalsIgnoreCase("Emaillink"))
			{
			driver.findElement(emaillink).click();
			
			}
			if(givenButtonname.equalsIgnoreCase("Displaysatoast"))
			{
			driver.findElement(displaytoast).click();
			By toastetxt = By.xpath("");
			String toast = driver.findElement(toastetxt).getText();
			cm.verifytext(toast, "toasttextinconfig");
			}
			if(givenButtonname.equalsIgnoreCase("Displaypopupwindow"))
			{
			driver.findElement(displaypopupwindow).click();
			
			}
			if(givenButtonname.equalsIgnoreCase("presstothrowunhandledException"))
			{
			driver.findElement(presstothrowunhandledexception).click();
			
			
			}
			if(givenButtonname.equalsIgnoreCase("Displaandfocusonlayout"))
			{
			driver.findElement(displayandfocusonlayout).click();
			
			}
		
			if(givenButtonname.equalsIgnoreCase("Acceptcheckbox"))
			{
			driver.findElement(acceptadscheckbox).click();
			
			}
			if(givenButtonname.equalsIgnoreCase("Displaytextview"))
			{
			driver.findElement(displaytextview).click();
			
			}
			if(givenButtonname.equalsIgnoreCase("ShowProgressbarforawhile"))
			{
			driver.findElement(showprogressbarbutton).click();
		    WebDriverWait wait = new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("element_id"),"100%"));
			}
			
			
		}
		catch(Exception e)
		{
			
		}
	}
	public void clickOnENButton()
	{
		try
		{
	
	driver.findElement(enButton).click();
	System.out.println("ENButton clicked");
	Thread.sleep(1000);
	driver.findElement(NonoButton).click();
	System.out.println("NoNoButtoncliked");
		}
		catch(Exception e)
		{
			
		}
	}
}
