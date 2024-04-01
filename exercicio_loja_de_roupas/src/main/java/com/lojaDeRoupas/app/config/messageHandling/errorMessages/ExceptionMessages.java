package com.lojaDeRoupas.app.config.messageHandling.errorMessages;

public abstract class ExceptionMessages {
    private static final String ALREADY_EXISTS = " already exists.";
    private static final String CANT_BE_FOUND = " can't be found.";
    public static final String CPF_ALREADY_IN_USE = "CPF is already in use.";
    public static final String USER_NOT_FOUND = "User" + CANT_BE_FOUND;
    public static final String USER_NAME_NOT_FOUND = "User name" + CANT_BE_FOUND;
    public static final String USER_LIST_NOT_FOUND = "User list" + CANT_BE_FOUND;
    public static final String LIST_NOT_FOUND = "List" + CANT_BE_FOUND;
    public static final String ENTITY_NOT_FOUND = "Entity" + CANT_BE_FOUND;
    public static final String ENTITY_ALREADY_EXISTS = "This entity is already registered.";
    public static final String ID_ALREADY_REGISTERED = "This ID already exists";
    public static final String NULL_ENTITY = "Entity can't be null";
    public static final String ENUM_NOT_FOUND = "Enum not found.";
    public static final String NAME_ALREADY_EXISTS = "Name" + ALREADY_EXISTS;
    public static final String COLOR_ALREADY_EXISTS = "This color" + ALREADY_EXISTS;
    public static final String IDENTIFIER_ALREADY_REGISTERED = "This identifier" + ALREADY_EXISTS;
    public static final String EMAIL_ALREADY_EXISTS = "E-mail" + ALREADY_EXISTS;
    public static final String LOGIN_ALREADY_EXISTS = "Login" + ALREADY_EXISTS;
    public static final String PASSWORDS_DONT_MATCH = "Passwords don't match.";
    public static final String OLD_PASSWORD = "Old password provided instead of a new password";
    public static final String WRONG_PASSWORD = "Wrong password.";
    public static final String LIST_IS_EMPTY = "This list couldn't be empty";
}
