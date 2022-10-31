public class AbstractFactory {
    public static void main(String[] args) {
        Chooser plat = new Chooser();
        plat.chooser(OperatingSystem.ANDROID_11);

        Chooser plat_ios = new Chooser();
        plat_ios.chooser(OperatingSystem.IOS_16);
    }
}