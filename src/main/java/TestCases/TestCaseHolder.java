package TestCases;


import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import DataProvider.DataProviderforAllTests;
import PageActions.DemoPageActions;
import PageActions.HomePageActions;
import PageActions.PropertyManagerSignInActions;
import Utility.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseHolder extends BaseTest {
		
	 @Test(description = "verify login for Property Manager", dataProviderClass =DataProviderforAllTests.class ,dataProvider = "loginDataForPropertyManager" )
	 public void  PropertyManagerSignIn(String uname, String password) throws InterruptedException {
	
		 HomePageActions homePageActions= new HomePageActions(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		 
		  JSClick(homePageActions.signInButtonHomePage);
          
		 homePageActions.clickpropertyManagerLoginButtonPageRedirection();
		 Thread.sleep(2000);
		 String actualURL = driver.getCurrentUrl();
		 String actualTitle = driver.getTitle();
		// Property Manager SignIn code
		 Assert.assertEquals(actualURL,"https://sso.entrata.com/entrata/login");
		 Assert.assertEquals(actualTitle, "Sso Login");
		 PropertyManagerSignInActions propertyManagerSignInActions = new PropertyManagerSignInActions(driver);
		 propertyManagerSignInActions.enterPropertyManagerUsername(uname);
		 propertyManagerSignInActions.enterPropertyManagerPassword(password);
		 propertyManagerSignInActions.clickPropertyManagerSignInButton();
 
	 }
	 
	 @Test(description = "verify request demo form submission",dataProviderClass =DataProviderforAllTests.class ,dataProvider = "DataforDemoform" )
	 public void ScheduleDemo(String fname,String lname,String email,String company,String phone,String unitcount,String title,String demotype) throws InterruptedException {
		 HomePageActions homePageActions= new HomePageActions(driver);
		 DemoPageActions demoPageActions = new DemoPageActions(driver);
	
		 JSClick(homePageActions.scheduleDemoButtonHomePageButton);
		 System.out.println("schedule your demo clicked");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 // Demo form submission
		 Set<String> windows =driver.getWindowHandles();
		 int size=windows.size();
		 if(size==2) {
			  for (String element : windows) {
		            if(driver.switchTo().window(element).getCurrentUrl().equalsIgnoreCase(
		            		"https://go.entrata.com/schedule-demo.html")){
		            	driver.switchTo().window(element);
		            	break;
		            		}
		        }
		 }
		 Thread.sleep(10000);
		 String actualURL = driver.getCurrentUrl();
		 // enter form data
		 Assert.assertEquals(actualURL,"https://go.entrata.com/schedule-demo.html");
		 demoPageActions.setFirstName(fname);
		 demoPageActions.setLastName(lname);
		 demoPageActions.setEmail(email);
		 demoPageActions.setCompany(company);
		 demoPageActions.setPhone(phone);
		 demoPageActions.selectUnitCount(unitcount);
		 demoPageActions.setTitle(title);
		 demoPageActions.selectDemoRequestType(demotype);
		 System.out.println("demo form data submitted - it is just a print statement");
	
	 }
	 @Test(description = "verify navigation individual product page on the basis of user input",dataProviderClass =DataProviderforAllTests.class ,dataProvider = "DataforSubProducts")
	 public void NavigatingToProductsPageAndVerifyOnBasisOfUserInput(String subproduct) throws InterruptedException {
		 HomePageActions homePageActions= new HomePageActions(driver);
		
		 homePageActions.moveToProductDropdown();

		 Thread.sleep(2000);
		   List<WebElement> subProductList = homePageActions.subProductListInProduct;
		   System.out.println(subProductList.size());
		   String text="";
		   // will open page on basis of user input 
		 for(WebElement ss: subProductList) {
			if(subproduct.equalsIgnoreCase(ss.getText())) {
				text=ss.getText();
				ss.click();
				break;
			}
		 }
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  WebElement we= driver.findElement(By.xpath("//h1[contains(text(),'" + text + "')]"));
       if(we.isDisplayed()) {
    	   System.out.println("we are at :"+ text);
       }
       else {
    	   Assert.fail();
       }
       

	 }
	 
	 @Test(description = " verify navigation individual solution page on the basis of user input" ,dataProviderClass =DataProviderforAllTests.class ,dataProvider = "DataforSubSolutions")
	 public void NavigatingToSolutionsPageAndVerifyOnBasisOfUserInput(String subsolutions) throws InterruptedException {
		 HomePageActions homePageActions= new HomePageActions(driver);
	
		 homePageActions.moveTosolutionsDropdown();
		 Thread.sleep(2000);
		   List<WebElement> subSolutionList = homePageActions.subSolutionsListInProduct;
		 //   will open page on basis of user input 
		   String text="";
		 for(WebElement ss: subSolutionList) {
			if(subsolutions.equalsIgnoreCase(ss.getText())) {
				text=ss.getText();
				ss.click();
				break;
			}
		 }
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  WebElement we= driver.findElement(By.xpath("//h1[contains(text(),'" + text + "')]"));
       if(we.isDisplayed()) {
    	   System.out.println("we are at :"+ text +" Page");
       }
       else {
    	   Assert.fail();
       }   

	 }

	 }
		


