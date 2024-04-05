package com.sparta.debugbteam.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver webDriver) {
        if (!webDriver.getCurrentUrl().contains("customer/account/")) {
            throw new IllegalStateException("This is not the Login Page," +
                    " current page is: " + webDriver.getCurrentUrl());
        }
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
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

    public boolean isEmailInvalid() {
        WebElement emailErrorMsg = webDriver.findElement(By.id("email-error"));
        if (emailErrorMsg != null) {
            return emailErrorMsg.getText().equals("Please enter a valid email address (Ex: johndoe@domain.com).");
        }
        return getUrl().contains("account/login");
    }

    public boolean isPasswordInvalid() {
        return getText().contains("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
    }

    public void clickLoginBtn() {
        WebElement loginBtn = webDriver.findElement(By.id("send2"));
        loginBtn.click();
    }

    public boolean checkLoginIsValid() {
        wait.until(ExpectedConditions.urlContains("https://magento.softwaretestingboard.com"));
        System.out.println(getUrl());
        return getUrl().equals("https://magento.softwaretestingboard.com/") || getUrl().endsWith("/customer/account/");
    }

    public String getText() {
        return webDriver.findElement(By.tagName("body")).getText();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }
}
