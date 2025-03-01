package org.example.thread.ui.pages.elementspage;

import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends BasePage {
    private final By yesRadioButton = By.cssSelector("label[class='custom-control-label'][for='yesRadio']");
    private final By impressiveRadioButton = By.cssSelector("label[class='custom-control-label'][for='impressiveRadio']");
    private final By noRadioButton = By.cssSelector("label[class='custom-control-label'][for='noRadio']");
    private final By result = By.cssSelector("span[class='text-success']");

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    public void clickYesButton() {
        driver.findElement(yesRadioButton).click();
    }

    public void clickImpressiveRadioButton() {
        driver.findElement(impressiveRadioButton).click();
    }

    public void clickNoRadioButton() {
        driver.findElement(noRadioButton).click();
    }

    public String getResult() {
        return driver.findElement(result).getText();
    }
}
