package com.sparta.debugbteam.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrainingShopPage implements Page {
    private final WebDriver webDriver;
    public TrainingShopPage(WebDriver webDriver) {
        if (!webDriver.getTitle().contains("Training")) {
            throw new IllegalStateException("This is not the Gear page," +
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
