package com.exaple.tread.ui.elementstests;

import com.exaple.tread.ui.BaseTest;
import org.example.thread.ui.pages.MainPage;
import org.example.thread.ui.pages.elementspage.UploadDownloadPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.await;

public class UploadDownloadTest extends BaseTest {
    private String downloadPath = System.getProperty("user.dir") + "/downloads";
//
//    @BeforeEach
//    public void setUp2() {
//        // Настройка Chrome для скачивания файлов
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new"); // для CI-серверов
//        options.addArguments("--disable-gpu");
//        options.addArguments("--no-sandbox");
//
//        // Указываем папку для скачивания
//        HashMap<String, Object> prefs = new HashMap<>();
//        prefs.put("download.default_directory", downloadPath);
//        prefs.put("download.prompt_for_download", false);
//        options.setExperimentalOption("prefs", prefs);
//
//
//        // Создаем папку для загрузок
//        new File(downloadPath).mkdirs();
//    }

    @Test
    public void uploadTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToElements().goToUploadDownload();
        UploadDownloadPage uploadDownloadPage = new UploadDownloadPage(driver);
        uploadDownloadPage.clickDownloadButton();

        // Ожидаемое имя файла (может быть динамическим)
        String expectedFileName = "sticker.png";
        Path filePath = Paths.get(downloadPath, expectedFileName);

        // Ждем скачивания файла (макс 30 сек)
        await().atMost(30, TimeUnit.SECONDS)
                .until(() -> Files.exists(filePath));

        // Проверяем что файл скачан
        assertThat(Files.exists(filePath))
                .as("Файл %s должен существовать", expectedFileName)
                .isTrue();

    }


//    @AfterEach
//    public void tearDown2() {
//        if (driver != null) {
//            driver.quit();
//        }
//
//        // Очистка скачанных файлов
//        File[] files = new File(downloadPath).listFiles();
//        if (files != null) {
//            for (File file : files) {
//                file.delete();
//            }
//        }
//    }
}
