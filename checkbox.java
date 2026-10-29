import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
public class pp {
public static void main(String[] args) {
WebDriver wd = new ChromeDriver();
wd.get("https://syntaxprojects.com/basic-checkbox-demo.php?utm_source=chatgpt.c
om");

List<WebElement> checkboxes =
wd.findElements(By.xpath("//input[@type='checkbox']"));
System.out.println("TOTAL CHECKBOXES : " + checkboxes.size());
int checked = 0;
int unchecked = 0;

for (WebElement checkbox : checkboxes) {
if (checkbox.isSelected()) {
checked++;
} else {
unchecked++;
}
}
System.out.println("CHECKED CHECKBOXES : " + checked);
System.out.println("UNCHECKED CHECKBOXES : " + unchecked);

for (WebElement checkbox : checkboxes) {
if (!checkbox.isSelected()) {
checkbox.click();
if (checkbox.isSelected()) {
System.out.println("Checkbox selected successfully.");
} else {
System.out.println("Checkbox selection failed.");
}
break;
}
}
wd.quit();
}
}
