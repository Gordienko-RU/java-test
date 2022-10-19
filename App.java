import java.util.ArrayDeque;
import java.util.Date;
import java.util.Iterator;

public class App {
  public static void main(String[] args) {
    class Consumer {
      static final class DataPair {
        public int number;
        public long timestamp;

        public DataPair(int number, long timestamp) {
          this.number = number;
          this.timestamp = timestamp;
        }
      }

      private ArrayDeque<DataPair> data = new ArrayDeque<DataPair>();
      private static final int EXPIRATION_PERIOD_MS_OFFSET = 300000;

      private long buildOldestValidTimestamp() {
        return new Date().getTime() - Consumer.EXPIRATION_PERIOD_MS_OFFSET;
      }

      public void accept(int number) {
        Long timestamp = new Date().getTime();

        Consumer.DataPair pair = new Consumer.DataPair(number, timestamp);
        this.data.addFirst(pair);
      }

      public long mean() {
        long oldestValidTimestamp = this.buildOldestValidTimestamp();
        long amount = 0;
        long sum = 0;
        Iterator<Consumer.DataPair> iterator = this.data.iterator();

        while (iterator.hasNext()) {
          Consumer.DataPair pair = iterator.next();

          if (pair.timestamp >= oldestValidTimestamp) {
            sum += pair.number;
            ++amount;
          } else {
            break;
          }
        }

        return amount == 0 ? 0 : sum / amount;
      }
    }

    Consumer consumer = new Consumer();

    consumer.accept(11);
    consumer.accept(7);
    consumer.accept(7);
    consumer.accept(7);

    // try {
    //   Thread.sleep();
    // } catch (InterruptedException e) {
    //   Thread.currentThread().interrupt();
    // }

    System.out.println(consumer.mean());
  }
}
