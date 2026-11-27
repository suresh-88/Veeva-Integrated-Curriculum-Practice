package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement point = driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
        WebElement laptops = driver.findElement(By.xpath("//a[normalize-space()='Laptops']"));
        Actions actions = new Actions(driver);
        //hovering to an element
        //actions.moveToElement(point).moveToElement(laptops).build().perform();
        //right click
        //actions.contextClick(point).perform();
        //double click
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
        actions.doubleClick(button).perform();
    }
}
