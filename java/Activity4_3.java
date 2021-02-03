package javaActivity4;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity4_3 {

	private static final String FILE_NAME = "resources/Activity4_Test.xlsx";

	public static void main(String[] args)
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
		Object[][] Fruits = {
				{"FruitName", "Quantity", "Cost"},
				{"Apple", "1", 100},
				{"Mango", "5", 350},
				{"Orange", "2", 150},
				{"Watermelon", "7", 120},
				{"Pineapple", "3", 200}
		};

		int rowNum = 0;
		System.out.println("Creating excel");

		for (Object[] datatype : Fruits)
		{
			Row row = sheet.createRow(rowNum++);
			int colNum = 0;
			for (Object field : datatype)
			{
				Cell cell = row.createCell(colNum++);
				if (field instanceof String)
				{
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) 
				{
					cell.setCellValue((Integer) field);
				}
			}
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		System.out.println("Done");
	}
}
