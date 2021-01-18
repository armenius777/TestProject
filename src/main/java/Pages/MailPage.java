package Pages;

import Constants.PageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailPage extends BasePage{

    private WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewMessageButton() {
        return driver.findElement(By.cssSelector(PageLocators.CREATE_NEW_MESSAGE_BUTTON_LOCATOR));
    }

    public WebElement getNewMessageWindow() {
        return driver.findElement(By.cssSelector(PageLocators.NEW_MESSAGE_WINDOW_LOCATOR));
    }

    public WebElement getAddressField() {
        return driver.findElement(By.cssSelector(PageLocators.NEW_MESSAGE_ADDRESS_FIELD_LOCATOR));
    }

    public WebElement getSubjectField() {
        return driver.findElement(By.cssSelector(PageLocators.NEW_MESSAGE_SUBJECT_FIELD_LOCATOR));
    }

    public WebElement getMessageBody() {
        return driver.findElement(By.cssSelector(PageLocators.NEW_MESSAGE_BODY_LOCATOR));
    }

    public WebElement getSendMessageButton() {
        return driver.findElement(By.cssSelector(PageLocators.SEND_MESSAGE_BUTTON_LOCATOR));
    }

    public WebElement getConfirmationMessage() {
        return driver.findElement(By.cssSelector(PageLocators.CONFIRMATION_MESSAGE_LOCATOR));
    }

}
