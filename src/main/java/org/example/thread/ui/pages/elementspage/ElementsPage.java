package org.example.thread.ui.pages.elementspage;

import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends BasePage {
    private final By textBox = By.xpath("//span[text()='Text Box']");
    private final By checkBox = By.xpath("//span[text()='Check Box']");
    private final By radioButton = By.xpath("//span[text()='Radio Button']");
    private final By webTables = By.xpath("//span[text()='Web Tables']");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void goToTextBox() {
        driver.findElement(textBox).click();
//        return new TextBoxPage(driver);
    }

    public void goToCheckBox() {
        driver.findElement(checkBox).click();
    }

    public void goToRadioButton() {
        driver.findElement(radioButton).click();
    }

    public void goToWebTables() {
        driver.findElement(webTables).click();
    }

}
