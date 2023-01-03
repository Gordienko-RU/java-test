public class App {
    public static void main( String args[] )
    {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.print( s1 == s2 );
    }
}
