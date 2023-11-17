package org.example.lecture_8;

import org.testng.annotations.*;

public class AnnotationsTestNG2 {

    @BeforeClass
    public void beforeClass(){
        System.out.println("I will gonna run before CLASS ONLY ONCE ");
    }

    @BeforeMethod
    public void beforeTest(){
        System.out.println("I'll run before every TEST");
    }

    @Test
    public void test3(){
        System.out.println("TEST 3 Running");
    }

    @Test
    public void test4(){
        System.out.println("Test 4 Running");
    }

    @AfterMethod
    public void afterTest(){
        System.out.println("I will gonna run after EVERY TEST !!! MUAHAHAHA");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I will gonna run after CLASS ONLY ONCE");
    }
}
