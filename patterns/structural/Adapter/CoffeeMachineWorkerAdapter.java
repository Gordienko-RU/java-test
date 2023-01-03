public class CoffeeMachineWorkerAdapter implements Worker
{
    private CoffeeMachine coffeeMachine;

    public final int getStatistic()
    {
        return coffeeMachine.getAmountOfMoneyFromTheBox();
    }
}
