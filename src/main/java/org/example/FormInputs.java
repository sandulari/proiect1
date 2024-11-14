package org.example;

public enum FormInputs {
    FIRST_NAME("Lari"),
    LAST_NAME("Alexandru"),
    USER_EMAIL("alexandrupopov12@gmail.com"),
    GENDER("Male"),
    PHONE_NUMBER("0692740989"),
    DATE_OF_BIRTH("5 dec 2005"),
    SUBJECT_MATH("Maths"),
    SUBJECT_BIOLOGY("Biology"),
    SPORTS_HOBBY_ID("hobbies-checkbox-1"),
    MUSIC_HOBBY_ID("hobbies-checkbox-3"),
    HOBBIES("Sports, Music"),
    FILE_PATH("C:\\Users\\L213_PC05\\Desktop\\automatedTesting_I-main\\src\\test\\resources\\pictures\\user.png"),
    ADDRESS("MINSK 49 "),
    COUNTRY("NCR"),
    CITY("Delhi");

    private final String value;

    FormInputs(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}