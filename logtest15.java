package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTest {
WebDriver driver;
@BeforeMethod
public void setup() {
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.saucedemo.com/");
}
@Test
public void verifyLogin() {
LoginPage loginPage = new LoginPage(driver);
loginPage.login("standard_user", "secret_sauce");
Assert.assertTrue(
driver.getCurrentUrl().contains("inventory"),
"Login Failed"
);
System.out.println("Login Successful");
}
@AfterMethod
public void closeBrowser() {
driver.quit();
}
}
