package org.example.password;

public class PasswordValidator {

  public static final String WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE =
      "Password length must be between 8 and 12";

  public static void validate(String password) {
    int length = password.length();
    if (length < 8 || password.length() > 12) {
      throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
    }
  }
}
