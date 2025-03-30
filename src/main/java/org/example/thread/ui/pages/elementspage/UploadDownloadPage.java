package org.example.thread.ui.pages.elementspage;

import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadDownloadPage extends BasePage {
    private final By DOWNLOAD_BUTTON = By.id("downloadButton");

    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }

    public void clickDownloadButton() {
        driver.findElement(DOWNLOAD_BUTTON).click();
    }
}
