package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ProjectCreation {


	@Test
	public void createProjetcts() {

		//Test steps for Open browser -> Login -> Create Projects

		long currentTimestamp = System.currentTimeMillis();

		String projectID = "TESTPROJECT"+currentTimestamp;

		//I need to delete this data created in createProjetcts testcase
		//before we create new Projets next day automation

		//Run Create Project from Jenkins Job1
		//Save dynamic data in excel or csv
		//Copy file from Job1 to Job2 in 
		//Read data from that file and delete 

		try {
			
			File f = new File(System.getProperty("user.dir")+"/DynamicData.xlsx");
			
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = wb.getSheetAt(0);
			Row row = sheet.createRow(0);
			Cell cell = row.getCell(0,org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
			if (cell == null) {
				cell = row.createCell(0);
			}
			cell.setCellValue(projectID);
			FileOutputStream fo = new FileOutputStream(f);
			wb.write(fo);
			wb.close();
			
			System.out.println("Writting created ProjectID in excel==> " +projectID);

		}catch(IOException io) {
			io.printStackTrace();
		}

	}

}
