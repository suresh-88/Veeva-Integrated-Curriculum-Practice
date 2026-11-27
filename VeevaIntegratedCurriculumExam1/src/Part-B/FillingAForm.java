import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class FillingAForm {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("D:\\Veeva Training\\VeevaIntegratedCurriculumExam1\\src\\Part-B\\login.html");
        driver.findElement(By.id("name")).sendKeys("Suresh");
        driver.findElement(By.id("email")).sendKeys("suresh@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        WebElement country = driver.findElement(By.id("country"));
        Select dropdown = new Select(country);
        dropdown.selectByVisibleText("India");
        WebElement checkbox = driver.findElement(By.id("terms"));
        if(!checkbox.isSelected())
            checkbox.click();
        Thread.sleep(3000);
        driver.findElement(By.tagName("button")).click();
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        driver.close();
    }
}
