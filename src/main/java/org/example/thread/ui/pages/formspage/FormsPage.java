package org.example.thread.ui.pages.formspage;

import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormsPage extends BasePage {
    private final By PRACTICE_FORM = By.xpath("//span[text()='Practice Form']");

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public void goToPracticeForm() {
        driver.findElement(PRACTICE_FORM).click();
    }
}
