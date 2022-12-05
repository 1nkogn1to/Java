public class Dying extends State {
    @Override
    public String message() {
        return OnDie();
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
        return "";
    }
    @Override
    public String OnDie() {
        return "Man dying from cringe.";
    }
}
