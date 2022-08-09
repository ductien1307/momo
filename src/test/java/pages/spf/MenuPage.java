package pages.spf;

import utilities.BasePage;

public class MenuPage extends BasePage {

    //public static final String MENU_LBL = "//*[@resource-id='com.deliverynow:id/bottom_tab']//*[contains(@text,'%s')]";
    public static final String MENU_LBL = "//*[@resource-id='com.foody.now.vn.internal:id/bottom_tab']//*[contains(@text,'%s')]";

    public void gotoMenu(String menuName) throws InterruptedException {
        clickOn(xPathDynamic(menuName, MENU_LBL));
    }
}
