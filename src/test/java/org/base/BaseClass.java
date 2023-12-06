package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	private static final String string = null;
	
	public static WebDriver driver;
	
	public static void getBrowser(String browser) {
		try {
			
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
			else if (browser.equalsIgnoreCase("internetexplorer")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			
			else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			
			else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			
		} catch (Exception e) {
			
			System.out.println("Invalid Browser");
			
		}
		
	}
	
	public static void getUrl(String url) {
		
		driver.get(url);

	}
	
	public static void getCurrentUrl() {
		
		driver.getCurrentUrl();

	}
	
	public static void getTitle() {
		
		driver.getTitle();

	}
	
	public static void maximize() {
		
		driver.manage().window().maximize();

	}
	
	public static void nextUrl(String url) {
		
		driver.navigate().to(url);

	}
	
	public static void nextPage() {
		
		driver.navigate().forward();
		
	}
	
	public static void previousPage() {
		
		driver.navigate().back();

	}
	
	public static void pageRefresh() {
		
		driver.navigate().refresh();

	}
	
	public static void SessionClose() {
		
		driver.close();

	}
	
	public static void terminate() {
		
		driver.quit();

	}
	
	public static void inputValue(WebElement element , String input) {
		
		element.sendKeys(input);
		
	}
	
	public static void clickon(WebElement element) {
		
		element.click();

	}
	
	public static void checkboxClick(WebElement element) {
		
	element.click();
	
	}
	
	public static void notifyAlert() {
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public static void confirmAlert() {
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void promptAlert() {
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public static void actionClick(WebElement element) {
		
		Actions ac = new Actions(driver);
		ac.click(element).build().perform();		
		
	}
	
	public static void actionDoubleclick(WebElement element) {
		
		Actions ac = new Actions(driver);
		ac.doubleClick(element).build().perform();		
		
	}
	
	public static void actionrightclick(WebElement element) {
		
		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();		
		
	}
	
	public static void actionMoveto(WebElement element) {
		
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();		
		
	}
	
	public static void actionDrag(WebElement src , WebElement dest) {
		
		Actions ac = new Actions(driver);
		ac.dragAndDrop(src,dest).build().perform();		
		
	}

	public static void robot() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

	}

	public static void robot1() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void parentWindow(WebElement frame) {

		frame.click();
		driver.switchTo().frame(0);

	}
	
	public static void defaultFrame(WebElement frame) {

		frame.click();
		driver.switchTo().defaultContent();

	}
	
	public static void elementVisible(WebElement element) {

		element.isDisplayed();

	}

	public static void elementSelect(WebElement element) {

		element.isSelected();

	}

	public static void elementView(WebElement element) {

		element.isEnabled();

	}
	
	public static void manageWindow() {

		driver.getWindowHandle();

	}

	public static void manageWindows() {

		driver.getWindowHandles();
		
	}
	
	public static void screenshot(String name) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File sourcefile = ts.getScreenshotAs(OutputType.FILE);

		File destfile = new File("C:\\Users\\DELL\\OneDrive\\Pictures\\" + name + ".png");

		Files.copy(sourcefile, destfile);
		
	}
	
	public static void byIndex(WebElement element , int index) {
		
		Select s = new Select(element);
		s.selectByIndex(index);

	}
	
	public static void byValue(WebElement element , String value) {
		
		Select s = new Select(element);
		s.selectByValue(value);

	}
	
	public static void byText(WebElement element , String text) {
		
		Select s = new Select(element);
		s.selectByVisibleText(text);

	}
	
	public static void deByIndex(WebElement element , int index) {
		
		Select s = new Select(element);
		s.deselectByIndex(index);

	}

	public static void deByValue(WebElement element , String value) {
		
		Select s = new Select(element);
		s.deselectByValue(value);

	}
	
	public static void deByText(WebElement element , String text) {
		
		Select s = new Select(element);
		s.deselectByVisibleText(text);

	}
	
	public static void selectfromList(WebElement element) {
		
		Select s = new Select(element);
		
		List<WebElement> options = s.getOptions();
		
		for (WebElement alloptions : options) {
			String text = alloptions.getText();
			System.out.println(text);
		}

	}
	
	public static void selectAll(WebElement element) {
		
		Select s = new Select(element);
		
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		
		for (WebElement alloptions : allSelectedOptions) {
			String text = alloptions.getText();
			System.out.println(text);
		}
		
	}
	
	public static void firstSelect(WebElement element) {
		
		Select s = new Select(element);
		
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println(text);

	}
	
	public static void implicWait() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	}
	
	public static void jsInputValue(WebElement element, String textinput) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value', '" + textinput + "')", element);

		} catch (Exception e) {
			
			System.out.println("Input Not Valid");

		}

	}

	public static void jsClick(WebElement element) {
	
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].click()", element);

	}

	public static void scrollDown() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}
	
	public static void navigatepixels() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public static void scrollUP(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", element);

	}
	
	public static String readexceldata(int rownum, int cellnum) {

		String value = null;
		try {

			File f = new File("C:\\\\Users\\\\DELL\\\\Documents\\\\Excel_Read.xlsx");

			FileInputStream fis = new FileInputStream(f);

			Workbook book = new XSSFWorkbook(fis);

			Sheet sheet = book.getSheet("Sheet1");

			Row row = sheet.getRow(rownum);

			Cell cell = row.getCell(cellnum);

			CellType cellType = cell.getCellType();

			switch (cellType) {

			case STRING:
				value = cell.getStringCellValue();

				break;

			default:

				if (DateUtil.isCellDateFormatted(cell)) {

					java.util.Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
					value = s.format(dateCellValue);

				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					BigDecimal valueOf = BigDecimal.valueOf(l);
					value = valueOf.toString();

				}

				break;
			}

		} catch (Exception e) {

		}
		return value;

	}
}
