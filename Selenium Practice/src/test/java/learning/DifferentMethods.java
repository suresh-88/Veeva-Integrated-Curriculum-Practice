package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferentMethods {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //different get methods, these are driver methods

        //1.get method is used to open a particular url or webpage
        driver.get("https://testautomationpractice.blogspot.com/");
        //2.getTitle method returns title of the webpage
        System.out.println("Title is: "+driver.getTitle());
        //3.getCurrentUrl returns the url of the webpage driver pointing to
        System.out.println("Url is: "+driver.getCurrentUrl());
        //4.getPageSource method returns page source of the webpage
        System.out.println("Page Source="+driver.getPageSource());
        driver.findElement(By.xpath("//img[@class='wikipedia-icon']")).click();
        //5.getWindowHandle returns the id of the current webpage
        System.out.println("Webpage id = "+driver.getWindowHandle());
        //6.getWindowHandles returns the ids of all webpages opened
        System.out.println("Webpage ids = "+driver.getWindowHandles());

        //different conditional methods, these are element methods, returns boolean
        WebElement element = driver.findElement(By.xpath("//input[@id='male']"));
        //1.isDisplayed checks weather an element is displayed or not
        System.out.println("Element is displayed = "+element.isDisplayed());
        //2.isEnabled checks weather an element is Element or not(buttons)
        System.out.println("Element is enabled = "+element.isEnabled());
        //3.isSelected checks weather an element is Selected or not(checkboxes,radio buttons)
        System.out.println("Element is selected = "+element.isSelected());

        //different browser closing methods
        //1.close methods closes only single webpage
        driver.close();
        //2.quit method closes all webpages and close the browser
        driver.quit();
    }
}
