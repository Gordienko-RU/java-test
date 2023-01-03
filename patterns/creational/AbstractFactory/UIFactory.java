interface IUIFactory
{
    void createButton();
    void createInput();
}

public class UIFactory {
    static public IUIFactory createUIFactory( String os )
    {
        if ( os == "mac" )
        {
            return new MacUIFactory();
        }

        return new WindowsUIFactory();
    }
}

