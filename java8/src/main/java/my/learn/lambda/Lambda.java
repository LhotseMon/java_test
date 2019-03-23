package my.learn.lambda;

public class Lambda {
  /*
  lambda表达式的标准格式由三部分组成：
      a.一些参数
      b.一个箭头
      c.一段代码
  格式：
      (参数列表)->{一些重写的代码}
  解释说明格式：
      ()接口中抽象方法的参数列表，没有就空着,有参数就写出来，多个参数之间用，分隔
      ->传递的意思，把参数传递给方法体{}
      {}重写接口的抽象方法的方法体
    */
  public static void main(String[] args) {
    // 使用匿名内部类实现多线程
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                System.out.println(Thread.currentThread().getName() + "----线程启动了");
              }
            })
        .start();

    new Thread(
            () -> {
              System.out.println(Thread.currentThread().getName() + "----lambda线程启动了");
            })
        .start();

    new Thread(() -> System.out.println(Thread.currentThread().getName() + "----省略格式lambda线程启动了"))
        .start();
  }
}
