package com.sparta.debugbteam.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final WebDriver webDriver;
    private final Wait<WebDriver> wait;

    private static final String MEDIUM_SIZE_ID = "option-label-size-143-item-168";
    private static final String BLUE_ID = "option-label-color-93-item-50";
    private static final String QUANTITY_FIELD_ID = "qty";
    private static final String CART_BUTTON_ID = "product-addtocart-button";


    public ProductPage(WebDriver webDriver, Wait<WebDriver> wait) {
        if (!webDriver.getTitle().contains("All | Search powered by Algolia")) {
            throw new IllegalStateException("This is not the search Page," +
                    " current page is: " + webDriver.getCurrentUrl());
        }

        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void selectSize() {
        WebElement sizeOption = wait.until(s -> s.findElement(By.id(MEDIUM_SIZE_ID)));
        sizeOption.click();
    }

    public void selectColour() {
        WebElement colourOption = wait.until(s -> s.findElement(By.id(BLUE_ID)));
        colourOption.click();
    }

    public void selectQuantity(String quantity) {
        WebElement quantityField = wait.until(s -> s.findElement(By.id(QUANTITY_FIELD_ID)));
        quantityField.sendKeys(Keys.BACK_SPACE, quantity);
    }

    public void addToBasket() {
        WebElement addToBasketButton = wait.until(s -> s.findElement(By.id(CART_BUTTON_ID)));
        addToBasketButton.click();
    }

    public void goToBasket() {
        WebElement showBasketButton = wait.until(s -> s.findElement(By.className("action showcart")));
        showBasketButton.click();
        WebElement viewBasketButton = wait.until(s -> s.findElement(By.className("action viewcart")));
        viewBasketButton.click();
    }
}