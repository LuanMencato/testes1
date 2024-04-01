package com.lojaDeRoupas.app.config.messageHandling.errorMessages;
public abstract class ValidationErrorMessages {
    public static final String SPACE_AND_LETTERS = "This field must contain only spaces and alphabetic characters.";
    public static final String LETTERS_SPACES_NUMBERS_DOTS = "This field must contain only spaces, dots, and alphabetic characters.";
    public static final String ONLY_NUMBERS = "This field must contain only numbers.";
    public static final String ONLY_LETTERS = "This field must contain only alphabetic characters.";
    public static final String ONLY_DATES = "This field must be an ISO date.";
    public static final String LETTERS_SPACES_NUMBERS = "This field must contain only numbers, letters and spaces.";
    public static final String CPF = "This field must contain a valid CPF.";
    public static final String TELEPHONE = "This field must contain a telephone number.";
    public static final String NAME = "This field is for a name, so it supports only spaces and alphabetic characters.";
    public static final String INVALID_CPF = "This field must contain a valid cpf number.";

    public static final String MAX_10 = "This field must contain a maximum of 10 characters.";
    public static final String MAX_15 = "This field must contain a maximum of 15 characters.";
    public static final String MAX_20 = "This field must contain a maximum of 20 characters.";
    public static final String MAX_30 = "This field must contain a maximum of 30 characters.";
    public static final String MAX_50 = "This field must contain a maximum of 50 characters.";
    public static final String MAX_60 = "This field must contain a maximum of 60 characters.";
    public static final String MAX_80 = "This field must contain a maximum of 80 characters.";
    public static final String MAX_100 = "This field must contain a maximum of 100 characters.";
    public static final String MAX_120 = "This field must contain a maximum of 120 characters.";
    public static final String MAX_150 = "This field must contain a maximum of 150 characters.";
    public static final String MAX_250 = "This field must contain a maximum of 250 characters.";
    public static final String MAX_350 = "This field must contain a maximum of 350 characters.";
    public static final String MAX_500 = "This field must contain a maximum of 500 characters.";
    public static final String MAX_750 = "This field must contain a maximum of 500 characters.";
    public static final String NOT_BLANK = "This field can't be blank.";
    public static final String NOT_NULL = "This field can't be null.";
    public static final String NOT_EMPTY = "This field needs at least one element.";
    public static final String POSITIVE = "This field must contain a positive value.";
    public static final String NON_NEGATIVE = "This field must contain a non-negative value.";
    public static final String ALREADY_DISABLED = "This element is already disabled.";
    public static final String INVALID_LOGIN = "This field must only numbers, letters, dots, underscores, or dashes.";
    public static final String INVALID_EMAIL = "This field must contain a valid e-mail address.";
    public static final String INVALID_PATTERN = "This field must contain a valid pattern.";
    public static final String INVALID_LENGTH = "This field must contain a valid length.";
    public static final String PASSWORD_STRONG_8 = "This field must contain:\n" +
            "At least 8 characters long.\n" +
            "At least one lowercase letter.\n" +
            "At least one capital letter.\n" +
            "At least one digit.\n" +
            "At least one special character (e.g. @, #, $, %, ^, &).\n" +
            "It must not contain white spaces.";
    public static final String PASSWORD_WEAK_4 = "This field must contain:\n" +
            "At least 4 characters long.\n" +
            "At least one letter (upper or lower case).\n" +
            "At least one digit.\n" +
            "It must not contain white spaces.";
   /*
   TODO: More generic errors messages.
    */
}
