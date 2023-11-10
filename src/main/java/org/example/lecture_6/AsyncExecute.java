package org.example.lecture_6;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AsyncExecute {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Navigate to a blank page
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

// Synchronous execution
        Object result1 = jsExecutor.executeScript("return 'Hello from synchronous!';");
        System.out.println(result1);  // Outputs: Hello from synchronous!

// Asynchronous execution
        Object result2 = jsExecutor.executeAsyncScript(
                "var callback = arguments[arguments.length - 1];" +
                        "setTimeout(function() {" +
                        "    callback('Hello from asynchronous!');" +
                        "}, 1000);"
        );
        System.out.println(result2);  // Outputs: Hello from asynchronous! (after a 1-second delay)

    }
}
