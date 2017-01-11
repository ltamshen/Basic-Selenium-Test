package testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import testbase.*;

public class AddEmployee {

public class AddEmployeeTest extends testbase {

	@Test
	public void AddNoDiscount(){
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboardPage = loginPage.login("testUser","Test1234");
		dashboardPage.AddEmployee();
		Assert.assertTrue(dashboardPage.CheckFieldValues(), "Error found in dashboard data after adding employee without discount");
	}
			

}
}