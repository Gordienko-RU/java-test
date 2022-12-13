public class App {
    public static void main(String[] args) {
      IUIFactory uiFactory = UIFactory.createUIFactory( System.getProperty("os.name") );
  
      uiFactory.createButton();
      uiFactory.createInput();
    }
  }