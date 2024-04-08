package com.sparta.debugbteam.testframework.lib.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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

    public void enterPriceRange(int min, int max) {
        webDriver.findElement(By.id("price")).sendKeys(Integer.toString(min));
        webDriver.findElement(By.id("price_to")).sendKeys(Integer.toString(max), Keys.ENTER);
//        webDriver.findElement(By.xpath("//button[contains(@class, 'action') and contains(@class, 'search')]")).click();
    }

    public void goToAdvancedSearchPage() {
        this.webDriver.get("https://magento.softwaretestingboard.com/catalogsearch/advanced/");
    }

    public List<Integer> getResultPrices() {
        List<WebElement> resultPriceTags = webDriver.findElements(By.className("price"));
        ArrayList<Integer> formattedPrices = new ArrayList<>();
        for (WebElement priceTag : resultPriceTags) {
            String priceText = priceTag.getText().replace("$", "").trim();
            if (!priceText.isEmpty()) {
                // Assuming prices are formatted like "$74.00"
                double price = Double.parseDouble(priceText);
                formattedPrices.add((int) price);
            }
        }
        return formattedPrices;
    }

    public boolean checkResultsAreInRange(List<Integer> prices, int min, int max) {
        return prices.stream().allMatch(price -> price >= min && price <= max);
    }
}