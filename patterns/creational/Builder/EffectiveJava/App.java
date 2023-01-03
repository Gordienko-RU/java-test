public class App {
  public static void main(String[] args) {
    Test test = new Test.Builder(1, 2)
        .setF3(3)
        .setF5(5)
        .build();

    System.out.print(test.f4);
  }
}
