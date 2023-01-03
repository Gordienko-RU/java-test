public class App
{
    public static void main( String args[] )
    {
        Worker worker1 = new HumanStuff();
        Worker worker2 = new CoffeeMachineWorkerAdapter();
    }
}
