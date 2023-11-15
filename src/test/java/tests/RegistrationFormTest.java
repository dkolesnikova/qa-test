package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.AuthorizationPage;
import page.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static tests.User.randomUser;

public class RegistrationFormTest extends TestBase {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String fakeEmail = faker.internet().emailAddress();
    String fakeName = faker.name().firstName();

    @BeforeEach
    public void commonSetUp() {
        authorizationPage
                .loginEmail.setValue("test@protei.ru");
        authorizationPage
                .loginPassword.setValue("test");
        authorizationPage
                .loginButton.click();
    }

    @Test
    public void successfulEmailAndNameInputTest() {
        registrationPage
                .mailField.setValue(fakeEmail);
        registrationPage
                .nameField.setValue(fakeName);
        registrationPage
                .genderField.selectOptionByValue("Мужской");
        registrationPage
                .variant11.click();
        registrationPage
                .variant12.click();
        registrationPage
                .variant21.click();
        registrationPage
                .variant22.click();
        registrationPage
                .variant23.click();
        registrationPage
                .sendDataButton.click();
        registrationPage
                .dataAddedButton.click();
        registrationPage
                .check(1, fakeEmail, fakeName, "Мужской", "1.1, 1.2", "2.3");
    }

    @Test
    public void registrationWithUppercaseInputTest() {
        registrationPage
                .mailField.setValue("TEST@protei.ru");
        registrationPage
                .nameField.setValue("КИВИ");
        registrationPage
                .genderField.selectOptionByValue("Мужской");
        registrationPage
                .variant11.click();
        registrationPage
                .variant12.click();
        registrationPage
                .variant21.click();
        registrationPage
                .sendDataButton.click();
        registrationPage
                .check(1, "TEST@protei.ru", "КИВИ", "Мужской", "1.1, 1.2", "2.1");
    }
    @Test
    public void registrationWithSpecialSymbolTest() {
        registrationPage
                .mailField.setValue("!@#$%^&@.com");
        registrationPage
                .nameField.setValue("!@#$%^");
        registrationPage
                .genderField.selectOptionByValue("Мужской");
        registrationPage
                .variant11.click();
        registrationPage
                .variant12.click();
        registrationPage
                .variant21.click();
        registrationPage
                .sendDataButton.click();
        registrationPage
                .dataAddedButton.click();
        registrationPage
                .check(1, "!@#$%^&@.com", "!@#$%^", "Мужской", "1.1, 1.2", "2.1");
    }

    @Test
    public void registrationWithoutNameFieldTest() {
        registrationPage
                .mailField.setValue(fakeEmail);
        registrationPage
                .genderField.selectOptionByValue("Женский");
        registrationPage
                .variant11.click();
        registrationPage
                .variant21.click();
        registrationPage
                .sendDataButton.click();
        registrationPage
                .blankNameError.shouldHave(text("Поле имя не может быть пустым"));
    }

    @Test
    public void registrationWithoutEmailFieldTest() {
        registrationPage
                .nameField.setValue(fakeName);
        registrationPage
                .genderField.selectOptionByValue("Мужской");
        registrationPage
                .variant12.click();
        registrationPage
                .variant23.click();
        registrationPage
                .sendDataButton.click();
        registrationPage
                .emailFormatError.shouldHave(text("Неверный формат E-Mail"));
    }

    @Test
    public void checkTheMinimumSizeOfFieldMailTest() {
        registrationPage
                .mailField.setValue("a@b.com");
        registrationPage
                .nameField.setValue(fakeName);
        registrationPage
                .variant12.click();
        registrationPage
                .variant23.click();
        registrationPage
                .sendDataButton.click();
        registrationPage
                .dataAddedButton.click();
        registrationPage
                .check(1, "a@b.com", fakeName, "Мужской", "1.2", "2.3");
    }

    @Test
    public void checkTheMaximumSizeOfFieldMailTest() {
        String mail = "a".repeat(300) + "@b.com";
        registrationPage
                .mailField.setValue(mail);
        registrationPage
                .nameField.setValue(fakeName);
        registrationPage
                .genderField.selectOptionByValue("Мужской");
        registrationPage
                .variant12.click();
        registrationPage
                .variant23.click();
        registrationPage
                .sendDataButton.click();
        registrationPage
                .dataAddedButton.click();
        registrationPage
                .check(1, mail, fakeName, "Мужской", "1.2", "2.3");
    }

    @Test
    public void registrationWithoutASpecialCharacterTest() {
        registrationPage
                .mailField.setValue("testprotei.ru");
        registrationPage
                .nameField.setValue(fakeName);
        registrationPage
                .genderField.selectOptionByValue("Мужской");
        registrationPage
                .variant12.click();
        registrationPage
                .variant23.click();
        registrationPage
                .sendDataButton.click();
        registrationPage
                .emailFormatError.shouldHave(text("Неверный формат E-Mail"));
    }

    @Test
    public void registrationWithShortFieldNameTest () {
        registrationPage
                .mailField.setValue(fakeEmail);
        registrationPage
                .nameField.setValue("a");
        registrationPage
                .genderField.selectOptionByValue("Мужской");
        registrationPage
                .variant11.click();
        registrationPage
                .variant12.click();
        registrationPage
                .variant21.click();
        registrationPage
                .sendDataButton.click();
        registrationPage
                .dataAddedButton.click();
        registrationPage
                .check(1, fakeEmail, "a", "Мужской", "1.1, 1.2", "2.1");

    }

    @Test
    public void checkTheFormativityOfThePageTest() {
        User user1 = randomUser();
        User user2 = randomUser();
        User user3 = randomUser();
        User user4 = randomUser();
        User user5 = randomUser();
        User user6 = randomUser();
        User user7 = randomUser();
        User user8 = randomUser();
        User user9 = randomUser();
        User user10 = randomUser();
        User user11 = randomUser();
        registrationPage.sendRequiredFields(user1);
        registrationPage.sendRequiredFields(user2);
        registrationPage.sendRequiredFields(user3);
        registrationPage.sendRequiredFields(user4);
        registrationPage.sendRequiredFields(user5);
        registrationPage.sendRequiredFields(user6);
        registrationPage.sendRequiredFields(user7);
        registrationPage.sendRequiredFields(user8);
        registrationPage.sendRequiredFields(user9);
        registrationPage.sendRequiredFields(user10);
        registrationPage.sendRequiredFields(user11);
        registrationPage
                .mailField.shouldBe(visible);
    }
}



