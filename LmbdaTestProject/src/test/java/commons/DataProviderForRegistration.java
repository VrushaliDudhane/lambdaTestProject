package commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderForRegistration {
	
	@DataProvider(name="RegistrationData")
	public Iterator<Row> dataProviderForRegistrationMethod(Method m) {
		 FileInputStream fip;
		 XSSFSheet sheet=null;
		  XSSFWorkbook workbook = null;
		  
		  try {
			fip=new FileInputStream("src\\test\\resources\\TestData\\RegistrationData.xlsx");
			workbook=new XSSFWorkbook(fip);
		  } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  if(m.getName().equalsIgnoreCase("providingValidRegistrationData"))
			{
			  sheet=workbook.getSheet("ValidRegistrationData");
			}
		  else if(m.getName().equalsIgnoreCase("providingblankUserName"))
		  {
			  sheet=workbook.getSheet("BlankUserName");
		  }
		  
		  else if(m.getName().equalsIgnoreCase("providingblankEmail"))
		  {
			  sheet=workbook.getSheet("BlankBusinessEmail");
		  }
		  
		  else if(m.getName().equalsIgnoreCase("providingRegisteredEmail"))
		  {
			  sheet=workbook.getSheet("RegisteredEmail");
		  }
		  
		  else if(m.getName().equalsIgnoreCase("providingShortPassword"))
		  {
			  sheet=workbook.getSheet("PasswordNegative");
		  }
		  
		  else if(m.getName().equalsIgnoreCase("providingBlankPhoneNumber"))
		  {
			  sheet=workbook.getSheet("BlankPhoneNumber");
		  }
		  
		  else if(m.getName().equalsIgnoreCase("withoutAcceptingTerms"))
		  {
			  sheet=workbook.getSheet("ValidRegistrationData");
		  }
		  
		  
		  
		
		 Iterator<Row> rows= sheet.rowIterator();
		 return rows;
			
	}

}
