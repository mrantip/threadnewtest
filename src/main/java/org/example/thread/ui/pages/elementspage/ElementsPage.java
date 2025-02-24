package org.example.thread.ui.pages.elementspage;

import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends BasePage {
    private final By textBox = By.xpath("//span[text()='Text Box']");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void goToTextBox() {
        driver.findElement(textBox).click();
//        return new TextBoxPage(driver);
    }

}
