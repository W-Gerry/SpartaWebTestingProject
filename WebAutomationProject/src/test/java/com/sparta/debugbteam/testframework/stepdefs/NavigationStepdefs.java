package com.sparta.debugbteam.testframework.stepdefs;

import com.sparta.debugbteam.testframework.lib.pages.*;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;

public class NavigationStepdefs {

    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver-win64/chromedriver.exe";
    private static final String BASE_URL = "https://magento.softwaretestingboard.com/";
    private static ChromeDriverService service;

    private WebDriver webDriver;
    private Page currentPage;
    private HomePage homePage;

    public NavigationStepdefs(WebDriver webDriver, Page currentPage, HomePage homePage) {
        this.webDriver = webDriver;
        this.currentPage = currentPage;
        this.homePage = homePage;
    }


    public NavigationStepdefs() {
    }

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
    //Navigate to pages on the Luma Website from the homepage
    @Given("I am on the Luma website")
    public void iAmOnTheLumaWebsite() {
        webDriver.get(BASE_URL);
        homePage = new HomePage(webDriver);
        currentPage = new HomePage(webDriver);
    }

    @And("I have accepted the cookie policy")
    public void iHaveAcceptedTheCookiePolicy() {
            WebElement acceptButton = webDriver.findElement(By.className("fc-cta-consent"));
            acceptButton.click();
    }



    // Navigate to the What's New page
    @When("I navigate to the What's New page")
    public void iNavigateToTheWhatSNewPage() {
        currentPage = homePage.goToWhatsNewPage();
    }

    @Then("I should see the What's New page")
    public void iShouldSeeTheWhatSNewPage() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), Matchers.equalTo(BASE_URL + "what-is-new.html"));
    }

    // Navigate to the Women page
    @When("I navigate to the Women page")
    public void iNavigateToTheWomenPage() {
        WomenShopPage womenShopPage = homePage.goToWomenShopPage();
    }

    @Then("I should see the Women page")
    public void iShouldSeeTheWomenPage() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), Matchers.equalTo(BASE_URL + "women.html"));
    }

    // Navigate to the Men page
    @When("I navigate to the Men page")
    public void iNavigateToTheMenPage() {
        MenShopPage menShopPage = homePage.goToMenShopPage();
    }

    @Then("I should see the Men page")
    public void iShouldSeeTheMenPage() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), Matchers.equalTo(BASE_URL + "men.html"));
    }

    // Navigate to the Gear page
    @When("I navigate to the Gear page")
    public void iNavigateToTheGearPage() {
        GearShopPage gearShopPage = homePage.goToGearShopPage();
    }

    @Then("I should see the Gear page")
    public void iShouldSeeTheGearPage() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), Matchers.equalTo(BASE_URL + "gear.html"));
    }

    // Navigate to the Training page
    @When("I navigate to the Training page")
    public void iNavigateToTheTrainingPage() {
        TrainingShopPage trainingShopPage = homePage.goToTrainingShopPage();
    }

    @Then("I should see the Training page")
    public void iShouldSeeTheTrainingPage() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), Matchers.equalTo(BASE_URL + "training.html"));
    }

    // Navigate to the Sale page
    @When("I navigate to the Sale page")
    public void iNavigateToTheSalePage() {
        currentPage = homePage.goToSalePage();
    }

    @Then("I should see the Sale page")
    public void iShouldSeeTheSalePage() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), Matchers.equalTo(BASE_URL + "sale.html"));
    }


    //---------------------------------------------------------------------------------------------------
    //Navigate to the Luma homepage from pages on the website
    @Given("I am on the What's New page")
    public void iAmOnTheWhatSNewPage() {
        webDriver.get(BASE_URL + "what-is-new.html");
        currentPage = new WhatsNewPage(webDriver);
    }

    @Given("I am on the Women's shop page")
    public void iAmOnTheWomenSShopPage() {
        webDriver.get(BASE_URL + "women.html");
        currentPage = new WomenShopPage(webDriver);
    }

    @Given("I am on the Men's shop page")
    public void iAmOnTheMenSShopPage() {
        webDriver.get(BASE_URL + "men.html");
        currentPage = new MenShopPage(webDriver);
    }

    @Given("I am on the Gear shop page")
    public void iAmOnTheGearShopPage() {
        webDriver.get(BASE_URL + "gear.html");
        currentPage = new GearShopPage(webDriver);
    }

    @Given("I am on the Training shop page")
    public void iAmOnTheTrainingShopPage() {
        webDriver.get(BASE_URL + "training.html");
        currentPage = new TrainingShopPage(webDriver);
    }

    @Given("I am on the Sale shop page")
    public void iAmOnTheSaleShopPage() {
        webDriver.get(BASE_URL + "sale.html");
        currentPage = new SalePage(webDriver);
    }

    @When("I click on the Luma logo")
    public void iClickOnTheLumaLogo() {
        currentPage.goToHomePage();
    }

    @Then("I should be taken to the Luma homepage")
    public void iShouldBeTakenToTheLumaHomepage() {
        MatcherAssert.assertThat(webDriver.getCurrentUrl(), Matchers.equalTo(BASE_URL));
    }

}
