package my.learn.lambda;

public class LamOfCalculate {
  public static void calculate(int a, int b, Calculator calculator) {
    System.out.println(calculator.calc(a, b));
  }

  public static void main(String[] args) {
    /** 使用匿名内部类 */
    calculate(
        10,
        20,
        new Calculator() {
          @Override
          public int calc(int a, int b) {
            return a + b;
          }
        });

    /** 使用lambda表达式 */
    calculate(
        30,
        40,
        (int a, int b) -> {
          return a + b;
        });

    /** 使用lambda表达式省略格式 */
    calculate(50, 10, (b, c) -> b - c);
  }
}
