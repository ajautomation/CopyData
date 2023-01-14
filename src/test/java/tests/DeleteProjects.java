package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DeleteProjects {

	@Test
	public void deleteProjects() {
		//Read data from DynamicData and then delete it before creating new projects
		try {

			File f = new File(System.getProperty("user.dir")+"/DynamicData.xlsx");
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			wb.close();
			String data = sheet.getRow(0).getCell(0).getStringCellValue();
			System.out.println("Project to be deleted is ==> " +data);
			
		}catch(IOException io) {
			io.printStackTrace();
		}
	}
}