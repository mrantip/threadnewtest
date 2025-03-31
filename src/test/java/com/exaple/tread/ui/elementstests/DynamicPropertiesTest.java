package com.exaple.tread.ui.elementstests;

import com.exaple.tread.ui.BaseTest;
import org.example.thread.ui.pages.MainPage;
import org.example.thread.ui.pages.elementspage.DynamicPropertiesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicPropertiesTest extends BaseTest {

    @Test
    public void enableIn5secondsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToDynamicProperties();
        DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage(driver);
        // Проверка начального состояния
        WebElement button = driver.findElement(dynamicPropertiesPage.getENABLE_WAIT_BUTTON());
        Assertions.assertFalse(button.isEnabled());

        // Замер времени активации
        long startTime = System.currentTimeMillis();

        // Ожидаем активации
        wait.until(ExpectedConditions.elementToBeClickable(dynamicPropertiesPage.getENABLE_WAIT_BUTTON()));

        long endTime = System.currentTimeMillis();
        long activationTime = (endTime - startTime) / 1000;

        // Проверяем что активация произошла примерно через 5 секунд (±1 сек)
        Assertions.assertTrue(activationTime >= 5 && activationTime <= 6,
                "Активация должна произойти через ~5 секунд. Фактическое время: " + activationTime + "s");

        // Проверяем кликабельность
        Assertions.assertTrue(button.isEnabled());
    }

    @Test
    public void changeColorTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToDynamicProperties();
        DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage(driver);

        dynamicPropertiesPage.checkColor();
    }
}
