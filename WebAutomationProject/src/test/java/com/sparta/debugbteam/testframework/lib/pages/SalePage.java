package com.sparta.debugbteam.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalePage implements Page{
    private final WebDriver webDriver;
    public SalePage(WebDriver webDriver) {
        if (!webDriver.getTitle().contains("Sale")) {
            throw new IllegalStateException("This is not the Sale page," +
                    " current page is: " + webDriver.getCurrentUrl());

        }
        this.webDriver = webDriver;
    }
    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public HomePage goToHomePage() {
        webDriver.findElement(By.className("logo")).click();
        return new HomePage(webDriver);
    }

}
