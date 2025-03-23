package org.example.thread.ui.pages.elementspage;

import lombok.Getter;
import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Getter
public class ButtonsPage extends BasePage {
    private final By DOUBLE_CLICK_BUTTON = By.id("doubleClickBtn");
    private final By RIGHT_CLICK_BUTTON = By.id("rightClickBtn");
    private final By CLICK_BUTTON = By.xpath("//button[text()='Click Me']");
    private final By DOUBLE_CLICK_MESSAGE= By.id("doubleClickMessage");
    private final By RIGHT_CLICK_MESSAGE= By.id("rightClickMessage");
    private final By CLICK_BUTTON_MESSAGE= By.id("dynamicClickMessage");

    Actions actions = new Actions(driver);

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void doubleClick() {
        WebElement element = driver.findElement(DOUBLE_CLICK_BUTTON);
        actions.doubleClick(element).perform();
    }

    public void rightClick() {
        WebElement element = driver.findElement(RIGHT_CLICK_BUTTON);
        actions.contextClick(element).perform();
    }

    public void clickButton() {
        WebElement element = driver.findElement(CLICK_BUTTON);
        actions.click(element).perform();
    }

    public void clickAny(String button, String clickType) {
        WebElement element;
        if (button.equals("doubleClick")) {
            element = driver.findElement(DOUBLE_CLICK_BUTTON);
        }
        if (button.equals("rightClick")) {
            element = driver.findElement(RIGHT_CLICK_BUTTON);
        }
        if (button.equals("clickButton")) {
            element = driver.findElement(CLICK_BUTTON);
        }
        if (clickType.equals("doubleClick")) {
            actions.doubleClick(element).perform();
        }
    }

    public List<WebElement> getMessages(By locator) {
        return driver.findElements(locator);
    }


    public String getClickMessage(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100L));
        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return textElement.getText();
//        return driver.findElement(DOUBLE_CLICK_MESSAGE).getText();
    }
}
