package corelibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestInitializer {
	private WebDriver driver;

	protected TestInitializer() {
		// TODO Auto-generated constructor stub
	}

	@BeforeSuite
	public void initiate(){
		System.out.println("Initiate framework");
		driver =  new DriverFactory().getDriver();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@AfterSuite
	public void wrapUp(){
		driver.quit();
	}  

	public WebDriver getDriverInstance(){
		return driver;
	}
}
