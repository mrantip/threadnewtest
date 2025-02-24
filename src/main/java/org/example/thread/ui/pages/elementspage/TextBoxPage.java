package org.example.thread.ui.pages.elementspage;

import com.github.javafaker.Faker;
import lombok.Getter;
import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class TextBoxPage extends BasePage {
    private final By fullName = By.cssSelector("input[id='userName']");
    private final By email = By.xpath("//input[@type='email']");
    private final By currentAddress = By.cssSelector("textarea[id='currentAddress']");
    private final By permanentAddress = By.cssSelector("textarea[id='permanentAddress']");
    private final By submitButton = By.id("submit");
    private final By nameResult = By.id("name");
    private final By emailResult = By.id("email");
    private final By currentAddressResult = By.cssSelector("p[id='currentAddress']");
    private final By permanentAddressResult = By.cssSelector("p[id='permanentAddress']");

    Faker faker = new Faker();

    private final String inputName = faker.name().fullName();
    private final String inputEmail = faker.internet().emailAddress();
    private final String inputCurrentAddress = faker.address().fullAddress();
    private final String inputPermanentAddress = faker.address().fullAddress();

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage fillFullName() {
        driver.findElement(fullName).sendKeys(inputName);
        return this;
    }

    public TextBoxPage fillEmail() {
        driver.findElement(email).sendKeys(inputEmail);
        return this;
    }

    public TextBoxPage fillWrongEmail() {
        driver.findElement(email).sendKeys("dd");
        return this;
    }

    public TextBoxPage fillCurrentAddress() {
        driver.findElement(currentAddress).sendKeys(inputCurrentAddress);
        return this;
    }

    public TextBoxPage fillPermanentAddress() {
        driver.findElement(permanentAddress).sendKeys(inputPermanentAddress);
        return this;
    }

    public void submitButton() {
        driver.findElement(submitButton).click();
    }

    public String getNameResult() {
        return driver.findElement(nameResult).getText();
    }

    public String getEmailResult() {
        return driver.findElement(emailResult).getText();
    }

    public String getCurrentAddressResult() {
        return driver.findElement(currentAddressResult).getText();
    }

    public String getPermanentAddressResult() {
        return driver.findElement(permanentAddressResult).getText();
    }

    public List<WebElement> getElements() {
        return driver.findElements(emailResult);
    }

}
