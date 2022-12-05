public class DrinkingSomeBeer extends State {
    @Override
    public String message() {
        return OnDrinkSomeBeer();
    }
    @Override
    public String OnWork() {
        return "";
    }
    @Override
    public String OnChillAndVibe() {
        return "";
    }
    @Override
    public String OnSleep() {
        return "";
    }
    @Override
    public String OnDrinkSomeBeer() {
        return "Man is drinking beer go away.";
    }
    @Override
    public String OnDie() {
        return "";
    }
}
