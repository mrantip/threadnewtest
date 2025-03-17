package org.example.thread.ui.data;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class Person {

    Faker faker = new Faker();
    public final String FIRST_NAME_INPUT = faker.name().firstName();
    public final String LAST_NAME_INPUT = faker.name().lastName();
    public final String EMAIL_INPUT = faker.internet().emailAddress();
    public final int AGE_INPUT = faker.number().numberBetween(0, 99);
    public final int SALARY_INPUT = faker.number().numberBetween(0, 999999999);
    public final String DEPARTMENT_INPUT = faker.company().industry();
}
