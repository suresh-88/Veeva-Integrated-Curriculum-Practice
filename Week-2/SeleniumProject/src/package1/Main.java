package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("Suresh");
        driver.findElement(By.id("lastName")).sendKeys("katta");
        driver.findElement(By.id("userEmail")).sendKeys("Suresh1234@gmail.com");
        driver.findElement(By.id("userNumber")).sendKeys("9948895393");
        driver.findElement(By.cssSelector("input#gender-radio-1")).click();
        Thread.sleep(5000);
        driver.close();
    }
}
