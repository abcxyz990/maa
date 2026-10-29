package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
public class pract14 {
WebDriver driver;
Logger log = LogManager.getLogger(pract14.class);
@Test
public void loginTest() {
try {
log.info("Test Started");
driver = new ChromeDriver();
driver.get("https://the-internet.herokuapp.com/login");
log.info("Login page opened");
driver.findElement(By.id("username"))
.sendKeys("tomsmith");
log.info("Username entered");
driver.findElement(By.id("password"))
.sendKeys("SuperSecretPassword!");
log.info("Password entered");
// Intentional error for demonstration
driver.findElement(By.id("wrongButton")).click();
log.info("Test Passed");
} catch (Exception e) {
log.error("Test Failed", e);
try {
File screenshot =
((TakesScreenshot) driver)
.getScreenshotAs(OutputType.FILE);
Files.copy(
screenshot.toPath(),
new File("failure-screenshot.png").toPath(),
StandardCopyOption.REPLACE_EXISTING
);
log.info("Screenshot captured successfully");
} catch (Exception ex) {
log.error("Screenshot capture failed", ex);
}
throw e;
} finally {
if (driver != null) {
driver.quit();
}
log.info("Browser Closed");
}
}
}
