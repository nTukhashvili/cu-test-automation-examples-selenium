package org.example.lecture_8;

import org.testng.annotations.*;

public class AnnotationsTestNG {

    @BeforeTest
    public void beforeTest(){
        System.out.println("runs before TESTING PROCESS BEFORE Classes");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("runs after TESTING PROCESS after Classes");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("I will gonna run before CLASS ONLY ONCE ");
    }

    @BeforeMethod
    public void beforeTestMethod(){
        System.out.println("I'll run before every TEST");
    }

    @Test
    public void test1(){
        System.out.println("TEST 1 Running");
    }

    @Test
    public void test2(){
        System.out.println("Test 2 Running");
    }

    @AfterMethod
    public void afterTestMethod(){
        System.out.println("I will gonna run after EVERY TEST !!! MUAHAHAHA");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I will gonna run after CLASS ONLY ONCE");
    }
}
