package my.learn.lambda;

public class Person {
  private int age;
  private String name;

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public Person() {}

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Person{" + "age=" + age + ", name='" + name + '\'' + '}';
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
