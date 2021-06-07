package demo.runner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import demo.utilities.WebDriverFactory;


@CucumberOptions(
		features = {"src/main/resources/scenarios"},
		glue = {"demo.steps"},
		
		 plugin = {"pretty",
	                "html:target/cucumber-reports/cucumber-pretty.html",
	                "json:target/cucumber-reports/CucumberTestReport.json",
	                "junit:target/my-reports/report.xml"},
		 tags="@mobilecases"
		)

public class TestRunner {


	private TestNGCucumberRunner testNGCucumberRunner;

	public static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUpCucumber() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({"deviceName","udid", "platformName", "platformVersion", "appPackage","appActivity","browser" })
	public void setUpClass(@Optional("noDevice") String deviceName, @Optional String udid, @Optional String platformName,@Optional String platformVersion, @Optional String appPackage, @Optional String appActivity, @Optional String browser) throws Exception {

		System.out.println("Browser - " + browser);
		WebDriverFactory driverFactory = new WebDriverFactory();
		if(!deviceName.equals("noDevice")){
			driver = driverFactory.getDriver(deviceName, udid, platformName, platformVersion, appPackage, appActivity) ;
			
		}else {
			driver = driverFactory.getDriver(browser);
			System.out.println("done");
		}
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
	public void feature(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runScenario(pickle.getPickle());
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}


	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		testNGCucumberRunner.finish();
	}


	@DataProvider
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}


}