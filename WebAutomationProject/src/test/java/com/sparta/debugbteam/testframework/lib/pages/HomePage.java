package com.sparta.debugbteam.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        if (!webDriver.getTitle().equals("Hacker News")) {
            throw new IllegalStateException(
                    "This is not the Hacker News home page, current page is: "
                            + webDriver.getCurrentUrl());
        }
        this.webDriver = webDriver;
    }

    public HomePage goToHomePage() {
        webDriver.findElement(By.linkText("home")).click();
        return new HomePage(webDriver);
    }

}
