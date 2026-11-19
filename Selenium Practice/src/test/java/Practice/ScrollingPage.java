package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrollingPage {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testerwork.com/");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,500).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedCondition);
    }
}
