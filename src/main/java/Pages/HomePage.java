package Pages;

import Constants.PageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPulseLenta() {
        return driver.findElement(By.cssSelector(PageLocators.PULSE_LENTA_LOCATOR));
    }

    public WebElement getLoginField() {
        return driver.findElement(By.cssSelector(PageLocators.LOGIN_FIELD_LOCATOR));
    }

    public WebElement getEnterPasswordButton() {
        return driver.findElement(By.cssSelector(PageLocators.ENTER_PASSWORD_BUTTON_LOCATOR));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.cssSelector(PageLocators.PASSWORD_FIELD_LOCATOR));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector(PageLocators.LOGIN_BUTTON_LOCATOR));
    }

    public void clickOnEnterPasswordButton() {
        getEnterPasswordButton().click();
        BasePage.waitUntilElementIsVisible(driver, PageLocators.LOGIN_BUTTON_LOCATOR);
    }

    public MailPage clickOnLoginButton() {
        getLoginButton().click();
        BasePage.waitUntilElementIsVisible(driver, PageLocators.CREATE_NEW_MESSAGE_BUTTON_LOCATOR);
        return new MailPage(driver);
    }
}
