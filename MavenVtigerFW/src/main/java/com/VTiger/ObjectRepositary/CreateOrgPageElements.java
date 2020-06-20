package com.VTiger.ObjectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateOrgPageElements {
	@FindBy(name="accountname")
	private WebElement orgnizNmae;

	@FindBy(xpath="(//input[@accesskey='S'])[1]")
	private WebElement saveBtn;

	public WebElement getOrgnizNmae()
	{
		return orgnizNmae;
	}

	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
}
