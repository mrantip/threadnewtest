package org.example.thread.ui.pages.elementspage;

import lombok.Getter;
import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class CheckBoxPage extends BasePage {
    private final By expandAllButton = By.cssSelector("button[aria-label='Expand all']");
    private final By collapseAllButton = By.cssSelector("button[aria-label='Collapse all']");

    private final By checkList = By.cssSelector("span[class='rct-title']");
    private final By uncheckedList = By.cssSelector("svg[class='rct-icon rct-icon-uncheck']");
    private final By checkedList = By.cssSelector("svg[class='rct-icon rct-icon-check']");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public List<WebElement> getCheckedList(){
        return driver.findElements(checkedList);
    }

//    public String getTe(){
//        List<WebElement> l = getCheckedList();
//        ArrayList<List> list = new ArrayList<>();
//        for (WebElement webElement : l) {
//            list.add(webElement.findElements(checkList));
//        }
//        return list.get(0).toString();
//    }

    public List<WebElement> getUncheckedList(){
        return driver.findElements(uncheckedList);
    }

    public void checkAll(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(uncheckedList));
        List<WebElement> checkboxes = driver.findElements(uncheckedList);
        checkboxes.get(0).click();
    }

    public void checkRandom() {
        List<WebElement> checkboxes = driver.findElements(uncheckedList);
        Random random = new Random();
        int numberOfCheckboxesToClick = random.nextInt(checkboxes.size()) + 1;
        for (int i = 0; i < numberOfCheckboxesToClick; i++) {
            int randomIndex = random.nextInt(checkboxes.size()); // Случайный индекс
            WebElement checkbox = checkboxes.get(randomIndex);
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

    }
}
