package util.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static FileInputStream fin;
	public static FileOutputStream fout;
	public static XSSFWorkbook xbook;
	public static XSSFSheet xsheet;
	public static XSSFRow xrow;
	public static XSSFCell xcell;
	public static CellStyle xstyle;   
	String excelPath;

	public ExcelUtil(String excelPath) throws IOException
	{
		this.excelPath=excelPath;
		fin=new FileInputStream(excelPath);
		xbook=new XSSFWorkbook(fin);
	}

	public String getCellDataByValue(String sheetName,String rowName,String colName) throws IOException {
		int rowNum = getRowNumber(sheetName, rowName);
		int colNum = getColumnNumber(sheetName, colName);
		return getCellDataByNum(sheetName, rowNum, colNum);

	}

	public String[][] getFullExcelData(String sheetName) throws IOException {

		int totalrows=getRowCount(sheetName);
		int totalcols=getCellCount(sheetName,1);	


		String loginData[][]=new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				loginData[i-1][j]=getCellDataByNum(sheetName, i, j);
			}

		}
		return loginData;
	}

	public int[] getRowColNumbers(String sheetName, String Value) throws IOException {

		int totalrows=getRowCount(sheetName);
		int totalcols=getCellCount(sheetName,1);	

		int[] intcol = new int[2];
		for(int i=0;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				if(getCellDataByNum(sheetName, i, j).equals(Value)) {
					intcol[0]=i;
					intcol[1]=j;
				}


			}

		}
		return intcol;
	}

	public int getRowNumber(String sheetName, String Value) throws IOException {

		int totalrows=getRowCount(sheetName);
		int totalcols=getCellCount(sheetName,1);	

		int RowNumber = 0;
		for(int i=0;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				if(getCellDataByNum(sheetName, i, j).equals(Value)) {
					RowNumber = i;
				}


			}

		}
		return RowNumber;
	}

	public int getColumnNumber(String sheetName, String Value) throws IOException {

		int totalrows=getRowCount(sheetName);
		int totalcols=getCellCount(sheetName,1);	

		int ColumnNumber = 0;
		for(int i=0;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				if(getCellDataByNum(sheetName, i, j).equals(Value)) {
					ColumnNumber = j;
				}


			}

		}
		return ColumnNumber;
	}

	public int getRowCount(String sheetName) throws IOException 
	{
		xsheet=xbook.getSheet(sheetName);
		int rowcount=xsheet.getLastRowNum();
		xbook.close();
		fin.close();
		return rowcount;		
	}


	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		xsheet=xbook.getSheet(sheetName);
		xrow=xsheet.getRow(rownum);
		int cellcount=xrow.getLastCellNum();
		xbook.close();
		fin.close();
		return cellcount;
	}



	public String getCellDataByNum(String sheetName,int rownum,int colnum) throws IOException
	{
		xsheet=xbook.getSheet(sheetName);
		xrow=xsheet.getRow(rownum);
		xcell=xrow.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try{
			data = formatter.formatCellValue(xcell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		xbook.close();
		fin.close();
		return data;
	}

	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(excelPath);
		if(!xlfile.exists())    // If file not exists then create new file
		{
			xbook=new XSSFWorkbook();
			fout=new FileOutputStream(excelPath);
			xbook.write(fout);
		}


		if(xbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			xbook.createSheet(sheetName);

		xsheet=xbook.getSheet(sheetName);

		if(xsheet.getRow(rownum)==null)   // If row not exists then create new Row
			xsheet.createRow(rownum);
		xrow=xsheet.getRow(rownum);

		xcell=xrow.createCell(colnum);
		xcell.setCellValue(data);
		fout=new FileOutputStream(excelPath);
		xbook.write(fout);		
		xbook.close();
		fin.close();
		fout.close();
	}


	public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
	{
		xsheet=xbook.getSheet(sheetName);

		xrow=xsheet.getRow(rownum);
		xcell=xrow.getCell(colnum);

		xstyle=xbook.createCellStyle();

		xstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		xstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND); 

		xcell.setCellStyle(xstyle);
		xbook.write(fout);
		xbook.close();
		fin.close();
		fout.close();
	}


	public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
	{
		xsheet=xbook.getSheet(sheetName);
		xrow=xsheet.getRow(rownum);
		xcell=xrow.getCell(colnum);

		xstyle=xbook.createCellStyle();

		xstyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		xstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);  

		xcell.setCellStyle(xstyle);		
		xbook.write(fout);
		xbook.close();
		fin.close();
		fout.close();
	}

}
