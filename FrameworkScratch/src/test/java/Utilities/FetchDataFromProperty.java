package Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromProperty 
{
	static FileReader reader;
	
	public static Properties readDataFromProperty()
	{
		try 
		{
			reader=new FileReader("src/main/java/Global.properties");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		Properties prop=new Properties();
		
		try 
		{
			prop.load(reader);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return prop;
	}
}
