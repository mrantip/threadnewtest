package org.example.thread.ui.pages.formspage;

import com.github.javafaker.Faker;
import lombok.Getter;
import org.example.thread.ui.data.Person;
import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class PracticeFormPage extends BasePage {
    private final By FIRST_NAME = By.id("firstName");
    private final By LAST_NAME = By.id("lastName");
    private final By EMAIL = By.id("userEmail");
    private final By MOBILE = By.id("userNumber");
    private final By CURRENT_ADDRESS = By.id("currentAddress");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    Faker faker = new Faker();

    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String email = faker.internet().emailAddress();
    private String mobileNumber = faker.phoneNumber().cellPhone();
    private String currentAddress = faker.address().fullAddress();


    public PracticeFormPage inputFirstName() {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        return this;
    }

    public PracticeFormPage inputLastName() {
        driver.findElement(LAST_NAME).sendKeys(lastName);
        return this;
    }

    public PracticeFormPage inputEmail() {
        driver.findElement(EMAIL).sendKeys(email);
        return this;
    }

    public PracticeFormPage inputMobileNumber() {
        driver.findElement(MOBILE).sendKeys(mobileNumber);
        return this;
    }

    public PracticeFormPage inputCurrentAddress() {
        driver.findElement(CURRENT_ADDRESS).sendKeys(currentAddress);
        return this;
    }
}
