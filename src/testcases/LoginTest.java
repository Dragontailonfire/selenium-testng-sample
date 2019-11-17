package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import businesscomponents.LoginPage;
import corelibrary.TestInitializer;


public class LoginTest extends TestInitializer{
	LoginPage loginPage;
	
	public LoginTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
  @Test
  public void login() {
	  loginPage.launchAut();
	  loginPage.logInToAut();
	  /*loginPage.navigateToMaintenance();
	  loginPage.rebootModem();*/
  }
  
  @BeforeClass
  public void startLogin(){
	  System.out.println("Before LoginTest");
	  loginPage = new LoginPage(this);

  }

}
