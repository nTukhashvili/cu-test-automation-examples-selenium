package org.example.lecture_8;

import org.testng.annotations.Test;

public class GroupingTests {
    @Test(groups={"regression"})
    public void test1(){
        System.out.println("TEST 1 regression");
    }

    @Test(groups = "new")
    public void test2(){
        System.out.println("Test 2 new Running");
    }

    @Test(groups = "regression")
    public void test4(){
        System.out.println("TEST 4 Regression");
    }

    @Test(groups = "new")
    public void test3(){
        System.out.println("Test 3  new Running");
    }
}
