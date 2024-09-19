package org.example.password;

public class User {

  private String password;

  public void initPassword(PasswordGenerator passwordGenerator) {
    String password = passwordGenerator.generatePassword();
    /** 비번은 최소 8자 이상 12자 이하여야 한다. */
    if (password.length() >= 8 && password.length() <= 12) {
      this.password = password;
    }
  }

  public String getPassword() {
    return password;
  }
}
