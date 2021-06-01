package pages;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationPage {

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void typeFirstName(String value) {
        $("#firstName").val(value);
    }

    public void typeLastName(String value) {
        $("#lastName").val(value);
    }

    public void typeEmail(String value) {
        $("#userEmail").val(value);
    }

    public void chooseGender(String value) {
        $(byText(value)).click();
    }

    public void typeNumber(String value) {
        $("#userNumber").val(value);
    }

    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day)).click();
    }

    public void typeSubject(String value) {
        $("#subjectsInput").val(value).pressEnter();
    }

    public void chooseHobby(String value) {
        $(byText(value)).click();
    }

    public void uploadPicture(String value) {
        $("#uploadPicture").uploadFile(new File(String.format("src/test/resources/%s", value)));
    }

    public void typeAdress(String value) {
        $("#currentAddress").val(value);
    }

    public void selectState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
    }

    public void selectCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
    }

    public void clickSubmit() {
        $("#submit").click();
    }

    public void checkTableResults(String firstName,
                                  String lastName,
                                  String email,
                                  String gender,
                                  String mobile,
                                  String day,
                                  String month,
                                  String year,
                                  String subject,
                                  String hobby,
                                  String picture,
                                  String currentAddress,
                                  String state,
                                  String city) {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']/following::td[1]").shouldHave(text(firstName), text(lastName));
        $x("//td[text()='Student Email']/following::td[1]").shouldHave(text(email));
        $x("//td[text()='Gender']/following::td[1]").shouldHave(text(gender));
        $x("//td[text()='Mobile']/following::td[1]").shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']/following::td[1]").shouldHave(text(day + " " + month + "," + year));
        $x("//td[text()='Subjects']/following::td[1]").shouldHave(text(subject));
        $x("//td[text()='Hobbies']/following::td[1]").shouldHave(text(hobby));
        $x("//td[text()='Picture']/following::td[1]").shouldHave(text(picture));
        $x("//td[text()='Address']/following::td[1]").shouldHave(text(currentAddress));
        $x("//td[text()='State and City']/following::td[1]").shouldHave(text(state + " " + city));
    }
}