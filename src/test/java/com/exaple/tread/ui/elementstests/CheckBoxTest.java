package com.exaple.tread.ui.elementstests;

import com.exaple.tread.ui.BaseTest;
import org.example.thread.ui.pages.MainPage;
import org.example.thread.ui.pages.elementspage.CheckBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckBoxTest extends BaseTest {
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
