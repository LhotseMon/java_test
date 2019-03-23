package my.learn.functional.basis;

/** lambda表达式可作为函数式接口的实现，当作函数的参数 */
public class ShowMyFunction {
  public static void show(MyFunctionalInterface myFunctionalInterface) {
    myFunctionalInterface.method();
  }

  public static void main(String[] args) {
    /** 传递接口的子类 */
    show(new MyFunctionalInterfaceImpl());

    /** 匿名内部类 */
    show(
        new MyFunctionalInterface() {
          @Override
          public void method() {
            System.out.println("匿名内部类");
          }
        });

    /** lambda表达式 */
    show(
        () -> {
          System.out.println("lambda表达式");
        });

    /** lambda表达式简化 */
    show(() -> System.out.println("lambda表达式简化"));
  }
}
