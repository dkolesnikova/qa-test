package page;

import com.codeborne.selenide.SelenideElement;
import tests.User;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public SelenideElement
            mailField = $("#dataEmail"),
            nameField = $("#dataName"),
            genderField = $("#dataGender"),
            variant11 = $("#dataCheck11"),
            variant12 = $("#dataCheck12"),
            variant21 = $("#dataSelect21"),
            variant22 = $("#dataSelect22"),
            variant23 = $("#dataSelect23"),
            sendDataButton = $("#dataSend"),
            blankNameError = $("#blankNameError"),
            emailFormatError = $("#emailFormatError"),
            dataTable = $("#dataTable"),
            dataAddedButton =$(".uk-modal-close");

    public void sendRequiredFields(User user) {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage
                .mailField.setValue(user.getEmail());
        registrationPage
                .nameField.setValue(user.getName());
        registrationPage
                .genderField.selectOptionByValue(user.getGender());
        registrationPage
                .sendDataButton.click();
        registrationPage
                .dataAddedButton.click();
    }
}
