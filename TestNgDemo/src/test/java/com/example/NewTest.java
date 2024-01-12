package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
    WebDriver wd = null;

    @BeforeTest
    public void initiate() {
        System.out.println("config initiated");
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        wd.manage().window().maximize();
    }

    @Test(priority = 1)
    public void searchOnAmazon() throws InterruptedException {
        System.out.println("test1 initiated");
        wd.get("https://www.amazon.in/");
        WebElement searchBox = wd.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        searchBox.sendKeys(Keys.RETURN);
        Thread.sleep( 1000);
    }

    @Test(priority = 2)
    public void searchOnFlipkart() throws InterruptedException {
        System.out.println("test2 initiated");
        wd.get("https://www.flipkart.com/");
       
        WebElement searchBox = wd.findElement(By.name("q"));
        searchBox.sendKeys("iphone");
        searchBox.sendKeys(Keys.RETURN);
        Thread.sleep( 1000);
    }

    @AfterTest
    public void derefer() {
        System.out.println("wd closed");
        wd.close();
    }
}
