package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebDriverFactory.DriverInitialization;

public class LoginPage extends DriverInitialization {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	///////////////////WEBELEMENTS//////////////////////////////////
	@FindBy(how=How.ID , using="username")
	WebElement fldUserName;
	
	@FindBy(how=How.ID , using="password")
	WebElement fldPassword;
	
	@FindBy(how=How.ID , using="loginButton")
	WebElement btnLogin;
	
	@FindBy(how=How.XPATH , using="//li[text()='Isolation Ward']")
	WebElement btnLocationIsolationWard;
	
	/////////////////REUSABLE METHODS/////////////////////////////////////
	
	/**
	 * @author vignesh
	 * @param userName
	 * @summary enter User Name
	 */
	public void enterUserName(String userName) {
		fldUserName.sendKeys(userName);
	}
	
	/**
	 * @author vignesh
	 * @param password
	 */
	public void enterPassword(String password) {
		fldPassword.sendKeys(password);
	}
	
	/**
	 * @author vignesh
	 * @return Home Page
	 * @summary click Login
	 */
	public HomePage clickLogin() {
		btnLogin.click();
		return new HomePage(driver);
	}
	
	/**
	 * @author vignesh
	 * @summary click Location Isolation Ward
	 */
	public void clickLocationIsolationWard() {
		btnLocationIsolationWard.click();
	}
	
	
}
