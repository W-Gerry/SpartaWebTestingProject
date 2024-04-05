package com.sparta.debugbteam.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        if (webDriver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/customer/account/create/")) {
            this.webDriver = webDriver;
        }
        else if (webDriver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/customer/account/login/")){
            this.webDriver = webDriver;
        }
        throw new IllegalStateException("This is not the Login Page," +
                " current page is: " + webDriver.getCurrentUrl());
    }
    public LoginPage login(String username, String password) throws InterruptedException {
        webDriver.findElement(By.id("email")).sendKeys(username, Keys.TAB);
        Thread.sleep(200);
        webDriver.findElement(By.id("pass")).sendKeys(password, Keys.ENTER);
        return new LoginPage(webDriver);
    }

    public LoginPage signUp(String firstName, String lastName, String email, String password) throws InterruptedException {
        webDriver.findElement(By.id("firstname")).sendKeys(firstName, Keys.TAB);
        Thread.sleep(200);
        webDriver.findElement(By.id("lastname")).sendKeys(lastName, Keys.TAB);
        Thread.sleep(200);
        webDriver.findElement(By.id("email_address")).sendKeys(email, Keys.TAB);
        Thread.sleep(200);
        webDriver.findElement(By.id("password")).sendKeys(password, Keys.TAB);
        Thread.sleep(200);
        webDriver.findElement(By.id("password-confirmation")).sendKeys(password, Keys.ENTER);
        return new LoginPage(webDriver);
    }

    public String getText(){
        return webDriver.findElement(By.tagName("body")).getText();
    }
}
