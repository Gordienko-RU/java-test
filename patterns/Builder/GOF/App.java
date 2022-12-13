package patterns.Builder.GOF;

class House {
  public int wallCount;
  public String roofType;
  public String address;
  public int florsCount;

  void setWallCount(int count) {
    this.wallCount = count;
  }

  void setRoofType(String type) {
    this.roofType = type;
  }

  void setAddress(String address) {
    this.address = address;
  }

  void setFlorsCount(int count) {
    this.florsCount = count;
  }
}

interface HouseBuilder {
  void buildWalls();

  void buildRoof();

  void setAddress();

  void buildFloors();

  House build();
}

class PlainHouseBuilder implements HouseBuilder {
  final House instance;

  PlainHouseBuilder() {
    this.instance = new House();
  }

  @Override
  public void buildWalls() {
    this.instance.setWallCount(2);
  };

  @Override
  public void buildRoof() {
    this.instance.setRoofType("plain");
  };

  @Override
  public void setAddress() {
    this.instance.setAddress("nowhere");
  };

  @Override
  public void buildFloors() {
    this.instance.setFlorsCount(2);
  };

  @Override
  public House build() {
    return this.instance;
  }
}

class Director {
  HouseBuilder builder;

  Director(HouseBuilder builder) {
    this.builder = builder;
  }

  House buildHouse() {
    this.builder.buildWalls();
    this.builder.buildRoof();
    this.builder.setAddress();
    this.builder.buildFloors();

    return this.builder.build();
  }
}

public class App {
  public static void main(String[] args) {
    HouseBuilder builder = new PlainHouseBuilder();
    House house = new Director(builder).buildHouse();

    System.out.print(house);
  }
}
