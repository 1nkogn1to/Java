public class Main {
    public static void main(String[] args) {
        Man man = new Man(new Sleeping());
        System.out.println(man.getState());
        man.changeState(new DrinkingSomeBeer());
        System.out.println(man.getState());
        System.out.println(man.getPreviousState());
    }
}