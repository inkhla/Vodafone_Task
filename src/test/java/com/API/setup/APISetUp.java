package com.API.setup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.*;

public class APISetUp extends RestAssured {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;
    protected static ExtentReports extent;
    protected static ExtentSparkReporter htmlReporter;
    protected static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    static {
        requestSpec = new RequestSpecBuilder().setBaseUri("https://api.publicapis.org").build();
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @BeforeSuite
    public void setUpExtentReport() {
        extent = new ExtentReports();
        htmlReporter = new ExtentSparkReporter("src/test/resources/reports/API_test_report.html");
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void setUp() {
        requestSpec = APISetUp.getRequestSpec();
        responseSpec = APISetUp.getResponseSpec();
    }

    @AfterSuite
    public void tearDownExtentReport() {
        extent.flush();
    }

    public static RequestSpecification getRequestSpec() {
        return requestSpec;
    }

    public static ResponseSpecification getResponseSpec() {
        return responseSpec;
    }

    public ExtentTest extentTest() {
        return extentTestThreadLocal.get();
    }
}
