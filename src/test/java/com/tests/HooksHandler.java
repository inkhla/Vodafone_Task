package com.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HooksHandler {
    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentSparkReporter htmlReporter;
    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();


    @Before
    public void setup(Scenario currentScenario){
        System.setProperty("webdriver.chrome.driver", "resources/WebDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        if (extent == null) {
            extent = new ExtentReports();
            htmlReporter = new ExtentSparkReporter("src/test/resources/reports/UI_test_report.html");
            extent.attachReporter(htmlReporter);
        }
        // Create a new ExtentTest instance for each scenario
        ExtentTest extentTest = extent.createTest(currentScenario.getName());
        extentTestThreadLocal.set(extentTest);
    }

    @After
    public void tearDown(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    @After
    public void tearDownReport(){
        extent.flush();
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public static ExtentReports getExtent(){
        return extent;
    }
    public static ExtentTest getExtentTest() {
        return extentTestThreadLocal.get();
    }
}
