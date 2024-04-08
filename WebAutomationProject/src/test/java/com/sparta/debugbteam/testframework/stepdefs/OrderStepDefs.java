package com.sparta.debugbteam.testframework.stepdefs;

import com.sparta.debugbteam.testframework.lib.pages.BasketPage;
import com.sparta.debugbteam.testframework.lib.pages.CheckoutPage;
import com.sparta.debugbteam.testframework.lib.pages.PaymentPage;
import com.sparta.debugbteam.testframework.lib.pages.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver-win64/chromedriver.exe";
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
//        options.addArguments("--start-maximised");
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
        webDriver.get(BASE_URL);
        productPage = new ProductPage(webDriver);
    }

    @And("I have clicked the consent button order")
    public void iHaveClickedTheConsentButton() {
        WebElement acceptButton = webDriver.findElement(By.className("fc-cta-consent"));
        acceptButton.click();
    }

    @And("I have selected a size")
    public void iHaveSelectedASize() {
        productPage.selectSize();
    }

    @And("I have selected a colour")
    public void iHaveSelectedAColour() {
        productPage.selectColour();
    }

    @And("I have selected a quantity")
    public void iHaveSelectedAQuantity() {
        productPage.selectQuantity("1");
    }

    @And("I have not selected a size")
    public void iHaveNotSelectedASize() {
    }

    @And("I have not selected a colour")
    public void iHaveNotSelectedAColour() {
    }

    @And("I have selected a quantity of zero")
    public void iHaveSelectedAQuantityOfZero() {
        productPage.selectQuantity("0");
    }

    @And("I have not selected a quantity")
    public void iHaveNotSelectedAQuantity() {
        productPage.selectQuantity("");
    }

    @When("I click on to add to basket")
    public void iClickOnToAddToBasket() {
        productPage.addToBasket();
    }

    @Then("I will see the success message")
    public void iWillSeeTheSuccessMessage() {
        MatcherAssert.assertThat(webDriver.findElement(By.className("message-success")).getText(), Matchers.containsString("You added Helios Endurance Tank"));
    }

    @Then("I will see the size failure message")
    public void iWillSeeTheSizeFailureMessage() {
        MatcherAssert.assertThat(webDriver.findElement(By.id("super_attribute[143]-error")).getText(), Matchers.containsString("This is a required field"));
    }

    @Then("I will see the colour failure message")
    public void iWillSeeTheColourFailureMessage() {
        MatcherAssert.assertThat(webDriver.findElement(By.id("super_attribute[93]-error")).getText(), Matchers.containsString("This is a required field"));
    }

    @Then("I will see the zero quantity failure message")
    public void iWillSeeTheZeroQuantityFailureMessage() {
        MatcherAssert.assertThat(webDriver.findElement(By.id("qty-error")).getText(), Matchers.containsString("Please enter a quantity greater than 0."));
    }

    @Then("I will see the empty quantity failure message")
    public void iWillSeeTheEmptyQuantityFailureMessage() {
        MatcherAssert.assertThat(webDriver.findElement(By.id("qty-error")).getText(), Matchers.containsString("Please enter a valid number in this field."));
    }




















//    @Then("The product will be added to my basket")
//    public void theProductWillBeAddedToMyBasket(String message) {
//        MatcherAssert.assertThat(webDriver.findElement(By.className("message-success")).getText(), Matchers.containsString(message));
//        MatcherAssert.assertThat(basketPage.getProductInfo("//b[contains(., 'Helios Endurance Tank')]"), Matchers.containsString("Helios Endurance Tank"));
//    }



//    @Then("Then I will see the message")
//    public void thenWillSeeTheMessage() {
//        MatcherAssert.assertThat(webDriver.findElement(By.className("message-success")).getText(), Matchers.containsString("You added Helios Endurance Tank"));
//    }

    @Then("I will see the {string}")
    public void iWillSeeThe(String message) {
        MatcherAssert.assertThat(webDriver.findElement(By.className("message-success")).getText(), Matchers.containsString("You added Helios Endurance Tank"));
    }

    @Then("I will see the success {string}")
    public void iWillSeeTheSuccess(String arg0) {

    }

    @Then("I will see the failure {string}")
    public void iWillSeeTheFailure(String arg0) {
    }



}
