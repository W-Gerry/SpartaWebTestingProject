package com.sparta.debugbteam.testframework.lib.pages;

import io.cucumber.java.da.Men;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage implements Page{

    private final WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        if (!webDriver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/")) {
            throw new IllegalStateException(
                    "This is not the Luma home page, current page is: "
                            + webDriver.getCurrentUrl());
        }
        this.webDriver = webDriver;
    }

    public HomePage goToHomePage() {
        webDriver.findElement(By.className("logo")).click();
        return new HomePage(webDriver);
    }

    public TrainingShopPage goToTrainingShopPage() {
        webDriver.findElement(By.linkText("Training")).click();
        return new TrainingShopPage(webDriver);
    }

    public GearShopPage goToGearShopPage() {
        webDriver.findElement(By.linkText("Gear")).click();
        return new GearShopPage(webDriver);
    }

    public SalePage goToSalePage() {
        webDriver.findElement(By.linkText("Sale")).click();
        return new SalePage(webDriver);
    }

    public WomenShopPage goToWomenShopPage() {
        webDriver.findElement(By.linkText("Women")).click();
        return new WomenShopPage(webDriver);
    }

    public MenShopPage goToMenShopPage() {
        webDriver.findElement(By.linkText("Men")).click();
        return new MenShopPage(webDriver);
    }

    public WhatsNewPage goToWhatsNewPage() {
        webDriver.findElement(By.linkText("What's New")).click();
        return new WhatsNewPage(webDriver);
    }

}
