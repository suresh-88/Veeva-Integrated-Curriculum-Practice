package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CheckTitle {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.youtube.com/");
        if(driver.getTitle().equals("Youtube"))
            System.out.println("The Title is correct.");
        else
            System.out.println("The title is wrong.");
        driver.quit();
    }
}
