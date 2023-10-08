
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Quiz2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600, 900));
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/PC/Downloads/quiz-index.html");


        driver.findElement(By.id("email")).sendKeys("s_lapachi@cu.edu.ge");
        driver.findElement(By.cssSelector("#password")).sendKeys("TestPassw0rd");
        //driver.findElement(By.cssSelector("#gender")).click();
        driver.findElement(By.cssSelector("#gender > option:nth-child(2)")).click();
        List<WebElement> Breeds = driver.findElements(By.xpath("//*[contains(@class, 'list-group-item list-group-item-action')]"));
        for (WebElement Breed : Breeds)
        {
            Breed.click();
        }
        Thread.sleep(100);
        Actions act = new Actions(driver);
        act.clickAndHold(driver.findElement(By.className("slider-handle"))).moveByOffset(400,0).release().perform();

        driver.findElement(By.id("terms")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String successtext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage"))).getText();
        System.out.println(successtext);


        Thread.sleep(2000);
        driver.quit();
    }
}
