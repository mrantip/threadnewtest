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


    public List<WebElement> getMessages(By locator) {
        return driver.findElements(locator);
    }


    public String getClickMessage(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100L));
        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return textElement.getText();
//        return driver.findElement(DOUBLE_CLICK_MESSAGE).getText();
    }


    public void performButtonAction(ButtonType buttonType, ActionType actionType) {
        // Получаем локатор кнопки по её типу
        By buttonLocator = getButtonLocator(buttonType);

        // Находим элемент кнопки
        WebElement button = driver.findElement(buttonLocator);

        // Выполняем действие в зависимости от типа
        switch (actionType) {
            case DOUBLE_CLICK:
                actions.doubleClick(button).perform();
                break;
            case RIGHT_CLICK:
                actions.contextClick(button).perform();
                break;
            case LEFT_CLICK:
                button.click();
                break;
            default:
                throw new IllegalArgumentException("Неизвестный тип действия: " + actionType);
        }
    }

    private By getButtonLocator(ButtonType buttonType) {
        // Возвращаем локатор в зависимости от типа кнопки
        return switch (buttonType) {
            case DOUBLE -> DOUBLE_CLICK_BUTTON;
            case RIGHT -> RIGHT_CLICK_BUTTON;
            case LEFT -> CLICK_BUTTON;
            default -> throw new IllegalArgumentException("Неизвестный тип кнопки: " + buttonType);
        };
    }


    // Enum для типов кнопок
    public enum ButtonType {
        DOUBLE, RIGHT, LEFT
    }

    // Enum для типов действий
    public enum ActionType {
        DOUBLE_CLICK, RIGHT_CLICK, LEFT_CLICK
    }
}
