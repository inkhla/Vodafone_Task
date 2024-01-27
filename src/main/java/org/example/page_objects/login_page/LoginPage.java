package org.example.page_objects.login_page;

import org.example.page_objects.home_page.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
    }

    private final By username_field = By.id("username");
    private final By password_field = By.id("password");
    private final By go_to_my_account_button = By.id("submitBtn");

    public void setUsername(String username){
        driver.findElement(username_field).sendKeys(username);
    }
    public void setPassword(String password){
        driver.findElement(password_field).sendKeys(password);
    }
    public HomePage clickGoToMyAccountButton(){
        wait.until(ExpectedConditions.elementToBeClickable(go_to_my_account_button)).click();
        return new HomePage(driver);
    }
}
