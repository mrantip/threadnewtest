package org.example.thread.ui.pages;

import org.example.thread.ui.pages.elementspage.ElementsPage;
import org.example.thread.ui.pages.formspage.FormsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private final By ELEMENTS = By.xpath("//div[@class='card-body']//h5[text()='Elements']");
    private final By FORMS = By.xpath("//div[@class='card-body']//h5[text()='Forms']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage goToElements() {
        driver.findElement(ELEMENTS).click();
        return new ElementsPage(driver);
    }

    public FormsPage goToForms() {
        driver.findElement(FORMS).click();
        return new FormsPage(driver);
    }
}
