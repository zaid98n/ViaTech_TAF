package com.singlestorefront.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.singlestorefront.base.BaseClass;

/**
 * This Action class contains action methods which
 * can pe called for the test execution.
 * Examples-Typing, clicking,....
 * 
 * @version 1.0
 *  
 */

@SuppressWarnings("unused")
public class Action extends BaseClass {

	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	
	public static void click(WebElement ele) {
		Action.fluentWait(getDriver(), ele, 10);
		//Action.explicitWait(getDriver(), ele, 10);
		Actions act = new Actions(getDriver());
		act.moveToElement(ele).click().build().perform();

	}

	
	public static boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			// System.out.println("Location not found: "+locatorName);
			flag = false;
		}
		return flag;
	}

	
	public static boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
		} else {
			//System.out.println("Not displayed ");
		}
		return flag;
	}

	
	public static boolean isSelected(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isSelected();
		} else {
			//System.out.println("Not selected ");
		}
		return flag;
	}

	
	public static boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isEnabled();
		} else {
			//System.out.println("Not Enabled ");
		}
		return flag;
	}


	public static boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			Action.fluentWait(getDriver(), ele, 10);
			flag = ele.isDisplayed();
			ele.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			ele.sendKeys(Keys.DELETE);
			ele.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			//System.out.println("Location Not found");
			flag = false;
		}
		return flag;
	}

	
	public static boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public static boolean selectByValue(WebElement element,String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	
	public static boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public static boolean pageUp() {
		boolean flag = false;
		try {
			Actions build = new Actions(getDriver());
			build.sendKeys(Keys.HOME).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public static boolean pageDown() {
		boolean flag = false;
		try {
			Actions build = new Actions(getDriver());
			build.sendKeys(Keys.END).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean downArrow() {
		boolean flag = false;
		try {
			Actions build = new Actions(getDriver());
			build.sendKeys(Keys.ARROW_DOWN).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean upArrow() {
		boolean flag = false;
		try {
			Actions build = new Actions(getDriver());
			build.sendKeys(Keys.ARROW_UP).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean leftArrow() {
		boolean flag = false;
		try {
			Actions build = new Actions(getDriver());
			build.sendKeys(Keys.ARROW_LEFT).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean rightArrow() {
		boolean flag = false;
		try {
			Actions build = new Actions(getDriver());
			build.sendKeys(Keys.ARROW_RIGHT).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean enterKey() {
		boolean flag = false;
		try {
			Actions build = new Actions(getDriver());
			build.sendKeys(Keys.ENTER).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean doubleClick(WebElement ele) {
		boolean flag = false;
		try {
			Actions build = new Actions(getDriver());
			build.doubleClick().build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void selectElementFromList(String elementsList, String targetElement){
        List<WebElement> allElements = getDriver().findElements(By.className(elementsList));
        int index = 1;
        for (WebElement element: allElements) {
            if (element.getText().equals(targetElement)) {
                getDriver().findElement(By.cssSelector(elementsList+":nth-child(" + index + ")")).click();
            }
            index++;
        }
    }
	
	public static void selectBySendkeys(String ele, String targetName) {
		List<WebElement> lst = getDriver().findElements(By.className(ele));
		Iterator<WebElement> it = lst.iterator();
		while(it.hasNext()) {
			WebElement wb = it.next();
			if(wb.getText().equalsIgnoreCase(targetName)) {
				//wb.click();
				JavascriptExecutor executor = (JavascriptExecutor) getDriver();
				executor.executeScript("arguments[0].click();", wb);
				break;
			}
		}
	}
	
	public static void scroll(WebElement Element) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].scrollIntoView();", Element);
	}
	
	public static boolean mouseHoverByJavaScript(WebElement ele) {
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	
	public static boolean JSClick(WebDriver driver, WebElement ele) throws Exception {
		boolean flag = false;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);

			flag = true;
		}
		catch (Exception e) {
			throw e;
		}
		return flag;
	}

	
	public static boolean switchToFrameByIndex(WebDriver driver,int index) {
		boolean flag = false;
		try {
			driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public static boolean switchToFrameById(WebDriver driver,String idValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(idValue);
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public static boolean switchToFrameByName(WebDriver driver,String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	
	public static boolean switchToDefaultFrame(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public static void mouseOverElement(WebDriver driver,WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			actions.moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	
	public static boolean mouseover(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public static boolean draggable(WebDriver driver,WebElement source, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;

		} catch (Exception e) {
		
			return false;
			
		}
	}
	
	public static boolean draganddrop(WebDriver driver,WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		}
	}
	
	
	public static boolean slider(WebDriver driver,WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
			// .perform();
			Action.fluentWait(getDriver(), ele, 10);
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(1000);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		}
	}
	
	
	public static boolean rightclick(WebDriver driver,WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		}
	}
	
	
	public static boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count-1]);

			if (driver.getTitle().contains(windowTitle)){
				flag = true;
			}else{
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			//flag = true;
			return false;
		}
	}
	
	
	public static boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		}
	}
	
	
	public static boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[0].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		}
	}
	
	
	public static int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}
	
	
	public static int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}
	
	
	public static boolean Alert(WebDriver driver) {
		boolean flag = false;
		Alert alert = null;

		try {
			alert = driver.switchTo().alert();
			alert.accept();
			flag = true;
		} catch (NoAlertPresentException ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean launchUrl(WebDriver driver,String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public static boolean isAlertPresent(WebDriver driver) 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
	}
	
	
	public static String getTitle(WebDriver driver) {

		String text = driver.getTitle();

		return text;
	}
	
	public static String getText(WebDriver driver, WebElement ele) {

		String text = ele.getText();

		return text;
	}
	
	
	public static String getCurrentURL(WebDriver driver)  {

		String text = driver.getCurrentUrl();
		return text;
	}
	
	
	public static boolean simpleClick(WebElement locator) {
		boolean flag = false;
		try {
			locator.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public static void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(timeOut))
	        	    .pollingEvery(Duration.ofSeconds(1))
	        	    .ignoring(Exception.class);
	        //wait.until(ExpectedConditions.visibilityOf(element));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        //element.click();
	    }catch(Exception e) {
	    }
	}
	
	
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	
	public static void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		//try {
			WebDriverWait wait = new WebDriverWait(driver,timeOut);
			//wait.ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
		//}
		//catch (Exception e) {
		//}
		
	}
	
	
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	
	
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
	
	
	public static String getCurrentDateTime() {
		String currentDate = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
		return currentDate;
	}

}

