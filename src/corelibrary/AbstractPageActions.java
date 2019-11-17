package corelibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class AbstractPageActions{
	WebDriver driver;
	WebDriverWait wait;
	
	public AbstractPageActions() {
		driver = new TestInitializer().getDriverInstance();	
		wait = new WebDriverWait(driver, 40);
	}
	
	public void clickElement(By element){
		try {
			WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			webElement.click();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertFalse(true, e.getMessage());
		}		
	}
	
	public void enterTextInElement(By element, String text){
		WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		webElement.sendKeys(text);	
	}
	
	public void hitUrl(String url){
		driver.get(url);
	}

}
