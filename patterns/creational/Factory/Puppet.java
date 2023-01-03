abstract class Puppet {
  protected String name;

  abstract public void sayName();

  Puppet(String name) {
    this.name = name;
  }
}
