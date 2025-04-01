package com.exaple.tread.ui.elementstests;

import com.exaple.tread.ui.BaseTest;
import org.example.thread.ui.pages.MainPage;
import org.example.thread.ui.pages.elementspage.RadioButtonPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioButtonTest extends BaseTest {
    @Test
    public void yesRadioButtonTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToRadioButton();
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.clickYesButton();
        Assertions.assertEquals("Yes", radioButtonPage.getResult());
    }

    @Test
    public void impressiveRadioButtonTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToRadioButton();
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.clickImpressiveRadioButton();
        Assertions.assertEquals("Impressive", radioButtonPage.getResult());
    }

    @Test
    public void noRadioButtonTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToRadioButton();
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.clickNoRadioButton();
        Assertions.assertEquals("No", radioButtonPage.getResult());
    }
}
