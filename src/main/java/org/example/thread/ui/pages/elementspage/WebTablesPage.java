package org.example.thread.ui.pages.elementspage;

import com.github.javafaker.Faker;
import lombok.Getter;
import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

@Getter
public class WebTablesPage extends BasePage {
    private final By addButton = By.id("addNewRecordButton");
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By emailField = By.id("userEmail");
    private final By ageField = By.id("age");
    private final By salaryField = By.id("salary");
    private final By departmentField = By.id("department");
    private final By submitButton = By.id("submit");
    private final By table = By.cssSelector("div[class=\"rt-tr-group\"]");
    private final By ONE_CELL = By.cssSelector("div[class=\"rt-td\"]");
    private final By ROWS_CHANGE = By.cssSelector("select[aria-label='rows per page']");
    //String rrrr = String.format("option[value=\"{x}\"]", x);



    Faker faker = new Faker();
    private final String firstNameInput = faker.name().firstName();
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

    public WebTablesPage inputLastName() {
        driver.findElement(lastNameField).sendKeys(lastNameInput);
        return this;
    }

    public WebTablesPage inputEmail() {
        driver.findElement(emailField).sendKeys(emailInput);
        return this;
    }

    public WebTablesPage inputAge() {
        driver.findElement(ageField).sendKeys(String.valueOf(ageInput));
        return this;
    }

    public WebTablesPage inputSalary() {
        driver.findElement(salaryField).sendKeys(String.valueOf(salaryInput));
        return this;
    }

    public WebTablesPage inputDepartment() {
        driver.findElement(departmentField).sendKeys(departmentInput);
        return this;
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public int getTableSize() {
        return driver.findElements(table).size();
    }

    public List<String> getTableRows() {
        List<String> rows = new ArrayList<>();
        List<WebElement> l =  driver.findElements(ONE_CELL);
        for (WebElement webElement : l) {
            if (!webElement.getText().equals(" "))
            {rows.add(webElement.getText());}
        }
        return rows;
    }

    public int changeRowsQuantity(){
        List<Integer> count =  Arrays.asList(5, 10, 20, 25, 50, 100);
        Random random = new Random();
        int index = random.nextInt(count.size());
        String locator = String.format("option[value='%d']", count.get(index));
        driver.findElement(By.cssSelector(locator)).click();
        return count.get(index);
    }
}
