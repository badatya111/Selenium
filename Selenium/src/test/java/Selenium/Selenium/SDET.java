package Selenium.Selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SDET {


	static WebDriver driver;
	public static void beforeTest() throws IOException {
		String currentDirectory = System.getProperty("user.dir");
		String chromeDiver;
		System.out.println("Chrome Driver Launch");
		chromeDiver=currentDirectory+"\\Drivers\\chromedriver.exe";
		System.out.println(chromeDiver);
		System.setProperty("webdriver.chrome.driver", chromeDiver);
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void ticketBooking(){
		driver.findElement(By.xpath("//*[@id='fromCity']")).click();

		WebDriverWait wait = new WebDriverWait (driver, 60);
		 String strFrom="Hyderabad, India";
		 String strTo="Chennai, India";
		 
		driver.findElement(By.xpath("//*[@placeholder='From']")).sendKeys(strFrom);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Hyderabad, India')]"))); 
		driver.findElement(By.xpath("(//*[contains(text(),'"+strFrom+"')])[1]")).click();
		System.out.println(strFrom+" : Selected");
		driver.findElement(By.xpath("//*[@placeholder='To']")).sendKeys(strTo);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Chennai, India')])[1]")));
		driver.findElement(By.xpath("(//*[contains(text(),'"+strTo+"')])[1]")).click();
		System.out.println(strTo+" : Selected");
		driver.quit();
	}
	public static void main(String[] args) throws IOException {
		beforeTest();
		ticketBooking();

	}
	//*[@class='react-autosuggest__input react-autosuggest__input--open']
}
