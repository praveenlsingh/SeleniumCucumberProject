package com.example.cucumber;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class stepdefination {
    private WebDriver driver;

    @Before
    public void report(){
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");

        //create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
//creates a toggle for the given test, add all log events under it
        ExtentTest test1 = extent.createTest("Test", "test to validate search box ");
        test1.log(Status.INFO, "Starting test case");
        test1.pass("pass test");
        test1.info("info test");
        extent.flush();


    }

    /******* Google search functionality ******/
    @Given("I am on Google search page")
    public void i_am_on_google_search_page() {
        // Write code here that turns the phrase above into concrete actions
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().driverVersion("120.0.6099.10900").setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        // Write code here that turns the phrase above into concrete actions
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(query);
        element.submit();
    }

    @Then("the page tile should start with {string}")
    public boolean checkTitle(String titleStartsWith) {
        return driver.getTitle().toLowerCase().startsWith(titleStartsWith);
    }


    @After
    public void closebrowser(){
        driver.quit();
    }
}
