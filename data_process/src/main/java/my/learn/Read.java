package my.learn;

import com.csvreader.CsvReader;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Read {
  public static void main(String[] args) {
    List<String> result = new ArrayList<>();
    ArrayList<String[]> csvList = new ArrayList<>();
    try {
      InputStream in = Read.class.getClassLoader().getResourceAsStream("phone.csv");
      CsvReader reader = new CsvReader(in, Charset.defaultCharset());

      //          reader.readHeaders(); //跳过表头,不跳可以注释掉

      while (reader.readRecord()) {
        csvList.add(reader.getValues()); // 按行读取，并把每一行的数据添加到list集合
      }
      reader.close();
      System.out.println("读取的行数：" + csvList.size());

      for (int row = 0; row < csvList.size(); row++) {
        // System.out.println(csvList.get(row)[0]);
        result.add("86" + csvList.get(row)[0]);
      }
//      result.forEach(r -> System.out.println(r));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
