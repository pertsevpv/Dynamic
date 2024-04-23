package dynamic.interpret;

import java.util.Scanner;

public class Context {

  public static final Scanner scanner = new Scanner(System.in);
  public static boolean isLeftRefCall = false;

  public static int nextInt() {
    return scanner.nextInt();
  }

  public static double nextDouble() {
    return scanner.nextDouble();
  }

  public static String nextString() {
    return scanner.next();
  }
}
