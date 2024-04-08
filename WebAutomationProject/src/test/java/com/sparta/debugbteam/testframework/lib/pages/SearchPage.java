package com.sparta.debugbteam.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    private WebDriver webDriver;

    // Constructor to initialize WebDriver
    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goToHomePage() {
        this.webDriver.get("https://magento.softwaretestingboard.com/");
    }

    public String getUrl() {
        return this.webDriver.getCurrentUrl();
    }

    public void searchForProducts(String searchTerm) {
        webDriver.findElement(By.id("search")).sendKeys(searchTerm, Keys.ENTER);
    }

    public int countSearchResults() {
        List<WebElement> searchResults = webDriver.findElements(By.className("product-item"));
        return searchResults != null ? searchResults.size() : 0;
    }

    public String getErrorText() {
        return webDriver.findElement(By.xpath("//div[contains(@class, 'message') and contains(@class, 'notice')]")).getText();
    }
}