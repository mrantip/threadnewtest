package org.example.thread.ui.pages.elementspage;

import com.github.javafaker.Faker;
import lombok.Getter;
import org.example.thread.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

@Getter
public class WebTablesPage extends BasePage {
    private final By ADD_BUTTON = By.id("addNewRecordButton");
    private final By FIRST_NAME_FIELD = By.id("firstName");
    private final By LAST_NAME_FIELD = By.id("lastName");
    private final By EMAIL_FIELD = By.id("userEmail");
    private final By AGE_FIELD = By.id("age");
    private final By SALARY_FIELD = By.id("salary");
    private final By DEPARTMENT_FIELD = By.id("department");
    private final By SUBMIT_BUTTON = By.id("submit");
    private final By TABLE = By.cssSelector("div[class=\"rt-tr-group\"]");
    private final By ONE_CELL = By.cssSelector("div[class=\"rt-td\"]");
    private final By ROWS_CHANGE = By.cssSelector("select[aria-label='rows per page']");
    private final By SEARCH_FIELD = By.id("searchBox");
    private final By EDIT_BUTTON = By.cssSelector("span[title='Edit']");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    Faker faker = new Faker();
    private final String FIRST_NAME_INPUT = faker.name().firstName();
    private final String LAST_NAME_INPUT = faker.name().lastName();
    private final String EMAIL_INPUT = faker.internet().emailAddress();
    private final int AGE_INPUT = faker.number().numberBetween(0, 99);
    private final int SALARY_INPUT = faker.number().numberBetween(0, 999999999);
    private final String DEPARTMENT_INPUT = faker.company().industry();

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddButton() {
        driver.findElement(ADD_BUTTON).click();
    }

    public WebTablesPage inputFirstName() {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(FIRST_NAME_INPUT);
        return this;
    }

    public WebTablesPage inputLastName() {
        driver.findElement(LAST_NAME_FIELD).sendKeys(LAST_NAME_INPUT);
        return this;
    }

    public WebTablesPage inputEmail() {
        driver.findElement(EMAIL_FIELD).sendKeys(EMAIL_INPUT);
        return this;
    }

    public WebTablesPage inputAge() {
        driver.findElement(AGE_FIELD).sendKeys(String.valueOf(AGE_INPUT));
        return this;
    }

    public WebTablesPage inputSalary() {
        driver.findElement(SALARY_FIELD).sendKeys(String.valueOf(SALARY_INPUT));
        return this;
    }

    public WebTablesPage inputDepartment() {
        driver.findElement(DEPARTMENT_FIELD).sendKeys(DEPARTMENT_INPUT);
        return this;
    }

    public void clickSubmitButton() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public int getTableSize() {
        return driver.findElements(TABLE).size();
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

    public void searchPerson(String value) {
        driver.findElement(SEARCH_FIELD).click();
        driver.findElement(SEARCH_FIELD).sendKeys(value);
    }

    public void changePerson(String value) {
        driver.findElement(EDIT_BUTTON).click();
        driver.findElement(FIRST_NAME_FIELD).clear();
        driver.findElement(FIRST_NAME_FIELD).sendKeys(value);
    }
}
