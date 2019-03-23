package my.learn.functional.basis;

import java.util.Arrays;
import java.util.Comparator;

/** 函数的返回值为函数式接口，lambda表达式作为返回值 */
public class ReturnComparator {
  public static Comparator<String> getComparator() {
    return new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.length() - o2.length();
      }
    };
  }

  public static Comparator<String> getComparatorOflambda() {
    //    return (String o1, String o2) -> {
    //      return o1.length() - o2.length();
    //    };
    return (o1, o2) -> o1.length() - o2.length();
  }

  /**
   * 最终形式
   *
   * @return
   */
  public static Comparator<String> getComparatorOfFinal() {
    return Comparator.comparingInt(String::length);
  }

  public static void main(String[] args) {
    String[] arr = new String[] {"aaaaaa", "bbbb", "ccccc"};
    System.out.println(Arrays.toString(arr));
    Arrays.sort(arr, getComparatorOflambda());
    System.out.println(Arrays.toString(arr));
  }
}
