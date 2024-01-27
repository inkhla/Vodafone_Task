package com.API.tests;

import com.API.setup.APISetUp;
import com.API.setup.ExcelDataProvider;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.Utils.Config.service.DataMapper;
import org.example.api_models.Entries;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RandomTests extends APISetUp {

    @Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "random_test_data", priority = 2)
    public void test_get_random(String endPoint, String queryParam, String queryParamValue) throws JsonProcessingException {
        ExtentTest extentTest = extent.createTest("Test get random with query parameter of: " + queryParam + " and query parameter value of: " + queryParamValue);
        extentTestThreadLocal.set(extentTest);
        Response response = given().spec(requestSpec)
                .contentType(ContentType.JSON).queryParam(queryParam, queryParamValue)
                .when().get(endPoint)
                .then().spec(responseSpec)
                .extract().response();
        extentTest.info("Request sent and get response");
        List<Entries> entriesList = DataMapper.dataMapper(response.getBody().asString());
        extentTest.info("Response mapped successfully");
        try {
            assertEquals(entriesList.size(), 1);
            extentTest.log(Status.PASS, "Entries List contains only one item");
            assertTrue(entriesList.getFirst().getValueOf(queryParam).toLowerCase().contains(queryParamValue.toLowerCase()), "API title doesn't contain the expected value");
            extentTest.log(Status.PASS, "Query data matches the value");

        } catch (Exception e) {
            extentTest.log(Status.FAIL, "API title doesn't contain the expected value, Error: " + e.getMessage());
        }
    }
}
