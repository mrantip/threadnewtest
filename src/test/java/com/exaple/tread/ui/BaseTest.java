package com.exaple.tread.ui;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.BrowserUpProxyServer;
import com.browserup.bup.client.ClientUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v133.network.Network;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.CompletableFuture;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static final Duration BASE_WAITING = Duration.ofSeconds(30);
    protected WebDriver driver;
    protected DevTools devTools;
    ChromeOptions options = new ChromeOptions();
    private String downloadPath = System.getProperty("user.dir") + "/downloads";
    protected WebDriverWait wait;

    @BeforeAll
    public static void downloadDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://85.192.34.140:8081/");
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
    }

//    @AfterEach
//    public void tearDown() {
//    if (devTools != null) {
//        devTools.close();
//    }
//        if (driver != null) {
//        driver.quit();
//    }
//        driver.close();
//    }

    protected void waitForRequest(String urlPart, int expectedStatus, long timeoutSeconds) {
        CompletableFuture<Boolean> requestFuture = new CompletableFuture<>();

        devTools.addListener(Network.responseReceived(), response -> {
            if (response.getResponse().getUrl().contains(urlPart)
                    && response.getResponse().getStatus() == expectedStatus) {
                requestFuture.complete(true);
            }
        });

        try {
            requestFuture.get(timeoutSeconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new AssertionError("Request not received within timeout", e);
        }
    }

}
