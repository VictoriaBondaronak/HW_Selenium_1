import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;


import java.lang.reflect.Array;
import java.util.function.BooleanSupplier;

public class InputTest {
    WebDriver driver;

    @BeforeAll
    static void loadDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/inputs");
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }

    @Test
    void inputTest(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement input = null;
        input = (WebElement) (((JavascriptExecutor) driver).executeScript("return document.getElementByXPath(\"//input[@type=\"number\"]\");"));
        input.sendKeys("hello");


//        input.sendKeys(Keys.ARROW_UP);
//        input.sendKeys(Keys.ARROW_DOWN);
//        String[] texts = {"text","text12","TEXT", "te xt"};
//        int[] numbers = {0,100,-100};
//
//        input.clear();
//        for (String t : texts) {
//            input.sendKeys(t);
//            input.sendKeys(Keys.ARROW_UP);
//            input.sendKeys(Keys.ARROW_DOWN);
//            System.out.println(input.getText());
//            input.clear();
//        }
//        for (int n : numbers) {
//            String n1 = String.valueOf(n);
//            input.sendKeys(n1);
//            input.sendKeys(Keys.ARROW_UP);
//            input.clear();
//        }


        driver.close();
    }

}

