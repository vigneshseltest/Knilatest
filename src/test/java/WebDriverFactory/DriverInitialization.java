package WebDriverFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitialization {
	public static WebDriver driver;
	
	public static WebDriver driverInitialization() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/java/utilities/config.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
		if(browser.toLowerCase().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.toLowerCase().equals("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		
		return driver;
	}
	
	

}
