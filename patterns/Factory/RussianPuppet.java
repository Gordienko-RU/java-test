class RussianPuppet extends Puppet {
  RussianPuppet(String name) {
    super(name);
  }

  public void sayName() {
    System.out.print("Privet, menyz zovut " + this.name);
  }
}
