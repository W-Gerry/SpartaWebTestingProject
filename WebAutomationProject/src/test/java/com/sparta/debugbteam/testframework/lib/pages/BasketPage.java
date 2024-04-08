package com.sparta.debugbteam.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class BasketPage {
    private final WebDriver webDriver;

    public BasketPage(WebDriver webDriver) {
        if (!webDriver.getTitle().contains("https://magento.softwaretestingboard.com/checkout/cart/")) {
            throw new IllegalStateException("This is not the Basket Page," +
                    " current page is: " + webDriver.getCurrentUrl());
        }

        this.webDriver = webDriver;
    }

    public String getProductInfo(String productName) {
        return webDriver.findElement(By.xpath(productName))
                .getText();
    }

    public void removeItemFromBasket() {
        WebElement deleteButton =  webDriver.findElement(By.className("action-delete"));
        deleteButton.click();
    }

    public void goToCheckout() {
        WebElement checkoutButton =  webDriver.findElement(By.className("checkout"));
        checkoutButton.click();
    }
}