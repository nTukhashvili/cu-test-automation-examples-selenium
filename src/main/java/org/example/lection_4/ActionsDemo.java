package org.example.lection_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Actions act = new Actions(driver);
        driver.manage().window().maximize();
        //moveElementDemo(driver,act);
        draggable(driver, act);

    }

    static void resizeDemo(WebDriver driver, Actions act) throws InterruptedException {
        driver.get("https://demoqa.com/resizable");
        WebElement resizable = driver.findElement(By.xpath("//*[@id='resizableBoxWithRestriction']/span"));
        WebElement resizable2 = driver.findElement(By.xpath("//*[@id='resizable']/span"));

        act.moveToElement(resizable).clickAndHold().moveByOffset(50, 50).release().build().perform();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            act.moveToElement(resizable2).clickAndHold().moveByOffset(50, 50).release().build().perform();
        }

    }

    static void moveElementDemo(WebDriver driver, Actions act) throws InterruptedException {
        driver.get("https://demoqa.com/sortable");
        WebElement firstElement = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-list\"]/div/div[1]"));
        WebElement lastElement = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-list\"]/div/div[6]"));

        //პირველ ელემენტს ხელი დავაკლიკოთ ჩამოვტიანოთ ბოლო ელემენტთან გავუშვათ კლიკი

        for (int i = 0; i < 5; i++) {
            act.clickAndHold(firstElement)
                    .moveToElement(lastElement)
                    .release()
                    .perform();

            act.clickAndHold(lastElement)
                    .moveToElement(firstElement)
                    .release()
                    .perform();
            Thread.sleep(1000);

        }

        driver.findElement(By.xpath("//*[@id='demo-tab-grid']")).click();
        WebElement gridElement = driver.findElement(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div[1]"));
        WebElement lastGridElement = driver.findElement(By.xpath("//*[@id='demo-tabpane-grid']/div/div/div[9]"));
        String generalGridXpath = "//*[@id='demo-tabpane-grid']/div/div/div";

        for (int i = 1; i < 9; i++) {
            Thread.sleep(2000);
            act.clickAndHold(driver.findElement(By.xpath(generalGridXpath + "[" + i + "]")))
                    .moveToElement(lastGridElement)
                    .release()
                    .perform();
        }

    }

    static void droppable(WebDriver driver, Actions act){
        driver.get("https://demoqa.com/droppable");
        WebElement draggableBox  = driver.findElement(By.id("draggable"));
        WebElement droppableBox  = driver.findElement(By.id("droppable"));
        act.dragAndDrop(draggableBox,droppableBox).perform();

        driver.findElement(By.xpath("//*[@id='droppableExample-tab-accept']")).click();
    }

    static void draggable(WebDriver driver, Actions act) throws InterruptedException {
        driver.get("https://demoqa.com/dragabble");
        WebElement draggableBox  = driver.findElement(By.id("dragBox"));

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            if (i % 2 ==0){
                act.dragAndDropBy(draggableBox,50,50).perform();
            }
            else {
                act.dragAndDropBy(draggableBox,-50,-50).perform();
            }

        }

    }



}

