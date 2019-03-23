package my.learn.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LamOfComparator {
  public static void print(String message, Person... person) {

    System.out.println("______" + message);
    for (Person p : person) {
      System.out.println(p);
    }
  }

  /*
  lambda表达式，是可推导的，凡是根据上下问能够推导出的内容，均可以省略不写
  可以省略的内容：
    1.参数列表：括号中的参数列表的数据类型，可以省略不写
    2.参数列表：括号中的参数如果只有一个，那么类型和（）都可以省略不写
    3.{一些代码}：如果{}中的代码只有一行，无论是否有返回值，都可以省略({},return,分号)
      注意：要省略{},return,分号必须一起省略
  */
  public static void main(String[] args) {
    Person[] person = {new Person(23, "zhang"), new Person(49, "li"), new Person(35, "sun")};
    print("排序之前", person);
    /** 匿名内部类方式实现 */

    //    Arrays.sort(
    //        person,
    //        new Comparator<Person>() {
    //          @Override
    //          public int compare(Person o1, Person o2) {
    //            return o1.getAge() - o2.getAge();
    //          }
    //        });

    /** 使用lambda表达式实现 */

    //    Arrays.sort(
    //        person,
    //        (Person o1, Person o2) -> {
    //          return o1.getAge() - o2.getAge();
    //        });

    /** 使用简化后的lambda */
    //    Arrays.sort(person, (o1, o2) -> o1.getAge() - o2.getAge());

    Arrays.sort(person, Comparator.comparingInt(Person::getAge));
    print("排序之后", person);
  }
}
