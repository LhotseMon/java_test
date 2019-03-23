package my.learn.functional.api;

import java.util.function.Function;

/*
Function接口，提供转换，  R apply(T t);
 */
public class DemoFunction {
  public static Integer change(String s, Function<String, Integer> function) {
    Integer apply = function.apply(s);
    return apply;
  }

  public static String change(
      String s, Function<String, Integer> function, Function<Integer, String> function1) {
    String apply = function.andThen(function1).apply(s);
    return apply;
  }

  public static void main(String[] args) {
    System.out.println(change("1234", str -> Integer.parseInt(str)));

    System.out.println(change("1234", str -> Integer.parseInt(str) + 10, i -> i + "000"));
  }
}
