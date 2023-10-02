package Solutions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1600, 900));
        driver.get("https://www.saucedemo.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //ნაბიჯები 5-7
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        Thread.sleep(2000);

        //ნაბიჯები 8-12
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//select[@class='product_sort_container']//option[text()='Price (low to high)']")).click();
        Thread.sleep(2000);
        //ალტერნატიულად შეგიძლიათ გამოიყენოთ ინდექსი თუ კი დავალების პირობაში არ არის მოთხოვნა მაგალითად
        //driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]//option[2];

        WebElement lastItem = driver.findElement(By.xpath("//div[@class='inventory_item'][last()]//button"));
        lastItem.click();
        Thread.sleep(2000);
        //Xpath-ის განმარტება: ვეძენთ ნებისმიერ ელემენტს რომელიც მოიცავს სიტყვა T-shirt-ს შემდეგ ავდივართ ზედა დონეზე //ancestor ბრძანებით რათა მივწვდეთ add to cart button-ს
        List<WebElement> tShirts = driver.findElements(By.xpath("//*[contains(text(),'T-Shirt')]//ancestor::div[@class='inventory_item']//button"));

        Thread.sleep(2000);
        for (WebElement tShirt : tShirts) {
            tShirt.click();
        }

        System.out.println(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText());

        //12+ ნაბიჯები გამოიყენეთ ისეთი ლოკატორები რომელებსაც ჩათვლით მიზანშეწონილად

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.xpath("//*[@data-test='firstName']")).sendKeys("Nika");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("Tukhashvili");
        driver.findElement(By.name("postalCode")).sendKeys("999");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='finish']")).click();

        System.out.println(driver.findElement(By.xpath("//*[@id='checkout_complete_container']/h2")).getText());

        driver.quit();

    }
}
