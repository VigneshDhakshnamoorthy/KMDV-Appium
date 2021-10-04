package testCase;


import util.Common.BaseClass;
import util.Data.ExcelUtil;

public class trialDemo extends BaseClass{

public static void main(String[] args) throws Throwable {
	xlutil = new ExcelUtil(pathUtil.getExcelPath("AzamExcelData.xlsx"));
	System.out.println(xlutil.getCellDataByValue("Sheet1", "phonenumber", "value"));

	}
}
