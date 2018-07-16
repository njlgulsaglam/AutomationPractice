package automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPractice {
	WebDriver driver;
	String baseUrl;

///navigate the url
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		baseUrl ="http://automationpractice.com/index.php";
		driver.get(baseUrl);
	}
	
	///verify title
	@Test(priority =1)
	public void test1() throws InterruptedException {
		String actualTitle = driver.getTitle();
		String expectedTitle = "My Store" ;
		
		Thread.sleep(2000);
		Assert.assertEquals(actualTitle,  expectedTitle);
			System.out.println("Loaded Page Successfully ");
			
		}
	
	
	@Test(priority = 2)
	public void testContactUs() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Contact Us']"));
		
		Thread.sleep(2000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "My Store" ;
		
		Thread.sleep(2000);
		Assert.assertEquals(actualTitle,  expectedTitle);
			System.out.println("testContact PASSED! ");
			
		}
	
	///find all of the dresses with prices
	@Test(priority = 3)
	public void testFindDress() throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='search_query form-control ac_input']")).sendKeys("dress");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		
		Thread.sleep(2000);
		List<WebElement> descriptions = driver.findElements(By.xpath("(//img[@class='replace-2x img-responsive'])[1]"));
     	for (WebElement item : descriptions) {
			System.out.println(item.getText());
		}
		
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='price product-price']"));
		for (WebElement price : prices) {
			System.out.println(price.getText());
		}
		
		
	}
	
	/////Homework part verify login button
	
	@Test(priority = 4)
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(2000);
	    driver.findElement(By.cssSelector("#email")).sendKeys("waya@IOreak.net");
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("#passwd")).sendKeys("password");
	    Thread.sleep(2000);
	    driver.findElement(By.id("authentication")).click();
	}
	
	
	
}
