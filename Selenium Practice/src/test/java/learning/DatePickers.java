package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DatePickers {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //using send keys
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/10/2010");

        //dropdown date picker
        driver.findElement(By.xpath("//input[@id='txtDate']")).click();
        WebElement month = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select mon = new Select(month);
        mon.selectByValue("11");
        WebElement year = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
        Select yer = new Select(year);
        yer.selectByValue("2024");
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for(WebElement date : dates)
            if(date.getText().equals("16")){
                date.click();
                break;
            }

        //start and end dates
        driver.findElement(By.xpath("//input[@id='start-date']")).sendKeys("16-12-2000");
        driver.findElement(By.xpath("//input[@id='end-date']")).sendKeys("16-12-2024");
    }
}
