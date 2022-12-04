package utilities;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadingXLS {
	
	public static String[] readingXlsFile(Row row) {
		String data[]=new String[row.getLastCellNum()];
		int i=0;
		Iterator<Cell> cellItr=row.cellIterator();
		while(cellItr.hasNext())
		{
			Cell cell=cellItr.next();
			switch(cell.getCellType())
			{
			case NUMERIC:
				 Integer val=(int) cell.getNumericCellValue();
					data[i]= val.toString();
					i++;
					break;
				 case STRING:
					 data[i]=cell.getStringCellValue();
					 i++;
					 break;
				 default:
					break;
			}
		}
		return data;
	}

}
