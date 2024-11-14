package org.example;
import org.example.pom.FormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormTest {

    public static WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\L213_PC05\\Desktop\\automatedTesting_I-main\\src\\test\\resources\\drivers\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void FormFillingTest() {
        driver.get("https://demoqa.com/automation-practice-form");
        FormPage page = new FormPage(driver);

        page.setFirstName(FormInputs.FIRST_NAME.getValue());
        page.setLastName(FormInputs.LAST_NAME.getValue());
        page.setEmail(FormInputs.USER_EMAIL.getValue());
        page.selectMaleGender();
        page.setMobileNumber(FormInputs.PHONE_NUMBER.getValue());
        page.setDateOfBirth(FormInputs.DATE_OF_BIRTH.getValue());
        page.setSubject(FormInputs.SUBJECT_MATH.getValue());
        page.setSubject(FormInputs.SUBJECT_BIOLOGY.getValue());
        page.setHobby(FormInputs.SPORTS_HOBBY_ID.getValue());
        page.setHobby(FormInputs.MUSIC_HOBBY_ID.getValue());
        page.setPicture(FormInputs.FILE_PATH.getValue());
        page.setAddress(FormInputs.ADDRESS.getValue());
        page.setState(FormInputs.COUNTRY.getValue());
        page.setCity(FormInputs.CITY.getValue());
        page.submitForm();

        Assert.assertEquals(page.getFirstAndLastName(), FormInputs.FIRST_NAME.getValue() + " " + FormInputs.LAST_NAME.getValue());
        Assert.assertEquals(page.getEmail(), FormInputs.USER_EMAIL.getValue());
        Assert.assertEquals(page.getGender(), FormInputs.GENDER.getValue());
        Assert.assertEquals(page.getMobileNumber(), FormInputs.PHONE_NUMBER.getValue());
        Assert.assertEquals(
                page.getDateOfBirth(),
                LocalDate.parse(FormInputs.DATE_OF_BIRTH.getValue(), DateTimeFormatter.ofPattern("dd MMM yyyy"))
                        .format(DateTimeFormatter.ofPattern("dd MMMM,yyyy"))
        );
        Assert.assertEquals(page.getSubjects(), FormInputs.SUBJECT_MATH.getValue() + ", " + FormInputs.SUBJECT_BIOLOGY.getValue());
        Assert.assertEquals(page.getHobbies(), FormInputs.HOBBIES.getValue());
        Assert.assertEquals(page.getPicture(), Paths.get(FormInputs.FILE_PATH.getValue()).getFileName().toString());
        Assert.assertEquals(page.getAddress(), FormInputs.ADDRESS.getValue());
        Assert.assertEquals(page.getStateAndCity(), FormInputs.COUNTRY.getValue() + " " + FormInputs.CITY.getValue());
    }

    @AfterClass
    public void CloseDriver() {
        driver.quit();
    }

}