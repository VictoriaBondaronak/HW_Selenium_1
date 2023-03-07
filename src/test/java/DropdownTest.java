import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.function.BooleanSupplier;

public class DropdownTest {
    WebDriver driver;

    @BeforeAll
    static void loadDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }

    @Test
    void selectEl(){
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        Assertions.assertFalse(By.xpath("//option[@value='1']") == null);
        Assertions.assertFalse(By.xpath("//option[@value='2']") == null);
        System.out.println("Dropdown elements exist");
        dropdown.selectByValue("1");
        Assertions.assertNotNull(By.xpath("//option[@value='1']").findElement(driver).getAttribute("selected"));
        System.out.println("Option 1 is selected");
        dropdown.selectByValue("2");
        Assertions.assertNotNull(By.xpath("//option[@value='2']").findElement(driver).getAttribute("selected"));
        System.out.println("Option 2 is selected");
        driver.close();
    }

}
