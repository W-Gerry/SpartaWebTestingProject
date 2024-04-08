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
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.is;

public class LoginStepDefs {
    //private static final String DRIVER_LOCATION = "src/test/resources/chromedriver-mac-arm64/chromedriver";
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver-win64/chromedriver.exe";
    private static final String BASE_URL = "https://magento.softwaretestingboard.com/customer/account/login/";
    private WebDriver webDriver;
    private LoginPage loginPage;
    private static ChromeDriverService service;

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
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

    @Given("The user is on the Luma store login page")
    public void theUserIsOnTheLumaStoreLoginPage() throws InterruptedException {
        webDriver.get(BASE_URL);
        loginPage = new LoginPage(webDriver);

    }


    @When("The user enters invalid username {string} and invalid password {string}")
    public void theUserEntersInvalidUsernameAndInvalidPassword(String invalidUsername, String invalidPassword) throws InterruptedException {

        loginPage.login(invalidUsername, invalidPassword);
    }

    @And("The user clicks the login button")
    public void theUserClicksTheLoginButton() {
//        loginPage.clickLoginBtn();
    }

    @Then("An error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String arg0) throws InterruptedException {
        Thread.sleep(2000);
        MatcherAssert.assertThat(loginPage.isEmailInvalid() || loginPage.isPasswordInvalid(), is(true));
    }

    @And("The user remains on the login page")
    public void theUserRemainsOnTheLoginPage() {
        MatcherAssert.assertThat(loginPage.getUrl().contains(BASE_URL), is(true));
    }

    @When("The user enters valid username {string} and valid password {string}")
    public void theUserEntersValidUsernameAndValidPassword(String arg0, String arg1) throws InterruptedException {
        loginPage = new LoginPage(webDriver);
        loginPage.login("testaccount@mail.com", "Password1!");
    }

    @Then("The user should be redirected to the Luma store homepage")
    public void theUserShouldBeRedirectedToTheLumaStoreHomepage() {
        MatcherAssert.assertThat(loginPage.checkLoginIsValid(), is(true));
    }

    @And("I have clicked the consent button login")
    public void iHaveClickedTheConsentButton() throws InterruptedException {
        Thread.sleep(500);
        WebElement acceptButton = webDriver.findElement(By.className("fc-primary-button"));
        acceptButton.click();
    }


}
