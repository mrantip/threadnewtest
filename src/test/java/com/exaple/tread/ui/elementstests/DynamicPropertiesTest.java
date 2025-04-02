package com.exaple.tread.ui.elementstests;

import com.exaple.tread.ui.BaseTest;
import org.example.thread.ui.pages.MainPage;
import org.example.thread.ui.pages.elementspage.DynamicPropertiesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

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

    @Test
    public void visibleButtonAfter5SecTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToDynamicProperties();
        DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage(driver);

        // 2. Мгновенная проверка отсутствия кнопки (без ожидания)
        try {
            // Проверяем отсутствие элемента без неявного ожидания
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); // Отключаем неявное ожидание
            Assertions.assertTrue(driver.findElements(dynamicPropertiesPage.getVISIBLE_WAIT_BUTTON()).isEmpty(),
                    "Кнопка не должна присутствовать при загрузке страницы");
        } finally {
            // Восстанавливаем неявное ожидание
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //Assertions.assertTrue(driver.findElements(dynamicPropertiesPage.getVISIBLE_WAIT_BUTTON()).isEmpty());
        }

        // 3. Ждем появления кнопки (5 секунд)
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(dynamicPropertiesPage.getVISIBLE_WAIT_BUTTON()));

        // 4. Проверяем, что кнопка стала видимой
        wait.until(ExpectedConditions.visibilityOf(button));
        Assertions.assertTrue(button.isDisplayed(), "Кнопка должна быть видимой через 5 секунд");
    }
}
