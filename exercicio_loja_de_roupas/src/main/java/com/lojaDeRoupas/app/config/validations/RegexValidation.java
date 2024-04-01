package com.lojaDeRoupas.app.config.validations;

public class RegexValidation {
    public static final String NAME = "^[a-zA-Z\\s]{1,50}$";
    public static final String ONLY_LETTERS = "^[a-zA-ZÀ-ú]*$";
    public static final String LETTERS_SPACES_NUMBERS = "^[a-zA-ZÀ-ú\\s0-9]*$";
    public static final String LETTERS_SPACES_NUMBERS_DOTS = "^[a-zA-ZÀ-ú\\s0-9\\.\\,]*$";
    public static final String LETTERS_NUMBERS_HYPHEN = "^[a-zA-ZÀ-ú\\s0-9\\-]*$";
    public static final String SPACE_AND_LETTERS = "^[a-zA-ZÀ-ú\\s]*$";
    public static final String ONLY_NUMBERS = "^[0-9]*$";
    public static final String CELLPHONE_BR = "^\\([0-9]{2}\\)[0-9]{9}";
    public static final String LOGIN = "^[a-zA-Z0-9._-]{3,20}$";
    public static final String EMAIL =  "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String PASSWORD_STRONG_8 = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    public static final String PASSWORD_WEAK_4 = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{4,}$";
    /*
    TODO: Create more generic validations
     */
}
