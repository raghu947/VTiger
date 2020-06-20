package com.VTiger.ObjectRepositary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.VTiger.GenericLib.BaseClass;

public class HomePageElements extends BaseClass{
	@FindBy (linkText="Leads")
	private WebElement leads;

	@FindBy (linkText="Organizations")
	private WebElement organizations;

	@FindBy (xpath="//span[text()=' Administrator']/../following-sibling::td[1]/img")
	private WebElement signoutDD;

	@FindBy (linkText="Sign Out")
	private WebElement signoutLink;

	public WebElement getLeads()
	{
		return leads;
	}

	public WebElement getOrganization()
	{
		return organizations;
	}

	public WebElement getSignoutDD()
	{
		return signoutDD;
	}

	public WebElement getSignoutLink()
	{
		return signoutLink;
	}

	public void logoutFromApp()
	{
		wlib.keepMouseOnElement(signoutDD);
		signoutLink.click();
	}
}
