package org.example.thread.ui.pages.elementspage;

import lombok.Getter;
import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class CheckBoxPage extends BasePage {
    private final By expandAllButton = By.cssSelector("button[aria-label='Expand all']");
    private final By collapseAllButton = By.cssSelector("button[aria-label='Collapse all']");

    private final By checkList = By.cssSelector("span[class='rct-title']");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public void expandAll() {
        driver.findElement(expandAllButton).click();
    }

    public void collapseAll() {
        driver.findElement(collapseAllButton).click();
    }

    public List<WebElement> getUnfoldList(){
        return driver.findElements(checkList);
    }
}
