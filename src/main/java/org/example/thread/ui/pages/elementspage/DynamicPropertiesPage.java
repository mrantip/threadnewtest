package org.example.thread.ui.pages.elementspage;

import lombok.Getter;
import org.example.thread.ui.pages.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class DynamicPropertiesPage extends BasePage {
    private final By ENABLE_WAIT_BUTTON = By.id("enableAfter");
    private final By COLOR_CHANGE_BUTTON = By.id("colorChange");
    private final By VISIBLE_WAIT_BUTTON = By.id("visibleAfter");

    // Цвета в формате HEX
    private final String INITIAL_COLOR = "#ffffff"; // белый
    private final String CHANGED_COLOR = "#dc3545"; // красный

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }

    // Метод для конвертации RGB/RGBA в HEX
    private String convertRGBToHex(String rgbColor) {
        if (rgbColor.startsWith("rgba")) {
            rgbColor = rgbColor.replace("rgba(", "").replace(")", "");
        } else if (rgbColor.startsWith("rgb")) {
            rgbColor = rgbColor.replace("rgb(", "").replace(")", "");
        }

        String[] colors = rgbColor.split(",");
        int r = Integer.parseInt(colors[0].trim());
        int g = Integer.parseInt(colors[1].trim());
        int b = Integer.parseInt(colors[2].trim());

        return String.format("#%02x%02x%02x", r, g, b);
    }

    public void checkColor() {
        // 2. Получаем кнопку
        WebElement button = driver.findElement(COLOR_CHANGE_BUTTON);
        // 3. Проверяем начальный цвет
        String initialColor = button.getCssValue("color");
        Assertions.assertEquals(convertRGBToHex(initialColor), INITIAL_COLOR,
                "Начальный цвет текста должен быть белым");

        // 4. Ждем изменения цвета (5 секунд)
        wait.until(d -> {
            String currentColor = button.getCssValue("color");
            return convertRGBToHex(currentColor).equalsIgnoreCase(CHANGED_COLOR);
        });

        // 5. Проверяем новый цвет
        String finalColor = button.getCssValue("color");
        Assertions.assertEquals(convertRGBToHex(finalColor), CHANGED_COLOR,
                "Цвет текста должен измениться на #dc3545 через 5 секунд");
    }

}
