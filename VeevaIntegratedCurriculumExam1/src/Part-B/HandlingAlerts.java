import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HandlingAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println(confirmAlert.getText());
        Thread.sleep(2000);
        confirmAlert.accept();
        driver.findElement(By.xpath("//button[@id='promptBtn']")).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Automation Test" );
        Thread.sleep(2000);
        promptAlert.dismiss();
        Thread.sleep(1000);
        driver.quit();
    }
}
