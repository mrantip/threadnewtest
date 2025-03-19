package org.example.thread.ui.pages.elementspage;

import lombok.Getter;
import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Getter
public class ButtonsPage extends BasePage {
    private final By DOUBLE_CLICK_BUTTON = By.id("doubleClickBtn");
    private final By RIGHT_CLICK_BUTTON = By.id("rightClickBtn");
    private final By CLICK_BUTTON = By.id("clickBtn");

    Actions actions = new Actions(driver);

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void doubleClick() {
        WebElement element = driver.findElement(DOUBLE_CLICK_BUTTON);
        actions.doubleClick(element).perform();
    }
}
