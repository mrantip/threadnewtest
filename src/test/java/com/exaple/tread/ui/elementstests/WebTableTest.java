package com.exaple.tread.ui.elementstests;

import com.exaple.tread.ui.BaseTest;
import org.example.thread.ui.pages.MainPage;
import org.example.thread.ui.pages.elementspage.WebTablesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WebTableTest extends BaseTest {

    @Test
    public void addPersonTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToWebTables();
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.clickAddButton();
        webTablesPage.inputFirstName().inputLastName()
                .inputEmail().inputAge()
                .inputSalary().inputDepartment().clickSubmitButton();

        List<String> tableValues = webTablesPage.getTableRows();

        Assertions.assertTrue(tableValues.contains(webTablesPage.getEmailInput()));
        System.out.println(webTablesPage.getTableRows());
    }

    @Test
    public void changeRowQuantityTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToWebTables();
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        int tableSize = webTablesPage.changeRowsQuantity();
        Assertions.assertEquals(webTablesPage.getTableSize(), tableSize);
    }
}
