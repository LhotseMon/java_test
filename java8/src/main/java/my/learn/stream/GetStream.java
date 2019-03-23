package my.learn.stream;

import java.util.*;
import java.util.stream.Stream;

/*
 * 获取流的方式
 * 1.所有的collection集合都可以用过stream方法获取
 * 2.Stream接口的静态方法of可以获取数组的流
 */
public class GetStream {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    Stream<String> stream = list.stream();

    Set<Stream> set = new HashSet<>();
    Stream<Stream> stream1 = set.stream();

    Map<String, String> map = new HashMap<>();
    Stream<String> stream2 = map.keySet().stream();
    Stream<String> stream3 = map.values().stream();

    Stream<Map.Entry<String, String>> stream4 = map.entrySet().stream();

    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    Integer[] arr = {1, 2, 3, 4, 5};
    Stream<Integer> arr1 = Stream.of(arr);
  }
}
