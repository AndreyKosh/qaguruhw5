package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

public class StudentRegistrationWithFakersTests {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobile = faker.number().digits(10),
            day = "15",
            month = "May",
            year = "1999",
            subject = "English",
            hobby = "Sports",
            picture = "cat.jpg",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Merrut";

    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @Test
    void registrationTest() {
        studentRegistrationPage.openPage();
        studentRegistrationPage.typeFirstName(firstName);
        studentRegistrationPage.typeLastName(lastName);
        studentRegistrationPage.typeEmail(email);
        studentRegistrationPage.chooseGender(gender);
        studentRegistrationPage.typeNumber(mobile);
        studentRegistrationPage.setDate(day, month, year);
        studentRegistrationPage.typeSubject(subject);
        studentRegistrationPage.chooseHobby(hobby);
        studentRegistrationPage.uploadPicture(picture);
        studentRegistrationPage.typeAdress(currentAddress);
        studentRegistrationPage.selectState(state);
        studentRegistrationPage.selectCity(city);
        studentRegistrationPage.clickSubmit();

        studentRegistrationPage.checkTableResults(firstName,
                lastName,
                email,
                gender,
                mobile, day,
                month,
                year,
                subject,
                hobby,
                picture,
                currentAddress,
                state,
                city);
    }
}