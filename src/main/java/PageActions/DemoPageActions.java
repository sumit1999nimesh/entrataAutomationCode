package PageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DemoPageActions {
    WebDriver driver;
	
	   public DemoPageActions(WebDriver driver) {
	        this.driver =driver;
	        PageFactory.initElements(driver, this);
	    }
	   @FindBy(id = "FirstName")
		private WebElement fNameField;
	   
	   @FindBy(id = "LastName")
		private WebElement lNameField;
	   

	   @FindBy(id = "Email")
		private WebElement emailField;
	   
	   @FindBy(id = "Company")
		private WebElement companyField;
	   
	   @FindBy(id = "Phone")
		private WebElement phoneField;
	   
	   @FindBy(id = "Unit_Count__c")
		private WebElement unitCountDropdown;
	   
	   @FindBy(id = "Title")
		private WebElement titleField;
	   
	   
	   @FindBy(id = "demoRequest")
		private WebElement demoRequestTypeDropdown;
	   
	   @FindBy(xpath = "//button[text()='SCHEDULE DEMO']")
		private WebElement demoDetailsSubmitButton;
	   
	   //action method to set first name
	   public void setFirstName(String firstName) {
	        fNameField.sendKeys(firstName);
	        System.out.println("first name entered : " + firstName);
	    }

	   //action method to set last name
	    public void setLastName(String lastName) {
	        lNameField.sendKeys(lastName);
	        System.out.println("last name entered : " + lastName);
	    }

	    //action method to set Email
	    public void setEmail(String email) {
	        emailField.sendKeys(email);
	        System.out.println("email  entered : " + email);
	    }

	    //action method to set company name
	    public void setCompany(String company) {
	        companyField.sendKeys(company);
	        System.out.println("company entered : " + company);
	    }

	    //action method to set phone number
	    public void setPhone(String phone) {
	        phoneField.sendKeys(phone);
	        System.out.println("phone entered : " + phone);
	    }

	    //action method to select value from unit count dropdown 
	    public void selectUnitCount(String unitCount) {
	        Select select = new Select(unitCountDropdown);
	        select.selectByVisibleText(unitCount);
	        System.out.println("unitCount selected : " + unitCount);
	    }

	    //action method to set title
	    public void setTitle(String title) {
	        titleField.sendKeys(title);
	        System.out.println("title entered : " + title);
	    }

	  //action method to select value from unit demo type dropdown 
	    public void selectDemoRequestType(String demoRequestType) {
	        Select select = new Select(demoRequestTypeDropdown);
	        select.selectByVisibleText(demoRequestType);
	        System.out.println("demoRequestType selected : " + demoRequestType);
	    }

	    //action method to sumbit form 
	    public void clickScheduleDemoButton() {
	        demoDetailsSubmitButton.click();
	        System.out.println("request demo form submitted");
	    }


	}
	