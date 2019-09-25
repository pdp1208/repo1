package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testcasename) throws IOException {

		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("F://SeleniumRelatedFiles//TestData.xlsx");
		XSSFWorkbook myBook = new XSSFWorkbook(fis);
		int sheets = myBook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (myBook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet = myBook.getSheetAt(i);

				// Identify TestCase coolumn by screening entire first row
				Iterator<Row> rows = sheet.iterator();

				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator();

				int k = 0;
				int column = 0;

				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("Test Case")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);

				while (rows.hasNext()) {
					Row r = rows.next();

					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) {

						Iterator<Cell> cellValue = r.cellIterator();
						
						while (cellValue.hasNext()) {
							Cell c=cellValue.next();
							if(c.getCellTypeEnum()==CellType.NUMERIC){
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}else
							a.add(c.getStringCellValue());
						}
					}

				}
			}

		}
		return a;
	}

	// Identify TestCase coolumn by screening entire first row
	// once column is identified then scan entire test case column to identify
	// actual test case row

	// After Grbbing the actual test case data, get all data

}
