package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	 public WebDriver driver;
	   // will run before each test to setup driver 
	   @BeforeMethod
	    public void setUp() {
	    	WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    System.out.println("Driver is Created");
		    driver.get("https://www.entrata.com/");  
		    System.out.println("Home page is loaded");
		    driver.manage().window().maximize();
		    try {
	             // handling cookies model
		     WebElement acceptCookie=  driver.findElement(By.id("cookie-accept"));
		     acceptCookie.click();
				 System.out.println("cookie model is displayed");
			 }
			 catch (Exception e) {
			     System.out.println("cookie model is not displayed");
			 }
		  	
	    }
	   
	   // will run after each test to close driver instances 
	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	    
	   public void JSClick(WebElement webElement) {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", webElement);


	   }
	}

