package com.exaple.tread.ui.practiceformtests;

import com.exaple.tread.ui.BaseTest;
import org.example.thread.ui.pages.MainPage;
import org.example.thread.ui.pages.formspage.PracticeFormPage;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends BaseTest {

    @Test
    public void testPracticeForm() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToForms().goToPracticeForm();
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);

        practiceFormPage.inputFirstName().inputLastName();
    }
}
