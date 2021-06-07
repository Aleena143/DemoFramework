package demo.pages;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



import demo.utilities.commonFunctionalities;
import demo.utilities.ConfigReader;


public class HomePage {
	WebDriver driver = null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	commonFunctionalities cm = new commonFunctionalities();
	public void navigateToHomePage() throws Exception {
	
		cm.LaunchApplication();
		driver.manage().window().maximize();
	}
	
	
	public void verifywebhomepageisopened()
	{
		ConfigReader con = new ConfigReader();
		try
		{
			
			
			String currenturl = driver.getCurrentUrl();
		String urlfromconfig =	con.getPropertyFromConfig("URL");
           if(currenturl.equals(urlfromconfig))
           {
        	   System.out.println("Homepage is verifed and pass");
           }
           else
           {
        	   throw new Exception();
           }
		}
		catch(Exception e)
		{
			
		}
	}
	public void selectDroppableButton() {
		try
		{
		driver.findElement(By.xpath("//div[@id='sidebar']//a[text()='Droppable']")).click();
		System.out.println("Droppable button is clicked");
		String text = driver.findElement(By.xpath("//div[@id='content']//h1[text()='Droppable']")).getText().trim();
		System.out.println("Droppable Page Title: " + text);
		dragAndDrop();
		}
		catch(Exception e)
		{
			System.err.println("caught exception");
		}
	}
	
	public void dragAndDrop() {
		try
		{
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement from = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement to = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(from, to).build().perform();
		System.out.println("Element is successfully dropped!!!");
		driver.switchTo().defaultContent();
		}
		catch(Exception e)
		{
			System.err.println("exception caught indraganddrop");
		}

	}
	
	public void selectcontrolgroup(){
		driver.findElement(By.xpath("//div[@id='sidebar']//a[text()='Controlgroup']")).click();
		System.out.println("Selected control Group link");
		selectAutomaticRadioButton();
		selectInsuranceRadioButton();
		selectStandardRadioButton();
		clickBookNowButton();
		driver.switchTo().defaultContent();
	}
	
	public void selectAutomaticRadioButton() {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement element1 = driver.findElement(By.xpath("//label[@for='transmission-automatic']/span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank']"));
		element1.click();
		Boolean selected = element1.isEnabled();
		System.out.println("Automatic is selected: " +selected);
	}

	public void selectInsuranceRadioButton() {
		WebElement element1 = driver.findElement(By.xpath("//label[@for='insurance']/span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank']"));
		element1.click();
		Boolean selected = element1.isEnabled();
		System.out.println("Insurance is selected: " +selected);
		
	}

	public void selectStandardRadioButton() {
		WebElement element1 = driver.findElement(By.xpath("//label[@for='transmission-standard-v']/span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank']"));
		element1.click();
		Boolean selected = element1.isEnabled();
		System.out.println("Standard is selected: " +selected);
	}


	public void selectInsuranceCheckBox() {
		WebElement element1 = driver.findElement(By.xpath("//label[@for='insurance-v']/span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank']"));
		element1.click();
		//Boolean selected = element1.isEnabled();
		if(element1.isSelected())
		System.out.println("Insurance check box is selected: ");
		
	}

	public void clickBookNowButton() {
		driver.findElement(By.xpath("//button[@id='book']")).click();
		
		
	}
	
	
	public void selectitems() {
		driver.findElement(By.xpath("//div[@id='sidebar']//a[text()='Selectable']")).click();
		System.out.println("link got selected");		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		List<WebElement> ele = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		 
	

		WebElement element1 = driver.findElement(By.xpath("//ol[@id='selectable']/li[text()='Item 1']"));
		WebElement element5 = driver.findElement(By.xpath("//ol[@id='selectable']/li[text()='Item 5']"));
		WebElement element7 = driver.findElement(By.xpath("//ol[@id='selectable']/li[text()='Item 7']"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL);
		action.click(element7).build().perform();
		action.click(element1).build().perform();
		action.click(element5).build().perform();
		System.out.println("1,5,7 clciked");
		driver.switchTo().defaultContent();
			
		
		
	}

	
	
	
	
	
}