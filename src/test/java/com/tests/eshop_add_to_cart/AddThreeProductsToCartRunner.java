package com.tests.eshop_add_to_cart;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/tests/eshop_add_to_cart/AddThreeProductsToCart.feature"
        , glue = "")
public class AddThreeProductsToCartRunner {
}
