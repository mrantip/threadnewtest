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

import java.time.Duration;

public class BaseTest {
    protected static final Duration BASE_WAITING = Duration.ofSeconds(30);
    protected WebDriver driver;
    ChromeOptions options = new ChromeOptions();

    @BeforeAll
    public static void downloadDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://85.192.34.140:8081/");
    }

//    @AfterEach
//    public void tearDown() {
//        driver.close();
//    }

    public interface UiTestSetup {
        @BeforeEach
        default void uiSetUp() {
        // Инициализация Selenium
        BrowserUpProxy proxy = new BrowserUpProxyServer();
        proxy.start(0);  // Случайный порт

        // 2. Настройка прокси для Selenium
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        ChromeOptions options = new ChromeOptions();
        options.setProxy(seleniumProxy);
        options.setAcceptInsecureCerts(true);
        }
    }
}
