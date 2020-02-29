package com.payme.APITestingFramework.Utilites;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.externalconfig.model.Config;
import com.payme.APITestingFramework.Setup.BaseTest;

public class DataUtils extends BaseTest{
	
	@DataProvider(name="data")
	public static Object[][] getData(Method m ){
		
		int rows = excel.getRowCount(prop.getProperty("TestDataSheetName"));
		
		System.out.println("total no. of rows are"+"......."+rows);
				
		String testName=m.getName();
		
		//find testcase name which is same as of method calling it
		
		int testcaseRowNum=1;
		for(testcaseRowNum=1;testcaseRowNum<=rows;testcaseRowNum++) {
			String testCaseName=excel.getCellData(prop.getProperty("TestDataSheetName"), 0, testcaseRowNum);
			if(testCaseName.equalsIgnoreCase(testName))
				break;
		
		}
		System.out.println("Test starts from row "+"-----"+ testcaseRowNum);
		
		// checking total no. of Rows in testcase
		
		int dataStartRowNum= testcaseRowNum +2;
		int testRows=0;
		while(!excel.getCellData(prop.getProperty("TestDataSheetName"), 0, dataStartRowNum+testRows).equals("")) {
			testRows++;
		}
		System.out.println("total no. of data sets in testcase is"+"-----"+testRows);
		
		//checking total no. of cols in testcase
		
		int colStartColNum=testcaseRowNum+1;
		int testCols=0;
		
		while(!excel.getCellData(prop.getProperty("TestDataSheetName"), testCols, colStartColNum).equals("")) {
				testCols++;
		
		}
		System.out.println("total no. of columns in test case is "+"-----"+testCols);
		
		// printing Data
		
		
		Object[][] data=new Object [testRows][1] ;
		
		int i=0;
		
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++) {
			
			Hashtable<String , String > table =new Hashtable<String, String>();
			
				for(int cNum=0; cNum<testCols;cNum++) {
					
					String testData=excel.getCellData(prop.getProperty("TestDataSheetName"), cNum, rNum);
					String ColName=excel.getCellData(prop.getProperty("TestDataSheetName"), cNum, colStartColNum);
					
					table.put(ColName, testData);
				}
			data[i][0]=table;
			i++;
		}
		
		return data;
		
	}
	
	

}
