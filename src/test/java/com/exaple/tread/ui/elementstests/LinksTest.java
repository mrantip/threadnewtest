package com.exaple.tread.ui.elementstests;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.BrowserUpProxyServer;
import com.browserup.bup.proxy.CaptureType;
import com.exaple.tread.ui.BaseTest;
import org.example.thread.ui.pages.MainPage;
import org.example.thread.ui.pages.elementspage.LinksPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Proxy;
import com.browserup.bup.client.ClientUtil;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class LinksTest extends BaseTest  {


//    @BeforeEach
//    public void setup() {
//        driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(1920, 1080));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.get("http://85.192.34.140:8081/");
//        DevTools devTools = driver.getDevTools();
//        devTools.createSession();
//        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//

//        requestSent = new CompletableFuture<>();
//        devTools.addListener(Network.requestWillBeSent(), request -> {
//            if (request.getRequest().getUrl().contains(link)) {
//                requestSent.complete(true);
//            }
//        });
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

    @Test
    public void createdLinkTest()  {

        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToLinks();
        LinksPage linksPage = new LinksPage(driver);
        linksPage.goToLink(linksPage.getCREATE_LINK());
        waitForRequest("/api/created", 201, 5);
    }

    @Test
    public void noContentLinkTest()  {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToLinks();
        LinksPage linksPage = new LinksPage(driver);
        linksPage.goToLink(linksPage.getNO_CONTENT_LINK());
        waitForRequest("/api/no-content", 204, 5);
    }

    @Test
    public void movedLinkTest()  {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToLinks();
        LinksPage linksPage = new LinksPage(driver);
        linksPage.goToLink(linksPage.getMOVED_LINK());
        waitForRequest("/api/moved", 301, 5);
    }

    @Test
    public void badRequestLinkTest()  {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToLinks();
        LinksPage linksPage = new LinksPage(driver);
        linksPage.goToLink(linksPage.getBAD_REQUEST_LINK());
        waitForRequest("/api/bad-request", 400, 5);
    }

    @Test
    public void unauthorizedLinkTest()  {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToLinks();
        LinksPage linksPage = new LinksPage(driver);
        linksPage.goToLink(linksPage.getUNAUTHORIZED_LINK());
        waitForRequest("/api/unauthorized", 401, 5);
    }

    @Test
    public void forbiddenLinkTest()  {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToLinks();
        LinksPage linksPage = new LinksPage(driver);
        linksPage.goToLink(linksPage.getFORBIDDEN_LINK());
        waitForRequest("/api/forbidden", 403, 5);
    }

    @Test
    public void invalidUrlLinkTest()  {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToLinks();
        LinksPage linksPage = new LinksPage(driver);
        linksPage.goToLink(linksPage.getNOT_FOUND_LINK());
        waitForRequest("/api/invalid-url", 404, 5);
    }

}
