package com.exaple.tread.ui.elementstests;

import com.exaple.tread.ui.BaseTest;
import org.example.thread.ui.pages.MainPage;
import org.example.thread.ui.pages.elementspage.ButtonsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ButtonsTest extends BaseTest {

    @Test
    public void doubleClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToButtons();
        ButtonsPage buttonsPage = new ButtonsPage(driver);
//        List<WebElement> beforeMessage = buttonsPage.getMessages(buttonsPage.getDOUBLE_CLICK_MESSAGE());
//        Assertions.assertTrue(beforeMessage.isEmpty());

        By locator = buttonsPage.getDOUBLE_CLICK_MESSAGE();
        buttonsPage.doubleClick();
        String message = buttonsPage.getClickMessage(locator);
        Assertions.assertTrue(message.contains("You have done a double click"));

    }
}
