package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class CheckBoxAndRadio {
    public static void main(String []args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //handling radio button
        driver.findElement(By.xpath("//input[@id='male']")).click();
        driver.findElement(By.xpath("//input[@id='female']")).click();

        //handling check boxes
        //selecting single checkbox
        driver.findElement(By.xpath("//input[@id='tuesday']")).click();
        //selecting all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox' and @class='form-check-input']"));
        for(WebElement box:checkboxes)
            box.click();
        //deselecting already selected checkboxes
        for(WebElement box:checkboxes)
            if(box.isSelected())
                box.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
