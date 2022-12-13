public class App {
  public static void main(String[] args) {
    Consumer consumer = new Consumer();

    consumer.accept(11);
    consumer.accept(-7);
    consumer.accept(-7);
    consumer.accept(-7);

    // try {
    // Thread.sleep(5000);
    // } catch (InterruptedException e) {
    // Thread.currentThread().interrupt();
    // }

    System.out.println(consumer.mean());
  }
}
