package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HandlingStaticTables {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.blazedemo.com");
        driver.manage().window().maximize();
        WebElement src = driver.findElement(By.xpath("//select[@name='fromPort']"));
        WebElement dest = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select from = new Select(src);
        Select to = new Select(dest);
        from.selectByValue("Mexico City");
        to.selectByValue("New York");
        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
        List<WebElement> prices = driver.findElements(By.xpath("//tr/td[6]"));
        double min = 999999;
        int minPriceIndex = -1;
        //finding minimum price in a table and it's index
        for(int i=1;i<=prices.size();i++){
            String amount = prices.get(i-1).getText().substring(1,7);
            double curr = Double.parseDouble(amount);
            if(curr<min) {
                min = curr;
                minPriceIndex = i;
            }
        }
        //booking minimum price flight
        driver.findElement(By.xpath("//tr["+minPriceIndex+"]/td[1]/input")).click();
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))).getText();
        System.out.println("message = " + msg);
    }
}
