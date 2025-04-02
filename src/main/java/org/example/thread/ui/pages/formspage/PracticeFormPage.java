package org.example.thread.ui.pages.formspage;

import com.github.javafaker.Faker;
import org.example.thread.ui.data.Person;
import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeFormPage extends BasePage {
    private final By FIRST_NAME = By.id("firstName");
    private final By LAST_NAME = By.id("lastName");
    private final By EMAIL = By.id("userEmail");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    Faker faker = new Faker();


    public PracticeFormPage inputFirstName() {
        driver.findElement(FIRST_NAME).sendKeys(faker.name().firstName());
        return this;
    }

    public PracticeFormPage inputLastName() {
        driver.findElement(LAST_NAME).sendKeys(faker.name().lastName());
        return this;
    }
}
