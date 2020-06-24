package com.VTiger.TestScripts;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.VTiger.GenericLib.BaseClass;
import com.VTiger.ObjectRepositary.CreateOrgPageElements;
import com.VTiger.ObjectRepositary.HomePageElements;
import com.VTiger.ObjectRepositary.OrgPageElements;
import com.VTiger.ObjectRepositary.OrgInfoPageElements;

public class OrgTest extends BaseClass{
	@Test
	public void createorganization() throws EncryptedDocumentException, IOException
	{
		HomePageElements hp = PageFactory.initElements(driver, HomePageElements.class);
		OrgPageElements op = PageFactory.initElements(driver, OrgPageElements.class);
		CreateOrgPageElements cop = PageFactory.initElements(driver, CreateOrgPageElements.class);
		OrgInfoPageElements oip = PageFactory.initElements(driver, OrgInfoPageElements.class);
		
		hp.getOrganization().click();
		op.getCreateOganiz().click();
		String orgname=data.getDataFromExcel("organization", 1, 1);
		Random r=new Random();
		int num=r.nextInt(9999);
		orgname=orgname+num;
		cop.getOrgnizNmae().sendKeys(orgname);
		cop.getSaveBtn().click();
		String successMsg=oip.getSuccessMsg().getText();
		Assert.assertTrue(successMsg.contains(data.getDataFromExcel("organization", 1, 2)));
		System.out.println("org");
	}
}
