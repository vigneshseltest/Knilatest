package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebDriverFactory.DriverInitialization;

public class PatientDetailsPage extends DriverInitialization {
	public PatientDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

///////////////////WEBELEMENTS//////////////////////////////////
	@FindBy(how = How.XPATH, using = "//div[normalize-space(text())='Start Visit']")
	WebElement startVisit;
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'patient1 family1 now?')]//following-sibling::button[@class='confirm right']")
	WebElement confirmVisit;
	
	
	public void clickAndVerifyVisit() throws InterruptedException {
		
		Thread.sleep(5000);;
		startVisit.click();
		confirmVisit.click();
	}
	

}