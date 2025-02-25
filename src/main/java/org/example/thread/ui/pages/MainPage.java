package org.example.thread.ui.pages;

import org.example.thread.ui.pages.elementspage.ElementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private final By elements = By.xpath("//div[@class='card-body']//h5[text()='Elements']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage goToElements() {
        driver.findElement(elements).click();
        return new ElementsPage(driver);
    }
}
