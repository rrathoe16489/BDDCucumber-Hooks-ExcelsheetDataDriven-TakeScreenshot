package com.qa.pages;

import org.openqa.selenium.By;

public class RegistryListPage {

	public static By signInMouseHover = By.xpath("//span[text()='Hello, Sign in']");
	public static By email = By.id("ap_email");
	public static By password = By.id("ap_password");
	public static By continueBtn = By.id("continue");
	public static By signInSubmit = By.id("signInSubmit");
	public static By signInbtn = By.xpath("//div[@id='nav-flyout-ya-signin']/a/span");
	public static By registryOption = By.xpath("//a[text()='Registry']");
	public static By registryName = By.name("name");
	public static By listDropdown = By.id("searchUrl");
	public static By searchButton = By.xpath("//div[@class='gr-find-stripe__search-button']/button");
	
	}

