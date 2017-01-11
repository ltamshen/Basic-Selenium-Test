package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
protected WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 20), this);
	}
	@FindBy(how= How.ID, using = "btnAddEmployee")
	private WebElement addEmployeeButton;
	
	@FindBy(how=How.XPATH, using = "//*[@id='employee-table']/tbody/tr[2]/td[2]")
	private WebElement dashboardLastName;

	@FindBy(how=How.XPATH, using = "//*[@id='employee-table']/tbody/tr[2]/td[3]")
	private WebElement dashboardFirstName;
	
	@FindBy(how=How.XPATH, using = "//*[@id='employee-table']/tbody/tr[2]/td[4]")
	private WebElement dashboardSalary; 
	
	@FindBy(how=How.XPATH, using = "//*[@id='employee-table']/tbody/tr[2]/td[5]")
	private WebElement dashboardDependents;
	
	@FindBy(how=How.XPATH, using = "//*[@id='employee-table']/tbody/tr[2]/td[6]")
	private WebElement dashboardGrossPay;
	
	@FindBy(how=How.XPATH, using = "//*[@id='employee-table']/tbody/tr[2]/td[7]")
	private WebElement dashboardBenefitCost;
	
	@FindBy(how=How.XPATH, using = "//*[@id='employee-table']/tbody/tr[2]/td[8]")
	private WebElement dashboardNetPay;
	
	public void AddEmployee(){
		addEmployeeButton.click();
		try {
			Helper.waitForPage();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String dashboardWindowHandler = driver.getWindowHandle(); 
		String addForm = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    addForm = iterator.next();
		}
		driver.switchTo().window(addForm); // switch to addForm
		AddFormPage addFormPage = new AddFormPage(driver);
		addFormPage.addEmployeeInfo();
		driver.switchTo().window(dashboardWindowHandler);  // switch back to dashboard
	}
	public boolean CheckFieldValues(){
		//  lastname, firstname, salary, dependents, gross pay, benefit cost, net pay 
		return (dashboardLastName.equals(Constants.lastName)&&
				dashboardFirstName.equals(Constants.firstName)&&
				dashboardSalary.equals(Constants.salary) &&
				dashboardDependents.equals(Constants.dependents) &&
				dashboardGrossPay.equals(Constants.grossPay) &&
				dashboardBenefitCost.equals(Constants.benefitCostEmployeeNoDiscount)&&
				dashboardNetPay.equals(Constants.netPayEmployeeNoDiscount));
	}
}
