package my.learn.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RegexTest {
  /*
   预定义字符类
            .	    任何字符（与行结束符可能匹配也可能不匹配）
           \d	    数字：[0-9]
           \D	    非数字： [^0-9]
           \s	    空白字符：[ \t\n\x0B\f\r]
           \S	    非空白字符：[^\s]
           \w	    单词字符：[a-zA-Z_0-9]
           \W	    非单词字符：[^\w]
           \	        转义字符，比如"\\"匹配"\"    ,"\{"匹配"{"

   数量词
            *	    等价于｛0，｝匹配0至多个在它之前的字符。例如正则表达式“zo*”能匹配“z”以及“zoo”
             	    正则表达式“.*”意味着能够匹配任意字符串。
            +        等价于｛1，｝匹配前面的子表达式一次或多次。例如正则表达式9+匹配9、99、999等

            ?        等价于｛0，1｝匹配前面的子表达式零次或一次。例如，"do(es)?" 可以匹配 "do" 或 "does" 中的"do" 。
                     此元字符还有另外一个用途，就是表示非贪婪模式匹配

            {n}	    匹配确定的 n 次。例如，“e{2}”不能匹配“bed”中的“d”，但是能匹配“seed”中的两个“e”。
            {n,}	    至少匹配n次。例如，“e{2,}”不能匹配“bed”中的“e”，但能匹配“seeeeeeeed”中的所有“e”。
            {n,m}    最少匹配 n 次且最多匹配 m 次。“e{1,3}”将匹配“seeeeeeeed”中的前三个“e”。

  边界匹配符号
            ^	    行的开头
            $	    行的结尾
            \b	    单词边界
            \B	    非单词边界
            \A	    输入的开头
            \G	    上一个匹配的结尾
            \Z	    输入的结尾，仅用于最后的结束符（如果有的话）
            \z	    输入的结尾

   []的使用
            []               匹配括号中的任何一个字符
            [abc]	        a、b 或 c（简单类）
            [^abc]	        任何字符，除了 a、b 或 c（否定）
            [a-zA-Z]	        a 到 z 或 A 到 Z，两头的字母包括在内（范围）
            [a-d[m-p]]	    a 到 d 或 m 到 p：[a-dm-p]（并集）
            [a-z&&[def]]	    d、e 或 f（交集）
            [a-z&&[^bc]]	    a 到 z，除了 b 和 c：[ad-z]（减去）
            [a-z&&[^m-p]]	a 到 z，而非 m 到 p：[a-lq-z]（减去）

   （）的使用
             （）将 () 之间括起来的表达式定义为“组”(group)，并且将匹配这个表达式的字符保存到一个临时区域,
              这个元字符在字符串提取的时候非常有用。捕获组可以通过从左到右计算其开括号来编号。
              (\d)	 第一组
              ((A)(B(C)))	 第一组  ((A)(B(C)))   第二组 (A)   第三组(B(C))  第四组(C)
    */

  public static void splitDemo() {
    String str = "erkktyqqquizzzzzo";
    // 按照叠词来进行切割
    String reg = "(.)\\1+";
    // 可以将规则封装成一个组。用()完成。组的出现都有编号，从1开始。使用已有的组可以通过 \n(n就是组的编号)的形式来获取。
    String[] arr = str.split(reg);
    Stream.of(arr).forEach(s -> System.out.println(s));
  }

  public static void getDemo() {
    String str = "yin yu shi wo zui cai de yu yan";
    String reg = "\\b[a-z]{3}\\b"; // 匹配只有三个字母的单词
    // 将规则封装成对象。
    Pattern p = Pattern.compile(reg);
    // 让正则对象和要作用的字符串相关联。获取匹配器对象。
    Matcher m = p.matcher(str);
    while (m.find()) {
      System.out.println(m.group());
      System.out.println(m.start() + "...." + m.end());
    }
  }

  public static void useMethod() {
    //      Java中使用正则表达式返回符合正则表达式的字符串就要用到group()，group中记录了所有符合指定表达式的字符串
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher("aaa2223bb");
    m.find(); // 匹配2223
    m.start(); // 返回3
    m.end(); // 返回7,返回的是2223后的索引号
    m.group(); // 返回2223

    Matcher m2 = p.matcher("2223bb");
    m.lookingAt(); // 匹配2223
    m.start(); // 返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0
    m.end(); // 返回4
    m.group(); // 返回2223

    Matcher m3 = p.matcher("2223bb");
    m.matches(); // 匹配整个字符串
    m.start(); // 返回0,原因相信大家也清楚了
    m.end(); // 返回6,原因相信大家也清楚了,因为matches()需要匹配所有字符串
    m.group(); // 返回2223bb
  }

  public static void main(String[] args) {
    Pattern p = Pattern.compile("\\d+");
    String[] str = p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
    Stream.of(str).forEach(s -> System.out.println(s));
    System.out.println("-------");
    splitDemo();
    System.out.println("-------");
    getDemo();
    System.out.println("-------");
    // useMethod();
  }
}
