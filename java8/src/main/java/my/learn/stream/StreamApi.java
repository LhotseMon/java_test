package my.learn.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("张无忌");
    list.add("周芷若");
    list.add("赵敏");
    list.add("张强");
    list.add("张三丰");
    List<String> list1 = new ArrayList<>();
    list.add("伤脑筋");
    list.add("快看看");
    list.add("兜兜风");
    list.add("感人的");
    list.add("算是 v");
    /*
    forEach 终结方法
     */
    list.stream().forEach(str -> System.out.println(str));
    System.out.println("-------");
    /*
    count 终结方法
     */
    System.out.println(list.stream().count());
    System.out.println("-------");
    /*
    filter
     */
    list.stream().filter(name -> name.startsWith("张")).forEach(name -> System.out.println(name));
    System.out.println("-------");
    /*
    limit 取前n个
     */
    list.stream().limit(3).forEach(name -> System.out.println(name));
    System.out.println("-------");
    /*
    skip 跳过前n个
     */
    list.stream().skip(2).forEach(name -> System.out.println(name));
    System.out.println("-------");
    /*
    将流映射为另一种类型的流
     */
    list.stream().map(name -> name.substring(1, 2)).forEach(name -> System.out.println(name));
    System.out.println("-------");
    /*
    concat 连接两个流
     */
    Stream.concat(list.stream(), list1.stream()).forEach(name -> System.out.println(name));
    System.out.println("-------");
    /*

     */
    Stream.of("zhang,so", "li,dii")
        .flatMap(str -> Stream.of(str.split(",")))
        .forEach(s -> System.out.println(s));
    System.out.println("-------");
    System.out.println("-------");
  }
}
