import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
public class pract13 {
public static void main(String[] args) {
String uploadPath =
"C:\\Users\\JCLAB-30\\Desktop\\TestFile.txt";
String downloadPath =
"C:\\SeleniumDownloads";
// Create download folder
new File(downloadPath).mkdirs();
// Chrome download settings
ChromeOptions options = new ChromeOptions();
options.addArguments("--start-maximized");
Map<String, Object> prefs = new HashMap<>();
prefs.put("download.default_directory", downloadPath);
prefs.put("download.prompt_for_download", false);
options.setExperimentalOption("prefs", prefs);
// Start Chrome
WebDriver driver = new ChromeDriver(options);
try {
// Open website
driver.get(
"https://demoqa.com/upload-download");
System.out.println("Website Opened");
// =========================
// FILE UPLOAD
// =========================
driver.findElement(
By.id("uploadFile"))
.sendKeys(uploadPath);
String uploadedFile =
driver.findElement(
By.id("uploadedFilePath"))
.getText();
System.out.println(
"Uploaded File: " + uploadedFile);
if (uploadedFile.contains("TestFile.txt")) {
System.out.println(
"UPLOAD SUCCESSFUL");
} else {
System.out.println(
"UPLOAD FAILED");
}
// =========================
// FILE DOWNLOAD
// =========================
// Delete old files
File folder = new File(downloadPath);
for (File file : folder.listFiles()) {
file.delete();
}
// Click Download
driver.findElement(
By.id("downloadButton"))
.click();
System.out.println(
"Download Started");
// Wait for download
Thread.sleep(5000);
// Check downloaded file
File[] files =
folder.listFiles();
boolean downloaded = false;
if (files != null) {
for (File file : files) {
if (file.exists()
&& file.length() > 0) {
downloaded = true;
System.out.println(
"Downloaded File: "
+ file.getName());
}
}
}
if (downloaded) {
System.out.println(
"DOWNLOAD SUCCESSFUL");
} else {
System.out.println(
"DOWNLOAD FAILED");
}
}
catch (Exception e) {
System.out.println(
"Error: " + e.getMessage());
}
finally {
driver.quit();
System.out.println(
"Browser Closed Successfully");
}
}
}
