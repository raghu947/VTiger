package com.VTiger.ObjectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrgPageElements {
	@FindBy(css="img[title='Create Organization...']")
	private WebElement createOrganiz;

	public WebElement getCreateOganiz()
	{
		return createOrganiz;
	}
}
