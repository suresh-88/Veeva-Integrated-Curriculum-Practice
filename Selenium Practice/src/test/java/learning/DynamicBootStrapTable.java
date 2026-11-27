package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class DynamicBootStrapTable {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@role='table']/div[1]")).getText());
        List<WebElement> rows = driver.findElements(By.xpath("//div[@role='table']/div[2]/div"));
        for(WebElement row : rows)
            System.out.println(row.getText());
    }
}
