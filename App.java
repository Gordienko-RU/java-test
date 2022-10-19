import java.util.Collection;
import java.util.Date;
import java.util.TreeMap;

public class App {
  public static void main(String[] args) {
    /**
     * why did we have '?' for mean method?\ - have to pick correct type(some
     * dynamic type, or sort of probably)
     * what about accessing from several threads
     * optimize slicing buy provide comparator
     * test
     */
    class Consumer {
      private TreeMap<Long, Integer> data = new TreeMap<Long, Integer>();
      private static final int EXPIRATION_PERIOD_MS_OFFSET = 300000;

      private Long getOldestNotExpiredDataKey(long ts) {
        long oldestValidTSValue = ts - Consumer.EXPIRATION_PERIOD_MS_OFFSET;

        return this.data.ceilingKey(oldestValidTSValue);
      }

      private boolean isThereDataToAggregate(long ts) {
        Long oldestNotExpiredDataKey = this.getOldestNotExpiredDataKey(ts);

        return oldestNotExpiredDataKey != null ? true : false;
      }

      private Collection<Integer> getAggregableValues(long ts) {
        long oldestNotExpiredDataKey = this.getOldestNotExpiredDataKey(ts);
        long lastKey = this.data.lastKey();

        return this.data
            .subMap(oldestNotExpiredDataKey, true, lastKey, true)
            .values();
      }

      public void accept(int number) {
        Long key = new Date().getTime();
        System.out.println(key);
        this.data.put(key, number);
      }

      public long mean() {
        long ts = new Date().getTime();
        boolean thereIsDataToAggregate = this.isThereDataToAggregate(ts);

        if (!thereIsDataToAggregate) {
          return 0;
        }

        Collection<Integer> aggregableValues = this.getAggregableValues(ts);
        long sum = 0;

        for (Integer number : aggregableValues) {
          sum += number;
        }

        return sum / aggregableValues.size();
      }
    }

    Consumer consumer = new Consumer();

    consumer.accept(3);
    consumer.accept(2);
    consumer.accept(7);
    System.out.println(consumer.mean());
  }
}
