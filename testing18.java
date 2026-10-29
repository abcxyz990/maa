import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URI;
public class testing1 {
static String gridURL = "http://localhost:4444";
static String chromeStatus;
static String firefoxStatus;
static String edgeStatus;
static String chromeIssue = "None";
static String firefoxIssue = "None";
static String edgeIssue = "None";
static long chromeTime;
static long firefoxTime;
static long edgeTime;
public static void main(String[] args) throws Exception {
testChrome();
testFirefox();
testEdge();
displayComparison();
}
// Chrome Test
public static void testChrome() throws Exception {
long startTime = System.currentTimeMillis();
ChromeOptions options = new ChromeOptions();
WebDriver driver = new RemoteWebDriver(
URI.create(gridURL).toURL(),
options
);
chromeStatus = runTest(driver, "Chrome");
driver.quit();
long endTime = System.currentTimeMillis();
chromeTime = endTime - startTime;
System.out.println("Chrome Execution Time: "
+ chromeTime + " ms");
}
// Firefox Test
public static void testFirefox() throws Exception {
long startTime = System.currentTimeMillis();
FirefoxOptions options = new FirefoxOptions();
WebDriver driver = new RemoteWebDriver(
URI.create(gridURL).toURL(),
options
);
firefoxStatus = runTest(driver, "Firefox");
driver.quit();
long endTime = System.currentTimeMillis();
firefoxTime = endTime - startTime;
System.out.println("Firefox Execution Time: "
+ firefoxTime + " ms");
}
// Edge Test
public static void testEdge() throws Exception {
long startTime = System.currentTimeMillis();
EdgeOptions options = new EdgeOptions();
WebDriver driver = new RemoteWebDriver(
URI.create(gridURL).toURL(),
options
);
edgeStatus = runTest(driver, "Edge");
driver.quit();
long endTime = System.currentTimeMillis();
edgeTime = endTime - startTime;
System.out.println("Edge Execution Time: "
+ edgeTime + " ms");
}
// Common Test
public static String runTest(WebDriver driver, String browser) {
try {
System.out.println("\nTesting on " + browser);
driver.get("https://www.google.com");
String title = driver.getTitle();
System.out.println("Page Title: " + title);
// Check page title
if (title == null || title.isEmpty()) {
throw new Exception("Page title not available");
}
// Find Google search box
driver.findElement(By.name("q"))
.sendKeys("Selenium WebDriver");
driver.findElement(By.name("q"))
.submit();
Thread.sleep(2000);
// Check whether page loaded successfully
String resultTitle = driver.getTitle();
if (resultTitle == null || resultTitle.isEmpty()) {
throw new Exception("Search result page did not load");
}
System.out.println(browser + " Test Passed");
return "PASS";
} catch (Exception e) {
System.out.println(browser + " Test Failed");
System.out.println("Compatibility Issue: "
+ e.getMessage());
// Store the error message
if (browser.equals("Chrome")) {
chromeIssue = e.getMessage();
}
if (browser.equals("Firefox")) {
firefoxIssue = e.getMessage();
}
if (browser.equals("Edge")) {
edgeIssue = e.getMessage();
}
return "FAIL";
}
}
// Display comparison
public static void displayComparison() {
System.out.println("\n");
System.out.println("==============================================");
System.out.println(" CROSS-BROWSER TESTING COMPARISON");
System.out.println("==============================================");
System.out.printf("%-12s %-12s %-18s %-30s%n",
"Browser", "Status", "Execution Time", "Compatibility Issue");
System.out.println("-----------------------------------------------------------
---------------");
System.out.printf("%-12s %-12s %-18s %-30s%n",
"Chrome",
chromeStatus,
chromeTime + " ms",
chromeIssue);
System.out.printf("%-12s %-12s %-18s %-30s%n",
"Firefox",
firefoxStatus,
firefoxTime + " ms",
firefoxIssue);
System.out.printf("%-12s %-12s %-18s %-30s%n",
"Edge",
edgeStatus,
edgeTime + " ms",
edgeIssue);
System.out.println("-----------------------------------------------------------
---------------");
// Find fastest browser
long fastestTime = Math.min(
chromeTime,
Math.min(firefoxTime, edgeTime)
);
String fastestBrowser;
if (fastestTime == chromeTime) {
fastestBrowser = "Chrome";
} else if (fastestTime == firefoxTime) {
fastestBrowser = "Firefox";
} else {
fastestBrowser = "Edge";
}
System.out.println("Fastest Browser: "
+ fastestBrowser
+ " (" + fastestTime + " ms)");
System.out.println("==============================================");
}
}
Output:
Testing on Chrome