package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import page.AuthorizationPage;
public class AuthorizationFormTest extends TestBase {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    String email = "test@protei.ru";
    String password = "test";
    @Test
    public void successfulAuthorizationClickTest() {
        authorizationPage
                .loginEmail.setValue(email);
        authorizationPage
                .loginPassword.setValue(password);
        authorizationPage
                .loginButton.click();
        authorizationPage
                .inputsPage.shouldBe(Condition.visible);
    }
    @Test
    void authorizationWithoutPasswordFieldTest() {
        authorizationPage
                .loginEmail.setValue(email);
        authorizationPage
                .loginButton.click();
        authorizationPage
                .invalidEmailPasswordButton.shouldHave(Condition.text("Неверный E-Mail или пароль"));
    }

    @Test
    void authorizationWithoutMailFieldTest() {
        authorizationPage
                .loginPassword.setValue(password);
        authorizationPage
                .loginButton.click();
        authorizationPage
                .emailFormatErrorButton.shouldHave(Condition.text("Неверный формат E-Mail"));
    }
    @Test
    void authorizationWithSpaceInEmailFieldTest() {
        authorizationPage
                .loginEmail.setValue(" "+email);
        authorizationPage
                .loginPassword.setValue(password);
        authorizationPage
                .loginButton.click();
        authorizationPage
                .invalidEmailPasswordButton.shouldHave(Condition.text("Неверный E-Mail или пароль"));
    }

    @Test
    void authorizationWithCapitalLetterInEmailFieldTest() {
        authorizationPage
                .loginEmail.setValue("TEST@PROTEI.RU");
        authorizationPage
                .loginPassword.setValue(password);
        authorizationPage
                .loginButton.click();
        authorizationPage
                .invalidEmailPasswordButton.shouldHave(Condition.text("Неверный E-Mail или пароль"));
    }

    @Test
    void authorizationWithCapitalLetterInPasswordFieldTest() {
        authorizationPage
                .loginEmail.setValue(email);
        authorizationPage
                .loginPassword.setValue("TEST");
        authorizationPage
                .loginButton.click();
        authorizationPage
                .invalidEmailPasswordButton.shouldHave(Condition.text("Неверный E-Mail или пароль"));
    }

    @Test
    void authorizationWithBlankMailAndPasswordFields() {
        authorizationPage
                .loginEmail.setValue("");
        authorizationPage
                .loginPassword.setValue("");
        authorizationPage
                .loginButton.click();
        authorizationPage
                .emailFormatErrorButton.shouldHave(Condition.text("Неверный формат E-Mail"));

    }
}
