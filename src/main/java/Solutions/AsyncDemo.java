import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class AsyncDemo {
    public static void main(String[] args) {// Set path to your chromedriver
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Navigate to a blank page
        driver.get("about:blank");

        // Execute asynchronous JavaScript code
        js.executeScript(
                "setTimeout(function() {" +
                        "    document.body.innerHTML = '<div id=\"asyncDiv\">Asynchronous Content Loaded</div>';" +
                        "}, 2000);"
        );

        // Execute synchronous JavaScript code immediately after
        js.executeScript(
                "document.body.innerHTML += '<div id=\"syncDiv\">Synchronous Content Loaded</div>';"
        );

        // Try to find the element added by the asynchronous code
        try {
            WebElement asyncElement = driver.findElement(By.id("asyncDiv"));
            System.out.println("Found async element: " + asyncElement.getText());
        } catch (Exception e) {
            System.out.println("Async element not yet loaded.");
        }

        // Find the element added by the synchronous code
        WebElement syncElement = driver.findElement(By.id("syncDiv"));
        System.out.println("Found sync element: " + syncElement.getText());

        // Wait for a while to let the asynchronous code complete
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Now, try to find the element added by the asynchronous code again
        WebElement asyncElementAfterWait = driver.findElement(By.id("asyncDiv"));
        System.out.println("Found async element after waiting: " + asyncElementAfterWait.getText());
    }
}
