package org.example.thread.ui.pages.elementspage;

import lombok.Getter;
import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class LinksPage extends BasePage {
    private final By SIMPLE_LINK = By.id("simpleLink");
    private final By DYNAMIC_LINK = By.id("dynamicLink");
    private final By CREATE_LINK = By.id("created");
    private final By NO_CONTENT_LINK = By.id("no-content");
    private final By MOVED_LINK = By.id("moved");
    private final By BAD_REQUEST_LINK = By.id("bad-request");
    private final By UNAUTHORIZED_LINK = By.id("unauthorized");
    private final By FORBIDDEN_LINK = By.id("forbidden");
    private final By NOT_FOUND_LINK = By.id("invalid-url");

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    public void goToLink(By locator) {
        driver.findElement(locator).click();
    }


    // Enum для типов кнопок
    public enum LinkType {
        SIMPLE, DYNAMIC, CREATED, NO_CONTENT, MOVED, BAD_REQUEST, UNAUTHORIZED, FORBIDDEN, NOT_FOUND
    }
}
