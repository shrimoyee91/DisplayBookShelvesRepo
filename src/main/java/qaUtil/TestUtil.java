package qaUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import qaBase.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 10;
	public static String TESTDATA_SHEET_PATH="C:\\Users\\shrim\\eclipse-workspace\\INTQEA23QE002\\src\\main\\java\\qaTestData\\UrbanLadderTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}catch (IOException e) {
			e.printStackTrace();
		} 
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				DataFormatter df = new DataFormatter();
				data[i][k] = df.formatCellValue(sheet.getRow(i + 1).getCell(k));
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	public String webPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	public void takenScreenshot() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File per = new File("C:\\Users\\shrim\\eclipse-workspace\\INTQEA23QE002\\target\\screenshot.png");
		try {
			FileUtils.copyFile(temp, per);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}

}
