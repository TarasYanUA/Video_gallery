package hooks;

import org.testng.asserts.SoftAssert;

public class CollectAssertMessages {

    private static final ThreadLocal<SoftAssert> threadLocal = new ThreadLocal<>();

    public static SoftAssert getSoftAsserts() {
        return threadLocal.get();
    }

    public static void setSoftAsserts(SoftAssert softAsserts) {
        threadLocal.set(softAsserts);
    }
}