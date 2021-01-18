package Constants;

public class PageLocators {

    //Home page locators
    public static final String PULSE_LENTA_LOCATOR = "div[class*=\"pulse-lenta-layout\"]";
    public static final String LOGIN_FIELD_LOCATOR = "input[class*=\"email-input\"]";
    public static final String ENTER_PASSWORD_BUTTON_LOCATOR = "button[class^=\"button\"]";
    public static final String PASSWORD_FIELD_LOCATOR = "input[name=\"password\"]";
    public static final String LOGIN_BUTTON_LOCATOR = "button[class^=\"second-button\"]";

    //mail page locators
    public static final String CREATE_NEW_MESSAGE_BUTTON_LOCATOR = "div[class=\"sidebar__header\"] a[href*=\"compose\"]";
    public static final String NEW_MESSAGE_WINDOW_LOCATOR = "div[class*=\"compose-app_popup\"]";
    public static final String NEW_MESSAGE_ADDRESS_FIELD_LOCATOR = "div[class*=\"contactsContainer\"] input";
    public static final String NEW_MESSAGE_SUBJECT_FIELD_LOCATOR = "div[class*=\"subject__container\"] input";
    public static final String NEW_MESSAGE_BODY_LOCATOR = "div[class*=\"editor_container\"] div[class*=\"editable-container\"]>div>div:nth-child(1)";
    public static final String SEND_MESSAGE_BUTTON_LOCATOR = "div[class*=\"compose-app__footer\"] span[class*=\"button2_primary\"]>span";
    public static final String CONFIRMATION_MESSAGE_LOCATOR = "div[class=\"layer__header\"]>a[class=\"layer__link\"]";

}
