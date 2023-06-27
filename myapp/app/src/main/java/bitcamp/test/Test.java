package bitcamp.test;

public class Test {

  public static void main(String[] args) {
    System.out.println(factorial(5, 100));
  }

  // 재귀호출 메모리 낭비가 매우 심하다
  static int factorial(int value, long value2) {
    if (value == 1) {
      return 1;
    }
    return factorial(value - 1, value2 + 1) * value;
  }
}
