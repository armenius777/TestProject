import Constants.ErrorMessages;
import Constants.PageConstants;
import Constants.PageLocators;
import Pages.BasePage;
import Pages.HomePage;
import Pages.MailPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoginAndSendMailTest {

    private WebDriver driver;
    private HomePage homePage;
    private MailPage mailPage;

    @BeforeClass
    public void openSite() {
        this.driver = BasePage.createDriver();
        driver.get(PageConstants.SITE_URL);
        BasePage.waitUntilElementIsVisible(driver, PageLocators.PULSE_LENTA_LOCATOR);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void closeBrowser() {
        BasePage.closeWebDriver(driver);
    }

    @Test (description = "Login to email", priority = 1)
    public void verifyThatUserIsLoggedIn() {
        SoftAssert softAssert = new SoftAssert();
        homePage.getLoginField().sendKeys(PageConstants.USERNAME);
        homePage.clickOnEnterPasswordButton();
        softAssert.assertTrue(homePage.getLoginButton().isDisplayed(),
                ErrorMessages.LOGIN_BUTTON_IS_MISSING);
        homePage.getPasswordField().sendKeys(PageConstants.PASSWORD);
        mailPage = homePage.clickOnLoginButton();
        Assert.assertTrue(mailPage.getNewMessageButton().isDisplayed(),
                ErrorMessages.USER_IS_NOT_LOGGED_IN);
        softAssert.assertAll();
    }

    @Test (description = "Send a new email message", priority = 2, dependsOnMethods = "verifyThatUserIsLoggedIn")
    public void verifyThatUserEmailIsSended() throws AWTException {
        SoftAssert softAssert = new SoftAssert();
        mailPage.getNewMessageButton().click();
        BasePage.waitUntilElementIsVisible(driver, PageLocators.NEW_MESSAGE_WINDOW_LOCATOR);
        softAssert.assertTrue(mailPage.getNewMessageWindow().isDisplayed(),
                ErrorMessages.NEW_MESSAGE_WINDOW_IS_MISSING);
        mailPage.getAddressField().sendKeys(PageConstants.DELIVER_MAIL);
        mailPage.getSubjectField().sendKeys(PageConstants.SUBJECT_TEXT);
        mailPage.getMessageBody().click();
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_T);
        rb.keyRelease(KeyEvent.VK_T);
        rb.keyPress(KeyEvent.VK_E);
        rb.keyRelease(KeyEvent.VK_E);
        rb.keyPress(KeyEvent.VK_S);
        rb.keyRelease(KeyEvent.VK_S);
        rb.keyPress(KeyEvent.VK_T);
        rb.keyRelease(KeyEvent.VK_T);
        mailPage.getSendMessageButton().click();
        BasePage.waitUntilElementIsVisible(driver, PageLocators.CONFIRMATION_MESSAGE_LOCATOR);
        softAssert.assertTrue(mailPage.getConfirmationMessage().isDisplayed(),
                ErrorMessages.CONFIRMATION_MESSAGE_IS_MISSING);
        softAssert.assertEquals(mailPage.getConfirmationMessage().getText(), PageConstants.CONFIRMATION_MESSAGE_TEXT,
                ErrorMessages.CONFIRMATION_MESSAGE_IS_INCORRECT);
        softAssert.assertAll();
    }

}
