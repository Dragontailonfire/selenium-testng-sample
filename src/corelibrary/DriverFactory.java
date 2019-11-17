package corelibrary;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * 
 * @author NVK
 *
 */
public class DriverFactory {
	private WebDriver webDriver;
	private String supportedBrowsers = "Chrome, IE, Firefox";
	private String browserName;
	
	
	
	private WebDriver launchDriver() {
		System.out.println("Inside DriverFactory.launchDriver");
		switch (getBrowserName()) {

		case "Chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/supportfiles/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			webDriver = new ChromeDriver(options);
			System.out.println("Chromedriver initiated");
			break;

		case "IE":
			break;

		case "Firefox":
			break;
		}

		return webDriver;
	}

	/**
	 * This method returns an instance of currently configured Webdriver.
	 * @return 
	 */
	public WebDriver getDriver() {
		System.out.println("Inside DriverFactory.getDriver");
		if (webDriver == null) {
			webDriver = launchDriver();
		}
		return webDriver;
	}

	public String getBrowserName() {
		if(browserName == null || browserName.trim().length() == 0){
			browserName = TestSettings.getTestSetting("Browser");
		}
		return browserName;
	}

	public void setBrowserName(String name) {
		if(supportedBrowsers.indexOf(name) < 0){
			throw new NotImplementedException("This browser is not supported currently. (Support available only for " + supportedBrowsers);
		}
		if(this.browserName == null || !this.browserName.equals(name)){
			this.browserName = name;
			//TODO check and close current webDriver
			webDriver = null;
		}
		
	}

}
