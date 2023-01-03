import java.util.ArrayList;
import java.util.List;

public class Test implements Cloneable
{
    private List<String> items;

    void initialize()
    {
        // request to fetch items happened here
        items = new ArrayList<String>();

        items.add( "First" );
        items.add( "Second" );
        items.add( "Third" );
    }

    public List<String> getItems()
    {
        return this.items;
    }

    @Override

    public Test clone()
    {
        final Test clone = new Test();
        clone.items = new ArrayList<>( this.items );

        return clone;
    }
}
