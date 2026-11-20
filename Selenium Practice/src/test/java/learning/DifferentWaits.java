package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DifferentWaits {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        //implicit wait works for every instruction until driver.close()
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/dynamic-properties");
        driver.findElement(By.xpath("//button[@id='enableAfter']")).click();
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("fun and games"))).click();
        driver.close();
    }
}
