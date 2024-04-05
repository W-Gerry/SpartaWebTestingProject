package com.sparta.debugbteam.testframework.stepdefs;

import com.sparta.debugbteam.testframework.lib.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class LoginStepDefs {
    private static final String BASE_URL = "https://magento.softwaretestingboard.com/customer/account/login/";
    private LoginPage loginPage;
    private WebDriver webDriver;
    private static ChromeDriverService service;

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
//        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
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


    @Given("the user is on the Luma store login page")
    public void theUserIsOnTheLumaStoreLoginPage() {
    webDriver.get(BASE_URL);
    }

    @When("the user enters invalid username {string} and invalid password {string}")
    public void theUserEntersInvalidUsernameAndInvalidPassword(String arg0, String arg1) {
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String arg0) {
    }

    @And("the user remains on the login page")
    public void theUserRemainsOnTheLoginPage() {
    }

    @When("the user enters valid username {string} and valid password {string}")
    public void theUserEntersValidUsernameAndValidPassword(String arg0, String arg1) {
    }

    @Then("the user should be redirected to the Luma store homepage")
    public void theUserShouldBeRedirectedToTheLumaStoreHomepage() {
    }
}
