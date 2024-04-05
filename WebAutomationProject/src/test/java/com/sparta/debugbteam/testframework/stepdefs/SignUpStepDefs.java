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
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;

import static org.hamcrest.Matchers.containsString;

public class SignUpStepDefs {
        private static final String DRIVER_LOCATION = "src/test/resources/chromedriver-win64/chromedriver.exe";
        private static final String BASE_URL = "https://magento.softwaretestingboard.com/customer/account/create/";
        private static ChromeDriverService service;

        private WebDriver webDriver;

        private LoginPage createAccount;

        public static ChromeOptions getChromeOptions() {
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--start-maximized");
            options.addArguments("--headless");
            options.addArguments("--remote-allow-origins=*");
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
            //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @After
        public void afterEach() {
            webDriver.quit();
        }

        @AfterAll
        static void afterAll() {
            service.stop();
        }

        @Given("I am on the create account page")
        public void iAmOnTheCreateAccountPage() {
            webDriver.get(BASE_URL);
            createAccount = new LoginPage(webDriver);
        }

        @When("I enter all valid {string}, {string}, {string} and {string}")
        public void iEnterAllValidAnd(String firstname, String lastname, String email, String password) throws InterruptedException {
        createAccount.signUp(firstname,lastname,email,password);
        }

        @Then("My Account should be successfully created")
        public void myAccountShouldBeSuccessfullyCreated() throws InterruptedException {
            Thread.sleep(2000);
            MatcherAssert.assertThat(webDriver.getTitle(), containsString("My Account"));
        }

}
