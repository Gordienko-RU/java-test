class App
{
    interface ITest
    {
        int a();
        int b();
    }

    static class Test
    {
        public int a() { return 1; };
        public int b() { return 1; };
    }

    public static void main(String[] args) {
        ITest test = ( ITest ) new App.Test();

        System.out.print(test.a());
        System.out.print(test.b());
    }
}
