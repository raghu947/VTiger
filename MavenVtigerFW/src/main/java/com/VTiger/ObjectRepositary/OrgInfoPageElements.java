package com.VTiger.ObjectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrgInfoPageElements {
	@FindBy(xpath="//span[contains(text(),'Organization Information')]")
	private WebElement successMsg;

	public WebElement getSuccessMsg()
	{
		return successMsg;
	}
}
