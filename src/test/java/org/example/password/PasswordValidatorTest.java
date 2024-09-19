package org.example.password;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 비밀번호는 최소 8자 이상 12자 이하여야 함. 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킴. 경계 조건에 대해
 * 테스트 코드를 작성.
 */
class PasswordValidatorTest {
  @DisplayName("비밀번호가 최소 8자이상, 12자 이하면 예외가 발생하지 않는다.")
  @Test
  void validatePasswordTest() {
    assertThatCode(() -> PasswordValidator.validate("serverwizard")).doesNotThrowAnyException();
  }

  @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
  @ParameterizedTest
  @ValueSource(strings={"aabbcce", "aabbccddeeffg" })
  void validatePasswordTest2() {
    assertThatCode(() -> PasswordValidator.validate("aabb"))
        .isInstanceOf(IllegalArgumentException.class).hasMessage("Password length must be between 8 and 12");
  }
}
