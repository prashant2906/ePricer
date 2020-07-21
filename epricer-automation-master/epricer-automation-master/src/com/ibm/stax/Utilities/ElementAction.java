package com.ibm.stax.Utilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;
import ch.ethz.ssh2.crypto.Base64;

public class ElementAction {

	public boolean isElementPresentByXpath(String xpath, WebDriver driver, String Element_Name)
			throws InterruptedException {
		try {
			driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException t) {
			Log.error("Element not Found -->"+t.getMessage());
			return false;
		}
		return true;
	}

	public boolean isElementPresentByLinkText(String linkText, WebDriver driver) throws InterruptedException {
		try {
			driver.findElement(By.linkText(linkText));
		} catch (NoSuchElementException t) {
			Log.error("Element not Found -->" + t.getMessage());
			t.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isElementPresentByID(String ID, WebDriver driver, String Element_Name) throws InterruptedException {
		try {
			driver.findElement(By.id(ID));
		} catch (NoSuchElementException t) {
			Log.info("Element not Found -->" + t.getMessage());
			t.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isElementPresentByName(String Name, WebDriver driver, String Element_Name)
			throws InterruptedException {
		try {
			driver.findElement(By.name(Name));
		} catch (NoSuchElementException t) {
			Log.info("Element not Found -->" + t.getMessage());
			t.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isElementPresentByClassName(String className, WebDriver driver, String Element_Name)
			throws InterruptedException {
		try {
			driver.findElement(By.className(className));
			
		} catch (NoSuchElementException t) {
			Log.info("Element not Found -->" + t.getMessage());
			
			t.printStackTrace();
			return false;
		}
		return true;
	}

	public void clickButtonID(WebDriver screenName, String ID, String Element_Name) throws Exception {
		try {
			WebElement webButton = screenName.findElement(By.id(ID));
			webButton.click();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void clickButton(WebDriver screenName, String ObjectxPath, String Element_Name) throws Exception {
		try {
			WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
			webButton.click();
			// webButton.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void clickLink(WebDriver screenName, String ObjectxPath, String Element_Name) throws Exception {
		try {
			WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
			webButton.click();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void clickLinkByLinkText(WebDriver screenName, String linkText, String Element_Name) throws Exception {
		try {
			WebElement webButton = screenName.findElement(By.linkText(linkText));
			webButton.click();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public boolean clickFirst(WebDriver screenName, String ObjectxPath, String Element_Name) throws Exception {
		boolean flag = true;
		try {
			WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
			webButton.click();
		} catch (NoSuchElementException t) {
			
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		return flag;
	}

	public void inputText(WebDriver screenName, String ObjectxPath, String sValue, String Element_Name)
			throws Exception {
		try {
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			elementHighlight(screenName, inputText);
			inputText.clear();
			inputText.sendKeys(sValue);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public void inputTextForPassword(WebDriver screenName, String ObjectxPath, String sValue, String Element_Name)
			throws Exception {
		try {
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			char[] encyString = sValue.toCharArray();
			byte[] actualByte= Base64.decode(encyString);
			String actualString= new String(actualByte);			
			elementHighlight(screenName, inputText);
			inputText.clear();
			inputText.sendKeys(actualString);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public void removeAttribute(WebDriver driver) {
		List<WebElement> inputs = driver.findElements(By.tagName("input"));
		for (WebElement input : inputs) {
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", input);
		}
	}

	public void typeNonEditable(WebDriver driver, String ObjectxPath, String sValue, String Element_Name)
			throws Exception {
		removeAttribute(driver);
		inputText(driver, ObjectxPath, sValue, Element_Name);
	}

	public void enterText(WebDriver screenName, String ObjectxPath, String sValue, String Element_Name)
			throws Exception {
		Actions actions = new Actions(screenName);
		try {
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			actions.moveToElement(inputText);
			actions.click();
			actions.sendKeys(sValue);
			actions.build().perform();
		} catch (NoSuchElementException t) {
			
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public void inputTextByID(WebDriver screenName, String ID, String sValue, String Element_Name) throws Exception {
		try {
			WebElement inputText = screenName.findElement(By.id(ID));
			inputText.sendKeys(sValue);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public void selectCheckBox(WebDriver screenName, String ObjectxPath, String Element_Name) throws Exception {
		try {
			WebElement checkBox = screenName.findElement(By.xpath(ObjectxPath));
			checkBox.click();
			
		} catch (NoSuchElementException t) {
			
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void selectRadio(WebDriver screenName, String ObjectxPath, String Element_Name) throws Exception {
		try {
			WebElement radioButton = screenName.findElement(By.xpath(ObjectxPath));
			radioButton.click();		
		} catch (NoSuchElementException t) {		
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public String getInputTextValue(WebDriver screenName, String ObjectxPath, String Element_Name) throws Exception {
		try {
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			
			return inputText.getText();
		} catch (NoSuchElementException t) {
			
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public String getInputValue(WebDriver screenName, String ObjectxPath, String Element_Name) throws Exception {
		try {
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));	
			return inputText.getAttribute("value");
		} catch (NoSuchElementException t) {
			
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void clearInputTextValue(WebDriver screenName, String ObjectxPath, String Element_Name) throws Exception {
		try {
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			inputText.clear();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void clearInputTextValueByName(WebDriver screenName, String name, String Element_Name) throws Exception {
		try {
			WebElement inputText = screenName.findElement(By.name(name));
			inputText.clear();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void clearAndInputTextValue(WebDriver screenName, String ObjectxPath, String value, String Element_Name)
			throws Exception {

		try {
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			Thread.sleep(1000);
			inputText.clear();
			Thread.sleep(1000);
			inputText.sendKeys(value);
		} catch (NoSuchElementException t) {			
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void selectDropBoxValue(WebDriver screenName, String ObjectxPath, String value, String Element_Name)
			throws Exception {
		try {
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			screenName.findElement(By.xpath(ObjectxPath)).click();
			Select select = new Select(selectDropBox);
			select.selectByValue(value);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public void selectDropBoxByVisibleText(WebDriver screenName, String ObjectxPath, String value, String Element_Name)
			throws Exception {
		// Thread.sleep(500);
		try {
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			// Thread.sleep(500);
			select.selectByVisibleText(value);
		} catch (NoSuchElementException t) {
			
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void selectDropBoxValueByID(WebDriver screenName, String ID, String value, String Element_Name)
			throws Exception {
		try {
			WebElement selectDropBox = screenName.findElement(By.id(ID));
			Select select = new Select(selectDropBox);
			select.selectByValue(value);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public void selectDropBoxValueByName(WebDriver screenName, String Name, String value, String Element_Name)
			throws Exception {
		try {
			WebElement selectDropBox = screenName.findElement(By.name(Name));
			Select select = new Select(selectDropBox);
			select.selectByValue(value);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public void selectDropBoxValue(WebDriver screenName, String ObjectxPath, int index, String Element_Name)
			throws Exception {
		try {
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			select.selectByIndex(index);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public void selectDropBoxDefaultValue(WebDriver screenName, String ObjectxPath, String Element_Name)
			throws Exception {
		try {
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			select.selectByIndex(0);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public String getDropBoxDefaultValue(WebDriver screenName, String ObjectxPath, String Element_Name)
			throws Exception {
		try {
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			return select.getFirstSelectedOption().getText();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public String getDropBoxSelectedValue(WebDriver screenName, String ObjectxPath, int index, String Element_Name)
			throws Exception {
		try {
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			return select.getFirstSelectedOption().getText();
		}

		catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public int getDropBoxSize(WebDriver screenName, String ObjectxPath, String Element_Name) throws Exception {
		try {
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			return select.getOptions().size();
		} catch (NoSuchElementException t) {
			
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public String[] getDropBoxValue(WebDriver screenName, String ObjectxPath, String Element_Name) throws Exception {
		try {
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			List<WebElement> optionValue = select.getOptions();
			String[] value = new String[optionValue.size()];
			for (int i = 0; i < optionValue.size(); i++)
				value[i] = optionValue.get(i).getText();
			return value;
		} catch (NoSuchElementException t) {
			
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public int getTotalTableCell(WebDriver driver, String ObjectxPath, String Element_Name) throws Exception {
		try {
			return driver.findElements(By.xpath(ObjectxPath)).size();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public int getElementsSize(WebDriver driver, String ObjectxPath, String Element_Name) throws Exception {
		try {
			return driver.findElements(By.xpath(ObjectxPath)).size();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public int getElementCount(WebDriver driver, String className, String Element_Name) throws Exception {
		int count = 0;
		try {
			count = driver.findElements(By.className(className)).size();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		return count;
	}

	public boolean isElementDisplayed(WebDriver driver, String xpath, String Element_Name) throws Exception {
		boolean flag = false;
		try {
			if (driver.findElement(By.xpath(xpath)).isDisplayed()) {// Extent_Reporting.Log_Pass(Element_Name +" is
																	// displayed ", Element_Name +" is displayed ");
				flag = true;
			}
		} catch (NoSuchElementException e) {
			flag = false;
			throw new Exception("Element Not Present");
		}
		return flag;

	}

	public boolean isElementDisplay(WebDriver driver, String xpath) throws Exception {
		boolean flag = false;
		try {
			if (driver.findElement(By.xpath(xpath)) != null) {
				elementHighlight(driver, driver.findElement(By.xpath(xpath)));
				flag = true;
			}
		} catch (NoSuchElementException e) {
			// e.printStackTrace();
			flag = false;
			throw new Exception("Element Not Present");
		}
		return flag;

	}

	public void mouseHoverAction_3(WebDriver driver, String mainElementXP, String subElementXP, String subSubElementXP,
			String Element_Name) throws Exception {
		try {
			Actions action = new Actions(driver);
			WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
			action.moveToElement(mainElement).perform();
			WebElement subElement = driver.findElement(By.xpath(subElementXP));
			action.moveToElement(subElement).perform();
			WebElement subSubElement = driver.findElement(By.xpath(subSubElementXP));
			action.moveToElement(subSubElement);
			action.click();
			action.perform();
			Log.info("Click action is performed on the selected Product Type");
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void mouseHoverAction_2(WebDriver driver, String mainElementXP, String subElementXP, String Element_Name)
			throws Exception {
		try {
			Actions action = new Actions(driver);
			WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
			action.moveToElement(mainElement).perform();
			WebElement subElement = driver.findElement(By.xpath(subElementXP));
			action.moveToElement(subElement).perform();
			action.moveToElement(subElement).click();
			action.moveToElement(subElement).perform();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void mouseHoverAction(WebDriver driver, String mainElementXP, String Element_Name) throws Exception {
		try {
			Actions action = new Actions(driver);
			WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
			action.moveToElement(mainElement).clickAndHold().build().perform();
			action.release().perform();
			// action.perform();
			Log.info("mouseHoverAction");
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void mouseHoverAction(WebDriver driver, String mainElementXP, String subElementXP, String subSubElementXP,
			String subBesideElementXP, String Element_Name) throws Exception {
		try {
			Actions action = new Actions(driver);
			WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
			action.moveToElement(mainElement).perform();
			WebElement subElement = driver.findElement(By.xpath(subElementXP));
			action.moveToElement(subElement).perform();
			WebElement subSubElement = driver.findElement(By.xpath(subSubElementXP));
			action.moveToElement(subSubElement).perform();
			WebElement subBesideElement = driver.findElement(By.xpath(subBesideElementXP));
			action.moveToElement(subBesideElement).perform();
			action.click();
			action.perform();
			Log.info("Click action is performed on the selected Product Type");
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void selectclass(WebDriver driver, WebElement parent, String elementToSelect, String Element_Name)
			throws Exception {
		try {
			Select dropdown = new Select(parent);
			dropdown.selectByVisibleText(elementToSelect);
		} catch (NoSuchElementException t) {
			
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public void getWindowHandle(WebDriver driver, String title) throws Exception {
		int cnt = 0;
		int l = 0;
		do {

			Set<String> handles = driver.getWindowHandles();

			String[] browser = handles.toArray(new String[0]);
			// System.out.println("Number of browsers opened are"
			// + browser.length);
			for (int i = 0; i < handles.size(); i++) {
				try {
					driver.switchTo().window(browser[i]);
					// System.out.println(driver.getTitle());
					if (driver.getTitle().contains(title)) {
						// System.out.println(driver.getTitle()+"found");
						driver.getWindowHandle();
						cnt = 1;
						break;
					}
				}

				catch (NoSuchElementException t) {
					System.out.println("Browser not opened");
					throw new Exception("Element Not Present");
				}

			}

			if (cnt == 1) {
				break;
			}
			if (l == 20) {
				break;
			}
			Thread.sleep(500);
			l = l + 1;
		} while (true);

	}

	public void selectWindowIfElementPresent(WebDriver driver, String element) throws Exception {
		Thread.sleep(2000);
		Set<String> windows = driver.getWindowHandles();
		Object[] win = windows.toArray();
		System.out.println(win.length);
		driver.switchTo().window(win[0].toString());
		if (!isElementDisplay(driver, element)) {
			driver.switchTo().window(win[1].toString());
			System.out.println("Selected Pop Up : " + driver.switchTo().window(win[1].toString()).getTitle());
		}
	}

	public void waitForElementNotPresent(WebDriver driver, String element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
		} catch (TimeoutException e) {
			e.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void waitForElementVisible(WebDriver driver, String element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 110);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}

	public void waitForElementClickable(WebDriver driver, String element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 110);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}

	public void waitForTextPresent(WebDriver driver, String text) throws Exception {
		try {
			Thread.sleep(2000);
			long timer = 0;
			while (isTextPresent(driver, text) == false && timer < Long.valueOf("30000")) {
				Thread.sleep(500);
				timer += 5000;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt("90"), TimeUnit.SECONDS);
	}

	public boolean isTextPresent(WebDriver driver, String text) {
		boolean flag = false;
		try {
			flag = driver.findElement(By.xpath("//*[contains(.,'" + text + "')]")).isDisplayed();
		} catch (NoSuchElementException e) {
			return flag;
		} catch (NoSuchWindowException e) {
			return flag;
		}
		return flag;
	}

	public void getTableData(WebDriver driver, String xpath) {
		// Grab the table
		WebElement table = driver.findElement(By.xpath(xpath));

		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));

		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));

			// Print the contents of each cell
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
		}
	}

	// Function for fetching the value from the object when value attribute is not
	// present.
	public String getObjectValue(WebDriver driver, WebElement webElement) {
		JavascriptExecutor e = (JavascriptExecutor) driver;
		return (String) e.executeScript(String.format("return $('#%s').val();", webElement.getAttribute("id")));
	}

	public String getObjectValueClass(WebDriver driver, WebElement webElement) {
		JavascriptExecutor e = (JavascriptExecutor) driver;
		return (String) e.executeScript(String.format("return $('#%s').val();", webElement.getAttribute("class")));
	}

	/*
	 * public void doubleClick(WebDriver driver,WebElement myElemment) throws
	 * InterruptedException { if(isElementPresentByXpath(driver, myElemment)) {
	 * Actions action = new Actions(driver); action.moveToElement(myElemment);
	 * Thread.sleep(2000); action.doubleClick(); //action.doubleClick(myElemment);
	 * action.build().perform(); } else { throw new
	 * Exception("selectDropBoxValue() --- >Element Not Present"); } }
	 */
	public int getElementCountXPath(WebDriver driver, String ObjectPath, String Element_Name)
			throws InterruptedException {
		int count = 0;
		if (isElementPresentByXpath(ObjectPath, driver, Element_Name)) {
			count = driver.findElements(By.xpath(ObjectPath)).size();
		}
		return count;
	}

	public void acceptAlert(WebDriver driver) throws Exception {
		try {
			Alert alert = waitforAlertPresent(driver);
			if (!alert.equals(null))
				alert.accept();
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public Alert waitforAlertPresent(WebDriver driver) throws InterruptedException {
		int i = 0;
		Alert alert = null;
		while (i++ < 30) {
			try {
				alert = driver.switchTo().alert();
				return alert;
			} catch (NoAlertPresentException ignored) {
				Thread.sleep(1000);
				continue;
			}
		}
		return alert;
	}

	public void waitForPopUp(WebDriver driver, String b) throws InterruptedException {
		Thread.sleep(3000);
		try {
			selectPopUp(driver, b);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (NoSuchWindowException e1) {
			e1.printStackTrace();
		}
	}

	public void selectPopUp(WebDriver driver, String arg) {
		boolean flag = false;
		try {
			for (int i = 0; i < 2 && flag == false; i++) {
				Set<String> pops = driver.getWindowHandles();
				Iterator<String> it = pops.iterator();
				if (pops.size() > 1) {
					System.out.println("No of Windows " + pops.size());
					for (int j = 0; j < pops.size() && flag == false; j++) {
						String popupHandle = it.next().toString();
						if (driver.switchTo().window(popupHandle).getTitle().contains(arg)) {
							driver.switchTo().window(popupHandle);
							flag = true;
						}
					}
					flag = true;
					pops.clear();
				}
			}
		} catch (NoSuchWindowException ignored) {
			System.out.println("Not able to Navigate to Window " + arg);
		} 
	}

	public void checkUsingJavaScript(WebDriver driver, String obj, String ObjectName) throws InterruptedException {
		try {
			WebElement element = null;
			if (obj.startsWith("id")) {
				element = driver.findElement(By.id(obj.split("id:")[1]));
			} else if (obj.startsWith("name")) {
				element = driver.findElement(By.name(obj.split("name:")[1]));
			} else {
				element = driver.findElement(By.xpath(obj));
			}
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			new Exception(ObjectName + " not present");
		}
	}

	public void waitForFrameAndSwitch(WebDriver driver, String frameName) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));

	}

	public void waitForElementVisible(WebDriver driver, String element, String Element_Name) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		} catch (NoSuchElementException we) {
			we.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void Javascriptexecutor_forClick(WebDriver driver, String frameName, String XpathObject, String ObjectName)
			throws Exception {
		waitForPageToLoad(driver);
		waitForFrameAndSwitch(driver, frameName);
		waitForPageToLoad(driver);
		try {
			waitForElementVisible(driver, XpathObject, ObjectName);
			WebElement e = driver.findElement(By.xpath(XpathObject));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", e);
		} catch (NoSuchElementException | InterruptedException t) {
			t.printStackTrace();
			new Exception(ObjectName + " not present");
			throw new Exception("Element Not Present");
		}

	}

	public void clickLinkBypartialLinkText(WebDriver screenName, String linkText, String Element_Name)
			throws Exception {
		try {
			WebElement webButton = screenName.findElement(By.partialLinkText(linkText));
			webButton.click();
		} catch (NoSuchElementException t) {
			
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void clickLinkBypartialLinkTextIfExist(WebDriver screenName, String linkText, String Element_Name)
			throws Exception {
		try {
			WebElement webButton = screenName.findElement(By.partialLinkText(linkText));
			webButton.click();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
		}
	}

	public void clickLinkByLinkTextIfExist(WebDriver screenName, String linkText, String Element_Name)
			throws Exception {
		try {
			WebElement webButton = screenName.findElement(By.linkText(linkText));
			webButton.click();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
		}
	}

	public boolean CheckifExist(WebDriver driver, String element) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
			waitForPageToLoad(driver);
			return true;

		} catch (NoSuchWindowException e) {
			System.out.println("not exist");
			waitForPageToLoad(driver);
			return false;
		} catch (WebDriverException we) {
			waitForPageToLoad(driver);
			return false;
		}
	}

	public boolean CheckifExistAndReport(WebDriver driver, String element, String Element_Name)
			throws InterruptedException {
		try {
			// driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
			System.out.println("Element Exist");
			waitForPageToLoad(driver);
			return true;

		} catch (NoSuchElementException t) {
			waitForPageToLoad(driver);
			System.out.println("not exist");
			return false;
		}
	}

	public void Clickbtn(WebDriver screenName, String ObjectxPath, String Element_Name) throws Exception {
		Thread.sleep(500);
		try {
			WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
			webButton.click();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public int getTableRowCount(WebDriver driver, String xapth) {
		try {
			WebElement htmltable = driver.findElement(By.xpath(xapth));
			elementHighlight(driver, htmltable);
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
			System.out.println(rows.size());
			return rows.size();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			return 0;
		}

	}

	public boolean CheckTableContains(WebDriver driver, String xapth, String value, String Element_Name)
			throws InterruptedException {
		int cnt = 0;
		try {
			WebElement htmltable = driver.findElement(By.xpath(xapth));

			List<WebElement> allRows = htmltable.findElements(By.tagName("tr"));

			for (WebElement row : allRows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));

				// Print the contents of each cell
				for (WebElement cell : cells) {
					if (cell.getText().contains(value))

					{
						cnt = 1;
						break;
					}

				}

				if (cnt == 1) {
					break;
				}
			}
			if (cnt == 1) {
				return true;
			} 
		} catch (NoSuchElementException t) {
			return false;
		}
		return true;
	}

	public boolean CheckTableHeaderContains(WebDriver driver, String xapth, String value) throws InterruptedException {
		int cnt = 0;
		try {
			WebElement htmltable = driver.findElement(By.xpath(xapth));

			List<WebElement> allRows = htmltable.findElements(By.tagName("tr"));

			for (WebElement row : allRows) {
				List<WebElement> cells = row.findElements(By.tagName("th"));

				// Print the contents of each cell
				for (WebElement cell : cells) {
					if (cell.getText().contains(value)) {
						cnt = 1;
						break;
					}

				}
				if (cnt == 1) {
					break;
				}
			}
			if (cnt == 1) {
				return true;
			}
		} catch (NoSuchElementException t) {
			return false;
		}
		return true;
	}

	public boolean checkElementClickable(WebDriver driver, String element, String Web_Element)
			throws InterruptedException {
		try {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
			waitForPageToLoad(driver);
			return true;
		} catch (NoSuchElementException e) {
			waitForPageToLoad(driver);
			return false;
		}

	}

	public boolean CheckTableallRowsofColumnContains(WebDriver driver, String xapth, String value, int column,
			String Element_Name) throws InterruptedException {
		int cnt = 0;
		try {
			WebElement htmltable = driver.findElement(By.xpath(xapth));

			List<WebElement> allRows = htmltable.findElements(By.tagName("tr"));
			// List<WebElement> columns=rows.get(1).findElements(By.tagName("td"));

			System.out.println("Number of rows:" + allRows.size());

			for (WebElement row : allRows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));

				// Print the contents of each cell
				// for (WebElement cell : cells) {
				System.out.println(cells.get(column).getText());
				if (cells.get(column).getText().contains(value)) {
					cnt = 1;

				} else {
					cnt = 0;
				}

			}
			if (cnt == 1) {
				return true;
			} 
			System.out.println("*********************completed");
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean CheckifTextExistAndReport(WebDriver driver, String element, String Element_Name)
			throws InterruptedException {
		try {
			// driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			String Strelement = "//*[contains(text(),'" + element + "')]";
			driver.findElement(By.xpath(Strelement));
			System.out.println("Element Exist");
			waitForPageToLoad(driver);
			return true;
		} catch (NoSuchElementException t) {
			waitForPageToLoad(driver);
			System.out.println("not exist");
			t.printStackTrace();
			return false;
		}
	}

	public void Verifydroplist(WebDriver driver, String Xpath, String ExpectedValues, String Element_name)
			throws Exception {
		String listvalues = "";
		try {

			WebElement dropdown = driver.findElement(By.xpath(Xpath));

			Select select = new Select(dropdown);
			List<WebElement> options = select.getOptions();
			for (WebElement we : options) {
				listvalues = listvalues + we.getText();
			}

			String val[] = ExpectedValues.split(";");
			for (String x : val)
			{
				listvalues.contains(x);
			}
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void elementHighlight(WebDriver driver, WebElement element) {
		for (int i = 0; i < 8; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: red; border: 3px solid red;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");

		}

	}

	public void WaitUntilExist(WebDriver driver, String Element) {
		RemovewaitForPageToLoad(driver);
		int i = 1;
		do {
			try {
				driver.findElement(By.xpath(Element));
				break;
			} catch (NoSuchElementException ignored) {
				System.out.println("Element not found");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i = i + 1;
			if (i == 50) {
				break;
			}

		} while (true);
		waitForPageToLoad(driver);
	}

	public void RemovewaitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt("0"), TimeUnit.SECONDS);
	}

	public void Waituntilsiappear(WebDriver driver, String Element) {
		RemovewaitForPageToLoad(driver);
		do {
			try {
				driver.findElement(By.xpath(Element));
			} catch (NoSuchElementException ignored) {
				break;
			}

		} while (true);
		waitForPageToLoad(driver);
	}

	public boolean isElementEnabled(WebDriver driver, String xpath, String Element_Name) {
		boolean flag = false;
		try {
			if (driver.findElement(By.xpath(xpath)).isEnabled()) {
				flag = true;
			}
		} catch (NoSuchElementException e) {
			flag = false;
		}
		return flag;
	}

	public void clickButtonwithEnterKeytwice(WebDriver screenName, String ObjectxPath, String Element_Name)
			throws Exception {
		try {
			WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
			// webButton.click();
			webButton.sendKeys(Keys.ENTER);
			webButton.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void selectDropBoxValuebyVisibleTextwithoutClick(WebDriver screenName, String ObjectxPath, String value,
			String Element_Name) throws Exception {
		try {
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			// screenName.findElement(By.xpath(ObjectxPath)).click();
			Select select = new Select(selectDropBox);
			select.selectByVisibleText(value);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public void Javascriptexecutor_forClick(WebDriver driver, String XpathObject, String ObjectName) throws Exception {
		waitForPageToLoad(driver);
		// waitForFrameAndSwitch(driver, frameName);
		waitForPageToLoad(driver);
		// waitForElementVisible(driver, XpathObject,ObjectName);
		try {
			WebElement e = driver.findElement(By.xpath(XpathObject));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", e);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			new Exception(ObjectName + " not present");
			throw new Exception("Element Not Present");
		}
	}

	public void waituntiltablerecordload(WebDriver driver, String Xpath, int recordcount) throws InterruptedException {
		int l = 0;
		do {
			Thread.sleep(500);
			l = l + 1;

			if (l == 5) {
				break;
			}
			if (getTableRowCount(driver, Xpath) >= recordcount) {
				break;
			}
		} while (getTableRowCount(driver, Xpath) < recordcount);
	}

	public boolean WaitUntilNumberofWindowHandleOpen(WebDriver driver, int n) throws InterruptedException {

		String[] browser;
		int i = 1;
		int cnt = 0;
		do {
			Set<String> handles = driver.getWindowHandles();

			browser = handles.toArray(new String[0]);
			System.out.println("Number of browsers opened are" + browser.length);
			Thread.sleep(500);

			if (browser.length == n) {
				cnt = 1;
				break;
			}
			if (i == 20) {
				cnt = 1;
				break;
			}

		} while (true);
		if (cnt == 1) {
			return true;

		} else {
			return false;
		}

	}

	public boolean CheckifExistAndReportWithWait(WebDriver driver, String element, String Element_Name)
			throws InterruptedException {
		try {
			waitForPageToLoad(driver);
			driver.findElement(By.xpath(element));
			System.out.println("Element Exist");
			return true;

		} catch (NoSuchElementException t) {
			waitForPageToLoad(driver);
			System.out.println("not exist");
			t.printStackTrace();
			return false;
		}

	}

	public boolean ClickifTextExistAndReport(WebDriver driver, String element) throws InterruptedException {
		try {
			// driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			String Strelement = "//*[contains(text(),'" + element + "')]";
			driver.findElement(By.xpath(Strelement)).click();
			System.out.println("Element Exist");
			waitForPageToLoad(driver);
			return true;

		} catch (NoSuchElementException t) {
			waitForPageToLoad(driver);
			System.out.println("not exist");
			t.printStackTrace();
			return false;
		}
	}

	public void inputTextwithClick(WebDriver screenName, String ObjectxPath, String sValue, String Element_Name)
			throws Exception {
		try {
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			elementHighlight(screenName, inputText);
			inputText.click();
			inputText.clear();
			System.out.println(sValue);
			inputText.sendKeys(sValue);
			inputText.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void mouseHoverActionandClick(WebDriver driver, String mainElementXP, String Element_Name) throws Exception {
		try {
			Actions action = new Actions(driver);
			WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
			action.moveToElement(mainElement).perform();
			action.click();
			action.perform();
		} catch (NoSuchElementException t) {
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void handleAlert(WebDriver driver) {
		if (isAlertPresent(driver)) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ignored) {
			return false;
		}
	}

	public boolean checkElementClickableFluent(WebDriver driver, final String ObjectxPath, String element)
			throws InterruptedException {
		try {
			FluentWait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver);
			waitFluent.pollingEvery(5, TimeUnit.SECONDS);
			waitFluent.withTimeout(90, TimeUnit.SECONDS);
			waitFluent.ignoring(NoSuchElementException.class);

			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					// return driver.findElement(By.xpath(ObjectxPath));
					WebElement element1 = driver.findElement(By.xpath(ObjectxPath));
					//System.out.println(element1);
					if (element1 != null) {
						//System.out.println(element1 + "is present in true statement");
						return true;
					}
					return false;
				}
			};
			return waitFluent.until(function);

		} catch (NoSuchElementException e) {
			waitForPageToLoad(driver);
			return false;
		}
	}
}
