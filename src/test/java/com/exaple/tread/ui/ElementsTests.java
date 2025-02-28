package com.exaple.tread.ui;

import org.example.thread.ui.pages.MainPage;
import org.example.thread.ui.pages.elementspage.CheckBoxPage;
import org.example.thread.ui.pages.elementspage.ElementsPage;
import org.example.thread.ui.pages.elementspage.TextBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsTests extends BaseTest{


    @Test
    public void positiveFillTextBoxTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToTextBox();
//        ElementsPage elementsPage = new ElementsPage(driver);
//        elementsPage.goToTextBox();
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.fillFullName()
                .fillEmail().fillCurrentAddress()
                .fillPermanentAddress().submitButton();
        Assertions.assertTrue(textBoxPage.getNameResult().contains(textBoxPage.getInputName()));
        Assertions.assertTrue(textBoxPage.getEmailResult().contains(textBoxPage.getInputEmail()));
        Assertions.assertTrue(textBoxPage.getCurrentAddressResult().contains(textBoxPage.getInputCurrentAddress()));
        Assertions.assertTrue(textBoxPage.getPermanentAddressResult().contains(textBoxPage.getInputPermanentAddress()));
    }

    @Test
    public void negativeFillTextBoxTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToTextBox();
//        ElementsPage elementsPage = new ElementsPage(driver);
//        elementsPage.goToTextBox();
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.fillFullName().fillWrongEmail().fillCurrentAddress()
                .fillPermanentAddress().submitButton();
        Assertions.assertTrue(textBoxPage.getElements().isEmpty());
    }

    @Test
    public void expandAllTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToCheckBox();
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.expandAll();
        Assertions.assertEquals(17, checkBoxPage.getUnfoldList().size());
    }

    @Test
    public void collapseAllTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToCheckBox();
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.expandAll();
        Assertions.assertEquals(17, checkBoxPage.getUnfoldList().size());
        checkBoxPage.collapseAll();
        Assertions.assertEquals(1, checkBoxPage.getUnfoldList().size());
    }

    @Test
    public void checkAllTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToCheckBox();
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.expandAll();
        checkBoxPage.checkAll();
        Assertions.assertIterableEquals(checkBoxPage.getUnfoldListText(), checkBoxPage.getResultListText());

    }

    @Test
    public void randomCheckTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToCheckBox();
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.expandAll();
        checkBoxPage.checkRandom();
    }
}
