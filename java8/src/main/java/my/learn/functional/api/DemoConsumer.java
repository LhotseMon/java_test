package my.learn.functional.api;

import java.util.function.Consumer;

/*
消费一个数据，数据类型由泛型的决定，包含抽象方法void accept（T t）
 */
public class DemoConsumer {
  public static void method(String s, Consumer<String> consumer) {
    consumer.accept(s);
  }

  // 默认方法andThen
  public static void method(String s, Consumer<String> consumer, Consumer<String> consumer2) {
    consumer.andThen(consumer2).accept(s);
  }

  public static void main(String[] args) {
    method(
        "hi",
        (name) -> {
          System.out.println(name);
        });

    method("hello", s -> System.out.println(s));

    method(
        "and then", str -> System.out.println(str), str -> System.out.println(str.toUpperCase()));
  }
}
