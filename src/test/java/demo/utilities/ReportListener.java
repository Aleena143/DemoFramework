package demo.utilities;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;



import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;

import org.testng.ITestResult;
import org.testng.IReporter;

import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;


public class ReportListener implements IReporter{

	
	 ExtentReports extent;
	 ExtentTest test;
	 
	    public void generateReport(final List<XmlSuite> xmlSuites, final List<ISuite> suites, final String outputDirectory) {
	    	
	        extent = new ExtentReports(outputDirectory + File.separator + "Extent.html", true);
	    	
	        for (final ISuite suite : suites) {
	            final Map<String, ISuiteResult> result = (Map<String, ISuiteResult>)suite.getResults();
	            for (final ISuiteResult r : result.values()) {
	                final ITestContext context = r.getTestContext();
	               buildTestNodes(context.getPassedTests(), LogStatus.PASS);
	                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
	                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
	            }
	        }
	        extent.flush();
	        extent.close();
	    }
	    
	    private void buildTestNodes(IResultMap tests,LogStatus pass) {
	        if (tests.size() > 0) {
	            for (final ITestResult result : tests.getAllResults()) {
	                final ExtentTest test = extent.startTest(result.getMethod().getMethodName());
	              test.setStartedTime(getTime(result.getStartMillis()));
	               test.setEndedTime(getTime(result.getEndMillis()));
	                String[] groups;
	                for (int length = (groups = result.getMethod().getGroups()).length, i = 0; i < length; ++i) {
	                    final String group = groups[i];
	                    test.assignCategory(new String[] { group });
	                }
	                if (result.getThrowable() != null) {
	                    test.log(pass, result.getThrowable());
	                }
	                else {
	                    test.log(pass, "Test " + pass.toString().toLowerCase() + "ed");
	                }
	                extent.endTest(test);
	            }
	        }
	    }
	    
	    private Date getTime(final long millis) {
	        final Calendar calendar = Calendar.getInstance();
	        calendar.setTimeInMillis(millis);
	        return calendar.getTime();
	    }
	
	
	
}
	
	
	
	

