package com.VTiger.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.VTiger.GenericLib.BaseClass;

public class CampaignTest extends BaseClass{
	@Test
	public void createCampaign() throws EncryptedDocumentException, IOException
	{
		WebElement supp=driver.findElement(By.linkText("More"));
		Actions act= new Actions(driver);
		act.moveToElement(supp).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(data.getDataFromExcel("campain", 1, 1));
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		String successMsg=driver.findElement(By.className("dvHeaderText")).getText();
		
		Assert.assertTrue(successMsg.contains(data.getDataFromExcel("campain", 1, 5)));
	}
}
