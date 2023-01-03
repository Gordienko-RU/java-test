public final class Singleton
{
    private static class Inner
    {
        private static Singleton INSTANCE = new Singleton();
    }
    
    private Singleton() {};

    public static Singleton getInstance()
    {
        return Inner.INSTANCE;
    }
}
