package demo.utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class WebDriverFactory {
	WebDriver driver;
	
	
	public WebDriver getDriver(String browser) {
		switch(browser) {
		case "chrome" : System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		break;
		}
		
		return driver;
	}
	
	public WebDriver getDriver(String deviceName, String udid, String platformName,String platformVersion, String appPackage, String appActivity) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();  
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("udid", udid);
		cap.setCapability("platformName", platformName);
		cap.setCapability("platformVersion", platformVersion);	
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity",appActivity);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<WebElement>(url,cap);
		return driver;
	}

}
