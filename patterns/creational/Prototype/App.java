import java.util.List;

public class App
{
    interface ItemsHolder
    {
        public List<String> getItems();
        public ItemsHolder clone();
    }
    public static void main(String args[])
    {
        final ItemsHolder item = ( ItemsHolder ) Factory.create();
        final ItemsHolder copy1 = item.clone();
        final ItemsHolder copy2 = item.clone();
    }
}
