package com.sparta.debugbteam.testframework.stepdefs;

import com.sparta.debugbteam.testframework.lib.pages.SearchPage;
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

public class SearchStepDefs {
//    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver-mac-arm64/chromedriver";
            private static final String DRIVER_LOCATION = "src/test/resources/chromedriver-win64/chromedriver.exe";
    private static final String BASE_URL = "https://magento.softwaretestingboard.com/";
    private static ChromeDriverService service;
    private SearchPage searchPage;
    private WebDriver webDriver;

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
        searchPage = new SearchPage(webDriver);
    }

    @After
    public void afterEach() {
        webDriver.quit();
    }

    @AfterAll
    static void afterAll() {
        service.stop();
    }

    @Given("I am on the Magento Software Testing Board website")
    public void iAmOnTheMagentoSoftwareTestingBoardWebsite() {
        searchPage.goToHomePage();
        MatcherAssert.assertThat(searchPage.getUrl(), is(BASE_URL));
    }

    @And("I have clicked the consent button search")
    public void iHaveClickedTheConsentButton() {
        WebElement acceptButton = webDriver.findElement(By.className("fc-cta-consent"));
        acceptButton.click();
    }

    @When("I search for available items")
    public void iSearchForAvailableItems() {
        searchPage.searchForProducts("mens jacket");
        MatcherAssert.assertThat(searchPage.getUrl().endsWith("catalogsearch/result/?q=mens+jacket"), is(true));
    }

    @Then("I should see a list of available items")
    public void iShouldSeeAListOfAvailableItems() {
        MatcherAssert.assertThat(searchPage.countSearchResults() > 0, is(true));
    }

    @When("I search for unavailable items")
    public void iSearchForUnavailableItems() {
        searchPage.goToHomePage();
        searchPage.searchForProducts("rsv123");
    }

    @Then("I should see a message indicating no items found")
    public void iShouldSeeAMessageIndicatingNoItemsFound() {
        MatcherAssert.assertThat(searchPage.getErrorText().contains("Your search returned no results"), is(true));
    }

    @When("I search for items within a specific price range")
    public void iSearchForItemsWithinASpecificPriceRange() {
        searchPage.goToAdvancedSearchPage();
        searchPage.enterPriceRange(50, 75);
    }

    @Then("I should see only items within that price range")
    public void iShouldSeeOnlyItemsWithinThatPriceRange() {
        MatcherAssert.assertThat(searchPage.checkResultsAreInRange(searchPage.getResultPrices(), 50, 75), is(true));
    }
}
