package org.example.lecture_7;

import com.codeborne.selenide.*;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public class Task_3 {

    @Test
    public void task_3() throws InterruptedException {

        Configuration.browserSize = "2560x1440";
        open("https://www.saucedemo.com");
        System.out.println(title());
        System.out.println(url());

        //ნაბიჯები 5-7
        $(By.cssSelector("#user-name"))
                .shouldBe(visible)
                .setValue("standard_user");

        $(By.cssSelector("#password"))
                .shouldBe(visible)
                .setValue("secret_sauce");

        $(By.cssSelector("#login-button"))
                .shouldBe(interactable)
                .click();
        Thread.sleep(2000);

        //ნაბიჯები 8-12
        $(By.xpath("//select[@class='product_sort_container']")).click();
        $(By.xpath("//select[@class='product_sort_container']"))
                .find(By.xpath("option[text()='Price (low to high)']"))
                .click();

        Thread.sleep(2000);
        //ალტერნატიულად შეგიძლიათ გამოიყენოთ ინდექსი თუ კი დავალების პირობაში არ არის მოთხოვნა მაგალითად
        //driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]//option[2];

        $$(By.xpath("//div[@class='pricebar']"))
                .last()
                .findElement(By.xpath("*[text()='Add to cart']"))
                .click();


        Thread.sleep(2000);
        //Xpath-ის განმარტება: ვეძენთ ნებისმიერ ელემენტს რომელიც მოიცავს სიტყვა T-shirt-ს შემდეგ ავდივართ ზედა დონეზე //ancestor ბრძანებით რათა მივწვდეთ add to cart button-ს
        ElementsCollection tShirts =  $(By.xpath("//div[@class='inventory_list']"))
                .$$(By.xpath("div[@class='inventory_item']"))
                .filterBy(text("T-Shirt"));
        System.out.println(tShirts.size());
        System.out.println(tShirts.get(0));
        Thread.sleep(2000);

        Thread.sleep(2000);
        ElementsCollection itemsToBeAdded = $$(By.className("inventory_item_description")).filterBy(text("Add to cart"));
        System.out.println(itemsToBeAdded.size());

    }

}

