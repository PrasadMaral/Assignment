package Scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPart
{	//for my understanding.

	public static void main(String[] args)
	{
		 WebDriver driver = new ChromeDriver();
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	        driver.manage().window().maximize();
	        driver.get("https://automationexercise.com/");
	        
	        //LoginId and Password
	        driver.findElement(By.cssSelector("a[href='/login']")).click();
	        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("TestedUser11110@gmail.com");
	        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("User11110");
	        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Welcome To Your Account']")));
            Assert.assertTrue(driver.getPageSource().contains("Welcome To Your Account"), "Login Failed.");

	        
	        //Searching the Product
            driver.findElement(By.xpath("//a[@href='/products']")).click();
            driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Tshirts");
            driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Search Results']")));
            Assert.assertTrue(driver.getPageSource().contains("Category"), "Product search failed.");
            
            //Choosing the product
            driver.findElement(By.partialLinkText("product_details/30\\")).click();
            driver.findElement(By.cssSelector("button[type='button']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
            driver.navigate().back();
            driver.findElement(By.cssSelector("a[href='/product_details/29']")).click();
            driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys("2");
            driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
            
            //View items in cart
            driver.findElement(By.partialLinkText("Cart")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Proceed to Checkout']")));
            Assert.assertTrue(driver.getPageSource().contains("Product successfully added to your cart"), "Add to cart failed.");


	}

}
