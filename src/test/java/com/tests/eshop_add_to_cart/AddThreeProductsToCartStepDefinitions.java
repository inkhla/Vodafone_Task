package com.tests.eshop_add_to_cart;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.tests.HooksHandler;
import io.cucumber.java.en.*;
import org.example.Utils.Config.PropertiesReader;
import org.example.page_objects.cartPage.CartPage;
import org.example.page_objects.home_page.HomePage;
import org.example.page_objects.login_page.LoginPage;
import org.example.page_objects.product_page.ProductPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class AddThreeProductsToCartStepDefinitions {
    private WebDriver driver;
    private ExtentReports extent;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private String url = "https://eshop.vodafone.com.eg/en";
    private Properties properties;


    public AddThreeProductsToCartStepDefinitions() throws IOException {
        this.driver = HooksHandler.getDriver();
        this.extent = HooksHandler.getExtent();
        this.properties = PropertiesReader.getCred();
    }


    @Given("I am on the eshop vodafone homepage")
    public void i_am_on_the_eshop_vodafone_homepage() {
        driver.get(properties.getProperty("url"));
        HooksHandler.getExtentTest().log(Status.INFO, "Open home page");
    }

    @Given("I log in with valid credentials")
    public void i_log_in_with_valid_credentials() {
        try{
            homePage = new HomePage(driver);
            homePage.handleCookiesSettingPopUp();
            HooksHandler.getExtentTest().info("Cookies rejected in the cookies popup");
            loginPage = homePage.clickUSerProfileIcon();
            HooksHandler.getExtentTest().log(Status.INFO, "Navigate to login page");
            loginPage.setUsername(properties.getProperty("username"));
            HooksHandler.getExtentTest().info("Username entered successfully");
            loginPage.setPassword(properties.getProperty("password"));
            HooksHandler.getExtentTest().info("Password entered successfully");
            loginPage.clickGoToMyAccountButton();
            HooksHandler.getExtentTest().log(Status.INFO,"Login successfull");
        }catch (Exception e){
            HooksHandler.getExtentTest().log(Status.INFO, "An Error occurred: " + e.getCause());
        }
    }

    @When("I select the first item, navigate to its product page, and add it to the cart")
    public void iSelectTheFirstItemNavigateToItsProductPageAndAddItToTheCart() {
        try {
            productPage = homePage.clickOPPOSmartPhoneA78();
            HooksHandler.getExtentTest().info("First product selected");
            productPage.clickAddToCart();
            HooksHandler.getExtentTest().log(Status.PASS, "Product added to cart");
        }catch (Exception e){
            HooksHandler.getExtentTest().log(Status.FAIL,"Ann Error occurred: "+e.getCause());
        }
    }

    @And("I select the second item, navigate to its product page, and add it to the cart")
    public void iSelectTheSecondItemNavigateToItsProductPageAndAddItToTheCart() {
        try{
            productPage = homePage.clickAppleWatchSeries8();
            HooksHandler.getExtentTest().info("Second product selected");
            productPage.clickAddToCart();
            HooksHandler.getExtentTest().log(Status.PASS, "Product added to cart");
        }catch (Exception e){
            HooksHandler.getExtentTest().log(Status.FAIL,"Ann Error occurred: "+e.getCause());
        }
    }

    @Then("the items should be in the cart")
    public void theItemsShouldBeInTheCart() {
        try{
            cartPage = homePage.clickCartButton();
            HooksHandler.getExtentTest().info("Navigate to cart page");
            Assert.assertEquals(cartPage.getCartItemCount(), 2);
            HooksHandler.getExtentTest().log(Status.PASS,"Selected items added to cart successfully");
        }catch (Exception e){
            HooksHandler.getExtentTest().log(Status.FAIL, "Test Fails: " + e.getCause());
        }
    }

    @When("I search for a specific item, navigate to its product page, and add it to the cart")
    public void iSearchForASpecificItemNavigateToItsProductPageAndAddItToTheCart() {
        try{
            productPage = homePage.searchProductFromSearchBar("iPhone 15");
            HooksHandler.getExtentTest().info("Search completed and navigate to product page");
            productPage.clickAddToCart();
            HooksHandler.getExtentTest().log(Status.PASS,"Product added to cart");
        }catch (Exception e){
            HooksHandler.getExtentTest().log(Status.FAIL,"An error occurred: "+ e.getCause());
        }
    }

    @Then("the item should be in the cart")
    public void theItemShouldBeInTheCart() {
        try{
            cartPage = homePage.clickCartButton();
            HooksHandler.getExtentTest().info("Navigate to cart page");
            Assert.assertEquals(cartPage.getCartItemCount(),3);
            HooksHandler.getExtentTest().log(Status.PASS,"Selected Items added to cart successfully");
        }catch (Exception e){
            HooksHandler.getExtentTest().log(Status.FAIL, "Test Fails: " + e.getCause());
        }
    }
}
