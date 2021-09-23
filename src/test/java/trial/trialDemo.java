package trial;

import java.io.IOException;

import baseUtil.BaseClass;
import commonUtil.ExcelUtil;

public class trialDemo {

	
	public static void main(String[] args) throws IOException {
		BaseClass BaseClass = new BaseClass();
		
	String path=BaseClass.getExcelPath("TestData.xlsx");
	ExcelUtil excelUtil=new ExcelUtil(path);
	String[][] fullExcelData = excelUtil.getFullExcelData("Sheet1");
	
	  for (int i = 0; i < fullExcelData.length; i++)
	  {
          for (int j = 0; j < fullExcelData[i].length; j++) {
              System.out.print(fullExcelData[i][j] + " ");
              System.out.print("  |  ");
          }
          System.out.println();
	  }
}
}
