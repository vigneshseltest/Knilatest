package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import WebDriverFactory.DriverInitialization;

public class HomePage extends DriverInitialization {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
///////////////////WEBELEMENTS//////////////////////////////////
@FindBy(how=How.XPATH , using="(//div[@id='apps']//a/i)[3] ")
WebElement btnRegisterAPatient;

/////////////////REUSABLE METHODS/////////////////////////////////////

/**
* @author vignesh
 * @return Register A Patient Page
* @summary click Register A Patient
*/
public RegisterAPatientPage clickRegisterAPatient() {
	btnRegisterAPatient.click();
	return new RegisterAPatientPage(driver);
}
}
