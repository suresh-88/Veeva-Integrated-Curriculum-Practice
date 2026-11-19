package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators {
    public static void main() throws InterruptedException {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        //ID Locator
        driver.findElement(By.id("firstName")).sendKeys("Suresh");
        driver.findElement(By.id("lastName")).sendKeys("katta");
        //Class Locator
        driver.findElement(By.className("mr-sm-2 form-control")).sendKeys("Suresh1234@gmail.com");
        driver.findElement(By.className(" mr-sm-2 form-control")).sendKeys("9948895393");
        //Link Locators
        driver.findElement(By.linkText("Online Trainings")).click();
        driver.findElement(By.partialLinkText("Online")).click();
        //CSS Selector Locator
        driver.findElement(By.cssSelector("input#gender-radio-1")).click();
        driver.findElement(By.cssSelector("input[@id='gender-radio-1']")).click();
        Thread.sleep(5000);
        driver.close();
    }
}
