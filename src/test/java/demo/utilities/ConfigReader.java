package demo.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private String filePath = "/src/main/resources/config/conf.properties";
	String propertyfilePath = null;
	Properties prop;
	public ConfigReader()
	{
		try
		{
			
	 prop= new Properties();
    String baseresourcePath = System.getProperty("user.dir");
    propertyfilePath = baseresourcePath + filePath;
    File source = new File(propertyfilePath);
   FileInputStream input  = new FileInputStream(source) ;
   try
   {
	   prop.load(input);
	   input.close();
   }
   

   catch(IOException e)
   {
	   e.printStackTrace();
   }
	}
	
	catch(Exception e)
	{
		System.err.println("caught exception in config reader"+e.getMessage());
	}
	}
	
	public String getApplicationUrl()
	{
		String url = prop.getProperty("URL");
		if(url!=null)
		{
			return url;
		}
		else
		{
			throw new RuntimeException("url is empty in config");
		}
	}
	
	public String getPropertyFromConfig(String property)
	{
		String config_property = prop.getProperty(property);
		if(config_property!=null)
		{
			return config_property;
		}
		else
		{
			return null;
		}
	}
	
	
}
