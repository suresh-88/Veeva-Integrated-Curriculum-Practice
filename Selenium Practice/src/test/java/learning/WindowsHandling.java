package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import javax.sql.rowset.serial.SQLOutputImpl;
import java.time.Duration;

public class WindowsHandling {
    public static void main(String args[]) {
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://practicetestautomation.com/");
        System.out.println("id = " + driver.getWindowHandle());
        driver.findElement(By.linkText("PRACTICE")).click();
        System.out.println("id = " + driver.getWindowHandles());
    }
}
