public class HardWorking extends State {
    @Override
    public String message() {
        return OnWork();
    }
    @Override
    public String OnWork() {
        return "Man is hard working.";
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
        return "";
    }
}
