package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static utils.DriverManager.os;

public class BasePage {
    private static final Logger logger = LogManager.getLogger(BasePage.class);
    WebDriverWait wait;
    AppiumDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 20);
    }

    public void clickOn(MobileElement element) {
        logger.info("click to " + element.toString());
        waitUntilElementVisiable(element);
        element.click();

    }

    public void typeTextTo(MobileElement element, String text) {
        logger.info("type text " + text + " to " + element.toString());
        waitUntilElementVisiable(element);
        element.clear();
        element.sendKeys(text);

    }

    public void clickOn(By by) {
        driver.findElement(by).click();

    }

    public boolean elementDisplayed(String text) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        if (strage.contains("id")){
//            return driver.findElementByAccessibilityId(text).isDisplayed();
//        }
//        else
//        return driver.findElement(MobileBy.iOSNsPredicateString()).isDisplayed();
        return driver.findElementByAccessibilityId(text).isDisplayed();
    }

    public String getTextOf(MobileElement element) {
        logger.info("get text of OS: " + os);
        waitUntilElementVisiable(element);
        String value = null;
        if (os.contains("android")) {
            value = element.getText();
        } else value = element.getAttribute("label");

        logger.info("text of element " + element + " is:" + value);
        return value;

    }

    private void waitUntilElementVisiable(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElementIos(MobileElement parent, String label) {
        Map<String, Object> args = new HashMap<>();
        args.put("element", parent.getId());
//        args.put("predicateString", "label == \"" + label + "\"");
        String value = "label == \"%s\"";
        args.put("predicateString", String.format(value, label));
        args.put("toVisible", true);
        args.put("direction", "down");
        driver.executeScript("mobile: scroll", args);
    }

}
