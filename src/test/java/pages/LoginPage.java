package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.BasePage;

public class LoginPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @AndroidFindBy(accessibility = "Số điện thoại/TextInput")
    private MobileElement phoneNumberTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Nhập mật khẩu/Input/Typing\"]/android.view.ViewGroup/android.view.ViewGroup[2]")
    private MobileElement passwordTxt;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Khám phá ngay/Button\"]/android.view.ViewGroup")
    private MobileElement exploreNowBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Tiếp tục/Button\"]/android.view.ViewGroup")
    private MobileElement loginBtn;

    @AndroidFindBy(accessibility = "Số điện thoại bạn vừa nhập không hợp lệ. Vui lòng kiểm tra lại/Text")
    private MobileElement errorText;

    public void inputPhoneNumber(String phoneNumber) {
        typeTextTo(phoneNumberTxt, phoneNumber);
    }

    public void inputPassword(String password) {
        typeTextTo(passwordTxt, password);
    }

    public void clickLogin() {
        clickOn(loginBtn);
    }

    public String getErrorText() {
        return getTextOf(errorText);
    }

    public void clickExploreButton() {
        clickOn(exploreNowBtn);
    }
}
