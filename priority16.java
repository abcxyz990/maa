package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestNGExample {
WebDriver driver;
// Runs before every test method
@BeforeMethod(alwaysRun = true)
public void setup() {
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.saucedemo.com/");
}
// Test Case 1
@Test(priority = 1, groups = "login")
public void verifyPageTitle() {
String title = driver.getTitle();
Assert.assertEquals(title, "Swag Labs");
System.out.println("Page Title Test Passed");
}
// Test Case 2
@Test(priority = 2, groups = "login")
public void verifyLogin() {
driver.findElement(By.id("user-name"))
.sendKeys("standard_user");
driver.findElement(By.id("password"))
.sendKeys("secret_sauce");
driver.findElement(By.id("login-button"))
.click();
Assert.assertTrue(
driver.getCurrentUrl().contains("inventory")
);
System.out.println("Login Test Passed");
}
// Test Case 3
@Test(priority = 3, groups = "product")
public void verifyProductPage() {
driver.findElement(By.id("user-name"))
.sendKeys("standard_user");
driver.findElement(By.id("password"))
.sendKeys("secret_sauce");
driver.findElement(By.id("login-button"))
.click();
String pageTitle =
driver.findElement(By.className("title"))
.getText();
Assert.assertEquals(pageTitle, "Products");
System.out.println("Product Page Test Passed");
}
// Runs after every test method
@AfterMethod(alwaysRun = true)
public void closeBrowser() {
driver.quit();
}
}