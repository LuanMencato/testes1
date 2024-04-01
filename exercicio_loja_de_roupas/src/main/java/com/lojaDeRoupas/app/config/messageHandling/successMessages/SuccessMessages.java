package com.lojaDeRoupas.app.config.messageHandling.successMessages;

public abstract class SuccessMessages {
    private static final String SUCCESSFULLY = "successfully";
    private static final String USER = "User";
    private static final String PASSWORD = "Password";
    public static final String SUCCESS = "Success";
    public static final String SAVED = "Saved " + SUCCESSFULLY + ".";
    public static final String UPDATED = "Updated " + SUCCESSFULLY + ".";
    public static final String DELETED = "Deleted " + SUCCESSFULLY + ".";
    public static final String DISABLED = "Disabled " + SUCCESSFULLY + ".";
    public static final String CREATED = "Created " + SUCCESSFULLY + ".";
    public static final String FINISHED = "Finished " + SUCCESSFULLY + ".";
    public static final String USER_DELETED = USER + " " + DELETED;
    public static final String USER_DISABLED = USER + " " + DISABLED;
    public static final String USER_UPDATED = USER + " " + UPDATED;
    public static final String USER_SAVED = USER + " " + SAVED;
    public static final String PASSWORD_UPDATED = PASSWORD + " " + UPDATED;
}
