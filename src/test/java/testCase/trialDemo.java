package testCase;


import util.Common.BaseClass;
import util.Data.ExcelUtil;

public class trialDemo extends BaseClass{

public static void main(String[] args) throws Throwable {
	ExcelUtil xlutil = new ExcelUtil(pathUtil.getExcelPath("ExcelData.xlsx"));
	int rowNum = xlutil.getRowNumber("Sheet1", "TC0001");
	int colNum = xlutil.getColumnNumber("Sheet1", "TestCase Description");
	System.out.println(xlutil.getCellData("Sheet1", rowNum, colNum));

	}
}
