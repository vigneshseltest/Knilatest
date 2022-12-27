package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import WebDriverFactory.DriverInitialization;

public class RegisterAPatientPage extends DriverInitialization {
	public RegisterAPatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

///////////////////WEBELEMENTS//////////////////////////////////
	@FindBy(how = How.NAME, using = "givenName")
	WebElement edtBoxGiven;

	@FindBy(how = How.XPATH, using = " //*[text()=' Attachments']")
	WebElement attachments;

	@FindBy(how = How.NAME, using = "familyName")
	WebElement edtBoxFamilyName;

	@FindBy(how = How.XPATH, using = "//icon[@class='fas fa-chevron-right']")
	WebElement iconNext;

	@FindBy(how = How.ID, using = "gender-field")
	WebElement drpDwnGender;

	@FindBy(how = How.ID, using = "birthdateMonth-field")
	WebElement drpBirthMonth;

	@FindBy(how = How.ID, using = "birthdateDay-field")
	WebElement edtBoxBirthDay;

	@FindBy(how = How.ID, using = "birthdateYear-field")
	WebElement edtBoxBirthYear;

	@FindBy(how = How.ID, using = "address1")
	WebElement edtBoxAdress;

	@FindBy(how = How.NAME, using = "phoneNumber")
	WebElement edtBoxPhoneNo;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Person Name']")
	WebElement edtBoxRelativeName;

	@FindBy(how = How.ID, using = "submit")
	WebElement btnSubmit;

	@FindBy(how = How.XPATH, using = "//span[text()='Name']")
	WebElement NameField;

	@FindBy(how = How.XPATH, using = "//div[@id='dataCanvas']//p[1]")
	WebElement NameVerify;

	@FindBy(how = How.XPATH, using = "//div[normalize-space(text())='Start Visit']")
	WebElement startVisit;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'patient1 family1 now?')]//following-sibling::button[@class='confirm right']")
	WebElement confirmVisit;

	@FindBy(how = How.XPATH, using = "//div[text()='Click or drop a file here.']")
	WebElement dropFile;

/////////////////REUSABLE METHODS/////////////////////////////////////

	/**
	 * @author vignesh
	 * @param givenName
	 * @summary Enter Given Name
	 */
	private void EnterGivenName(String givenName) {
		edtBoxGiven.sendKeys(givenName);
	}

	/**
	 * @author vignesh
	 * @param familyName
	 * @summary Enter family Name
	 */
	private void EnterFamilyName(String familyName) {
		edtBoxFamilyName.sendKeys(familyName);
	}

	public void enterPatientName(String givenName, String familyName) {
		EnterGivenName(givenName);
		EnterFamilyName(familyName);
		clickNextIcon();
	}

	/**
	 * @author vignesh
	 * @summary click Next Icon
	 */
	private void clickNextIcon() {
		iconNext.click();
	}

	/**
	 * @author vignesh
	 * @param gender
	 * @summary select Gender
	 */
	public void selectGender(String gender) {
		Select select = new Select(drpDwnGender);
		select.selectByVisibleText(gender);
		iconNext.click();
	}

	/**
	 * @author vignesh
	 * @param birthDay
	 * @throws InterruptedException
	 * @summary enter Birth Day
	 */
	private void enterBirthDay(String birthDay) {

		edtBoxBirthDay.sendKeys(birthDay);
	}

	/**
	 * @author vignesh
	 * @param birthMonth
	 * @summary select Birth Month
	 */
	private void selectBirthMonth(String birthMonth) {
		Select select = new Select(drpBirthMonth);
		select.selectByVisibleText(birthMonth);
	}

	/**
	 * @author vignesh
	 * @param birthYear
	 * @summary entry Birth Year
	 */
	private void entryBirthYear(String birthYear) {
		edtBoxBirthYear.sendKeys(birthYear);
	}

	/**
	 * @author vignesh
	 * @param birthDay
	 * @param birthMonth
	 * @param birthYear
	 * @throws InterruptedException
	 * @summary fill D O B
	 */
	public void fillDOB(String birthDay, String birthMonth, String birthYear) {

		enterBirthDay(birthDay);
		selectBirthMonth(birthMonth);
		entryBirthYear(birthYear);
		clickNextIcon();
	}

	/**
	 * @author vignesh
	 * @param adress
	 * @summary enter Adress
	 */
	public void enterAdress(String adress) {
		edtBoxAdress.sendKeys(adress);
		clickNextIcon();
	}

	/**
	 * @author vignesh
	 * @param phoneNo
	 * @summary entryPhone Number
	 */
	public void entryPhoneNumber(String phoneNo) {
		edtBoxPhoneNo.sendKeys(phoneNo);
		clickNextIcon();
	}

	/**
	 * @author vignesh
	 * @param relativeName
	 * @summary entry Relative Name
	 */
	public void entryRelativeName(String relativeName) {
		edtBoxRelativeName.sendKeys(relativeName);
		clickNextIcon();
	}

	/**
	 * @author vignesh
	 * @summary click Submit Button
	 */
	public void clickSubmitButton() {
		btnSubmit.click();
	}

	public void VerifyDetails() throws InterruptedException {

		// NameField.click();
		Thread.sleep(5000);
		String Name = NameVerify.getText();

		Assert.assertEquals(Name, "Name: patient1, family1");
	}

	public void clickAndVerifyVisit() throws InterruptedException {

		Thread.sleep(5000);
		startVisit.click();
		confirmVisit.click();
	}

	public void attachmentsTask() throws AWTException, InterruptedException {
		Thread.sleep(5000);

		attachments.click();
		Thread.sleep(5000);
		dropFile.click();
		Robot rb = new Robot();

		// copying File path to Clipboard
		StringSelection str = new StringSelection("C:\\Users\\Dell\\Desktop\\111.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter a caption']")).sendKeys("heelo");
		driver.findElement(By.xpath("//button[text()='Upload file']")).click();
		driver.findElement(By.xpath("//a[normalize-space(text())='patient1 family1']")).click();
		Thread.sleep(3000);
		/*
		 * driver.findElement(By.xpath("(//p[@class='ng-binding'])[3]")).isDisplayed();
		 * Thread.sleep(3000);
		 */
		driver.findElement(By.xpath("//div[normalize-space(text())='End Visit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class='confirm right' and text()='Yes'])[2]")).click();
	}
}
