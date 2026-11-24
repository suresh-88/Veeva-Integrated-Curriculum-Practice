package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class DifferentWaits {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();

        //implicit wait works for every instruction until driver.close()
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/dynamic-properties");
        driver.findElement(By.xpath("//button[@id='enableAfter']")).click();
        //Explicit wait
//      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("fun and games"))).click();

        //fluent wait
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(d->driver.findElement(By.id("hello")));
        driver.close();
    }
}
