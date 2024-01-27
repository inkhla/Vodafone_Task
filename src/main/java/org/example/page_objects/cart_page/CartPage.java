package org.example.page_objects.cart_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public CartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
    }
    private final By order_summary = By.xpath("//div[@class='cart']//h3");
    private final By items_card = By.className("cart-card-container");

    public int getCartItemCount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(order_summary));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(items_card)).size();
    }
}
