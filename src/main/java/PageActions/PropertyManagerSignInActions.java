package PageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyManagerSignInActions {
	   WebDriver driver;
		
	   public PropertyManagerSignInActions(WebDriver driver) {
	        this.driver =driver;
	        PageFactory.initElements(driver, this);
	    }

	@FindBy(id = "entrata-username")
	 private WebElement propertyManagerUserNameField;
	
	
	@FindBy(id = "entrata-password")
	 private WebElement propertyManagerPasswordField;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	 private WebElement propertyManagerSignInButton;
	
    public void enterPropertyManagerUsername(String username) {
        propertyManagerUserNameField.sendKeys(username);
        System.out.println("Property Manager Username entered : "+username);
    }

    public void enterPropertyManagerPassword(String password) {
        propertyManagerPasswordField.sendKeys(password);
        System.out.println("Property Manager password entered : "+password );
    }

    public void clickPropertyManagerSignInButton() {
        propertyManagerSignInButton.click();
        System.out.println("PropertyManager sign in clicked");
    }
	
}
