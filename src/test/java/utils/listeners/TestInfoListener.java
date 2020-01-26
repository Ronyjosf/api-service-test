//package utils.listeners;
//
//import org.junit.platform.launcher.TestExecutionListener;
//import org.junit.platform.launcher.TestIdentifier;
//
//public class TestInfoListener implements TestExecutionListener {
//    private static ThreadLocal<TestIdentifier> identifierThreadLocal = new ThreadLocal<>();
//
//    @Override
//    public void executionStarted(TestIdentifier testIdentifier) {
//        identifierThreadLocal.set(testIdentifier);
//    }
//
//    public static ThreadLocal<TestIdentifier> getIdentifierThreadLocal() {
//        return identifierThreadLocal;
//    }
//
//    public static TestIdentifier getTestId() {
//        return TestInfoListener.getIdentifierThreadLocal().get();
//    }
//}
