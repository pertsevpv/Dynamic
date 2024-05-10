package dynamic.interpret;

import java.util.StringTokenizer;
import java.util.function.Consumer;

public class IOContext {

  private static final String DELIMS = " \t\n\r";
  private static StringTokenizer scanner = new StringTokenizer("", DELIMS);
  private static Consumer<String> print = System.out::print;

  public static int nextInt() {
    return Integer.parseInt(scanner.nextToken());
  }

  public static double nextDouble() {
    return Double.parseDouble(scanner.nextToken());
  }

  public static String nextString() {
    return scanner.nextToken();
  }

  public static void setScannerSource(String source) {
    scanner = new StringTokenizer(source, DELIMS);
  }

  public static void setPrint(Consumer<String> print) {
    IOContext.print = print;
  }

  public static void print(String str) {
    print.accept(str);
  }

  public static void println(String str) {
    print.accept(str);
    print.accept("\n");
  }
}
