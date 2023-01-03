// some 3rd party factory to create an object
public class Factory
{
    public static Test create()
    {
        final Test test = new Test();
        test.initialize();

        return test;
    }
}
