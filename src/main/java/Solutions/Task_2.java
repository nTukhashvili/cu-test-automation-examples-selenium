package Solutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("C:\\Users\\white\\Desktop\\task2.html");
        driver.findElement(By.xpath("//*[@id='fName']")).sendKeys("Nika");
        driver.findElement(By.cssSelector("input[data-selenium='lName']")).sendKeys("Tukhashvili");
        driver.findElement(By.name("date")).sendKeys("10291998");
        driver.findElement(By.xpath("//*[@id='gender']")).click();
        WebElement item1 =  driver.findElement(By.xpath("//*[@id='sortable']/li[1]"));
        WebElement item4 =  driver.findElement(By.xpath("//*[@id='sortable']/li[4]"));

        Actions act = new Actions(driver);
        act.clickAndHold(item4).moveToElement(item1).release().perform();
        WebElement confirmation =  driver.findElement(By.id("draggable"));
        WebElement confirmDestination =  driver.findElement(By.id("confirmBox"));

        act.clickAndHold(confirmation)
                .moveToElement(confirmDestination)
                .release()
                .perform();

        driver.findElement(By.xpath("//button[@data-btn='submitBtn']")).click();
        Thread.sleep(1000);

    }
}
