package org.example.page_objects.product_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage{
    private WebDriver driver;
    private WebDriverWait wait;
    public ProductPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
    }
    private final By add_to_cart_button = By.xpath("//button[@class='add-to-cart']");

    public void clickAddToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(add_to_cart_button)).click();
        wait.until(ExpectedConditions.elementToBeClickable(add_to_cart_button));
        driver.navigate().back();
    }

}