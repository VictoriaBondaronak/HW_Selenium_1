import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddRemoveElementsTest {
    WebDriver driver;

    @BeforeAll
    static void loadDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }

    @Test
    void addRemoveEl(){
        driver.findElement(By.xpath("//button[contains(text(),'Add Element')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Add Element')]")).click();
        int count = driver.findElements(By.className("added-manually")).size();
        driver.findElement(By.xpath("//div[@class='example']/div/button[" + count + "]")).click();
        count = driver.findElements(By.className("added-manually")).size();
        System.out.println("Number of created elements: " + count);
        driver.close();
    }

}
