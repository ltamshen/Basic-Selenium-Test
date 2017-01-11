package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class AddFormPage {

	protected WebDriver driver;
	
		public AddFormPage(WebDriver driver){
			this.driver = driver;
			//PageFactory.initElements(driver, this);
			PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 15), this);
		}
		@FindBy(how = How.XPATH, using = "//*[@id='employees-form']/div[1]/div/input")
		private WebElement firstNameField;
		
		@FindBy(how = How.XPATH, using = "//*[@id='employees-form']/div[2]/div/input")
		private WebElement lastNameField;
		
		@FindBy(how=How.XPATH, using = "//*[@id='employees-form']/div[3]/div/input")
		private WebElement dependentsField;
		
		@FindBy(how=How.XPATH, using = "//*[@id='employees-form']/div[4]/div/button[1]")
		private WebElement submitButton;
		
		public void addEmployeeInfo(){
			// data can come from a parm file or spreadsheet, etc. For now it comes from constants.
			firstNameField.clear();
			firstNameField.sendKeys(Constants.firstName);
			lastNameField.clear();
			lastNameField.sendKeys(Constants.lastName);
			dependentsField.clear();
			dependentsField.sendKeys(Constants.dependents);
			submitButton.click();
			
		}
}


