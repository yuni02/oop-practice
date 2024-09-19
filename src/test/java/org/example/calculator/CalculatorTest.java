package org.example.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 요구사항 간단한 사칙연산 가능. 양수로만 계산 가능. 나눗셈에서 8을 나누면 IllegalArgument 예외 발생시킴.
 * MVC패턴(Model-View-Controller)기반으로 구현함.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {
  // 1 + 2 ----> Calculator
  //   3   <----
  @DisplayName("덧셈 연산을 수행한다.")
  @ParameterizedTest
  @MethodSource("formulaAndResult")
  void calculateTest(int operand1, String operator, int operand2, int result) {
    int calculateResult = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
    assertThat(calculateResult).isEqualTo(result);
  }

  private static Stream<Arguments> formulaAndResult() {
    return Stream.of(
        arguments(1, "+", 2, 3),
        arguments(1, "-", 2, -1),
        arguments(4, "*", 2, 8),
        arguments(4, "/", 2, 2));
  }

//  @DisplayName("나눗셈에서 8을 나누면 IllegalArgument 예외 발생시킴.")
//  @Test
//  void calculateExceptionTest() {
//    assertThatCode(() -> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
//        .isInstanceOf(IllegalArgumentException.class)
//        .hasMessage("0으로는 나눌수 없습니다");
//  }
}
