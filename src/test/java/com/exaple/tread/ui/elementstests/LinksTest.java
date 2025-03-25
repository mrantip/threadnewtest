package com.exaple.tread.ui.elementstests;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.BrowserUpProxyServer;
import com.exaple.tread.ui.BaseTest;
import org.example.thread.ui.pages.MainPage;
import org.example.thread.ui.pages.elementspage.LinksPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Proxy;
import com.browserup.bup.client.ClientUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class LinksTest extends BaseTest implements BaseTest.UiTestSetup {

//    private WebDriver driver;
//    private BrowserUpProxy proxy;
//
//    @BeforeEach
//    public void setup() {
//        // 1. Запуск прокси
//        proxy = new BrowserUpProxyServer();
//        proxy.start(0);  // Случайный порт
//
//        // 2. Настройка прокси для Selenium
//        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//        ChromeOptions options = new ChromeOptions();
//        options.setProxy(seleniumProxy);
//        options.setAcceptInsecureCerts(true);
//
//        driver = new ChromeDriver(options);
//    }

    @Test
    public void simpleLinkTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToLinks();
        LinksPage linksPage = new LinksPage(driver);
        linksPage.goToLink(linksPage.getSIMPLE_LINK());
        // Переключаемся на новую вкладку (последнюю в списке)
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));

        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        Assertions.assertEquals(currentUrl, "http://85.192.34.140:8081/");
        Assertions.assertEquals(title, "ThreadQa");
    }

    @Test
    public void dynamicLinkTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToLinks();
        LinksPage linksPage = new LinksPage(driver);
        linksPage.goToLink(linksPage.getDYNAMIC_LINK());
        // Переключаемся на новую вкладку (последнюю в списке)
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));

        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        Assertions.assertEquals(currentUrl, "http://85.192.34.140:8081/");
        Assertions.assertEquals(title, "ThreadQa");
    }

}
