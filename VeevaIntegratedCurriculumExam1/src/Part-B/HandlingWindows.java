import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Set;

public class HandlingWindows {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println("Parent Title = "+driver.getTitle());
        driver.findElement(By.xpath("//button[normalize-space()='New Tab']")).click();
        String driverWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for(String window : windows)
            if(!driverWindow.equals(window))
                driver.switchTo().window(window);
        System.out.println("New Page Title = "+driver.getTitle());
        driver.switchTo().defaultContent();
        driver.close();
    }
}
