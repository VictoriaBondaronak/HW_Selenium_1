import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class CheckboxesTest {
    WebDriver driver;

    @BeforeAll
    static void loadDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }

    @Test
    void checkUncheckEl(){
        if(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).getAttribute("checked") == null){
            System.out.println("Checkbox 1 is unchecked");
            driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).click();
            Assertions.assertNotNull(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).getAttribute("checked"));
            System.out.println("Checkbox 1 is checked");
        }
        if(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).getAttribute("checked") != null){
            System.out.println("Checkbox 2 is checked");
            driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).click();
            Assertions.assertNull(By.xpath("//form[@id='checkboxes']/input[2]").findElement(driver).getAttribute("checked"));
            System.out.println("Checkbox 2 is unchecked");
        }
        driver.close();
    }

}
