package Scripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ScriptCodes
{    
    public static void main(String[] args)
    {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try
        {
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com/");
            
            //First it'll check user is already present or not. if not it'll register the user.
            driver.findElement(By.partialLinkText("Signup / Log")).click();
            driver.findElement(By.xpath("//input[@placeholder=\"Email Address\"]")).sendKeys("TestUser33@gmail.com");
            driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("TestUser33");
            driver.findElement(By.xpath("//button[@type='submit' and @data-qa='login-button']")).click();
            driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("TestUser33");
            driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("TestUser33@gmail.com");
            driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
            
            
            //Registration Process-Account Information
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1"))).click();
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("TestUser33");
            driver.findElement(By.xpath("//select[@id='days']")).sendKeys("10");
            driver.findElement(By.xpath("//select[@id='months']")).sendKeys("April");
            driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1996");
            
            
            //Registration Process-Address Information
            driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("TestUser33");
            driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("TestUser33");
            driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Kharadi");
            driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Maharashtra");
            driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Pune");
            driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("411036");
            driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("1234567890");
            driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]")).isEnabled();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]"))).click();
            
            
            //After successful creation, click on continue then logout.
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-qa='create-account']")));
            Assert.assertTrue(driver.getPageSource().contains("Account Created!"), "User registration failed.");
            driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
            driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
            
            
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
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        finally
        {
        	driver.quit();
        }
     }
}