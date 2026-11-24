package learning;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HandlingAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        //handling simple alert
        driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println("simple alert message = "+simpleAlert.getText());
        Thread.sleep(3000);
        simpleAlert.accept();

        //handling confirmation alert
        driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("confirmation alert message = "+confirmAlert.getText());
        Thread.sleep(3000);
        //confirmAlert.accept();
        confirmAlert.dismiss();

        //handling prompt alert
        driver.findElement(By.xpath("//button[@id='promptBtn']")).click();
        Alert promptAlert = driver.switchTo().alert();
        System.out.println("prompt alert message = "+promptAlert.getText());
        promptAlert.sendKeys("suresh");
        Thread.sleep(3000);
        promptAlert.accept();
        //promptAlert.dismiss();
    }
}
