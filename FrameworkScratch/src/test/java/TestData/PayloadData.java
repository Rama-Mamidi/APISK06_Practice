package TestData;

import PojoMapper.CreateUserNew;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadData 
{
	public static String createUserData() throws JsonProcessingException
	{
		CreateUserNew emp=new CreateUserNew();
		emp.setUserName("Harry");
		emp.setId(12345);
		emp.setMarried(true);
		emp.setAddress("Florida");
		
		ObjectMapper obj=new ObjectMapper();
		String empJSON=obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		return empJSON;
	}

}
