package com.qa.util;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @authorID Rat105478
 * @authorName RameshRathod
 */

public class CommonMethodUtil {
	private static WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	private static Actions actions;
	// private static WebDriver driver = DriverFactory.getDriver();

	public CommonMethodUtil(WebDriver driver) {
		this.driver = driver;
	}

	public static boolean isElementPresent(By locator, String elementName) {
		try {

			getWebElement(locator).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {

			return false;
		}
	}

	public static boolean isElementsPresent(By locator) {

		Boolean isPresent = driver.findElements(locator).size() > 0;
		return isPresent;

	}

	public static boolean isElementsPresentB(By locator, double available) {

		Boolean isPresent = driver.findElements(locator).size() > 0;
		double total = Double.parseDouble(((WebElement) driver.findElements(locator)).getText().split(" ")[0]);
		if (total > available) {
			return true;
		}
		return isPresent;

	}

	public static void doSendKeysIntiger(By locator, int value) {
		try {
			getWebElement(locator).sendKeys(String.valueOf(value));

		} catch (Exception e) {
			System.out.println("Some exception occured while sending to webelement" + locator);

		}
	}

	public static void doSendKeys(By locator, String value) {
		try {
			getWebElement(locator).sendKeys(value);

		} catch (Exception e) {
			System.out.println("Some exception occured while sending to webelement" + locator);

		}
	}

	public static void doSendKeysExecuter(By locator, String value) {
		try {

			WebElement wb = driver.findElement(locator);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value='';", wb);
			getWebElement(locator).sendKeys(value);

		} catch (Exception e) {
			System.out.println("Some exception occured while sending to webelement" + locator);

		}
	}

	public static void clearAnddoSendKeys(By locator, String value) {
		try {
			getWebElement(locator).clear();
			getWebElement(locator).sendKeys(value);
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Some exception occured while sending to webelement" + locator);

		}
	}

	public static String getTex(By locator) {

		WebElement element = driver.findElement(locator);
		String text = element.getText();
		return text;
	}

	public static void focusOnElement() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('x').focus()");
	}

	/**
	 * Method to click on an element
	 * 
	 * @param locator         : String : Locator type (id, name, class, xpath, css)
	 * @param stepDiscription : String : Locator value
	 */
	public static void clickElement(By locator, String stepDiscription) throws RuntimeException {
		try {
			WebDriverWait ww = new WebDriverWait(driver, 30000);
			WebElement element = getWebElement(locator);
			ww.until(ExpectedConditions.elementToBeClickable(element));
			Thread.sleep(3000);
			if (element.isEnabled()) {
				Actions ac = new Actions(driver);
				ac.moveToElement(element).click().build().perform();
				Thread.sleep(3000);
			} else
				System.out.println(" failure report statement will be generate : " + element);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static boolean clickElements(By locator, String stepDiscription) throws RuntimeException {
		try {

			WebDriverWait ww = new WebDriverWait(driver, 30000);
			WebElement element = getWebElement(locator);
			if (element.isEnabled()) {
				ww.until(ExpectedConditions.elementToBeClickable(element));
				Thread.sleep(3000);
				Actions ac = new Actions(driver);
				ac.moveToElement(element).click().build().perform();
				Thread.sleep(6000);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void selectValueAndEnter(By locator, String value) throws RuntimeException {
		try {

			WebElement element = driver.findElement(locator);
			element.sendKeys(Keys.TAB);
			element.sendKeys(value);
			Thread.sleep(2000);
			element.sendKeys(Keys.ENTER);
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static WebElement getWebElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);

		} catch (Exception e) {
			System.out.println("Some Exception occured while creating webelement " + locator);
		}
		return element;

	}

	public static boolean isEnabled(By locator, String elementName) {
		try {

			getWebElement(locator).isEnabled();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Method of dropDownSelect
	 * 
	 * @param locator         : String : Locator type (id, name, class, xpath, css)
	 * @param stepDiscription : String : Locator value
	 */
	public static void dropDownSelect(By locator, String val, String elementName) throws RuntimeException {
		WebElement element = driver.findElement(locator);
		Select drp = new Select(element);
		drp.selectByVisibleText(val);

	}

	/**
	 * Method of dropDownSelect byIndex
	 * 
	 * @param locator         : String : Locator type (id, name, class, xpath, css)
	 * @param stepDiscription : String : Locator value
	 */
	public static void dropDownSelectByIndex(By locator, int val, String elementName) throws RuntimeException {
		WebElement element = driver.findElement(locator);
		Select drp = new Select(element);
		drp.selectByIndex(val);

	}

	/**
	 * Method of dropDownSelect byValue
	 * 
	 * @param locator         : String : Locator type (id, name, class, xpath, css)
	 * @param stepDiscription : String : Locator value
	 */
	public static void dropDownSelectByValue(By locator, String val, String elementName) throws RuntimeException {
		WebElement element = driver.findElement(locator);
		Select drp = new Select(element);
		drp.selectByValue(val);

	}

	public static void scrollDownForLogPage() throws RuntimeException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200000)");

	}

	public static void scrollDownKey(By locator) throws RuntimeException {
		WebElement element = driver.findElement(locator);
		element.sendKeys(Keys.PAGE_DOWN);

	}

	public static void scrollDown() throws RuntimeException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,70000)");

	}

	public static void scrollDownForShort() throws RuntimeException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");

	}

	public static void scrollDownTillBottum() throws RuntimeException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollDownToElementPresent(By locator) throws RuntimeException {
		WebElement Element = driver.findElement(locator);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", Element);
	}

	public static void scrollDownTillElementPresent(By locator) throws RuntimeException {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'nearest'})",
				driver.findElement(locator));
	}

	public static void scrollUpTop() throws RuntimeException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-1000)", ")");
	}

	public static void scrollUP() throws RuntimeException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, -700000)");

	}

	public static void scrollUpToElementPresent(By locator) throws RuntimeException {

		WebElement element = driver.findElement(locator);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

	public static void scrolltoponly() throws RuntimeException {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, 0);");
	}

	public static void scrollUp() throws RuntimeException, Throwable {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();

	}

	public static void mouseHover(By locator) throws RuntimeException, Throwable {
		WebElement ele = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		Thread.sleep(3000);

	}

	public static void mouseHoverAndClick(By locator) throws RuntimeException, Throwable {
		WebElement ele = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		Thread.sleep(5000);
		actions.click().build().perform();
	}

	public static void tabFeature(By locator, String value) throws RuntimeException {
		try {

			WebElement element = driver.findElement(locator);

			element.sendKeys(value);
			element.sendKeys(Keys.TAB);
			element.sendKeys(Keys.TAB);
			element.sendKeys(Keys.TAB);

		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}

}

