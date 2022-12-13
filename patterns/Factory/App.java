public class App {
  public static void main(String[] args) {
    Puppet ruPup = PuppetFactory.create("ru", "Serega");
    Puppet enPup = PuppetFactory.create("en", "Sam");

    ruPup.sayName();
    enPup.sayName();
  }
}
