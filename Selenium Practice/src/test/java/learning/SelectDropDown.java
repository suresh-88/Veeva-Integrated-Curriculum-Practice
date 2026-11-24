package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectDropDown {
    public static void main() {
        EdgeDriver driver = new EdgeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();

        //for non auto suggestive dropdowns - select dropdown
        WebElement dropdown = driver.findElement(By.id("Skills"));
        Select s = new Select(dropdown);
        //selecting by index
        s.selectByIndex(1);
        //selecting by internal value
        s.selectByValue("C");
        //selecting by visible text
        s.selectByVisibleText("Android");
        //counting options
        List<WebElement> options = s.getOptions();
        System.out.println("no.of options = "+options.size());
        //printing all options
        for(WebElement option:options)
            System.out.println(option.getText());

    }
}


