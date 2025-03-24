package com.exaple.tread.ui.elementstests;

import com.exaple.tread.ui.BaseTest;
import org.example.thread.ui.pages.MainPage;
import org.example.thread.ui.pages.elementspage.ButtonsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    @Test
    public void rightClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToButtons();
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        By locator = buttonsPage.getRIGHT_CLICK_MESSAGE();
        buttonsPage.rightClick();
        String message = buttonsPage.getClickMessage(locator);
        Assertions.assertTrue(message.contains("You have done a right click"));
    }

    @Test
    public void leftClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToButtons();
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        By locator = buttonsPage.getCLICK_BUTTON_MESSAGE();
        buttonsPage.clickButton();
        String message = buttonsPage.getClickMessage(locator);
        Assertions.assertTrue(message.contains("You have done a dynamic click"));
    }

    @Test
    public void negativeDoubleClickTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToButtons();
        ButtonsPage buttonsPage = new ButtonsPage(driver);

        buttonsPage.performButtonAction(ButtonsPage.ButtonType.DOUBLE, ButtonsPage.ActionType.RIGHT_CLICK);

        List<WebElement> Message = buttonsPage.getMessages(buttonsPage.getDOUBLE_CLICK_MESSAGE());
        Assertions.assertTrue(Message.isEmpty());
    }
}
