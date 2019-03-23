package my.learn.functional.api;

import java.util.function.Supplier;

/** java.util.function.Supplier接口包含一个无参的get方法，用来获取一个泛型指定类型的对象数据，被称为生成型接口 */
public class DemoSupplier {
  public static String getString(Supplier<String> supplier) {
    return supplier.get();
  }

  public static void main(String[] args) {
    System.out.println(
        getString(
            () -> {
              return "复杂写法";
            }));
    System.out.println(getString(() -> "返回一个string"));
  }
}
