package trial;

import java.io.IOException;

import baseUtil.BaseClass;
import commonUtil.ExcelUtil;

public class trialDemo {

	
	public static void main(String[] args) throws IOException {
		BaseClass BaseClass = new BaseClass();
		
	String path=BaseClass.getExcelPath("TestData.xlsx");
	ExcelUtil excelUtil=new ExcelUtil(path);
	
	int totalrows=excelUtil.getRowCount("Sheet1");
	int totalcols=excelUtil.getCellCount("Sheet1",1);	
			
		
	
	for(int i=0;i<=totalrows;i++) //1
	{
		for(int j=0;j<totalcols;j++) //0
		{
			System.out.print(excelUtil.getCellData("Sheet1", i, j));
			System.out.print("  |  ");
		}
			
		System.out.println();
	}
}
}
