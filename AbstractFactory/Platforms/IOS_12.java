package Platforms;

public class IOS_12 implements Platform{
    @Override
    public void Option() {
        System.out.println("IOS 12 Option");
    }
    @Override
    public void Action() {
        System.out.println("IOS 12 Action");
    }
    @Override
    public void SuperAction() {
        System.out.println("IOS 12 SuperAction");
    }
}