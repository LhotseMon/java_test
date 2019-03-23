package my.learn.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamListFilter {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("张无忌");
    list.add("周芷若");
    list.add("赵敏");
    list.add("张强");
    list.add("张三丰");

    //    list.stream()
    //        .filter(
    //            (name) -> {
    //              return name.length() == 3;
    //            })
    //        .filter(
    //            (name) -> {
    //              return name.startsWith("张");
    //            })
    //        .forEach(
    //            (name) -> {
    //              System.out.println(name);
    //            });
    //  }

    list.stream()
        .filter(name -> name.startsWith("张"))
        .filter(name -> name.length() == 3)
        .forEach(name -> System.out.println(name));

  }
}
