package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class HandlingFrames {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //switching to first frame
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Frame 1");

        //getting out of frame 1
        driver.switchTo().defaultContent();

        //switching to second frame
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.name("mytext2")).sendKeys("Frame 2");

        //getting out of frame 2
        driver.switchTo().defaultContent();

        //switching to fifth frame and clicking a link in it
        WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
        driver.switchTo().frame(frame5);
        WebElement link = driver.findElement(By.linkText("https://a9t9.com"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", link);

        //getting out of frame 5
        driver.switchTo().defaultContent();

        //handling iframes - frame 3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        //frame inside frame 3
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
        driver.findElement(By.xpath("//div[@id='i21']//div[@class='uHMk6b fsHoPb']")).click();
        driver.findElement(By.xpath("//div[@id='i24']//div[@class='uHMk6b fsHoPb']")).click();
    }
}
