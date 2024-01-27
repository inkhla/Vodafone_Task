package org.example.page_objects.home_page;



import org.example.page_objects.cart_page.CartPage;
import org.example.page_objects.login_page.LoginPage;
import org.example.page_objects.product_page.ProductPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor jsExecutor;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        jsExecutor = (JavascriptExecutor) this.driver;
    }

    private final By user_profile = By.id("userProfileMenu");
    private final By search_bar = By.id("searchInput");
    private final By oppo_smart_phone_A78 = By.xpath("//p[normalize-space()='OPPO Smart Phone A78']");
    private final By apple_watch_series8_41mm = By.xpath("//p[contains(normalize-space(),'Apple Watch Series 8 GPS 41mm')]");
    private final By reject_all_cookies_button = By.id("onetrust-reject-all-handler");
    private final By cart = By.xpath("//button[@class='cart-btn']");
    private final By all_products = By.className("product-display-name");

    public LoginPage clickUSerProfileIcon() {
        driver.findElement(user_profile).click();
        return new LoginPage(driver);
    }

    public ProductPage clickOPPOSmartPhoneA78() {
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(oppo_smart_phone_A78));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
        jsExecutor.executeScript("arguments[0].click();", item);
        return new ProductPage(driver);
    }

    public ProductPage clickAppleWatchSeries8() {
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(apple_watch_series8_41mm));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
        jsExecutor.executeScript("arguments[0].click();", item);
        return new ProductPage(driver);
    }

    public ProductPage searchProductFromSearchBar(String product_name) {
        By product = By.xpath("//div[@class='search-results desktop-search-results']//div" +
                "//div[@class='product-result']//p[normalize-space()='" + product_name + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(search_bar)).sendKeys(product_name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(product)).click();
        return new ProductPage(driver);
    }

    public void handleCookiesSettingPopUp() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(reject_all_cookies_button)).click();
        } catch (Exception e) {
            System.out.println(e.getCause() + e.getMessage());
        }
    }

    public CartPage clickCartButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cart)).click();
        return new CartPage(driver);
    }

}