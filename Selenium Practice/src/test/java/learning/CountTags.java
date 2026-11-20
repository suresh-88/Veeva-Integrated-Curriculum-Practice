package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class CountTags {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("links count = " + links.size());
        links = driver.findElements(By.tagName("img"));
        System.out.println("images count = " + links.size());
    }
}
