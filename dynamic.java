import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Pract_12 {
public static void main(String[] args) {
WebDriver driver = new ChromeDriver();
try {
// Launch Chrome Browser
driver.manage().window().maximize();
// Implicit Wait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
// Open Website
driver.get("https://datatables.net/examples/basic_init/zero_configuration.html"
);
// ==============================
// Count Rows
// ==============================
int rows = driver.findElements(By.xpath("//tbody/tr")).size();
System.out.println("Total Rows : " + rows);
// ==============================
// Count Columns
// ==============================
int cols = driver.findElements(By.xpath("//thead/tr/th")).size();
System.out.println("Total Columns : " + cols);
// ==============================
// Print Complete Table Data
// ==============================
System.out.println("\n----- Table Data -----");
List<WebElement> tableRows =
driver.findElements(By.xpath("//tbody/tr"));
for (WebElement row : tableRows) {
System.out.println(row.getText());
}
// ==============================
// Sorting Validation
// ==============================
System.out.println("\nClicking Name Column for Sorting...");
// Click Name column
driver.findElement(By.xpath("//thead/tr/th[1]")).click();
Thread.sleep(2000);
// Get Names after sorting
List<WebElement> names =
driver.findElements(By.xpath("//tbody/tr/td[1]"));
List<String> actualList = new ArrayList<>();
for (WebElement name : names) {
actualList.add(name.getText());
}
// Create Ascending List
List<String> ascendingList =
new ArrayList<>(actualList);
Collections.sort(ascendingList);
// Create Descending List
List<String> descendingList =
new ArrayList<>(ascendingList);
Collections.reverse(descendingList);
// Validate Sorting
if (actualList.equals(ascendingList)) {
System.out.println(
"Sorting Validation Passed - Ascending Order");
} else if (actualList.equals(descendingList)) {
System.out.println(
"Sorting Validation Passed - Descending Order");
} else {
System.out.println(
"Sorting Validation Failed");
}
// ==============================
// Search / Filter Validation
// ==============================
System.out.println("\n----- Search / Filter Validation -----");
WebElement searchBox =
driver.findElement(By.xpath("//input[@type='search']"));
// Clear search box
searchBox.clear();
// Enter name
searchBox.sendKeys("Tiger Nixon");
Thread.sleep(2000);
// Get filtered name
String actualName =
driver.findElement(By.xpath("//tbody/tr/td[1]"))
.getText();
// Validate Filter
if (actualName.equals("Tiger Nixon")) {
System.out.println("Filter Validation Passed");
} else {
System.out.println("Filter Validation Failed");
}
// Print filtered record
System.out.println("\nFiltered Record:");
System.out.println(
driver.findElement(By.xpath("//tbody/tr"))
.getText()
);
}
catch (Exception e) {
System.out.println("Error: " + e.getMessage());
}
finally {
// ==============================
// Close Browser
// ==============================
driver.quit();
System.out.println("\nBrowser Closed Successfully.");
}
}
}
