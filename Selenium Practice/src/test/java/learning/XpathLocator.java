package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class XpathLocator {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.youtube.com/");
        //driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("Irumudi\n");
        //driver.findElement(By.xpath("//*[@name='search_query']")).sendKeys("Manikanta\n");
        //driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("aankh maarey\n");
        //driver.findElement(By.xpath("//*[@name='search_query' or @placeholder='Search']")).sendKeys("Hi nanna\n");
        //driver.findElement(By.xpath("//*[@name='search_query' and @placeholder='Search']")).sendKeys("Hi nanna\n");
        driver.quit();
    }
}
