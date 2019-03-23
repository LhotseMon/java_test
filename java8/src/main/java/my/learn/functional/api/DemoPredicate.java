package my.learn.functional.api;

import java.util.function.Predicate;

/*
Predicate 接口包含一个抽象方法
    Boolean test(T t):用来对指定数据类型进行判断的方法，符合true，否则false
 */
public class DemoPredicate {
  public static Boolean method(String s, Predicate<String> predicate) {
    return predicate.test(s);
  }

  public static Boolean method(
      String s, Predicate<String> predicate, Predicate<String> predicate1) {
    return predicate.and(predicate1).test(s);
  }

  public static Boolean method1(
      String s, Predicate<String> predicate, Predicate<String> predicate1) {
    return predicate.or(predicate1).test(s);
  }

  public static Boolean method2(String s, Predicate<String> predicate) {
    return predicate.negate().test(s);
  }

  public static void main(String[] args) {
    System.out.println(method("abcde", str -> str.length() == 5));
    System.out.println(method("abcde", str -> str.length() > 4, s -> s.contains("f")));
    System.out.println(method1("abcde", str -> str.length() > 5, s -> s.contains("e")));
    System.out.println(method2("abcde", str -> str.length() == 5));
  }
}
