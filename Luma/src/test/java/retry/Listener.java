package retry;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNG;

public class Listener implements ITestListener {
	private static       int count  = 1;
	private final static int maxTry = 3;
	@Override
    public void onTestFailure(ITestResult iTestResult) {
        if (count < maxTry) {
            count++;
            TestNG tng = new TestNG();
            tng.setDefaultTestName("RETRY TEST");
            Class[] classes1 = { iTestResult.getTestClass().getRealClass() };
            tng.setTestClasses(classes1);
            tng.addListener(new Listener());
            tng.run();
        }
    }
}
