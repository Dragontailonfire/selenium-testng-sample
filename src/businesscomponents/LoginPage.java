package businesscomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import corelibrary.TestInitializer;
import corelibrary.TestSettings;
import corelibrary.AbstractPageActions;

public class LoginPage extends AbstractPageActions {
	TestInitializer init;
	public LoginPage(TestInitializer init){
		super();
		this.init = init;

	}
	
	public void launchAut(){
		hitUrl(TestSettings.getTestSetting("AutUrl"));
	}

	public void logInToAut(){
		
		/*enterTextInElement(By.id("ismjs-username"), "n_vk46@yahoo.com");
		enterTextInElement(By.id("ismjs-password"), "retrogressive");
		clickElement(By.xpath(".//*[@id='ismr-main']/div[1]/form/div[3]/div/button"));*/
		
		enterTextInElement(By.id("password"), "3.ka.kara");
		clickElement(By.id("loginBtn"));
		/*JavascriptExecutor jsExecutor = (JavascriptExecutor) init.getDriverInstance();
		jsExecutor.executeScript("do javascript stuff here!");*/
	}
	
	public void navigateToMaintenance(){
		clickElement(By.linkText("Maintenance"));
	}
	
	public void rebootModem(){
		clickElement(By.name("reboot"));
	}
}
