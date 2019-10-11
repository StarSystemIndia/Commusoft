package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataprovider {
	
	Properties pro;
	
	public ConfigDataprovider()
	{
		File src = new File("./Config/Config.properties");
		
		FileInputStream frc;
		try {
			frc = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(frc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Can not able to read the properties file:-" +e );
		}
		
		
	}

	public String geturl(String key)
	{
	return	pro.getProperty(key);
	}
	
	public String getbrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String geturl()
	{
		return pro.getProperty("URL");
	}
	
	public String getliveurl()
	{
		return pro.getProperty("LiveUKURL");
	}
	
}
