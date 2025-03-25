package org.example.thread.ui.pages.elementspage;

import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends BasePage {
    private final By TEXT_BOX = By.xpath("//span[text()='Text Box']");
    private final By CHECK_BOX = By.xpath("//span[text()='Check Box']");
    private final By RADIO_BUTTON = By.xpath("//span[text()='Radio Button']");
    private final By WEB_TABLES = By.xpath("//span[text()='Web Tables']");
    private final By BUTTONS = By.xpath("//span[text()='Buttons']");
    private final By LINKS = By.xpath("//span[text()='Links']");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void goToTextBox() {
        driver.findElement(TEXT_BOX).click();
//        return new TextBoxPage(driver);
    }

    public void goToCheckBox() {
        driver.findElement(CHECK_BOX).click();
    }

    public void goToRadioButton() {
        driver.findElement(RADIO_BUTTON).click();
    }

    public void goToWebTables() {
        driver.findElement(WEB_TABLES).click();
    }

    public void goToButtons() {
        driver.findElement(BUTTONS).click();
    }

    public void goToLinks() {
        driver.findElement(LINKS).click();
    }

}
