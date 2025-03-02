package org.example.thread.ui.pages.elementspage;

import com.github.javafaker.Faker;
import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablesPage extends BasePage {
    private final By addButton = By.id("addNewRecordButton");
    private final By firstNameField = By.id("firstName");

    Faker faker = new Faker();
    private String firstNameInput = faker.name().firstName();
    private final String lastNameInput = faker.name().lastName();
    private final String emailInput = faker.internet().emailAddress();
    private final int ageInput = faker.number().numberBetween(0, 99);
    private final int salaryInput = faker.number().numberBetween(0, 999999999);
    private final String departmentInput = faker.company().industry();

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public WebTablesPage inputFirstName() {
        driver.findElement(firstNameField).sendKeys(firstNameInput);
        return this;
    }
}
