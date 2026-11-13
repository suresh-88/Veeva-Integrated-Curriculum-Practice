package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownLocator {
    public static void main() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/dropdown");
        driver.manage().window().maximize();
        //for non auto suggestive dropdowns
        WebElement dropdown = driver.findElement(By.id("country"));
        Select s = new Select(dropdown);
        s.selectByContainsVisibleText("Egypt");
        s.selectByIndex(4);
    }
}


