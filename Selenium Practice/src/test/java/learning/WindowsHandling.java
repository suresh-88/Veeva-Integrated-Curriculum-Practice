package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import javax.sql.rowset.serial.SQLOutputImpl;
import java.time.Duration;
import java.util.Set;

public class WindowsHandling {
    public static void main(String args[]) {
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://testautomationpractice.blogspot.com/");
        System.out.println("id = " + driver.getWindowHandle());
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        Set<String> windows = driver.getWindowHandles();
        System.out.println("id = " +windows );
        //getting all windows titles by switching
        for(String s:windows){
            System.out.println(driver.switchTo().window(s).getTitle());
        }
        driver.quit();
    }
}
