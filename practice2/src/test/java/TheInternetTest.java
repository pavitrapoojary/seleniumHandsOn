import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class TheInternetTest {
    WebDriver driver = new ChromeDriver();

    @Test
    void login() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[text()=' Login']")).click();
        String expectedLoginText = "Welcome to the Secure Area. When you are done click logout below.";
        String actualTestAfterLoggingIn = driver.findElement(By.xpath("//h4[contains(text(),'Welcome to the Secure Area.')]")).getText();
        assertEquals(expectedLoginText, actualTestAfterLoggingIn);
        driver.quit();
    }

    @Test
    void checkboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected());
        assertFalse(driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected());
        driver.quit();
    }

    @Test
    void dragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement elementA = driver.findElement(By.id("column-a"));
        WebElement elementB = driver.findElement(By.id("column-b"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(elementA, elementB).build().perform();
        String textInElementB = elementB.getText();
        assertTrue(textInElementB.contains("A"));
        driver.quit();
    }

    @Test
    void fileUpload() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/upload");
        String filePath = "C:/HANDS ON/test.js";
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        assertEquals("File Uploaded!", driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!')]")).getText());
        driver.quit();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
