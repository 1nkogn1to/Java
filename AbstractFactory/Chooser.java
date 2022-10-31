import Platforms.*;

public class Chooser {
    public void Caller(Platform plat) {
        plat.Option();
        plat.Action();
        plat.SuperAction();
        System.out.println();
    }

    public void chooser(OperatingSystem value) {
        OperatingSystem os = value;
        Platform plat = null;
        switch (os) {
            case ANDROID_11:
                plat = new Android_11();
                break;
            case ANDROID_12:
                plat = new Android_12();
                break;
            case ANDROID_13:
                plat = new Android_13();
                break;
            case IOS_12:
                plat = new IOS_12();
                break;
            case IOS_13:
                plat = new IOS_13();
                break;
            case IOS_14:
                plat = new IOS_14();
                break;
            case IOS_15:
                plat = new IOS_15();
                break;
            case IOS_16:
                plat = new IOS_16();
                break;
            default:
                System.out.println("This operating system is not supported:(");
        }
        Caller(plat);
    }
}
