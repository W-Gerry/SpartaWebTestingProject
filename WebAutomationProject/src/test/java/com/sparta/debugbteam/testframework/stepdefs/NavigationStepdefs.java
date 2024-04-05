package com.sparta.debugbteam.testframework.stepdefs;

//import com.sparta.debugbteam.testframework.lib.pages.HomePage;
//import com.sparta.debugbteam.testframework.lib.pages.PastPage;
//import com.sparta.debugbteam.testframework.lib.pages.SearchPage;
//import com.sparta.debugbteam.testframework.lib.pages.LoginPage;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;

public class NavigationStepdefs {

    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver-win64/chromedriver.exe";
    private static final String BASE_URL = "https://news.ycombinator.com/";
    private static ChromeDriverService service;
    private WebDriver webDriver;

//    private HomePage homePage;
//    private PastPage pastPage;
//    private SearchPage searchPage;
//    private LoginPage loginPage;

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


    //---------------------------------------------------------------------------------------------------


    @Given("I am on the Luma website")
    public void iAmOnTheLumaWebsite() {
    }

    // Navigate to the homepage
    @When("I navigate to the homepage")
    public void iNavigateToTheHomepage() {
    }

    @Then("I should see the homepage")
    public void iShouldSeeTheHomepage() {
    }

    // Navigate to the What's New page
    @When("I navigate to the What's New page")
    public void iNavigateToTheWhatSNewPage() {
    }

    @Then("I should see the What's New page")
    public void iShouldSeeTheWhatSNewPage() {
    }

    // Navigate to the Women page
    @When("I navigate to the Women page")
    public void iNavigateToTheWomenPage() {
    }

    @Then("I should see the Women page")
    public void iShouldSeeTheWomenPage() {
    }

    // Navigate to the Men page
    @When("I navigate to the Men page")
    public void iNavigateToTheMenPage() {
    }

    @Then("I should see the Men page")
    public void iShouldSeeTheMenPage() {
    }

    // Navigate to the Gear page
    @When("I navigate to the Gear page")
    public void iNavigateToTheGearPage() {
    }

    @Then("I should see the Gear page")
    public void iShouldSeeTheGearPage() {
    }

    // Navigate to the Training page
    @When("I navigate to the Training page")
    public void iNavigateToTheTrainingPage() {
    }

    @Then("I should see the Training page")
    public void iShouldSeeTheTrainingPage() {
    }

    // Navigate to the Sale page
    @When("I navigate to the Sale page")
    public void iNavigateToTheSalePage() {
    }

    @Then("I should see the Sale page")
    public void iShouldSeeTheSalePage() {
    }
}
