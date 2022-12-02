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
			fip=new FileInputStream("F:\\VrushaliTestingData\\CJCSelenium-20221122T035116Z-001\\CJCSelenium\\TaskFromMaheshSir\\LmbdaTestProject\\src\\test\\resources\\TestData\\RegistrationData.xlsx");
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
			  sheet=workbook.getSheet("sheet1");
			}
		  else if(m.getName().equalsIgnoreCase("providingblankUserName"))
		  {
			  sheet=workbook.getSheet("sheet2");
		  }
		  
		  
		
		 Iterator<Row> rows= sheet.rowIterator();
		 return rows;
			
	}

}
