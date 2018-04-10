package amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Plasticcase {
	private WebDriver driver;
	String plasticCase = "//*[@id=\"leftNavContainer\"]/ul[9]/div/li[1]/span/span/div/label/input";
	//Actions actions = new Actions(driver);
	@BeforeTest
	public void OpeningBrowser(){
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
	}
	
	@Test
	
	public void ActualTest() throws InterruptedException {
		//Search for "ipad air 2 case"
		driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("ipad air 2 case");
		driver.findElement(By.className("nav-input")).click();
		//Selecting only Plastic cases
		WebElement checkBox = driver.findElement(By.xpath(plasticCase));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);
		driver.findElement(By.xpath(plasticCase)).click();
		//Setting price parameters
		WebElement priceField = driver.findElement(By.xpath("//input[@id = 'low-price']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", priceField);
		
		WebElement lowPrice = driver.findElement(By.id("low-price"));
		Actions actions = new Actions(driver);
		actions.moveToElement(lowPrice);
		actions.perform();
		Thread.sleep(5000L);
		
		driver.findElement(By.id("low-price")).sendKeys("20");
		driver.findElement(By.id("high-price")).sendKeys("100");
		driver.findElement(By.className("a-button-input")).click();
		
		WebElement result = driver.findElement(By.id("result_0"));
		//Actions actions = new Actions(driver);
		actions.moveToElement(result);
		actions.perform();
		//Name and price of the first result
		System.out.println("The first result:");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"result_0\"]/div/div[3]/div[1]/a/h2")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"result_0\"]/div/div[4]/div[1]/a/span[2]/span")).getText());
		//Name and price of the second result
		System.out.println("The second result:");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"result_1\"]/div/div[3]/div[1]/a/h2")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"result_1\"]/div/div[4]/div[1]/a/span[2]/span")).getText());
		//Name and price of the third result
		System.out.println("The third result:");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"result_2\"]/div/div[3]/div[1]/a/h2")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"result_2\"]/div/div[4]/div[1]/a/span[2]/span")).getText());
		//Name and price of the fourth result
		System.out.println("The fourth result:");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"result_3\"]/div/div[3]/div[1]/a/h2")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"result_3\"]/div/div[4]/div[1]/a/span[2]/span")).getText());
		//Name and price of the fifth result
		System.out.println("The fifth result:");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"result_4\"]/div/div[3]/div[1]/a/h2")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"result_4\"]/div/div[4]/div[1]/a/span[2]/span")).getText());
		
			}
	
	
	@AfterTest
	public void ClosingBrowser() {
		driver.quit();
	}
	
	
}
