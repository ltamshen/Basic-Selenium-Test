package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {
	protected WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using = "form-username")
	private WebElement userNameField;
	
	@FindBy(how = How.NAME, using = "form-password")
	private WebElement passwordField;
	
	@FindBy(how=How.ID, using = "btnLogin")
	private WebElement loginButton;
	
	public DashboardPage login(String username, String password){
		userNameField.clear();
		userNameField.sendKeys(username);
		passwordField.clear();
		passwordField.sendKeys(password);
		loginButton.click();
		return new DashboardPage(driver);
		
	}
}
