package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class HandlingPaginationTable {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@class='pagination']//a"));
        for(WebElement page : pages){
            page.click();
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']//tr"));
            for(int i=1;i<rows.size();i++){
                System.out.println(driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]")).getText());
                driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]//input")).click();
            }
        }
    }
}
