public class Man {
    private State state;
    private State prevState;
    public Man(State state) {
        this.state = state;
        prevState = null;
    }
    public void changeState(State state) {
        this.prevState = this.state;
        this.state = state;
    }
    public String getState() {
        return state.message();
    }
    private void setPreviousState(State state) {
        this.prevState = state;
    }
    public String getPreviousState() {
        return this.prevState.message();
    }
}
