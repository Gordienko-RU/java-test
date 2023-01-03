class EnglishPuppet extends Puppet {
  EnglishPuppet(String name) {
    super(name);
  }

  public void sayName() {
    System.out.print("Hi, my name is " + this.name);
  }
}
