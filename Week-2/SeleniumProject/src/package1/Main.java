package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        //ID Locator
        driver.findElement(By.id("firstName")).sendKeys("Suresh");
        driver.findElement(By.id("lastName")).sendKeys("katta");
        //Class Locator
        driver.findElement(By.className("mr-sm-2 form-control")).sendKeys("Suresh1234@gmail.com");
        driver.findElement(By.className(" mr-sm-2 form-control")).sendKeys("9948895393");
        //CSS Selector Locator
        driver.findElement(By.cssSelector("input#gender-radio-1")).click();
        Thread.sleep(5000);
        driver.close();
    }
}
