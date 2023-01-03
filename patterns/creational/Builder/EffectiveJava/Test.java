public class Test {
  public final int f1;
  public final int f2;
  public final int f3;
  public final int f4;
  public final int f5;

  private Test(Builder builder) {
    f1 = builder.f1;
    f2 = builder.f2;
    f3 = builder.f3;
    f4 = builder.f4;
    f5 = builder.f5;
  };

  public static class Builder {
    private final int f1;
    private final int f2;
    private int f3;
    private int f4;
    private int f5;

    public Builder(int f1, int f2) {
      this.f1 = f1;
      this.f2 = f2;
    }

    public Builder setF3(int f3) {
      this.f3 = f3;

      return this;
    }

    public Builder setF4(int f4) {
      this.f4 = f4;

      return this;
    }

    public Builder setF5(int f5) {
      this.f5 = f5;

      return this;
    }

    public Test build() {
      return new Test(this);
    }
  }
}
