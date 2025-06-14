package org.example.thread.ui.pages.formspage;

import com.github.javafaker.Faker;
import lombok.Getter;
import org.example.thread.ui.data.Person;
import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

@Getter
public class PracticeFormPage extends BasePage {
    Random random = new Random();

    private final By FIRST_NAME = By.id("firstName");
    private final By LAST_NAME = By.id("lastName");
    private final By EMAIL = By.id("userEmail");
    private final By GENDER = By.xpath("//div[contains(@class, 'custom-control')]/label[starts-with(@for, 'gender-radio-')]");
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

    public PracticeFormPage clickRandomGender() {
        Random random = new Random();
        List<WebElement> genders = driver.findElements(GENDER);
        WebElement randomGender = genders.get(random.nextInt(genders.size()));
        randomGender.click();
        return this;
    }

    public PracticeFormPage inputCurrentAddress() {
        driver.findElement(CURRENT_ADDRESS).sendKeys(currentAddress);
        return this;
    }

    public String getSelectedGender() {
        List<WebElement> genders = driver.findElements(GENDER);
        return driver.findElements(GENDER).stream()
                .filter(WebElement::isSelected)
                .findFirst()
                .map(e -> e.getAttribute("for"))
                .orElse("No gender selected");
    }

    //   "Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"
}
