package TestData;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import ConstantData.ConstantsData;
import Utilities.CommonFunctions;
import Utilities.FetchDataFromExcel;

import io.restassured.RestAssured;

public class TestDataExcel 
{
	public static Map getDataFromExcel() throws IOException
	{
		FetchDataFromExcel obj=new FetchDataFromExcel(ConstantsData.excelDatapath1,ConstantsData.sheetName);
		
		
		Map<String,Object> mp=new LinkedHashMap<String,Object>();
		mp.put("name",FetchDataFromExcel.getData(1, 0));
		mp.put("gender",FetchDataFromExcel.getData(1, 1));
		mp.put("status",FetchDataFromExcel.getData(1, 2));
		mp.put("email",CommonFunctions.generateRandomEmail());
		
		return mp;
	}

}
