package PageActions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageActions {
     WebDriver driver;
	
	   public HomePageActions(WebDriver driver) {
	        this.driver =driver;
	        PageFactory.initElements(driver, this);
	    }

	   
	@FindBy(xpath = "//a[text()='Sign In']")
	 public  WebElement signInButtonHomePage;
 
	 @FindBy(id = "cookie-accept")
	 private WebElement cookieAcceptButton;
	
	 @FindBy(xpath = "//div[text()='Schedule Your Demo']")
	 public WebElement scheduleDemoButtonHomePageButton;
		
	 @FindBy(id = "w-dropdown-toggle-0")
	 private WebElement productDropdown;
	
	 
		
	 @FindBy(id = "w-dropdown-toggle-5")
	 private WebElement solutionsDropdown;
	
		
	 @FindBy(xpath = "//div[@class='mega-nav']/div//descendant::a | //div[@class='mega-nav desktop']/div//descendant::a")
	 public List<WebElement> subProductListInProduct;
	
	
	
	 
	 @FindBy(xpath = "//div[@class='drowpdown-wrapper']//descendant::a")
	 public List<WebElement> subSolutionsListInProduct;
	
	@FindBy(xpath = "//a[@class='button hover_black new-button w-inline-block']")
	 private WebElement propertyManagerLoginButtonPageRedirection;

	  public void clickSignInButtonHomePage() {
	        signInButtonHomePage.click();
	        System.out.println("sign in button clicked on homepage");
	    }
	    public void clickcookieAcceptButton() {
	    	cookieAcceptButton.click();
	    }
	    
	    public void clickscheduleDemoButton() {
	    	scheduleDemoButtonHomePageButton.click();
	    	  System.out.println("Schedule Your Demo Button clicked on home page");
		    }
	    
	    public void moveToProductDropdown() {
	    	Actions action= new Actions(driver);
	    	action.moveToElement(productDropdown).perform();
	    	  System.out.println("move to product dropdown home page");
		    }
	    
	    public void moveTosolutionsDropdown() {
	    	Actions action= new Actions(driver);
	    	action.moveToElement(solutionsDropdown).perform();
	    	System.out.println("move to solutions dropdown home page");
		    }
	    
      public void clickpropertyManagerLoginButtonPageRedirection() {
    	  propertyManagerLoginButtonPageRedirection.click();
    	  System.out.println("propertyManager LoginButton clicked and redirected to sign in page");
	    }

	

}
