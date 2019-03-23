package my.learn.lambda;

/** 函数式接口：只有一个抽象方法 */
@FunctionalInterface
public interface Calculator {
  // public abstract 可以省略
  int calc(int a, int b);
}
