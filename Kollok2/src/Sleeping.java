public class Sleeping extends State {
    @Override
    public String message() {
        return OnSleep();
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
        return "Man is sleeping do not bother him.";
    }
    @Override
    public String OnDrinkSomeBeer() {
        return "";
    }
    @Override
    public String OnDie() {
        return "";
    }
}
