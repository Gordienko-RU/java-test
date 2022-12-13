class PuppetFactory {
  static public Puppet create(String locale, String name) {
    if (locale == "ru") {
      return new RussianPuppet(name);
    }

    return new EnglishPuppet(name);
  }
}
