package com.sparta.debugbteam.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GearShopPage {
    private final WebDriver webDriver;
    public GearShopPage(WebDriver webDriver) {
        if (!webDriver.getTitle().contains("Gear")) {
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
        webDriver.findElement(By.linkText("home")).click();
        return new HomePage(webDriver);
    }

}
