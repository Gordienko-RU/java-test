public class Consumer {
  private DataNode node = null;
  private static final int EXPIRATION_PERIOD_MS_OFFSET = 300000;

  class DataNode {
    public int number;
    public long timestamp;
    public DataNode next;
  }

  private long calcOldestValidTimestamp() {
    return System.currentTimeMillis() - Consumer.EXPIRATION_PERIOD_MS_OFFSET;
  };

  synchronized public void accept(int number) {
    DataNode newNode = new DataNode();
    newNode.timestamp = System.currentTimeMillis();
    newNode.number = number;
    newNode.next = node;

    node = newNode;
  }

  public double mean() {
    long oldestValidTimestamp = calcOldestValidTimestamp();
    long sum = 0;
    int amount = 0;

    DataNode currentNode = node;

    while (currentNode != null && currentNode.timestamp >= oldestValidTimestamp) {
      sum += currentNode.number;
      amount++;

      currentNode = currentNode.next;
    }

    currentNode = null;

    return amount == 0 ? 0 : sum / amount;
  }
}
