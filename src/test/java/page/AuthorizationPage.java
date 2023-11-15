package page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
public class AuthorizationPage {
    public SelenideElement
            loginEmail = $("#loginEmail"),
            loginPassword = $("#loginPassword"),
            inputsPage = $("#inputsPage"),
            loginButton = $("#authButton"),
            invalidEmailPasswordButton = $("#invalidEmailPassword"),
            emailFormatErrorButton = $("#emailFormatError");

}


