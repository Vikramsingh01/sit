package com.meganexus.SIT_AutomationTesting.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	public static WebDriver driver = null;
	static String fileName = "";
	static File file = new File(System.getProperty("user.dir") + "/src/test/resources" + fileName);
	
	// Launching nDelius application
	public static void openFireFoxBrowserAndLaunch_nDelius() throws InterruptedException {
		try {

			System.setProperty("webdriver.gecko.driver", file + "/geckodriver.exe");
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setCapability("platform", Platform.ANY);
			capability.setCapability("binary", "C:\\Program Files\\Mozilla  Firefox\\firefox.exe");
			driver = new FirefoxDriver(capability);
			Log.info("New Driver instantiated and Launching firefox browser");
			driver.get(ConfigFile.readProperty("/config.propeties", "nDeliusURL"));
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			Log.info("pageload wait applied on the driver for 50 seconds");
						

		} catch (Exception e) {
			waitForImplicitWait();
			Log.error("Class Utils | Method openFireFoxBrowserAndLaunch_nDelius | Exception desc :" + e.getMessage());
		}
		
		if(driver.getTitle().contains("Problem loading page")) {
			System.out.println("VPN connection is not active. Connecting VPN, please wait");
			VPNConnectDisconnect.openCiscoVPN_Connect();
			Thread.sleep(20000);
			driver.navigate().refresh();
			waitForImplicitWait();
		}else {
			System.out.println("Active VPN connecton");
		}

	}

	// Launching cms application with already opened browser
	public static void cmsApps() {
		try {
			Log.info("Launching CMS application");
			driver.get(ConfigFile.readProperty("/config.propeties", "cmsURL"));
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		} catch (Exception e) {
			waitForImplicitWait();
			Log.error("Unable to launch CMS application " + e.getMessage());
		}

	}

	public static void get_rbacs_CMS_driver() {
		try {
			Log.info("Launching firefox browser");
			System.setProperty("webdriver.gecko.driver", file + "/geckodriver.exe");
			Log.info("geckodriver 0.18.0");
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setCapability("platform", Platform.ANY);
			capability.setCapability("binary", "C:\\Program Files\\Mozilla  Firefox\\firefox.exe");
			driver = new FirefoxDriver(capability);
			driver.get(ConfigFile.readProperty("/config.propeties", "rbacsURL"));
			driver.manage().timeouts().pageLoadTimeout(40000, TimeUnit.SECONDS);
			Log.info("CMS launched successfully... ");
		} catch (Exception e) {
			Log.error("Class Utils | Method get_rbacs_CMS_driver | Exception desc :" + e.getMessage());
		}
	}

	// close the browser
	public static void tearDown() {
		Log.info("Closing all opened browser");
		if (driver == null) {

			return;
		}
		driver.quit();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Log.error("Driver did not close successfully " + e.getMessage());
		}
		driver = null;
	}

	// maximize the browser
	public static void maxmizeBrowser() {
		driver.manage().window().maximize();
		pageLoad();

	}

	// scroll to move an element
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	// scroll to click an element
	public void scrollToClickElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	// To get value from drop down list using select by indexno using locator id
	public static void selectAnElementFromIndexNo(String id, int indexNo) {
		((JavascriptExecutor) driver).executeScript("jQuery('#assignee').css('display','block')");
		new Select(driver.findElement(By.id(id))).selectByIndex(indexNo);

	}

	// To get value from drop down list using select by text using locator xpath
	public static void selectAnElementFromIndexNoX(String xpath, int indexNo) {
		new Select(driver.findElement(By.xpath(xpath))).selectByIndex(indexNo);
	}

	// To get value from drop down list using select by text using locator id
	public static void selectAnElementFromText(String id, String text) {
		waitForElementVisible(By.id(id));
		new Select(driver.findElement(By.id(id))).selectByVisibleText(text);

	}

	// To get value from drop down list using select by value using locator id
	public static void selectAnElementFromValue(String id, String value) {
		new Select(driver.findElement(By.id(id))).selectByValue(value);

	}

	// To get all the value from drop down list
	@SuppressWarnings("unused")
	private List<WebElement> getListOfElementDDl(WebElement element) {
		return new Select(element).getOptions();

	}
	
	public static boolean alertAccept() {
		try {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		return true;
		} catch (Exception e) {
		System.out.print("no alert");
		return false;
		}
	}
	
	public static boolean alertDismiss() {
		try {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.dismiss();
		return true;
		} catch (Exception e) {
		System.out.print("no alert");
		return false;
		}
	}
	
	

	// wait for an element to be clickable on UI using explicit wait
	public static void waitForElementClickable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// wait for an element to be visible on UI using explicit wait
	public static void waitForElementVisible(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// wait for an element to be present on UI using explicit wait
	public static WebElement waitForElementPresent(By locator) {

		return new WebDriverWait(driver, 40).ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class).ignoring(Exception.class)
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// wait for select an element from drop down list using explicit wait -To be
	// implement
	public static void waitForElementSelecable(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeSelected(locator));
	}

	// implicit wait
	public static void waitForImplicitWait() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	// wait for element using fluent wait
	public static WebElement waitForElement(By locator) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS)
				.pollingEvery(40, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

	}

	// wait for page to load
	public static void pageLoad() {
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.MILLISECONDS);

	}

	// take screen shot and save the image on target folder
	public static void takeScreenShot(String folderName, String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,
					new File(System.getProperty("user.dir") + "/target/" + folderName + fileName + ".png"));
		} catch (IOException e) {
			Log.error("Unable to save screenshot on defined path " + e.getMessage());
		}
	}

	public boolean retryingFindElement(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	// To get the system date and time
	public static String getSysDateAndTime() {
		DateFormat dtf = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss");
		Date date = new Date();
		return dtf.format(date);
	}

	public static String getSysDate() {
		DateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dtf.format(date);
	}
	public static String getYearAfterCurrentDate() {
		
		Calendar date = Calendar.getInstance();
	    date.setTime(new Date());
	    DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	    System.out.println(f.format(date.getTime()));
	    date.add(Calendar.YEAR,1);
	    return f.format(date.getTime());
	}
	
	// To get the testcase name
	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			Log.error("Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());
			throw (e);
		}
	}

	// actions class use for mouse hover action- To be implemented
	public static void mouseHoverAction(WebElement mainElement, String subElement) {

		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		if (subElement.equals("")) {
			action.moveToElement(driver.findElement(By.linkText("")));
			Log.info("");
		}
		if (subElement.equals("")) {
			action.moveToElement(driver.findElement(By.linkText("")));
			Log.info("");
		}
		if (subElement.equals("")) {
			action.moveToElement(driver.findElement(By.linkText("")));
			Log.info("");
		}
		if (subElement.equals("")) {
			action.moveToElement(driver.findElement(By.linkText("")));
			Log.info("");
		}
		action.click();
		action.perform();
		Log.info("Click action is performede");
	}

	// to switch browser windows - to be implemented
	public static boolean switchWindow(String title) {
		Log.info("Switching browser");
		String currentWindow = driver.getWindowHandle();
		Set<String> availableWindows = driver.getWindowHandles();
		Iterator<String> it = availableWindows.iterator();
		currentWindow = it.next();
		String nextWindow = it.next();
		String b = driver.switchTo().window(nextWindow).getTitle().trim();
		if (b.equals(title)) {
			((JavascriptExecutor) Utils.driver).executeScript("window.focus();");

			return true;
		} else
			driver.switchTo().window(currentWindow);

		return false;
	}

}
