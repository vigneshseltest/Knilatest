package TestScripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PatientDetailsPage;
import Pages.RegisterAPatientPage;
import WebDriverFactory.DriverInitialization;

public class loginScripts extends DriverInitialization {

	HomePage homePage;
	LoginPage loginPage;
	RegisterAPatientPage registerAPatientPage;
	PatientDetailsPage patientPage;
	

	@Test
	public void Login() throws IOException, InterruptedException {
		driver = driverInitialization();
		driver.get("https://qa-refapp.openmrs.org/openmrs/login.htm");
		loginPage = new LoginPage(driver);
		loginPage.enterUserName("admin");
		loginPage.enterPassword("Admin123");
		loginPage.clickLocationIsolationWard();
		homePage = loginPage.clickLogin();

	}

	@Test
	public void registerPatient() {

		registerAPatientPage = homePage.clickRegisterAPatient();
		registerAPatientPage.enterPatientName("patient1", "family1");
		registerAPatientPage.selectGender("Male");
		registerAPatientPage.fillDOB("1", "January", "1997");
		registerAPatientPage.enterAdress("adress1");
		registerAPatientPage.entryPhoneNumber("123445");
		registerAPatientPage.entryRelativeName("relative1");

	}

	@Test
	public void verifyPage() throws InterruptedException {

		registerAPatientPage.VerifyDetails();
		registerAPatientPage.clickSubmitButton();

	}
	
	@Test
	public void visitConfirm() throws InterruptedException, AWTException {
		
		registerAPatientPage.clickAndVerifyVisit();
		registerAPatientPage.attachmentsTask();
		
	}

}
