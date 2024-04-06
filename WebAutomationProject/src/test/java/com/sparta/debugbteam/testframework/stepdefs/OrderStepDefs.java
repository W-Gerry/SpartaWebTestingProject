package com.sparta.debugbteam.testframework.stepdefs;

import com.sparta.debugbteam.testframework.lib.pages.BasketPage;
import com.sparta.debugbteam.testframework.lib.pages.CheckoutPage;
import com.sparta.debugbteam.testframework.lib.pages.PaymentPage;
import com.sparta.debugbteam.testframework.lib.pages.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class OrderStepDefs {
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver-win64";
    private static final String BASE_URL = "https://magento.softwaretestingboard.com/helios-endurance-tank.html";
    private  static ChromeDriverService service;
    private WebDriver webDriver;

    private ProductPage productPage;
    private BasketPage basketPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));

        return options;
    }

    @BeforeAll
    public static void beforeAll() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(DRIVER_LOCATION))
                .usingAnyFreePort()
                .build();
        service.start();
    }
    @Before
    public void setup() {
        webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
    }
    @After
    public void afterEach() {
        webDriver.quit();
    }
    @AfterAll
    static void afterAll() {
        service.stop();
    }

    /// TESTS ///
    @Given("I am on a Product page")
    public void iAmOnAProductPage() {
    }

    @And("I have selected a size")
    public void iHaveSelectedASize() {
    }

    @And("I have selected a colour")
    public void iHaveSelectedAColour() {
    }

    @And("I have selected a valid quantity")
    public void iHaveSelectedAValidQuantity() {
    }

    @When("I click on to add to basket")
    public void iClickOnToAddToBasket() {
    }

    @Then("The product will be added to my basket")
    public void theProductWillBeAddedToMyBasket() {
    }
}