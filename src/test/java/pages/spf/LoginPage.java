package pages.spf;

import utilities.BasePage;

public class LoginPage extends BasePage {

    public static final String LOGIN_BTN = "(//*[contains(@text,'Log In')])[2]";

    public void login(String phoneNumber, String password) throws InterruptedException {
        clickOn(xPathDynamic("Log In/Sign Up"));
        clickOn(xPathDynamic("Login with ShopeeFood"));
        clickOn(xPathDynamic("Log In with Password"));
        typeTextTo(xPathDynamic("Email/Username"), phoneNumber);
        typeTextTo(xPathDynamic("Password"), password);
        clickOn(LOGIN_BTN);
        sleep(3);
    }
}
