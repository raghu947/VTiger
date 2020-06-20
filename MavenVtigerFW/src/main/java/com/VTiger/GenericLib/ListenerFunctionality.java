package com.VTiger.GenericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.VTiger.GenericLib.BaseClass;

public class ListenerFunctionality implements ITestListener{
	public void onStart(ITestContext context) {}

	public void onFinish(ITestContext context) {}

	public void onTestStart(ITestResult result) {}
	
	public void onTestSuccess(ITestResult result) {}
	
	public void onTestFailure(ITestResult result) {
	
		String tcname = result.getMethod().getMethodName();
		EventFiringWebDriver efwd=new EventFiringWebDriver(BaseClass.driver);
		
		File sourcefile=efwd.getScreenshotAs(OutputType.FILE);
		File destinationfile=new File("./screenshot/"+tcname+".png");
		try {
			FileUtils.copyFile(sourcefile, destinationfile);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

}
