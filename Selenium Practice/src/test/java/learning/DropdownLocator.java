package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropdownLocator {
    public static void main() {
        EdgeDriver driver = new EdgeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();


        //for non auto suggestive dropdowns
        WebElement dropdown = driver.findElement(By.id("Skills"));
        Select s = new Select(dropdown);
        //selecting by index
        s.selectByIndex(1);
        //selecting by internal value
        s.selectByValue("C");
        //selecting by visible text
        s.selectByVisibleText("Android");

        //for auto-suggestive dropdown
        driver.findElement(By.id("select2-country-container")).sendKeys("jap");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
}


