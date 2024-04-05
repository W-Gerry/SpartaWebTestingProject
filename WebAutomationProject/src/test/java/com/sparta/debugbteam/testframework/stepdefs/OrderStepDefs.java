package com.sparta.debugbteam.testframework.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class OrderStepDefs {
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver-win64";
    private static final String BASE_URL = "https://magento.softwaretestingboard.com/helios-endurance-tank.html";
    private  static ChromeDriverService service;
    private WebDriver webDriver;
}
